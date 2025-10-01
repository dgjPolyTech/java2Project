package w1001;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonTest extends JFrame{
    public JButtonTest(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setTitle("JButtonTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);//화면 종료시 코드도 종료

        // 버튼에 담길 문구들로 배열 생성
        String[] btn_texts = {"상어", "돌고래", "문어", "물개", "범고래"};

        // 버튼이 담긴 배열 생성
        JButton[] btns = new JButton[btn_texts.length];

        // 배열만큼 반복
        for(int i=0; i< btns.length; i++){
            btns[i] = new JButton(btn_texts[i]);
            btns[i].addActionListener(btnListener);
            add(btns[i]);
        }

        // JButton 객체를 생성
//        JButton btn = new JButton("클릭하세요.");
//        btn.addActionListener(btnListener);
//        add(btn);
//
//        JButton btn2 = new JButton("내가 만든 버튼");
//        btn2.addActionListener(btnListener);
//        add(btn2);


        setBounds(200,200, 300, 200);//기본 화면 넓이
        setVisible(true);
    }

    // 버튼에 연계할 액션 이벤트를 내가 직접 선언
    ActionListener btnListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // 앞의 null은, 원래는 특정 컴포넌트를 부모 컴포넌트로 지정해서 종속되게 할 수 있다.
            // 우린 그럴 필요가 없으므로 null로 지정한 것.
            // e.getActionCommand = 이벤트가 발생한 버튼의 메시지 반환.
            JOptionPane.showMessageDialog(null, e.getActionCommand() + "버튼을 선택했습니다.");
        }
    };

    public static void main(String[] args){
        new JButtonTest();

    }
}
