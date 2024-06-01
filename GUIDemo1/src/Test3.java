import javax.swing.*;
import java.awt.*;

public class Test3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
//        JColorChooser chooser = new JColorChooser();
//        chooser.setBounds(0, 0, 600, 300);
//        frame.add(chooser);

//        JButton button = new JButton("按钮");
//        button.setBounds(20, 50, 100, 30);
//        button.setToolTipText("help");
//        frame.add(button);

//        JToggleButton button = new JToggleButton("切换按钮");
//        button.setBounds(20, 30, 100, 30);
//        frame.add(button);

//        //这里我们让JTree展示.idea目录下所有文件
//        File file = new File(".idea");   //这里我们列出.idea目录下所有文件
//        DefaultMutableTreeNode root = new DefaultMutableTreeNode(file.getName()); //既然是树形关系，肯定有一个根结点
//        //拿到当前目录下所有文件和文件夹
//        File[] files = Optional.ofNullable(file.listFiles()).orElseGet(() -> new File[0]);
//        for (File f : files) {
//            root.add(new DefaultMutableTreeNode(f.getName()));    //构造子结点并连接
//        }
//
//        JTree tree = new JTree(root);    //设定默认的根结点
//        tree.setBounds(10, 10, 200, 200);
//        frame.add(tree);

//        JFileChooser chooser = new JFileChooser("E:\\java_code\\GUIDemo1");
//        chooser.setBounds(0, 0, 500, 300);
//        chooser.setBackground(Color.cyan);
//        frame.add(chooser);


    }
}
