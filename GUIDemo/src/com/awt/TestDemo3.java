package com.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestDemo3 {
    public static void main(String[] args) throws InterruptedException {
        Frame frame = new Frame("frame");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        //        });

//        BorderLayout bl = new BorderLayout();
//        bl.setHgap(50);
//        bl.setVgap(50);
//        frame.setLayout(bl);
//        frame.add(new Button("1 button"), BorderLayout.WEST);
//        frame.add(new Button("2 button"), BorderLayout.EAST);
//        frame.add(new Button("3 button"), BorderLayout.CENTER);
//        frame.add(new Button("4 button"), BorderLayout.NORTH);
//        frame.add(new Button("5 button"), BorderLayout.SOUTH);

//        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 50, 50);
//        frame.setLayout(fl);
//        frame.add(new Button("1 button"));
//        frame.add(new Button("2 button"));
//        frame.add(new Button("3 button"));
//        frame.add(new Button("4 button"));
//        frame.add(new Button("5 button"));

//        CardLayout layout = new CardLayout();
//        frame.setLayout(layout);
//        Label label1 = new Label("the first");
//        label1.setPreferredSize(new Dimension(50, 30));
//        frame.add(label1);
//        Label label2 = new Label("the second");
//        label2.setPreferredSize(new Dimension(50, 30));
//        frame.add(label2);
//
//        frame.setVisible(true);
//
//        while (true) {
//            Thread.sleep(3000);
//            layout.next(frame);    //我们需要使用CardLayout对象来进行切换
//        }

//        GridLayout gridLayout  = new GridLayout();
//        gridLayout.setRows(3);
//        frame.setLayout(gridLayout);
//        for (int i = 0; i < 9; i++) {
//            frame.add(new Button("this is the " + i));
//        }

//        GridLayout gridLayout = new GridLayout();
//        gridLayout.setRows(2);
//        frame.setLayout(gridLayout);
//
//        Panel top = new Panel();
//        top.setBackground(Color.pink);
//        frame.add(top);
//
//        Button button1 = new Button("this is the first button");
//        button1.setBounds(50, 50, 100, 30);
//        button1.setBackground(Color.black);
//        button1.setForeground(Color.white);
//        top.add(button1);
//
//        Panel bottom = new Panel();
//        bottom.setBackground(Color.GREEN);
//        frame.add(bottom);
//
//        for (int i = 0; i < 5; i++) {
//            bottom.add(new Button("girdBag " + i));
//        }
//        frame.add(bottom);

        ScrollPane scrollPane = new ScrollPane();
        frame.add(scrollPane);

//        GridLayout gridLayout = new GridLayout();
//        gridLayout.setRows(20);
//        Panel panel = new Panel();
//        panel.setLayout(gridLayout);
//        for (int i = 0; i < 20; i++) {
//            Button button = new Button("this is " + i);
//            button.setPreferredSize(new Dimension(100, 30));
//            panel.add(button);
//        }
//        //frame.add(panel);
//        scrollPane.add(panel);

//        List list = new List();
//        list.add("prompt");
//        list.add("decline");
//        list.add("meaning");
//        list.add("indispensable");
//        list.setMultipleMode(true);
////        GridLayout gridLayout = new GridLayout();
////        gridLayout.setRows(2);
////        Panel panel = new Panel();
////        panel.add(list);
////        panel.setLayout(gridLayout);
////        scrollPane.add(panel);
//        list.addItemListener(System.out::println);
//        scrollPane.add(list);

//        MenuBar menuBar = new MenuBar();
//        Menu menu = new Menu("Menu");
//        CheckboxMenuItem item1 = new CheckboxMenuItem("first");
//        CheckboxMenuItem item2 = new CheckboxMenuItem("second");
//        CheckboxMenuItem item3 = new CheckboxMenuItem("third");
//        menu.add(item1);
//        menu.add(item2);
//        menu.add(item3);
//        menu.addSeparator();
//        item1.addActionListener(e -> System.out.println(item1.getLabel() + " is "));
//
//        menuBar.add(menu);
//        frame.setMenuBar(menuBar);
//        item1.setShortcut(new MenuShortcut('H'));

//        PopupMenu menu = new PopupMenu();    //创建弹出菜单
//        menu.add(new MenuItem("1"));   //每一个选项依然是使用MenuItem
//        menu.add(new MenuItem("2"));
//        frame.add(menu);    //注意，弹出菜单也要作为组件加入到窗口中（但是默认情况下不显示）
//
//        frame.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                if (e.getButton() == MouseEvent.BUTTON3) {  //监听鼠标右键
//                    menu.show(frame, e.getX(), e.getY());   //要展示弹出菜单，我们只需要调用show方法即可
//                    //注意，第一个参数必须是弹出菜单所加入的窗口或是窗口中的任意一个组件
//                    //后面的坐标就是相对于这个窗口或是组件的原点（左上角）这个位置进行弹出
//                    //我们这里写的就是相对于当前窗口的左上角，鼠标点击位置的x、y位置弹出窗口
//                }
//            }
//        });
//        Dialog dialog = new Dialog(frame, "dialog", true);
//        dialog.setSize(200, 80);
//
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                dialog.setVisible(true);
//            }
//        });

        FileDialog dialog = new FileDialog(frame, "请选择一个文件", FileDialog.LOAD);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.setVisible(true);   //注意，需要将对话框展示出来之后，才能进行选择
                //选择完成之后getDirectory和getFile方法就可以返回结果了，否则会阻塞
                System.out.println("选择的文件为："+dialog.getDirectory() + dialog.getFile());
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("opened");
            }
        });
        frame.setVisible(true);

    }
}
