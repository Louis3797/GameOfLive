import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Topbar extends JPanel {

    public static int CellAmount = 1000;
    public static boolean drawCells = false;


    public static JButton buttonDrawCells;
    public static JButton buttonGenerate;
    public static JButton buttonClear;
    public static JButton buttonStop;


    public static JSlider sliderCellsAmount;

    public static JLabel labelTextCellAmount;
    public static JLabel labelDataCellAmount;

    private final Font font = new Font("", Font.BOLD, 12);


    public Topbar() {
        /*
        Konstruktor der Topbar definiert Topbar und die Inhalte JButton, Labels, Slider...

        ChangeListener und etc, werden erzeugt
         */
        setSize(1200, 50);
        setBackground(Color.LIGHT_GRAY);
        setBounds(0, 0, 1200, 50);
        setLayout(null);


        labelTextCellAmount = new JLabel("Amount:");
        labelTextCellAmount.setFont(font);
        labelTextCellAmount.setBounds(10, 10, 60, 30);
        add(labelTextCellAmount);

        sliderCellsAmount = new JSlider(0, 10000, CellAmount);
        sliderCellsAmount.setBounds(70, 10, 100, 30);
        sliderCellsAmount.setBackground(Color.LIGHT_GRAY);
        add(sliderCellsAmount);

        labelDataCellAmount = new JLabel();
        labelDataCellAmount.setBounds(180, 10, 60, 30);
        labelDataCellAmount.setText(String.valueOf(CellAmount));
        labelDataCellAmount.setFont(font);
        add(labelDataCellAmount);

        buttonGenerate = new JButton("Generate");
        buttonGenerate.setBackground(Color.WHITE);
        buttonGenerate.setBounds(270, 10, 100, 30);
        add(buttonGenerate);

        buttonDrawCells = new JButton("Draw Cells");
        buttonDrawCells.setBackground(Color.WHITE);
        buttonDrawCells.setBounds(400, 10, 100, 30);
        add(buttonDrawCells);

        buttonClear = new JButton("Clear");
        buttonClear.setBackground(Color.WHITE);
        buttonClear.setBounds(600, 10, 100, 30);
        add(buttonClear);

        buttonStop = new JButton("Start");
        buttonStop.setBackground(Color.WHITE);
        buttonStop.setBounds(720, 10, 100, 30);
        add(buttonStop);


        setVisible(true);


        sliderCellsAmount.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //Anzahl der Zellen die in World mit der Methode generateCells erzeugt werden
                CellAmount = sliderCellsAmount.getValue();
                labelDataCellAmount.setText(String.valueOf(CellAmount));
            }
        });

        buttonDrawCells.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //boolean drawCells entweder true oder false durch JButton buttonDrawCells
                drawCells = !drawCells;
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                Array cells wird komplett auf false gesetzt
                Thread wird angehalten
                gen wird auf 0 gesetzt
                 */
                Clock c = new Clock();
                Clock.running = false;
                c.interrupt();
                World.gen = 0;
                World.clearWorld();
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Thread wird gestartet
                Clock c = new Clock();
                Clock.running = true;
                c.start();
            }
        });

        buttonGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Ruft generateCells in World Klasse auf
                World.generateCells();
            }
        });
    }
}
