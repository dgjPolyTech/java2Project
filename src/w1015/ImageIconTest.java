package w1015;

import centerFrame.CenterFrame;

import javax.swing.*;
import java.awt.*;

public class ImageIconTest extends JFrame {
    public ImageIconTest(){
        ImageIcon icon1 = new ImageIcon("D://JAVA//Java2Project//JavaProject2//src//w1015//imgs//luffy.jpg");
        ImageIcon icon2 = new ImageIcon("D://JAVA//Java2Project//JavaProject2//src//w1015//imgs//zoro.jpg");

        JLabel label = new JLabel(icon1);
        JButton button = new JButton(icon2);
        add(label, "North");
        add(button, "Center"); //

        setTitle("RadioButtonTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        CenterFrame cf = new CenterFrame(500, 300);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);

        setTitle("ImageIconTest");
    }

    public static void main(String[] args){
        new ImageIconTest();
    }
}
