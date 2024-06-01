import javax.swing.*;
import java.awt.*;

public class Test4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JSplitPane pane = new JSplitPane();
        pane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);  //设定为横向分割
        //横向分割之后，我们需要指定左右两边的组件
        pane.setLeftComponent(new JPanel() {{
            setBackground(Color.ORANGE);
        }});
        pane.setRightComponent(new JPanel() {{
            setBackground(Color.PINK);
        }});
        frame.add(pane);
    }
}
