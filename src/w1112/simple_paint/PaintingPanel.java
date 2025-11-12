package w1112.simple_paint;

import javax.swing.*;
import java.awt.*;

public class PaintingPanel extends JPanel {
    public static String polygon;

    public PaintingPanel(String polygon){
        this.polygon = polygon;
        setBackground(Color.YELLOW);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        switch (polygon){
            case "선":
                g.setColor(Color.RED);
                g.drawLine(30, 30, 100, 50);
                break;
            case "사각형":
                g.setColor(Color.MAGENTA);
                g.fillRect(50, 70, 200, 200);
                break;
            case "타원":
                g.setColor(Color.BLUE);
                g.fillOval(220, 150, 200, 300);
                break;
        }
    }
}
