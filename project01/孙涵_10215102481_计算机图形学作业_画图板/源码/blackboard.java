import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class blackboard {

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        JButton [] drawButton = new  JButton[20];
        JButton [] colorButton = new JButton[20];

        DrawListener drawListener = new DrawListener();
        ButtonListener buttonListener = new ButtonListener(drawListener);


        Prepare p = new Prepare(jf,jp1,jp2,jp3,drawButton,colorButton,buttonListener,drawListener);
        p.prepareJf();
        p.preparePanel();
        p.prepareButton();
        p.prepareDraw();
    }
}
