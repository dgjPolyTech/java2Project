package w1001;

import javax.swing.*;
import java.awt.*;

public class JLabelTest extends JFrame{
    public JLabelTest(){
        setLayout(new FlowLayout()); // FlowLayout = 크기가 남으면 나란히, 크기가 부족하면 자동 줄바꿈으로 정렬됨.
        setTitle("JLabelTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setBounds(100, 100, 300, 500);

        String[] lblTexts = {"한국폴리텍대학", "서울 정수캠퍼스", "인공지능소프트웨어과"};
        //String[] locTexts = {"North", "Center", "South"}; // 대소문자 구분 제대로 해야함.
        Color[] lblBgColors = {Color.orange, Color.magenta, Color.BLACK};
        JLabel[] lbls = new JLabel[lblTexts.length];

        for(int i=0; i< lbls.length;i++){
            lbls[i] = new JLabel(lblTexts[i], JLabel.CENTER);
            lbls[i].setForeground(Color.white);
            lbls[i].setOpaque(true);
            lbls[i].setBackground(lblBgColors[i]);
            add(lbls[i]);
        }

        Font font = new Font("맑은 고딕", Font.BOLD, 30);
        lbls[2].setFont(font);

        setBounds(100, 100, 300, 400);
        setVisible(true);
    }

    public static void main(String[] args){
        new JLabelTest();
    }
}
