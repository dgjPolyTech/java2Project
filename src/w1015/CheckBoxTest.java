package w1015;

import centerFrame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxTest extends JFrame {
    JCheckBox checkBox;

    public CheckBoxTest(){
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setTitle("CheckBoxTest");
        // JCheckBox => 데이터 소스, 즉 데이터의 근원지
        checkBox = new JCheckBox("체크박스를 선택하세요.");
        checkBox.addActionListener(checkBoxListener);
        add(checkBox);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // JFrame이 모니터 화면 정중앙에 오도록 한다.
        // 우리가 만든 CenterFrame 클래스는 패키지 내 다른 프로젝트에서도 사용 가능.
        CenterFrame cf = new CenterFrame(500, 300);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    ActionListener checkBoxListener = new ActionListener() {
        // ActionListener 안의 추상 메소드 actionPerformed를 반드시 구현해줘야 함.
        @Override
        public void actionPerformed(ActionEvent e){
            if(checkBox.isSelected()){
                JOptionPane.showMessageDialog(null, "체크박스가 선택되었습니다.");
            } else {
                JOptionPane.showMessageDialog(null, "체크박스가 해제되었습니다.");
            }
        }
    };

    public static void main(String[] args){
        new CheckBoxTest();
    }
}
