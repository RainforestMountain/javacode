package com.awt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

public class TestDemo4 {
    public static void main(String[] args) throws IOException {
        Frame frame = new Frame("frame");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);

        frame.setUndecorated(true);
        frame.setShape(new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(),20, 20));
        frame.setVisible(true);

        GridLayout gridLayout = new GridLayout();
        frame.setLayout(gridLayout);
        frame.add(new ImageView("F:\\壁纸\\005AiVyoly1hj4chcy4v2j30u0190wtr.jpg"));
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        Image image = ImageIO.read(new File("F:\\壁纸\\20230510114303393.png"));
        frame.setIconImage(image);
        frame.addMouseMotionListener(new MouseMotionAdapter() {   //只需要写一个监听器就可以搞定了
            int oldX, oldY;
            public void mouseDragged(MouseEvent e) {   //鼠标拖动时如果是标题栏，就将窗口位置修改
                if(e.getY() <= 28)
                    frame.setLocation(e.getXOnScreen() - oldX, e.getYOnScreen() - oldY);
            }

            public void mouseMoved(MouseEvent e) {   //记录上一次的鼠标位置
                oldX = e.getX();
                oldY = e.getY();
            }
        });


    }
}
