package w1022;

import centerFrame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldTest extends JFrame {
    JTextField tf;
    JTextArea ta;
    JPasswordField pf;

    public TextFieldTest(){
        tf = new JTextField(10);
        ta = new JTextArea(5, 10);
        pf = new JPasswordField(10);

        JButton btn = new JButton("ShowMessage");
        // 버튼을 클릭했을 때 3개의 컴포넌트에 입력된 값을 대화상자에 출력해주세요.
        btn.addActionListener(btnListener);

        setLayout(new FlowLayout());

        add(tf);
        JScrollPane sp = new JScrollPane(ta);
        add(sp);
        add(pf);
        add(btn);

        setTitle("텍스트 입력 가능 컴포넌트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(200, 250);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tfText = tf.getText();
            String taText = ta.getText();
            // getPassword 사용할 때는 아래처럼 char[]로 받아 string으로 형변환 하는 식으로 쓰는게 좋음.
            char[] pwText = pf.getPassword();
            String getPWText = String.copyValueOf(pwText);

            JOptionPane.showMessageDialog(null, tfText + "\n" + taText + "\n" + getPWText);
        }
    };

    public static void main(String[] args){
        //TextFieldTest tf = new TextFieldTest();
        new TextFieldTest();
    }
}
