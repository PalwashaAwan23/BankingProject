import java.util.LinkedList;
import java.util.logging.Handler;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GUI extends JFrame{
    Transaction transferObject = new Transaction();

    StringBuilder sbAllData = new StringBuilder();
    LinkedList<Account> globalAccounts = new LinkedList<Account>();

    private JLabel showAllData;
    private JButton showAllButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transferButton;

    private JTextField accDeposit;
    private JTextField accWithdraw;
    private JTextField acc1Transfer;
    private JTextField acc2Transfer;
    private JTextField depositInput;
    private JTextField withdrawInput;
    private JTextField transferAmount;

    public GUI(LinkedList<Account> account){
        super("Banking Project ");
        setLayout(null);
        
        this.globalAccounts = account;
        
        for (int i = 0; i < account.size() - 1; i++){
            sbAllData.append(globalAccounts.get(i));
        }

        

        showAllButton = new JButton("Show All");
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        transferButton = new JButton("Transfer");

        accDeposit = new JTextField("Account Deposit ");
        accWithdraw = new JTextField("Account Withdraw");
        acc1Transfer = new JTextField("Account Deposit Name");
        acc2Transfer = new JTextField("Account Withdraw Name");
        depositInput = new JTextField("Deposit Amount ");
        withdrawInput = new JTextField("Withdraw Amount ");
        transferAmount = new JTextField("Transfer Amount");

        showAllButton.setBounds(10, 40, 100, 20);
        depositButton.setBounds(10, 70, 100, 20);
        withdrawButton.setBounds(10, 100, 100, 20);
        transferButton.setBounds(10, 130, 100, 20);
        accDeposit.setBounds(120, 40, 200, 20);
        accWithdraw.setBounds(120, 70, 200, 20);
        acc1Transfer.setBounds(120, 100, 200, 20);
        acc2Transfer.setBounds(120, 130, 200, 20);
        depositInput.setBounds(330, 40, 100, 20);
        withdrawInput.setBounds(330, 70, 100, 20);
        transferAmount.setBounds(330, 100, 100, 20);

        add(showAllButton);
        add(depositButton);
        add(withdrawButton);
        add(transferButton);

        add(accDeposit);
        add(accWithdraw);
        add(acc1Transfer);
        add(acc2Transfer);
        add(depositInput);
        add(withdrawInput);
        add(transferAmount);

        HandlerClass handler = new HandlerClass();
    }
    
    private class HandlerClass implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == depositButton) {
                System.out.println("...");

            } else if (e.getSource() == showAllButton){
                System.out.println("...");

            } else if (e.getSource() == withdrawButton){
                int accountWithdraw = Integer.parseInt(withdrawInput.getText());

            } else if (e.getSource() == transferButton) {
                int acc1 = Integer.parseInt(acc1Transfer.getText());
                int acc2 = Integer.parseInt(acc2Transfer.getText());
                double amount = Double.parseDouble(transferAmount.getText());
                transferObject.transfer(globalAccounts.get(acc1), globalAccounts.get(acc2), 300);
                JOptionPane.showInputDialog(null, sbAllData.toString(), "All Accounts", JOptionPane.PLAIN_MESSAGE);
            }

            
        }

    }
}

