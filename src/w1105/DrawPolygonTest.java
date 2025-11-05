package w1105;

import centerFrame.CenterFrame;

import javax.swing.*;
import java.awt.*;

public class DrawPolygonTest extends JFrame{
    public DrawPolygonTest() {
        DrawPanel dp = new DrawPanel();
        add(dp);

        setTitle("RandomGridDice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(500, 400);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    public static void main(String[] args) {
        new DrawPolygonTest();
    }

    class DrawPanel extends JPanel {
        // 도형을 그리는 "붓"의 역할을 한다고 보면 됨
        @Override
        protected void paintComponent(Graphics g ){
            super.paintComponent(g);
            // 선 그리기
            g.setColor(Color.red);
            // x시작점, y시작점, x끝점, y끝점.
            // x는 가로 길이, y는 세로 각도?같은 느낌
            g.drawLine(10, 20, 490, 20);
            
            // 원 그리기
//            g.setColor(Color.green);
//            g.drawOval(20, 30, 150, 100);
//
//            g.setColor(Color.blue);
//            g.fillOval(200, 30, 150, 100);
//
//            g.setColor(Color.orange);
//            g.fillOval(370, 30, 100, 100);
//
//            g.setColor(Color.pink);
//            // 사격흥 그리기
//            g.drawRect(20, 160, 200, 150);
//
//            // 사각형 안에 사각형(약간 둥근 사각형) 그리기
//            g.setColor(Color.magenta);
//            g.fillRect(250, 160, 200, 200);
//            g.setColor(Color.BLACK);
//            g.fillRoundRect(280, 190, 140, 140, 20, 20);
//
//            g.setColor(Color.magenta);
//            int[] xPoints = {110, 30, 180};
//            int[] yPoints = {180, 250, 250};
//            // x, y좌표, xPoints.length(3)이므로 삼각형이 그려지게 된다.
//            g.drawPolygon(xPoints, yPoints, xPoints.length);
        }
    }
}
