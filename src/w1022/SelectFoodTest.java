package w1022;

import centerFrame.CenterFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class SelectFoodTest extends JFrame {
    JComboBox combo;
    JLabel imgLbl;
    String[] items = {"루피", "조로", "상디"};
    
    public SelectFoodTest(){
        JPanel northPan = new JPanel();
        JLabel lbl1 = new JLabel("Character: ");
        combo = new JComboBox(items);
        JButton btn = new JButton("선택");

        northPan.add(btn);
        northPan.add(combo);
        northPan.add(lbl1);
        add(northPan, "North");
        imgLbl = new JLabel(new ImageIcon("D:\\JAVA\\Java2Project\\JavaProject2\\src\\w1022\\imgs\\luffy.jpg"));
        add(imgLbl, "Center");

        btn.addActionListener(btnListener);
        
        setTitle("원피스 등장인물 선택");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(500, 400);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = combo.getSelectedIndex();
            ImageIcon imgIcon = new ImageIcon("D:\\JAVA\\Java2Project\\JavaProject2\\src\\w1022\\imgs\\one"+selectedIndex+".jpg");
            imgLbl.setIcon(imgIcon);
        }
    };

    public static void main(String args[]){
        new SelectFoodTest();
    }
}
