package org.student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class StudentGUI {
    private StudentManager manager;
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;

    public StudentGUI() {
        manager = new StudentManager();
        frame = new JFrame("Student Manager");
        String[] columnNames = {"ID", "Name", "Gender", "Score"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        JButton findButton = new JButton("Find");
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findStudent();
            }
        });

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        JButton sortButton = new JButton("Sort");
        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortStudents();
            }
        });

        JPanel panel = new JPanel();
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(findButton);
        panel.add(updateButton);
        panel.add(sortButton);

        frame.add(new JScrollPane(table), "Center");
        frame.add(panel, "South");

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addStudent() {
        String id = JOptionPane.showInputDialog("Enter ID");
        String name = JOptionPane.showInputDialog("Enter Name");
        String gender = JOptionPane.showInputDialog("Enter Gender");
        double score = Double.parseDouble(JOptionPane.showInputDialog("Enter Score"));

        Student student = new Student(id, name, gender, score);
        manager.addStudent(student);

        updateTable();
    }

    private void deleteStudent() {
        String id = JOptionPane.showInputDialog("Enter ID to delete");

        manager.deleteStudent(id);

        updateTable();
    }

    private void findStudent() {
        String id = JOptionPane.showInputDialog("Enter ID to find");
        Student student = manager.findStudent(id);

        if (student != null) {
            JOptionPane.showMessageDialog(null, "Found student: " + student.getName());
        } else {
            JOptionPane.showMessageDialog(null, "Student not found");
        }
    }

    private void updateStudent() {
        String id = JOptionPane.showInputDialog("Enter ID to update");
        String name = JOptionPane.showInputDialog("Enter new Name");
        String gender = JOptionPane.showInputDialog("Enter new Gender");
        double score = Double.parseDouble(JOptionPane.showInputDialog("Enter new Score"));

        Student newStudent = new Student(id, name, gender, score);
        manager.updateStudent(id, newStudent);

        updateTable();
    }

    private void sortStudents() {
        manager.sortStudents();
        updateTable();
    }

    private void updateTable() {
        model.setRowCount(0);
        for (Student student : manager.getStudents()) {
            model.addRow(new Object[]{student.getId(), student.getName(), student.getGender(), student.getScore()});
        }
    }

    public static void main(String[] args) {
        new StudentGUI();
    }
}