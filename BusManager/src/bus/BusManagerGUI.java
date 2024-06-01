package bus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class BusManagerGUI {
    private BusManager manager;
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JFrame showFrame;

    public BusManagerGUI() {
        manager = new BusManager();
        frame = new JFrame("汽车车票管理系统");
        String[] columnNames = {"班次", "发车时间", "起点站", "终点站", "行车时间", "额定票数"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        //table.getColumn(model.getColumnName(1)).setPreferredWidth(200);

        JButton addButton = new JButton("增加班次");
        addButton.addActionListener(e -> add());
        addButton.setPreferredSize(new Dimension(100, 40));

        JButton deleteButton = new JButton("删除班次");
        deleteButton.addActionListener(e -> delete());
        deleteButton.setPreferredSize(new Dimension(100, 40));

        JButton modifyButton = new JButton("修改班次");
        modifyButton.addActionListener(e -> modify());
        modifyButton.setPreferredSize(new Dimension(100, 40));

        JButton findBybusNumberButton = new JButton("按班次查询");
        findBybusNumberButton.addActionListener(e -> findBybusNumber());
        findBybusNumberButton.setPreferredSize(new Dimension(100, 40));

        JButton findByendStationButton = new JButton("按终点站查询");
        findByendStationButton.addActionListener(e -> findByendStation());
        findByendStationButton.setPreferredSize(new Dimension(100, 40));

        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout();
        gridLayout.setRows(5);
        gridLayout.setVgap(40);
        panel.setLayout(gridLayout);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(modifyButton);
        panel.add(findBybusNumberButton);
        panel.add(findByendStationButton);
        panel.setPreferredSize(new Dimension(150, 600));

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.EAST);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                loading();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                save();
            }
        });

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private void findByendStation() {
        String endStation = JOptionPane.showInputDialog("输入要查询的终点站");
        List<Bus> temp = manager.findByendStation(endStation);
        if (temp.isEmpty()) {
            JOptionPane.showMessageDialog(null, "没有此路线");
        } else {
            show(temp);
        }
    }

    private void findBybusNumber() {
        String busNumber = JOptionPane.showInputDialog("输入要查询的班次");
        int index = manager.findBybusNumber(busNumber);
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "没有此路线");
        } else {
            List<Bus> temp = new ArrayList<>();
            temp.add(manager.getBuses().get(index));
            show(temp);
        }
    }

    private void show(List<Bus> temp) {
        frame.dispose();
        showFrame = new JFrame();
        showFrame.setUndecorated(true);
        showFrame.setSize(800, 600);
        showFrame.setLocationRelativeTo(null);
        showFrame.setLayout(new BorderLayout());

        String[] columnNames = {"班次", "发车时间", "起点站", "终点站", "行车时间", "额定票数"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        tableModel.setRowCount(0);
        tableModel.setRowCount(0);
        for (Bus bus : temp) {
            tableModel.addRow(new Object[]{bus.getBusNumber(), bus.getDepartureTime(), bus.getStartStation(),
                    bus.getEndStation(), bus.getTravelTime(), bus.getTicketCount()});
        }
        JTable jTable = new JTable(tableModel);

        JButton exitButton = new JButton("退出当前页面");
        exitButton.setPreferredSize(new Dimension(50, 20));

        JScrollPane sPane = new JScrollPane(jTable);

        showFrame.add(exitButton, BorderLayout.SOUTH);
        showFrame.add(sPane, BorderLayout.CENTER);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFrame.dispose();
                frame.setVisible(true);
            }
        });

        showFrame.setVisible(true);
    }

    private void modify() {
        String busNumber = JOptionPane.showInputDialog("输入要修改的班次");
        String departureTime = JOptionPane.showInputDialog("输入发车时间 hh:mm");
        String startStation = JOptionPane.showInputDialog("输入起点站");
        String endStation = JOptionPane.showInputDialog("输入终点站");
        String travelTime = JOptionPane.showInputDialog("输入行车时间 hh:mm");
        int ticketCount = Integer.parseInt(JOptionPane.showInputDialog("输入额定票数"));
        Bus newbus = new Bus(busNumber, departureTime, startStation, endStation, travelTime, ticketCount);
        boolean b = manager.modifyBus(busNumber, newbus);
        if (b) {
            JOptionPane.showMessageDialog(null, "修改成功");
        } else {
            JOptionPane.showMessageDialog(null, "修改失败");
        }

        updateBus();
    }

    private void delete() {
        String busNumber = JOptionPane.showInputDialog("输入要删除的班次");
        boolean b = manager.deleteBus(busNumber);
        if (b) {
            JOptionPane.showMessageDialog(null, "删除成功");
        } else {
            JOptionPane.showMessageDialog(null, "删除失败");
        }

        updateBus();
    }

    private void add() {
        String busNumber = JOptionPane.showInputDialog("输入要增加的班次");
        String departureTime = JOptionPane.showInputDialog("输入发车时间 hh:mm");
        String startStation = JOptionPane.showInputDialog("输入起点站");
        String endStation = JOptionPane.showInputDialog("输入终点站");
        String travelTime = JOptionPane.showInputDialog("输入行车时间 hh:mm");
        int ticketCount = Integer.parseInt(JOptionPane.showInputDialog("输入额定票数"));
        Bus bus = new Bus(busNumber, departureTime, startStation, endStation, travelTime, ticketCount);
        boolean ret = manager.addBus(bus);
        if (ret) {
            JOptionPane.showMessageDialog(null, "增加成功");
        } else {
            JOptionPane.showMessageDialog(null, "增加失败");
        }

        updateBus();
    }

    private void updateBus() {
        model.setRowCount(0);
        for (Bus bus : manager.getBuses()) {
            model.addRow(new Object[]{bus.getBusNumber(), bus.getDepartureTime(), bus.getStartStation(),
                    bus.getEndStation(), bus.getTravelTime(), bus.getTicketCount()});
        }
    }

    private void save() {
        manager.save();

        updateBus();
    }

    private void loading() {
        manager.loading();

        updateBus();
    }

    public static void main(String[] args) {
        new BusManagerGUI();
    }
}
