import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;


public class DrawListener extends JFrame implements MouseListener, MouseMotionListener {


    Color color = Color.black;
    String shape = "直线";
    Graphics g;
    JPanel jp2;
    int x0,x1,x2,y0,y1,y2,newx1,newy1,newx2,newy2;
    boolean flag = true;




    @Override
    public void mouseClicked(MouseEvent e) {
    }


    @Override
    public void mousePressed(MouseEvent e) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));
        System.out.println("mousePressed");
        x1 = e.getX();
        y1 = e.getY();
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));
        System.out.println("mouseReleased");
        x2 = e.getX();
        y2 = e.getY();
        int w = x2-x1;
        int h = y2-y1;

        //绘制图形
        if (shape.equals("直线")){
            System.out.println("2");
            g.drawLine(x1,y1,x2,y2);
        }else if (shape.equals("矩形")){
            g.drawRect(Math.min(x1,x2),Math.min(y1,y2),Math.abs(w),Math.abs(h));
        }else if (shape.equals("椭圆")){
            g.drawOval(Math.min(x1,x2),Math.min(y1,y2),Math.abs(w),Math.abs(h));
        }else if(shape.equals("弧线")){
            g.drawArc(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1), 0, 180);
        }else if (shape.equals("正圆")){
            g.drawOval(Math.min(x1,x2),Math.min(y1,y2),Math.abs(w),Math.abs(w));
        }else if (shape.equals("正方形")){
            g.drawRect(Math.min(x1,x2),Math.min(y1,y2),Math.abs(w),Math.abs(w));
        }else if(shape.equals("圆角矩形")){
            g.drawRoundRect(Math.min(x1,x2),Math.min(y1,y2),Math.abs(w),Math.abs(h),10,10);
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));
        System.out.println("mouseDragged");
        x2 = e.getX();
        y2 = e.getY();
        if (shape.equals("画笔")) {
            g.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }else if(shape.equals("橡皮擦")){
            g2.setStroke(new BasicStroke(80));
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(Color.WHITE);
            g.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }else if(shape.equals("喷枪")){
            for(int k=0;k<20;k++){
                Random i=new Random();
                int a=i.nextInt(8);
                int b=i.nextInt(10);
                g.drawLine(x2+a, y2+b, x2+a, y2+b);
            }
        }
    }


    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void setColor(Color color) {
        this.color = color;
        g.setColor(color);
    }

    public void setShape(String shape) {
        Graphics2D g2 = (Graphics2D) g;
        if(this.shape.equals("橡皮擦")){
            g.setColor(Color.black);
        }else {
            this.shape = shape;
        }
    }

}
