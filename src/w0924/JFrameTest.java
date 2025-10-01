package w0924;

import javax.swing.*; //gui 개발 시 필요.

public class JFrameTest extends JFrame{
    public JFrameTest(){
        setTitle("처음 만드는 프레임");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocation(200, 200);
        setVisible(true);
    }

    public static void main(String[] args){
        //JFrameTest jft = new JFrameTest();
        new JFrameTest();
    }


}
