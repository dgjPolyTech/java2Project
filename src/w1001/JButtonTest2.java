package w1001;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JButtonTest2 extends JFrame{
    // 후술할 액션 리스너에서 텍스트 필드 참조해야 하므로, 전역 변수로 설정해줘야 한다.
    // 혹은 이벤트 리스너 자체를 JButton 안에 선언해줘야 한다.
    JTextField jtf;

    public JButtonTest2(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int fw = 300;
        int fh = 400;

        setLayout(new FlowLayout(FlowLayout.CENTER));
        setTitle("JButtonTest2");

        JButton btn = new JButton("입력값 확인");
        jtf = new JTextField(20); // 위에서 선언한 텍스트 필드를 여기서 제대로 정의.

        // x, y를 아래와 같이 설정하면, 어떤 화면에서도 가운데에 위치하게됨.
        setBounds(screenWidth/2 - (fw/2), screenHeight/2 - (fh/2), fw, fh);
        setVisible(true);

        btn.addActionListener(btnListener);
        
        add(btn);
        add(jtf);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // ActionListener를 상속받아 btnListener 생성
    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, jtf.getText()+"라고 입력했습니다.");
        }
    };

    public static void main(String[] args){
        new JButtonTest2();
    }
}
