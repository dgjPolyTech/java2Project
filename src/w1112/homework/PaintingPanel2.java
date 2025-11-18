package w1112.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaintingPanel2 extends JPanel implements MouseListener {
    public static String polygon;
    int x1, y1, x2, y2;

    public PaintingPanel2(String polygon){
        this.polygon = polygon;
        setBackground(Color.YELLOW);
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if (polygon.equals("선")) {
            g.setColor(Color.RED);
            g.drawLine(x1, y1, x2, y2);
        } else {
            int startX = Math.min(x1, x2);
            int startY = Math.min(y1, y2);
            int width = Math.abs(x1 - x2);
            int height = Math.abs(y1 - y2);

            if (polygon.equals("사각형")) {
                g.setColor(Color.MAGENTA);
                g.fillRect(startX, startY, width, height);
            } else if (polygon.equals("타원")) {
                g.setColor(Color.BLUE);
                g.fillOval(startX, startY, width, height);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}