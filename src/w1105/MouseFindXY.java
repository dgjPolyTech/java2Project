package w1105;

import centerFrame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseFindXY extends JFrame {
    JTextField tfx, tfy;
    
    public MouseFindXY(){
        setLayout(new FlowLayout());
        addMouseListener(mouseListener);
        tfx = new JTextField(10);
        tfy = new JTextField(10);
        JLabel lblX = new JLabel("X좌표");
        JLabel lblY = new JLabel("Y좌표");
        add(lblX); add(tfx);
        add(lblY); add(tfy);

        
        setTitle("MouseEvent find XY");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(500, 400);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }
    
    MouseAdapter mouseListener = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            tfx.setText(e.getX()+"");
            tfy.setText(e.getY()+"");
        }
    };

    public static void main(String[] args) {
        new MouseFindXY();
    }
}
