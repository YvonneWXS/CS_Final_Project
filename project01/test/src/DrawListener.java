import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawListener implements ActionListener, MouseListener {

    private int x1,x2,y1,y2;
    private String name;
    private Color color;
    public Graphics g;

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("")){
            //点击颜色按钮
            JButton jButton = (JButton)e.getSource();
            color = jButton.getBackground();
            g.setColor(color);
        }else {
            //点击图形按钮
            name = command;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        int w = x2-x1;
        int h = y2-y1;

        //绘制图形

        if (name.equals("直线")){
            g.drawLine(x1,y1,x2,y2);
        }else if (name.equals("矩形")){
            g.drawRect(Math.min(x1,x2),Math.min(y1,y2),Math.abs(w),Math.abs(h));
        }else if (name.equals("圆")){
            g.drawOval(Math.min(x1,x2),Math.min(y1,y2),Math.abs(w),Math.abs(h));
        }else if (name.equals("实心圆")){
            g.fillOval(Math.min(x1,x2),Math.min(y1,y2),Math.abs(w),Math.abs(h));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
