package com.app.clases.utilidades;

import com.app.config.Configuracion;
import com.app.form.Especiales.callMenus;
import com.app.form.Especiales.frm_Padre;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JuegoBuscaMinas extends frm_Padre implements ActionListener, MouseListener {

    int nomines = 40;
    String tmp;
    boolean found = false;
    int row, column;
    int[][] guesses, perm, mines;
    JButton b[][];
    boolean allmines;
    int n = 10;
    int m = 10;
    int deltax[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    int deltay[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    double starttime, endtime;

    public JuegoBuscaMinas() {
        this.setResizable(false);
        this.setName("buscaMinas");
        this.setTitle("..:: " + Configuracion.getTITULO_VENTANA() + " - Busca Minas ::..");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        perm = new int[n][m];
        allmines = false;
        guesses = new int[n + 2][m + 2];
        mines = new int[n + 2][m + 2];
        b = new JButton[n][m];
        this.setLayout(new GridLayout(n, m));
        for (int y = 0; y < m + 2; y++) {
            mines[0][y] = 3;
            mines[n + 1][y] = 3;
            guesses[0][y] = 3;
            guesses[n + 1][y] = 3;
        }
        for (int x = 0; x < n + 2; x++) {
            mines[x][0] = 3;
            mines[x][m + 1] = 3;
            guesses[x][0] = 3;
            guesses[x][m + 1] = 3;
        }
        do {
            int check = 0;
            for (int y = 1; y < m + 1; y++) {
                for (int x = 1; x < n + 1; x++) {
                    mines[x][y] = 0;
                    guesses[x][y] = 0;
                }
            }
            for (int x = 0; x < nomines; x++) {
                mines[(int) (Math.random() * (n) + 1)][(int) (Math.random() * (m) + 1)] = 1;
            }
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (mines[x + 1][y + 1] == 1) {
                        check++;
                    }
                }
            }
            if (check == nomines) {
                allmines = true;
            }
        } while (allmines == false);
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if ((mines[x + 1][y + 1] == 0) || (mines[x + 1][y + 1] == 1)) {
                    perm[x][y] = perimcheck(x, y);
                }
                b[x][y] = new JButton(":)");
                b[x][y].addActionListener(this);
                b[x][y].addMouseListener(this);
                add(b[x][y]);
                b[x][y].setEnabled(true);
            }//end inner for
        }//end for
        pack();
        this.setVisible(true);
        for (int y = 0; y < m + 2; y++) {
            for (int x = 0; x < n + 2; x++) {
                System.out.print(mines[x][y]);
            }
            System.out.println("");
        }
        starttime = System.nanoTime();
    }//end constructor Mine()

    @Override
    public void actionPerformed(ActionEvent e) {
        found = false;
        JButton current = (JButton) e.getSource();
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                JButton t = b[x][y];
                if (t == current) {
                    row = x;
                    column = y;
                    found = true;
                }
            }//end inner for
        }//end for
        if (!found) {
            System.out.println("No se encuentra el boton, se produjo un error!!!");
            System.exit(-1);
        }
        Component temporaryLostComponent = null;
        if (b[row][column].getBackground() == Color.orange) {
            return;
        } else if (mines[row + 1][column + 1] == 1) {
            //b[row][column].setText(":p");
            JOptionPane.showMessageDialog(temporaryLostComponent, "Se encontró una mina!!!.");
            this.Salir(this);
        } else {
            tmp = Integer.toString(perm[row][column]);
            if (perm[row][column] == 0) {
                tmp = " ";
            }
            b[row][column].setText(tmp);
            b[row][column].setEnabled(false);
            checkifend();
            if (perm[row][column] == 0) {
                scan(row, column);
                checkifend();
            }
        }
    }

    public void checkifend() {
        int check = 0;
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (b[x][y].isEnabled()) {
                    check++;
                }
            }
        }
        if (check == nomines) {
            endtime = System.nanoTime();
            Component temporaryLostComponent = null;
            JOptionPane.showMessageDialog(temporaryLostComponent, "Felicidades ¡Ganaste!!! le tomo " + (int) ((endtime - starttime) / 1000000000) + " segundos!");
        }
    }

    public void scan(int x, int y) {
        for (int a = 0; a < 8; a++) {
            if (mines[x + 1 + deltax[a]][y + 1 + deltay[a]] == 3) {
            } else if ((perm[x + deltax[a]][y + deltay[a]] == 0) && (mines[x + 1 + deltax[a]][y + 1 + deltay[a]] == 0) && (guesses[x + deltax[a] + 1][y + deltay[a] + 1] == 0)) {
                if (b[x + deltax[a]][y + deltay[a]].isEnabled()) {
                    b[x + deltax[a]][y + deltay[a]].setText(" ");
                    b[x + deltax[a]][y + deltay[a]].setEnabled(false);
                    scan(x + deltax[a], y + deltay[a]);
                }
            } else if ((perm[x + deltax[a]][y + deltay[a]] != 0) && (mines[x + 1 + deltax[a]][y + 1 + deltay[a]] == 0) && (guesses[x + deltax[a] + 1][y + deltay[a] + 1] == 0)) {
                tmp = Integer.toString(perm[x + deltax[a]][y + deltay[a]]);
                b[x + deltax[a]][y + deltay[a]].setText(Integer.toString(perm[x + deltax[a]][y + deltay[a]]));
                b[x + deltax[a]][y + deltay[a]].setEnabled(false);
            }
        }
    }

    public int perimcheck(int a, int y) {
        int minecount = 0;
        for (int x = 0; x < 8; x++) {
            if (mines[a + deltax[x] + 1][y + deltay[x] + 1] == 1) {
                minecount++;
            }
        }
        return minecount;
    }

    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            found = false;
            Object current = e.getSource();
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    JButton t = b[x][y];
                    if (t == current) {
                        row = x;
                        column = y;
                        found = true;
                    }
                }//end inner for
            }//end for
            if (!found) {
                System.out.println("No se encuentra el boton, se produjo un error!!!");
                System.exit(-1);
            }
            if ((guesses[row + 1][column + 1] == 0) && (b[row][column].isEnabled())) {
                b[row][column].setText("x");
                guesses[row + 1][column + 1] = 1;
                b[row][column].setBackground(Color.orange);
            } else if (guesses[row + 1][column + 1] == 1) {
                b[row][column].setText("?");
                guesses[row + 1][column + 1] = 0;
                b[row][column].setBackground(null);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

//    public static void main(String[] args) {
//        new JuegoBuscaMinas();
//    }
}//end class
