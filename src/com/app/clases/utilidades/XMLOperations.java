package com.app.clases.utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * The class will handle parsing an XML when open is selected. It will also
 * convert the table to XML when needed.
 *
 * @author Zoli
 */
public class XMLOperations extends DefaultHandler {

    private final String attrib; // In this string are the attribute values stored.
    private String cellvalue; // The string in which the value between the tags are stored.
    private Vector table, row;
    private Vector names;
    private String document;

    /**
     * Constructor inits instance variables.
     */
    public XMLOperations() {
        super();
        this.names = new Vector();
        this.attrib = "";
        this.cellvalue = "";
        this.table = new Vector();
        this.document = "";
    }

    public void setDocument(String doc) {
        this.document = doc;
    }

    public String getDocument() {
        return this.document;
    }

    /**
     * Parse the XML document.
     *
     * @throws javax.xml.parsers.ParserConfigurationException
     */
    public void ParseDocument() throws ParserConfigurationException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser sp = spf.newSAXParser();
            sp.parse(this.document, this);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        this.cellvalue = "";
        if (qName.equalsIgnoreCase("row")) {
            this.row = new Vector();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        this.cellvalue = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("field")) {
            this.names.add(this.cellvalue);
        } else if (qName.equalsIgnoreCase("row")) {
            this.table.add(this.row);
        } else if (qName.equalsIgnoreCase("column")) {
            this.row.add(this.cellvalue);
        }

    }

    /**
     * Create a model for the table, based on the data read from the XML file.
     *
     * @return The TableModel
     */
    public DefaultTableModel getTableData() {

        DefaultTableModel model = new DefaultTableModel(this.table, this.names);
        return model;
    }

    public void saveTableData(TableModel m, String filename) {
        DefaultTableModel model = (DefaultTableModel) m;

        FileOutputStream fop = null;

        try {

            File f = new File(filename);

            if (!f.exists()) {
                f.createNewFile();
            }

            fop = new FileOutputStream(f);

            fop.write("<?xml version=\"1.0\" encoding=\"utf-8\" ?>".getBytes());
            fop.write("\n<table>".getBytes());

            for (int i = 0; i < model.getColumnCount(); i++) {
                String str = "<field>";
                str = str + model.getColumnName(i) + "</field>";
                fop.write(str.getBytes());
            }

            for (int i = 0; i < model.getRowCount(); i++) {
                fop.write("<row>\n".getBytes());
                for (int j = 0; j < model.getColumnCount(); j++) {
                    String str = "<column>";
                    str = str + model.getValueAt(i, j).toString() + "</column>\n";
                    fop.write(str.getBytes());
                }
                fop.write("</row>\n".getBytes());
            }
            fop.write("</table>".getBytes());
            fop.flush();
            fop.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                fop.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
