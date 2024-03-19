package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

import Database.User;

public class BankingAppGUI extends Baseframe implements ActionListener {
    private JTextField currentbalancField;

    public JTextField getCurrentBalanceField() {
        return currentbalancField;
    }

    public BankingAppGUI(User user) {
        super("𝐁𝐚𝐧𝐤𝐢𝐧𝐠™", user);
        // setUndecorated(true);
        getContentPane().setBackground(Color.decode("#111111"));
    }

    @Override
    protected void addGuiComponents() {
        ImageIcon icon = new ImageIcon("Banking\\src\\MEDIA\\bank (3).png");
        this.setIconImage(icon.getImage());
        // create Welcome message
        String WelcomeMessage = "<html>" +
                "<body style='text-align:center'>" +
                "<b>Hello " + user.getUsername() + "</b><br>" +
                "What would you like to do today?</body></html>";
        JLabel welcomeMessagelabel = new JLabel(WelcomeMessage);
        welcomeMessagelabel.setBounds(0, 20, getWidth() - 10, 40);
        welcomeMessagelabel.setFont(new FontUIResource("Dialog", Font.PLAIN, 16));
        welcomeMessagelabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeMessagelabel.setForeground(Color.WHITE);

        // create currentBalance label
        JLabel currentbalanceLabel = new JLabel("<html><u>Current Balance</u></html>");
        currentbalanceLabel.setBounds(0, 80, getWidth() - 10, 30);
        currentbalanceLabel.setFont(new FontUIResource("Dialog", Font.BOLD, 22));
        currentbalanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        currentbalanceLabel.setForeground(Color.WHITE);

        // create currentBalance Field
        currentbalancField = new JTextField("₹" + user.getCurrentBalance());
        currentbalancField.setBounds(15, 120, getWidth() - 50, 40);
        currentbalancField.setFont(new FontUIResource("Dialog", Font.BOLD, 28));
        // currentbalancField.setForeground(Color.WHITE);
        currentbalancField.setHorizontalAlignment(SwingConstants.RIGHT);
        // currentbalancField.setBackground(new Color(3, 83, 255,150));
        currentbalancField.setEditable(false);
        currentbalancField.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        /* ----------------------------Add buttons--------------------------- */
        JButton depositButoon = new JButton("Deposit");
        depositButoon.setBounds(15, 180, getWidth() - 50, 50);
        depositButoon.setFont(new Font("Dialog", Font.BOLD, 22));
        depositButoon.setBackground(new Color(0, 81, 255));
        depositButoon.setForeground(Color.WHITE);
        depositButoon.setBorder(BorderFactory.createLoweredBevelBorder());
        depositButoon.addActionListener(this);
        depositButoon.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                depositButoon.setBorder(BorderFactory.createRaisedBevelBorder());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                depositButoon.setBorder(BorderFactory.createLoweredBevelBorder());
            }

        });

        JButton withdrawlButton = new JButton("Withdraw");
        withdrawlButton.setBounds(15, 250, getWidth() - 50, 50);
        withdrawlButton.setFont(new Font("Dialog", Font.BOLD, 22));
        withdrawlButton.setBackground(new Color(35, 233, 18));
        withdrawlButton.setForeground(Color.WHITE);
        withdrawlButton.setBorder(BorderFactory.createLoweredBevelBorder());
        withdrawlButton.addActionListener(this);
        withdrawlButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                withdrawlButton.setBorder(BorderFactory.createRaisedBevelBorder());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                withdrawlButton.setBorder(BorderFactory.createLoweredBevelBorder());
            }

        });

        JButton pastTransactionButton = new JButton("Show Transactions");
        pastTransactionButton.setBounds(15, 320, getWidth() - 50, 50);
        pastTransactionButton.setFont(new Font("Dialog", Font.BOLD, 22));
        pastTransactionButton.setBackground(new Color(228, 231, 0));
        pastTransactionButton.setForeground(Color.WHITE);
        pastTransactionButton.setBorder(BorderFactory.createLoweredBevelBorder());
        pastTransactionButton.addActionListener(this);
        pastTransactionButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                pastTransactionButton.setBorder(BorderFactory.createRaisedBevelBorder());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pastTransactionButton.setBorder(BorderFactory.createLoweredBevelBorder());
            }

        });

        JButton transferButton = new JButton("Transfer");
        transferButton.setBounds(15, 390, getWidth() - 50, 50);
        transferButton.setFont(new Font("Dialog", Font.BOLD, 22));
        transferButton.setBackground(new Color(99, 0, 255));
        transferButton.setForeground(Color.WHITE);
        transferButton.setBorder(BorderFactory.createLoweredBevelBorder());
        transferButton.addActionListener(this);
        transferButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                transferButton.setBorder(BorderFactory.createRaisedBevelBorder());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                transferButton.setBorder(BorderFactory.createLoweredBevelBorder());
            }

        });

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(15, 500, getWidth() - 50, 50);
        logoutButton.setFont(new Font("Dialog", Font.BOLD, 22));
        logoutButton.setBackground(new Color(255, 0, 0));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBorder(BorderFactory.createLoweredBevelBorder());
        logoutButton.addActionListener(this);
        logoutButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                logoutButton.setBorder(BorderFactory.createRaisedBevelBorder());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logoutButton.setBorder(BorderFactory.createLoweredBevelBorder());
            }

        });

        add(welcomeMessagelabel);
        add(currentbalanceLabel);
        add(currentbalancField);
        // add all buttons
        add(depositButoon);
        add(withdrawlButton);
        add(transferButton);
        add(logoutButton);
        add(pastTransactionButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Buttonpressed = e.getActionCommand();

        // user pressed logout
        if (Buttonpressed.equalsIgnoreCase("Logout")) {

            // dispose this GUI
            this.dispose();

            // launch login GUI
            new LoginGUI().setVisible(true);

            return;

        }

        BankingAppDialog bankingAppDialog = new BankingAppDialog(this, user);
        bankingAppDialog.setTitle(Buttonpressed);
        if (Buttonpressed.equalsIgnoreCase("Deposit") || Buttonpressed.equalsIgnoreCase("Withdraw")
                || Buttonpressed.equalsIgnoreCase("Transfer")) {
            bankingAppDialog.addCurrentBalanceAndamount();

            // add actionButton
            bankingAppDialog.addActionButton(Buttonpressed);

            // for the transfer action it will require more components
            if (Buttonpressed.equalsIgnoreCase("Transfer")) {
                bankingAppDialog.addUserField();
            }

        } else if (Buttonpressed.equalsIgnoreCase("Show Transactions")) {
            bankingAppDialog.addPastTransactionComponenets();
        }
        // make the app dilog visible
        bankingAppDialog.setVisible(true);
    }

}
