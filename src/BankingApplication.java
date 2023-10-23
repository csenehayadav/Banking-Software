import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class BankingApplication {
    private JFrame frame;
    private JTextField accountNumberField;
    private JTextField accountHolderField;
    private JTextField initialBalanceField;
    private JTextArea outputArea;

    public BankingApplication() {
        // Create the main frame
        frame = new JFrame("Banking Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the GUI components
        accountNumberField = new JTextField(10);
        accountHolderField = new JTextField(20);
        initialBalanceField = new JTextField(10);
        outputArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        JButton createAccountButton = new JButton("Create Account");

        // Add action listener for the Create Account button
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });

        // Create a panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Account Number:"));
        inputPanel.add(accountNumberField);
        inputPanel.add(new JLabel("Account Holder:"));
        inputPanel.add(accountHolderField);
        inputPanel.add(new JLabel("Initial Balance:"));
        inputPanel.add(initialBalanceField);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createAccountButton);

        // Add components to the frame
        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void createAccount() {
        String accountNumber = accountNumberField.getText();
        String accountHolder = accountHolderField.getText();
        double initialBalance = Double.parseDouble(initialBalanceField.getText());

        // Create a simple output string (replace this with your BankAccount logic)
        String outputText = "Account created successfully:\n" +
                "Account Number: " + accountNumber + "\n" +
                "Account Holder: " + accountHolder + "\n" +
                "Balance: $" + initialBalance + "\n\n";

        outputArea.append(outputText);

        // Clear input fields
        accountNumberField.setText("");
        accountHolderField.setText("");
        initialBalanceField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BankingApplication();
            }
        });
    }
}

