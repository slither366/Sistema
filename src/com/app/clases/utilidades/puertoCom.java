package com.app.clases.utilidades;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.TooManyListenersException;
import javax.comm.CommPort;
import javax.comm.CommPortIdentifier;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;
import javax.comm.UnsupportedCommOperationException;

/**
 *
 * @author Diego
 */
public class puertoCom implements SerialPortEventListener {

    Enumeration ports;
    HashMap portMap = new HashMap();

    public void searchForPorts() {
        System.out.println("Puertos Disponibles:");
        ports = CommPortIdentifier.getPortIdentifiers();
        while (ports.hasMoreElements()) {
            CommPortIdentifier curPort = (CommPortIdentifier) ports.nextElement();

            if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                System.out.println(curPort.getName());
                portMap.put(curPort.getName(), curPort);
            }
        }
        System.out.println("———————-");
    }

    CommPortIdentifier selectedPortIdentifier;
    SerialPort serialPort;
    boolean connected;

    public void connect() {
        String puerto = "COM8";
        selectedPortIdentifier = (CommPortIdentifier) portMap.get(puerto);

        CommPort commPort = null;

        try {
            commPort = selectedPortIdentifier.open("Send Sms Java", 100);
            serialPort = (SerialPort) commPort;
            setSerialPortParameters();
            connected = true;

            System.out.println("conectado exitosamente a puerto " + puerto);
        } catch (PortInUseException e) {
            System.out.println("Puerto en uso.");
        } catch (Exception e) {
            System.out.println("Error al abrir puerto.");
        }
    }

    private void setSerialPortParameters() throws IOException {
        int baudRate = 115200;

        try {
            serialPort.setSerialPortParams(baudRate,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            serialPort.setFlowControlMode(
                    SerialPort.FLOWCONTROL_NONE);
        } catch (UnsupportedCommOperationException ex) {
            throw new IOException("Unsupported serial port parameter");
        }
    }

    InputStream input;
    OutputStream output;

    public boolean initIOStream() {
        boolean successful = false;

        try {
//
            input = serialPort.getInputStream();
            output = serialPort.getOutputStream();
            writeData("HELLO");

            successful = true;
            return successful;
        } catch (IOException e) {
            System.out.println("Error al abrir Stream.");
            return successful;
        }
    }

    public void initListener() {
        try {
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
            System.out.println("Listo..");
        } catch (TooManyListenersException e) {
            System.out.println("Demasiados escuchas.");
        }
    }

    public void writeData(String aenviar) {
        try {
            output.write(aenviar.getBytes());
        } catch (IOException ex) {
            System.out.println("Error al enviar informacion.");
        }
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            byte[] readBuffer = new byte[20];

            try {
                while (input.available() > 0) {
                    int numBytes = input.read(readBuffer);
                }
                System.out.print(new String(readBuffer));
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public void disconnect() {
        try {
            writeData("GOODBYE");

            serialPort.removeEventListener();
            serialPort.close();
            input.close();
            output.close();
            connected = false;

            System.out.println("Desconectado.");
        } catch (Exception e) {
            System.out.println("Error al desconectar.");
        }
    }

    public static void main(String[] args) throws Exception {
        puertoCom obj = new puertoCom();
        obj.searchForPorts();

        obj.connect();
        if (obj.connected == true) {
            if (obj.initIOStream() == true) {
                obj.initListener();

                obj.writeData("comandos a puerto serial");

            }
        }
    }   
}
