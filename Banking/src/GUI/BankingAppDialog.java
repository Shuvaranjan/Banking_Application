package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Database.MyJDBC;
import Database.Transaction;
import Database.User;

/*
 * Diasplay a Custom Dialog on our Banking GUI
 */
public class BankingAppDialog extends JDialog implements ActionListener {
    private User user;
    private BankingAppGUI bankingAppGUI;
    private JLabel balancelabel, enterAmountLabel, enterUserLabel;
    private JTextField enterAmountField, enterUserField;
    private JButton actionButton;
    private JPanel pastTransactioPanel;
    private ArrayList<Transaction> pastTransactions;

    public BankingAppDialog(BankingAppGUI bankingAppGUI, User user) {
        // set size
        setSize(400, 400);

        setModal(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setResizable(false);

        // null select because manually set position and the Size of each component
        setLayout(null);

        // set the Location to center of the BankingApp GUI
        setLocationRelativeTo(bankingAppGUI);

        getContentPane().setBackground(new Color(21, 21, 21));

        this.bankingAppGUI = bankingAppGUI;

        this.user = user;

    }

    public void addCurrentBalanceAndamount() {
        // balance label
        balancelabel = new JLabel("Balance: ₹" + user.getCurrentBalance());
        balancelabel.setBounds(0, 10, getWidth() - 20, 20);
        balancelabel.setFont(new Font("Dialog", Font.BOLD, 16));
        balancelabel.setHorizontalAlignment(SwingConstants.CENTER);
        balancelabel.setForeground(Color.WHITE);
        // add component
        add(balancelabel);

        // enter Amount label
        enterAmountLabel = new JLabel("Enter Amount:");
        enterAmountLabel.setBounds(0, 50, getWidth() - 20, 20);
        enterAmountLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        enterAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        enterAmountLabel.setForeground(Color.WHITE);
        add(enterAmountLabel);

        // enter Amount Field
        enterAmountField = new JTextField();
        enterAmountField.setBounds(15, 80, getWidth() - 50, 40);
        enterAmountField.setFont(new Font("Dialog", Font.BOLD, 20));
        enterAmountField.setHorizontalAlignment(SwingConstants.CENTER);
        enterAmountField.setBorder(BorderFactory.createLoweredBevelBorder());
        add(enterAmountField);
    }

    public void addActionButton(String actionButtonType) {
        actionButton = new JButton(actionButtonType);
        actionButton.setBounds(15, 300, getWidth() - 50, 40);
        actionButton.setFont(new Font("Dialog", Font.BOLD, 20));
        actionButton.addActionListener(this);
        add(actionButton);
    }

    public void addUserField() {
        // enter user label
        enterUserLabel = new JLabel("Enter User:");
        enterUserLabel.setBounds(0, 160, getWidth() - 20, 20);
        enterUserLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        enterUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
        enterUserLabel.setForeground(Color.WHITE);
        add(enterUserLabel);

        // enter user field
        enterUserField = new JTextField();
        enterUserField.setBounds(15, 190, getWidth() - 50, 40);
        enterUserField.setFont(new Font("Dialog", Font.BOLD, 20));
        enterUserField.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterUserField);

    }

    public void addPastTransactionComponenets() {
        pastTransactioPanel = new JPanel();

        pastTransactioPanel.setLayout(new BoxLayout(pastTransactioPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(pastTransactioPanel);

        // display the Vertical scrollbar, when it is required
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        scrollPane.setBounds(0, 20, getWidth() - 8, getHeight() - 15);

        // perform database to call of the past all transactions and store into
        // ArrayList
        pastTransactions = MyJDBC.getPastTransaction(user);

        // iteriate through the list and add to the GUI
        for (int i = 0; i < pastTransactions.size(); i++) {
            // store current Transaction
            Transaction pastTransaction = pastTransactions.get(i);

            // create a container to store a individual transaction
            JPanel pastTransactionContainer = new JPanel();
            pastTransactionContainer.setLayout(new BorderLayout());

            // create transactionType Label
            JLabel transactiontypeLabel = new JLabel("<html>" + pastTransaction.getTransactioType() + "<hr/></html>");
            transactiontypeLabel.setFont(new Font("Dialog", Font.BOLD, 20));

            // create transactions amount label
            JLabel transactionAmountlabel = new JLabel(String.valueOf(pastTransaction.getTransactionAmount()));
            transactionAmountlabel.setFont(new Font("Dialog", Font.BOLD, 18));

            // create transaction date label
            JLabel transactioDatelabel = new JLabel(
                    String.valueOf("<html>" + pastTransaction.getTransactionDate()) + "<br/><br/><br/></html>");
            transactioDatelabel.setFont(new Font("Dialog", Font.BOLD, 16));
            transactioDatelabel.setForeground(new Color(196, 0, 0));

            // add to the container
            pastTransactionContainer.add(transactiontypeLabel, BorderLayout.WEST);
            pastTransactionContainer.add(transactionAmountlabel, BorderLayout.EAST);
            pastTransactionContainer.add(transactioDatelabel, BorderLayout.SOUTH);

            // give a white background to each container
            pastTransactionContainer.setBackground(Color.LIGHT_GRAY);

            // give a black border to each transaction container
            pastTransactionContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // add transaction componenet to the transaction panel
            pastTransactioPanel.add(pastTransactionContainer);

        }

        // add to the dialog
        add(scrollPane);
    }

    private void handleTransaction(String transactionType, float amountValue) {
        Transaction transaction;

        if (transactionType.equalsIgnoreCase("Deposit")) {
            // deposit transaction type
            // add to current balance
            user.setCurrentBalance(user.getCurrentBalance().add(new BigDecimal(amountValue)));
            // create transaction
            // we leave date null because we are goingto be using the NOW() in SQL which
            // will get the current date
            transaction = new Transaction(user.getId(), transactionType, new BigDecimal(amountValue), null);

        } else {
            // withdraw transaction type
            // subtract from current balance
            user.setCurrentBalance(user.getCurrentBalance().subtract(new BigDecimal(amountValue)));

            // we want to show a negetive sign for the amount value when withdrawing
            transaction = new Transaction(user.getId(), transactionType, new BigDecimal(-amountValue), null);
        }

        // update database
        if (MyJDBC.addTransactionToDatabase(transaction) && MyJDBC.updateCurrentBalance(user)) {
            // show success dialog
            JOptionPane.showMessageDialog(this, transactionType + " Successfully!");

            // reset the fields
            resetFieldsAndUpdateCurrentBalance();

        } else {
            // show failture dialog
       
            JOptionPane.showMessageDialog(this, transactionType + " Failed...");
        }

    }

    private void resetFieldsAndUpdateCurrentBalance() {
        // reset fields
        enterAmountField.setText("");

        // only appears when transfer is clicked
        if (enterUserField != null) {
            enterUserField.setText("");

        }

        // update current balance on dialog
        balancelabel.setText("Balance: ₹" + user.getCurrentBalance());

        // update current balance on main GUI
        bankingAppGUI.getCurrentBalanceField().setText("₹" + user.getCurrentBalance());
    }

    private void handleTransfer(User user, String transferedUser, float amount) {

        // attemt to perform Transfer
        if (MyJDBC.transfer(user, transferedUser, amount)) {
            // show success
            ImageIcon img1 = new ImageIcon("Banking\\src\\MEDIA\\icons8-verified-account-50.png");
            JOptionPane.showMessageDialog(this, "Transfer Successfully...", "Done", getDefaultCloseOperation(), img1);
            resetFieldsAndUpdateCurrentBalance();
        } else {
            // show failture dialog
            ImageIcon img2 = new ImageIcon("Banking\\src\\MEDIA\\login failed.png");
            JOptionPane.showMessageDialog(this, "Transfer Failed !", "Oops !", getDefaultCloseOperation(), img2);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Buttonpressed = e.getActionCommand();

        // get amount value
        float amountValue = Float.parseFloat(enterAmountField.getText());

        // pressed deposit
        if (Buttonpressed.equalsIgnoreCase("Deposit")) {
            // we want to handle the deposit transaction
            handleTransaction(Buttonpressed, amountValue);
        } else {
            // preesed wirthdraw and transfer

            // validate input by making sure that withdraw or transfer amount is less then
            // current balance
            // if result is -1 it means that the entered amount is more, 0 means they are
            // equal and 1 means that the entered amount is less
            int result = user.getCurrentBalance().compareTo(BigDecimal.valueOf(amountValue));
            if (result < 0) {
                // display Error dialog

                JOptionPane.showMessageDialog(this, "\t\t\t   Insufficient balance !", ":(",
                        JOptionPane.WARNING_MESSAGE);

                return;

            }

            // check to see if withdraw or transfer was pressed
            if (Buttonpressed.equalsIgnoreCase("Withdraw")) {
                handleTransaction(Buttonpressed, amountValue);

            } else {
                // transfer
                String transferedUser = enterUserField.getText();

                // handle transfer
                handleTransfer(user, transferedUser, amountValue);
            }
        }
    }
}
