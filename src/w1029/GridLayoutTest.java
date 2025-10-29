package w1029;

import centerFrame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GridLayoutTest extends JFrame {

    public GridLayoutTest(){
        setLayout(new GridLayout(3, 3, 10, 10));

        // 버튼 여러개 만들 때, 무조건 배열을 만들 필요 없음
        for(int i=0; i<9; i++){
            JButton btn = new JButton("버튼"+(i+1));
            add(btn);
            btn.addActionListener(btnListener);
        }

        setTitle("GridTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(250, 250);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            JOptionPane.showMessageDialog(null, btn.getText()+" 선택되었습니다.");
        }
    };

    public static void main(String[] args){
        new GridLayoutTest();
    }
}
