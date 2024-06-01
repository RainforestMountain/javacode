import javax.swing.*;
import java.awt.*;

public class Test1 {
    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.setSize(400, 300);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 10, 20);
//        frame.setLayout(flowLayout);
//
////        JButton button = new JButton("我是按钮");
////        button.setPreferredSize(new Dimension(100, 30));
////        frame.add(button);
//
//        JMenuBar menuBar = new JMenuBar();
//        JMenu fileMenu = new JMenu("文件");
//        JMenu helpMenu = new JMenu("打开");
//        menuBar.add(fileMenu);
//        menuBar.add(helpMenu);
//
//        fileMenu.add(new JMenuItem("新建"));
//        fileMenu.add(new JMenuItem("打开"));
//        fileMenu.addSeparator();
//        fileMenu.add(new JMenuItem("打印"));
//
//        helpMenu.add(new JMenuItem("进入网站"));
//
//        frame.setJMenuBar(menuBar);

        JFrame frame = new JFrame("我是窗口");
        JMenuBar bar = new JMenuBar();    //JMenuBar对应的就是MenuBar
        JMenu menu = new JMenu("我是菜单");
        menu.add(new JMenuItem("选项1"));
        menu.add(new JMenuItem("选项2"));
        bar.add(menu);
        frame.setJMenuBar(bar);
        frame.setSize(500, 300);
        frame.setVisible(true);

    }
}
