package w1112;

import centerFrame.CenterFrame;

import javax.swing.*;

public class ConfirmDialogTest extends JFrame {
    public ConfirmDialogTest() {
        // --- 기본 포함 문구 ---
        setTitle("RandomGridDice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(500, 400);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
        // --- 기본 포함 문구 ---

        int option = JOptionPane.showConfirmDialog(null, "버튼을 선택해 주세요.", "yes/no/cancel", JOptionPane.YES_NO_OPTION);

        String message = "";

        switch(option) {
            case JOptionPane.YES_OPTION:
                message = "Yes";
                break;
            case JOptionPane.NO_OPTION:
                message = "No";
                break;
            case JOptionPane.CANCEL_OPTION:
                message = "Cancel";
                break;
            default:
                break;
        }

        JOptionPane.showMessageDialog(null, message+"버튼을 선택하셨습니다.");
    }

    public static void main(String[] args){
        new ConfirmDialogTest();
    }
}
