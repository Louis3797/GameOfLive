import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.ThreadLocalRandom;

public class World extends JPanel implements MouseListener, MouseMotionListener {

    /*
    World erbt von JPanel zude, werden MouseListener und MouseMotionListener implemtiert
     */

    /*
    In cells werden die unterschiedlichen Zellen gespeichert
    und in Zeile 38 gezeichnet

    Die Variablen x,y sind für den Mauszeiger um zu erkennen wo der Click auf das JPanel World war

    int gen zeigt die unterschiedlichen Generationen an
     */
    public static boolean[][] cells = new boolean[1100][750];
    private int x, y;
    public static int gen = 0;

    public World() {
        /*
        Im Konstruktor World leben wir die Attribute des JPanel fest
         */
        setSize(1100, 750);
        setBackground(Color.WHITE);
        setBounds(50, 100, 1100, 750);
        setVisible(true);
        addMouseListener(this);
        addMouseMotionListener(this);

    }

    protected void paintComponent(Graphics g) {
        /*
        Zeichen Klasse
         */
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        //Sind cells[x][y] == true werden sie gezeichnet
        for (int x = 0; x < 1100; x++) {
            for (int y = 0; y < 750; y++) {
                if (cells[x][y]) {
                    g.setColor(Color.BLUE);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.drawRect(x * 1, y * 1, 1, 1);
            }
        }
        repaint();

    }

    //Zellen werden in der generateCells Methode erzeugt
    public static void generateCells() {
        for (int i = 0; i < Topbar.CellAmount; i++) {
            int x = r(0, 1100);
            int y = r(0, 750);
            cells[x][y] = true;
        }
    }

    //Regeln für die nächste Generation an Zellen
    public static void nextGen() {
        gen++;
        Counter.labelDataGeneration.setText(String.valueOf(World.gen));
        for (int x = 0; x < 1100; x++) {
            for (int y = 0; y < 750; y++) {
                int n = neighbours(x, y);

                //Regel 1
                if (n == 3 && !cells[x][y]) {
                    cells[x][y] = true;
                }

                //Regel 2
                if (n < 2) {
                    cells[x][y] = false;
                }

                //Regel 3
                if (n == 2 || n == 3) {
                    //Zelle ändert sich nicht
                }

                //Regel 4
                if (n > 3) {
                    cells[x][y] = false;
                }

            }
        }
    }

    //Nachbarn der Zellen werden durch die Methode erkannt und durch ein int returned
    public static int neighbours(int x, int y) {
        int count = 0;

        int[] xoff = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] yoff = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < 8; i++) {
            try {
                if (cells[x + xoff[i]][y + yoff[i]]) count++;
            } catch (Exception e) {
            }
        }
        return count;
    }

    //Zufallszahlen für die Methode generateCells
    public static int r(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static void clearWorld() {
        gen = 0;
        for (int x = 0; x < 1100; x++) {
            for (int y = 0; y < 750; y++) {
                cells[x][y] = false;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Erkennt einzelne Mausklicks
        try {
            if (Topbar.drawCells) {
                x = e.getX();
                y = e.getY();
                cells[x][y] = true;
                repaint();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //Erkennt wenn maus gedrückt gehalten wird
        try {
            if (Topbar.drawCells) {
                x = e.getX();
                y = e.getY();
                cells[x][y] = true;
                repaint();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


}
