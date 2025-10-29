package w1029;

import centerFrame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomGridDice extends JFrame {
    public RandomGridDice(){
        Random rnd = new Random();
        int rows = rnd.nextInt(10)+1;
        int cols = rnd.nextInt(10)+1;
        setLayout(new GridLayout(rows, cols));

        Color[] colors = {Color.gray, Color.magenta, Color.red, Color.green, Color.orange, Color.pink};
        for(int i=0; i< rows*cols; i++){
            int diceNum = rnd.nextInt(6)+1;
            JButton btn = new JButton(diceNum+"");
            btn.setBackground(colors[diceNum-1]);
            add(btn);
        }

        setTitle("RandomGridDice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(250, 250);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    public static void main(String[] args){
        new RandomGridDice();
    }
}
