import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.security.SecureRandom;

public class RandomColors extends JPanel {

    private static int oval1_red,oval1_green,oval1_blue;
    private static int oval2_red,oval2_green,oval2_blue;

    public void drawASingleOval(Graphics g,Color a_color_combination,int start_x,int start_y,int oval_width,int oval_height) {

        g.setColor(a_color_combination);
        g.fillOval(start_x,start_y,oval_width,oval_height);

    }

    public void drawOvals (Graphics g, int oval1_red, int oval1_green, int oval1_blue, int oval2_red, int oval2_green, int oval2_blue) {

        int use_color_combination, screen_height, screen_width, start_x, start_y, oval_width, oval_height, ovals_to_display;

        Color color_combination_to_use = null;

        use_color_combination= 0;
        ovals_to_display = 5;

        screen_height = super.getHeight();
        screen_width = super.getWidth();

        start_x = (screen_width/2) - 200;
        start_y = (screen_height/2) - 200;
        oval_width = 200;
        oval_height = 200;

        for (int i = 0; i < ovals_to_display; i++) {

            switch (use_color_combination) {
                case 0:
                    color_combination_to_use = new Color(oval1_red,oval1_green,oval1_blue);
                    use_color_combination = 1;
                break;
                case 1:
                    color_combination_to_use = new Color(oval2_red,oval2_green,oval2_blue);
                    use_color_combination = 0;
                break;
            }
            drawASingleOval(g,color_combination_to_use,start_x,start_y,oval_width,oval_height);
            start_x += 20;
            start_y += 20;
            oval_width -= 40;
            oval_height -= 40;
        }
    }

    public int randomGenerator () {

        SecureRandom secure_random = new SecureRandom();
        return secure_random.nextInt(255);
    }

    public void graphic_draw_control (Graphics g) {



        oval1_red = randomGenerator();
        oval1_green = randomGenerator();
        oval1_blue = randomGenerator();

        oval2_red = randomGenerator();
        oval2_green = randomGenerator();
        oval2_blue = randomGenerator();

        drawOvals(g,oval1_red,oval1_green,oval1_blue,oval2_red,oval2_green,oval2_blue);
    }

    public void paintComponent (Graphics g) {

        super.paintComponent(g);
        graphic_draw_control(g);
    }
}
