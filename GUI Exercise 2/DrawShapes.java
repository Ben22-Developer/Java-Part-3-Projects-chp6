import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.security.SecureRandom;

public class DrawShapes extends JPanel {

    private final static SecureRandom randomize = new SecureRandom();

    public void draw_shapes (Graphics g) {

        int shape_chosen,start_x,start_y,height,width,red,green,blue;
        int screen_width,screen_height;

        screen_width = getWidth();
        screen_height = getHeight();

        int shapes_to_draw = 10;

        for (int i = 0; i < shapes_to_draw; i++) {

            shape_chosen = randomize.nextInt(2);
            width = 20 + randomize.nextInt(81);
            height = 20 + randomize.nextInt(81);
            start_x = 20 + randomize.nextInt(screen_width - (width + 50));
            start_y = 20 + randomize.nextInt(screen_height - (height + 50));
            red = randomize.nextInt(256);
            green = randomize.nextInt(256);
            blue = randomize.nextInt(256);

            Color a_color = new Color(red,green,blue);
            g.setColor(a_color);

            switch (shape_chosen) {
                case 0:
                    g.fillOval(start_x,start_y,width,height);
                break;
                case 1:
                    g.fillRect(start_x,start_y,width,height);
                break;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw_shapes(g);
    }
}
