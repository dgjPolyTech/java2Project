package w1022;

import centerFrame.CenterFrame;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutTest extends JFrame{
    public FlowLayoutTest(){
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton[] btns = new JButton[5];

        for(int i = 0; i< btns.length; i++){
            btns[i] = new JButton("버튼 "+(i+1));
            add(btns[i]);
        }
        setTitle("플로우 레이아웃 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(200, 250);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    public static void main(String[] args){
        new FlowLayoutTest();
    }
}
