import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Graphics;

public class Main {

    public static  void main (String[] args) {

        int generate = 1;

        JOptionPane.showMessageDialog(null,"Welcome to our application!\nIt draws an displays awesome colored ovals!");

        while (generate != 0) {

            RandomColors canvas = new RandomColors();
            JFrame window = new JFrame();

            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.add(canvas);
            window.setSize(700,700);
            window.setVisible(true);

            String generate_string = JOptionPane.showInputDialog("Press any number to re-generate again\npress 0 to end the application");
            generate = Integer.parseInt(generate_string);
        }

        JOptionPane.showMessageDialog(null,"Thank u for using our application");
    }
}
