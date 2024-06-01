package com.awt;

import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;

/**
 *
 */

public class TestDemo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Frame frame = new Frame("Test");
        frame.setSize(new Dimension(200, 300));
        //frame.setBackground(Color.lightGray);//颜色
//        frame.setLocationRelativeTo(null);//居中
        frame.setLocation(400, 200);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {

                System.out.println("窗口已经打开");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("窗口已经关闭");
                System.exit(0);
            }
        });
        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }
        });

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getButton());
                System.out.println(e.getXOnScreen() + " , " + e.getYOnScreen());
            }
        });

        frame.addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println(e.getWheelRotation());
            }
        });

        //frame.setLayout(null);
        String str1 = new String("i am a label;");
        byte[] bytes = str1.getBytes("UTF-8");
        String str2 = new String(bytes, "UTF-8");
        Label label = new Label(str2);
        label.setSize(100, 100);
        label.setLocation(100, 20);
        frame.add(label);
    }
}
