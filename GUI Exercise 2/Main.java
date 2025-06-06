import javax.swing.JFrame;

public class Main {

    public static void main (String[] args) {

        DrawShapes shapes = new DrawShapes();
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(shapes);
        window.setSize(300,300);
        window.setVisible(true);
    }
}
