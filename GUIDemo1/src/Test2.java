import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JProgressBar bar = new JProgressBar();
        bar.setMaximum(1000);
        bar.setBounds(20, 50, 300, 10);

        JButton button = new JButton("点击开始");
        button.setBounds(20, 100, 100, 30);
        button.addActionListener(event -> new Thread(() -> {
            File file = new File("in.iso");
            try (FileInputStream in = new FileInputStream("E:\\java_code\\GUIDemo1\\ideaIC-2022.3.3.exe");
                 FileOutputStream out = new FileOutputStream("E:\\java_code\\GUIDemo1\\data.exe")) {
                long size = file.length(), current = 0;
                int len = 0;
                byte[] bytes = new byte[10];
                while ((len = in.read(bytes)) != -1) {
                    current = current + len;
                    bar.setValue((int) (bar.getMaximum() * (double) current / size));
                    bar.repaint();
                    out.write(bytes, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start());

        frame.add(button);
        frame.add(bar);

    }
}
