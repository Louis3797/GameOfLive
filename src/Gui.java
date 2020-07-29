import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

    public void create() {
        /*
        In der create Methode setzen wir alles für unser JFrame fest

        Gui Klasse erbt von JFrame

        Objekte von Topbar, Counter und World werden erzeugt und dem JFrame hinzugefügt
         */
        setTitle("Game of Live by Louis");
        setSize(1200, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        Topbar tb = new Topbar();
        add(tb);

        Counter c = new Counter();
        add(c);

        World w = new World();
        add(w);

        setVisible(true);

    }
}
