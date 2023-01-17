import javax.swing.*;
import java.awt.*;

public class DrawTest {

    //可绘制的图形
    private String[] strs = {"直线","矩形","圆","实心圆"};
    //可选颜色
    private Color[] colors = {
            Color.BLACK,
            Color.LIGHT_GRAY,
            Color.GRAY,
            Color.WHITE,
            Color.YELLOW,
            Color.RED,
            Color.GREEN,
            Color.BLUE
    };

    public void show(){
        JFrame jf = new JFrame("图形绘制");

        jf.setSize(1000,1000);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlowLayout fl = new FlowLayout();
        jf.setLayout(fl);
        //设置监听
        DrawListener drawListener = new DrawListener();

        //设置大小
        Dimension dm = new Dimension(75,50);

        for (int i = 0; i < strs.length; i++) {
            JButton jButton = new JButton(strs[i]);
            jButton.setPreferredSize(dm);
            jButton.addActionListener(drawListener);
            jf.add(jButton);
        }

        for (int i = 0; i < colors.length; i++) {
            JButton jButton = new JButton();
            jButton.setBackground(colors[i]);
            jButton.setPreferredSize(dm);
            jButton.addActionListener(drawListener);
            jf.add(jButton);
        }

        jf.setVisible(true);

        //向drawListener中传入g必须在setVisible之后
        Graphics g = jf.getGraphics();
        drawListener.g = g;

        jf.addMouseListener(drawListener);
    }

    public static void main(String[] args) {
        new DrawTest().show();
    }
}
