package com.awt;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("Test");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        Button button = new Button("click to recharge");   //Button是按钮组件
        button.setBounds(20, 50, 100, 50);
        frame.add(button);
        frame.add(button);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("opened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("closing");
                frame.dispose();
                System.exit(0);
            }
        });
        frame.setVisible(true);
        button.addActionListener(e -> System.out.println("click the button"));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize.toString());
//        for (Font font : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()) {
//            System.out.println(font);
//        }
//        Label label = new Label("label");
//        frame.add(label);
//        label.setFont(new Font("华文行楷",Font.PLAIN,14));
//        label.setLocation(new Point(100,100));
//        label.setSize(50,30);
//        label.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("clicked");
//            }
//        });
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
//        TextField textField = new TextField();
//        textField.setBounds(200, 100, 100, 30);
//        textField.setFont(new Font("华文行楷", Font.PLAIN, 14));
//        textField.setEchoChar('*');
//
//        button.addActionListener(e -> System.out.println("输入的用户名是：" + textField.getText()));
//        frame.add(textField);

//        TextArea textArea = new TextArea();
//        textArea.setBounds(200, 100, 100, 50);
//        textArea.setBackground(Color.yellow);
//        frame.add(textArea);
//        button.addActionListener(e -> System.out.println("输入的用户名是：" + textArea.getText()));

//        Checkbox checkbox = new Checkbox("记住密码");
//        checkbox.setBounds(200, 150, 100, 30);   //这个大小并不是勾选框的大小，具体的勾选框大小要根据操作系统决定，跟Label一样，是展示的空间大小
//        frame.add(checkbox);

        CheckboxGroup checkboxGroup = new CheckboxGroup();
        Checkbox checkbox1 = new Checkbox("M");
        checkbox1.setBounds(200, 150, 100, 30);
        Checkbox checkbox2 = new Checkbox("N");
        checkbox2.setBounds(200, 180, 100, 30);
        frame.add(checkbox1);
        frame.add(checkbox2);
//        checkboxGroup.setSelectedCheckbox(checkbox1);
//        checkboxGroup.setSelectedCheckbox(checkbox2);
        checkbox1.setCheckboxGroup(checkboxGroup);
        checkbox2.setCheckboxGroup(checkboxGroup);
        Button b = new Button("click the button");
        b.setBounds(200, 200, 100, 30);
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(checkboxGroup.getSelectedCheckbox().getLabel());
            }
        });
        frame.add(b);
    }
}
