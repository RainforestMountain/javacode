import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class SignSystem extends JFrame {
    private JComboBox<String> userTypeComboBox;
    private JComboBox<String> teacherComboBox;
    private JComboBox<String> studentComboBox;
    private JTextField codeTextField;
    private JButton startButton;
    private JButton submitButton;
    private JTextArea infoTextArea;

    private String[] teachers = {"Teacher A", "Teacher B", "Teacher C"};
    private String[] students = {"Student 1", "Student 2", "Student 3"};

    private String selectedUserType;
    private String selectedTeacher;
    private String selectedStudent;

    private String code;
    private boolean isSignStarted = false;

    public SignSystem() {
        // 设置窗口标题和布局
        super("课堂签到系统");
        setLayout(new FlowLayout());

        // 创建用户类型选择框
        userTypeComboBox = new JComboBox<>(new String[]{"老师", "学生"});
        userTypeComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                selectedUserType = (String) userTypeComboBox.getSelectedItem();
                updateUI();
            }
        });
        add(userTypeComboBox);

        // 创建老师选择框
        teacherComboBox = new JComboBox<>(teachers);
        teacherComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                selectedTeacher = (String) teacherComboBox.getSelectedItem();
            }
        });
        add(teacherComboBox);

        // 创建学生选择框
        studentComboBox = new JComboBox<>(students);
        studentComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                selectedStudent = (String) studentComboBox.getSelectedItem();
            }
        });
        add(studentComboBox);

        // 创建开始签到按钮
        startButton = new JButton("开始签到");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (isSignStarted) {
                    JOptionPane.showMessageDialog(null, "签到已经开始");
                    return;
                }

                if (selectedUserType.equals("学生")) {
                    JOptionPane.showMessageDialog(null, "只有老师可以开始签到");
                    return;
                }

                code = generateCode();
                isSignStarted = true;
                JOptionPane.showMessageDialog(null, "签到已开始\n签到码：" + code);
            }
        });
        add(startButton);

        // 创建签到提交按钮
        submitButton = new JButton("提交签到");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (!isSignStarted) {
                    JOptionPane.showMessageDialog(null, "签到未开始");
                    return;
                }

                String inputCode = codeTextField.getText();
                if (!inputCode.equals(code)) {
                    JOptionPane.showMessageDialog(null, "签到码不正确");
                    return;
                }

                String record = selectedStudent + " 在 " + selectedTeacher + " 的课堂签到成功";
                saveRecord(record);
                JOptionPane.showMessageDialog(null, "签到成功");
                codeTextField.setText("");
            }
        });
        add(submitButton);

        // 创建显示信息的文本区域
        infoTextArea = new JTextArea(10, 30);
        add(new JScrollPane(infoTextArea));

        // 创建签到码输入框
        codeTextField = new JTextField(10);
        add(codeTextField);

        // 设置窗口属性
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private void updateUI() {
        if (selectedUserType == null || selectedUserType.equals("学生")) {
            teacherComboBox.setEnabled(false);
            studentComboBox.setEnabled(true);
            startButton.setEnabled(false);
            submitButton.setEnabled(true);
            codeTextField.setEnabled(true);
            infoTextArea.setText(getRecords());
        } else {
            teacherComboBox.setEnabled(true);
            studentComboBox.setEnabled(false);
            startButton.setEnabled(true);
            submitButton.setEnabled(false);
            codeTextField.setEnabled(false);
            infoTextArea.setText(getRecords());
        }
    }

    private String generateCode() {
        return String.valueOf((int) (Math.random() * 9000 + 1000));
    }

    private String getRecords() {
        String records = "";
        try (java.util.Scanner scanner = new java.util.Scanner(new java.io.File("data.txt"))) {
            while (scanner.hasNextLine()) {
                records += scanner.nextLine() + "\n";
            }
        } catch (java.io.IOException ioException) {
            ioException.printStackTrace();
        }
        return records;
    }

    private void saveRecord(String record) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true))) {
            writer.write(record);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SignSystem();
            }
        });
    }
}
