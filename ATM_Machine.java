import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ATM_Machine {
    Frame frame = new Frame("ATM Machine");
    Balance b = new Balance();

    ATM_Machine() {
        frame.setLayout(new BorderLayout());

        Label label = new Label("Welcome to the online bank!!!!");
        label.setAlignment(Label.CENTER);
        frame.add(label, BorderLayout.NORTH);

        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout(0,0,50));

        Button b1 = new Button("Deposit");
        Button b2 = new Button("Withdraw");
        Button b3 = new Button("Check balance");
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);

        frame.add(buttonPanel, BorderLayout.CENTER);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame depositFrame = new Frame("Deposit");
                depositFrame.setLayout(new FlowLayout());

                Label depositLabel = new Label("Please enter the value you want to deposit");
                TextField tf = new TextField(10);
                Button depositButton = new Button("Deposit");

                depositFrame.add(depositLabel);
                depositFrame.add(tf);
                depositFrame.add(depositButton);

                depositButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int tfint = Integer.parseInt(tf.getText());
                        b.balance += tfint;
                        depositFrame.dispose();
                    }
                });
                depositFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                depositFrame.pack();
                depositFrame.setVisible(true);
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame withdrawFrame = new Frame("Withdraw");
                withdrawFrame.setLayout(new FlowLayout());

                Label withdrawLabel = new Label("Please enter the value you want to withdraw");
                TextField tf = new TextField(10);
                Button withdrawButton = new Button("Withdraw");

                withdrawFrame.add(withdrawLabel);
                withdrawFrame.add(tf);
                withdrawFrame.add(withdrawButton);

                withdrawButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int tfint = Integer.parseInt(tf.getText());
                        if (tfint <= b.balance) {
                            b.balance -= tfint;
                            withdrawFrame.dispose();
                        } else {
                            Label errorLabel = new Label("Insufficient funds");
                            withdrawFrame.add(errorLabel);
                        }
                    }
                });
                withdrawFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                withdrawFrame.pack();
                withdrawFrame.setVisible(true);
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Label balanceLabel = new Label("Your current balance: " + b.balance);
                Frame balanceFrame = new Frame("Balance");
                balanceFrame.setLayout(new FlowLayout());
                balanceFrame.add(balanceLabel);
                balanceFrame.pack();
                balanceFrame.setVisible(true);
                balanceFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
        frame.setSize(250,200);
    }

    public static void main(String[] args) {
        ATM_Machine a1 = new ATM_Machine();
    }
}

class Balance {
    int balance = 5000;
}
