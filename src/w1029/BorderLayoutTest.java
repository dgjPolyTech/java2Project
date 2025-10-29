package w1029;

import centerFrame.CenterFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorderLayoutTest extends JFrame {
    public BorderLayoutTest() {
        setLayout(new BorderLayout(10, 10));
        String[] constraints = {"East", "West", "South", "North", "Center"};

        for(int i=0; i<5; i++){
            JButton btn = new JButton("버튼" +(i+1));
            add(btn, constraints[i]);
            btn.addActionListener(btnListener);
        }

        setTitle("BorderTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(300, 250);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // e.getSource란, 이벤트가 발생한 "근원지"를 의미함.
            // 이 코드에서는 버튼에서 이벤트가 발생하므로, JButton e.getSource라고 하는 것
            JButton btn = (JButton) e.getSource();
            JOptionPane.showMessageDialog(null, btn.getText()+"선택됨");
        }
    };

    public static void main(String[] args){
        new BorderLayoutTest();
    }
}
