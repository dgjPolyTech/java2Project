package w1015;


import centerFrame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class RadioButtonTest extends JFrame {
    // 라디오는 여러개를 만들어 그룹화 필요하므로, 배열 기반으로 생성한다.
    JRadioButton[] rbArr = new JRadioButton[3];
    
    // 라디오에 쓰일 string 값 배열
    String[] rbStrArr = {"루피", "조로", "상디"};

    //이미지 아이콘이 위치할 라벨. 우리는 이미지를 출력할거라 ""로 한 것
    JLabel lbl = new JLabel("", JLabel.CENTER);

    public RadioButtonTest(){
        JPanel panel = new JPanel();
        ButtonGroup bg = new ButtonGroup();

        int i = 0;

        // 인핸스드 for문: 굳이 번거롭게 쓰지 않아도, 반복문 안을 0번부터 끝까지 돈다.
        // 아래 반복문의 경우 rbStrArr 끝까지 순서대로 돌며, 각각의 인덱스 별 요소는 str이라는 이름으로 사용된다.
        for(String str : rbStrArr){
            rbArr[i] = new JRadioButton(str);
            add(rbArr[i]);
            bg.add(rbArr[i]);
            panel.add(rbArr[i]);
            rbArr[i].addActionListener(radioBtnListener);
            i++;
        }

        // label의 경우 아래처럼 OPaque true, backgroundColor 설정해줘야 보임.
        lbl.setOpaque(true);
        lbl.setBackground(Color.BLUE);

        add(panel, "North");
        add(lbl, "Center");

        setTitle("RadioButtonTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // JFrame이 모니터 화면 정중앙에 오도록 한다.
        // 우리가 만든 CenterFrame 클래스는 패키지 내 다른 프로젝트에서도 사용 가능.
        CenterFrame cf = new CenterFrame(500, 300);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    ActionListener radioBtnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 내가 썼던 버전
//            for(int i =0; i<rbArr.length; i++){
//                if(rbArr[i].isSelected()){
//                    JOptionPane.showMessageDialog(null, rbArr[i].getText());
//                }
//            }

            ImageIcon icon;
            for(JRadioButton rb : rbArr){
                if(rb.isSelected()){
                    JOptionPane.showMessageDialog(null, rb.getText());

                    if(rb.getText().equals("루피")){
                        JOptionPane.showMessageDialog(null, rb.getText()+"로 이미지 설정");
                        icon = new ImageIcon("D://JAVA//Java2Project//JavaProject2//src//w1015//imgs//one0.jpg");
                        lbl.setIcon(icon);
                    }

                    if(rb.getText().equals("조로")){
                        JOptionPane.showMessageDialog(null, rb.getText()+"로 이미지 설정");
                        icon = new ImageIcon("D://JAVA//Java2Project//JavaProject2//src//w1015//imgs//one1.jpg");
                        lbl.setIcon(icon);
                    }

                    if(rb.getText().equals("상디")){
                        JOptionPane.showMessageDialog(null, rb.getText()+"로 이미지 설정");
                        icon = new ImageIcon("D://JAVA//Java2Project//JavaProject2//src//w1015//imgs//one2.jpg");
                        lbl.setIcon(icon);
                    }
                    
                }
            }
        }
    };

    public static void main(String[] args){
        new RadioButtonTest();
    }
}
