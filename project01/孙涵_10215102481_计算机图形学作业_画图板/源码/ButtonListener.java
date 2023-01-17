import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//获取形状和颜色

public class ButtonListener implements ActionListener {
    Color color;
    String shape;
    DrawListener drawListener;

    public ButtonListener(DrawListener drawListener) {
        this.drawListener = drawListener;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals("")){
            JButton btn = (JButton) actionEvent.getSource();
            color = btn.getBackground();
            drawListener.setColor(color);
            System.out.println(color.toString());
        }else {
            JButton btn = (JButton) actionEvent.getSource();
            shape = btn.getActionCommand();
            drawListener.setShape(shape);
            System.out.println(shape.toString());
        }
    }

    public Color getColor() {
        return color;
    }

    public String getShape() {
        return shape;
    }


}
