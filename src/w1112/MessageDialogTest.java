package w1112;

import centerFrame.CenterFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageDialogTest extends JFrame implements ActionListener {
    String[] bntStrs = {"Plain", "Warning", "Information"};
    JButton[] buttons = new JButton[bntStrs.length];

    public MessageDialogTest(){
        JPanel panel = new JPanel();
        add(panel, "North");

        for(int i=0; i<bntStrs.length; i++) {
            buttons[i] = new JButton(bntStrs[i]);
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        // --- 기본 포함 문구 ---
        setTitle("RandomGridDice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(500, 400);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
        // --- 기본 포함 문구 ---
    }

    public static void main(String[] args){
        // --- new ~클래스명 기본 포함 문구 ---
        new MessageDialogTest();
        // --- 기본 포함 문구 ---
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String eBtnStr = e.getActionCommand();
        switch(eBtnStr){
            case "Plain":
                JOptionPane.showConfirmDialog(null, "일반메시지대화상자입니다.", "plain option", JOptionPane.PLAIN_MESSAGE);
                break;

            case "Warning":
                JOptionPane.showConfirmDialog(null, "경고메시지대화상자입니다.", "warning option", JOptionPane.WARNING_MESSAGE);
                break;

            case "Information":
                JOptionPane.showConfirmDialog(null, "정보메시지대화상자입니다.", "information option", JOptionPane.INFORMATION_MESSAGE);
                break;    
        }
    }
}
