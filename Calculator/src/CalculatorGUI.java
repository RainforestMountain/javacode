import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    private JFrame frame;
    private JTextField textField;

    public CalculatorGUI() {
        frame = new JFrame("Calculator");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        container.setPreferredSize(new Dimension(500, 200));

        textField = new JTextField();
        container.add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        frame.add(panel, BorderLayout.CENTER);

        addButton(panel, "Add", e -> performOperation(Operation.ADD));
        addButton(panel, "Subtract", e -> performOperation(Operation.SUBTRACT));
        addButton(panel, "Multiply", e -> performOperation(Operation.MULTIPLY));
        addButton(panel, "Divide", e -> performOperation(Operation.DIVIDE));
        addButton(panel, "Square root", e -> performOperation(Operation.SQUARE_ROOT));
        addButton(panel, "Clear", e -> textField.setText(""));

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addButton(Container container, String title, ActionListener listener) {
        JButton button = new JButton(title);
        button.addActionListener(listener);
        container.add(button);
    }

    private void performOperation(Operation operation) {
        String[] numbers = textField.getText().split("\\s");
        double result = 0;

        switch (operation) {
            case ADD:
                result = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                break;
            case SUBTRACT:
                result = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                break;
            case MULTIPLY:
                result = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                break;
            case DIVIDE:
                result = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                break;
            case SQUARE_ROOT:
                result = Math.sqrt(Double.parseDouble(numbers[0]));
                break;
        }

        textField.setText(String.valueOf(result));
    }

    private enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, SQUARE_ROOT
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}