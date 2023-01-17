import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Prepare {
    JFrame jf;
    JPanel jp1;
    JPanel jp2;
    JPanel jp3;
    JButton [] drawButton;
    JButton [] colorButton;
    Graphics g;
    ButtonListener buttonListener;
    DrawListener drawListener;

    public Prepare(JFrame jf, JPanel jp1,JPanel jp2, JPanel jp3, JButton[] drawButton, JButton[] colorButton, ButtonListener buttonListener, DrawListener drawListener) {
        this.jf = jf;
        this.jp1 = jp1;
        this.jp2 = jp2;
        this.jp3 = jp3;
        this.drawButton = drawButton;
        this.colorButton = colorButton;
        this.buttonListener = buttonListener;
        this.drawListener = drawListener;

    }

    public void prepareJf(){
        jf.setVisible(true);
        jf.setTitle("简易画图板");
        jf.setSize(1000,1000);
        jf.setLayout(new BorderLayout());
        jf.setDefaultCloseOperation(3);
        jf.addMouseListener(drawListener);
    }

    public void preparePanel(){
        jp1.setBackground(Color.BLACK);
        jp1.setLayout(new FlowLayout(FlowLayout.CENTER));
        jp1.setBackground(Color.GRAY);
        jf.add(jp1,BorderLayout.NORTH);

        jp2.setBackground(Color.WHITE);
        jp2.addMouseListener(drawListener);
        jp2.addMouseMotionListener(drawListener);
        jp2.setVisible(true);
        g = jp2.getGraphics();
        drawListener.g = g;
        jf.add(jp2,BorderLayout.CENTER);

        jp3.setLayout(new FlowLayout((FlowLayout.CENTER)));
        jp3.setBackground(Color.black);
        jp3.setLayout(new FlowLayout(FlowLayout.CENTER));
        jp3.setBackground(Color.gray);
        jf.add(jp3,BorderLayout.SOUTH);
    }

    public void prepareButton(){
        String [] shape = {"直线","椭圆","正圆","矩形","正方形","圆角矩形","画笔","喷枪","弧线","橡皮擦"};
        for(int i = 0; i < shape.length; i++){
            drawButton[i] = new JButton(shape[i]);
            drawButton[i].setBackground(Color.WHITE);
            drawButton[i].addActionListener(buttonListener);
            jp1.add(drawButton[i]);
        }


        Color[] colorList = {Color.BLACK,Color.BLUE,Color.CYAN,Color.DARK_GRAY,Color.GRAY,Color.GREEN,Color.LIGHT_GRAY,Color.MAGENTA,Color.magenta,Color.ORANGE,Color.PINK,Color.RED,Color.WHITE,Color.YELLOW};
        for(int i = 0; i < colorList.length; i++){
            colorButton[i] = new JButton();
            colorButton[i].setBackground(colorList[i]);
            colorButton[i].setPreferredSize(new Dimension(30,30));
            colorButton[i].addActionListener(buttonListener);
            jp3.add(colorButton[i]);
        }

    }

    public void prepareDraw(){
        jp2.setVisible(true);
        g = jp2.getGraphics();
        drawListener.g = g;
    }


}
