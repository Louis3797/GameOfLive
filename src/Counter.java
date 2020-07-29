import javax.swing.*;
import java.awt.*;

public class Counter extends JPanel {

    public static JLabel labelTextCellsAlive;
    public static JLabel labelTextCellsDead;
    public static JLabel labelDataCellsAlive;
    public static JLabel labelDataCellsDead;
    public static JLabel labelDataGeneration;
    public static JLabel labelTextGeneration;

    public static int alive, dead;

    private final Font font = new Font("", Font.BOLD, 12);

    public Counter() {
        /*
        K0nstruktor beschreibt Counter und enthaltene JLabels
         */
        setSize(800, 30);
        setBackground(Color.LIGHT_GRAY);
        setBounds(200, 60, 800, 30);
        setLayout(null);

        labelTextCellsAlive = new JLabel("Cells Alive:");
        labelTextCellsAlive.setFont(font);
        labelTextCellsAlive.setBounds(20, 0, 100, 30);
        add(labelTextCellsAlive);

        labelDataCellsAlive = new JLabel();
        labelDataCellsAlive.setFont(font);
        labelDataCellsAlive.setBounds(100, 0, 100, 30);
        add(labelDataCellsAlive);

        labelTextCellsDead = new JLabel("Cells Dead:");
        labelTextCellsDead.setFont(font);
        labelTextCellsDead.setBounds(300, 0, 100, 30);
        add(labelTextCellsDead);

        labelDataCellsDead = new JLabel();
        labelDataCellsDead.setFont(font);
        labelDataCellsDead.setBounds(380, 0, 100, 30);
        add(labelDataCellsDead);

        labelTextGeneration = new JLabel("Generation:");
        labelTextGeneration.setFont(font);
        labelTextGeneration.setBounds(600, 0, 100, 30);
        add(labelTextGeneration);

        labelDataGeneration = new JLabel(String.valueOf(World.gen));
        labelDataGeneration.setFont(font);
        labelDataGeneration.setBounds(680, 0, 100, 30);
        add(labelDataGeneration);
    }

    //Berechnung lebender Zellen
    public static void CellsAlive() {
        int counter = 0;
        for (int x = 0; x < 1100; x++) {
            for (int y = 0; y < 750; y++) {
                if (World.cells[x][y]) counter++;
            }
        }
        labelDataCellsAlive.setText(String.valueOf(counter));
        alive = counter;
    }

    //Berechnung toter Zellen
    public static void CellsDead() {
        int counter = 0;
        for (int x = 0; x < 1100; x++) {
            for (int y = 0; y < 750; y++) {
                if (!World.cells[x][y]) counter++;
            }
        }
        labelDataCellsDead.setText(String.valueOf(counter));
        dead = counter;
    }
}
