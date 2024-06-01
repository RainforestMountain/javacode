package com.swing;

import javax.swing.*;

public class HelloSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloWorldSwing");
        JLabel label = new JLabel("第一个Swing程序",SwingConstants.CENTER);
        frame.setSize(400,300);

        frame.add(label);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
