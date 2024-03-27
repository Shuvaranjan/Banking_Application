package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
        getContentPane().setBackground(Color.decode("#181818"));
       
        
  
    }

    @Override
    protected void addGuiComponents() {
        ImageIcon icon = new ImageIcon("Banking\\src\\MEDIA\\bank (3).png");
        this.setIconImage(icon.getImage());
        // create Welcome message
        String WelcomeMessage = "<html>" +
                "<body style='text-align:center; color: rgb(255, 165, 0)'>" +
                "Hello<b> " + user.getUsername() + "</b><br>" +
                "<p style=\"color: White;\">What would you like to do today?</p></body></html>";
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
        currentbalancField = new JTextField("₹" + user.getCurrentBalance()){
            @Override protected void paintComponent(Graphics g) {
                int w = getWidth();
                int h = getHeight();
                Graphics2D g2 = (Graphics2D)g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                g.setColor(getBackground());
                g.fillRoundRect(0,0,w-0,h-0,10,15);
                g2.setColor(new Color(3, 83, 255,150));
                super.paintComponent(g);
              }
        };
        currentbalancField.setOpaque(false);
        currentbalancField.setBorder(BorderFactory.createEmptyBorder());
        currentbalancField.setBounds(15, 120, getWidth() - 45, 40);
        currentbalancField.setFont(new Font("Dialog", Font.BOLD, 28));
        currentbalancField.setHorizontalAlignment(SwingConstants.RIGHT);

        currentbalancField.setEditable(false);
      
        

        /* ----------------------------Add buttons--------------------------- */
        JButton depositButoon = new JButton("Deposit");
        depositButoon.setBounds(15, 180, getWidth() - 45, 50);
        depositButoon.setFont(new Font("Dialog", Font.BOLD, 22));
        depositButoon.setBackground(new Color(0, 81, 255));
        depositButoon.setForeground(Color.WHITE);
        depositButoon.setBorder(BorderFactory.createRaisedBevelBorder());
        depositButoon.addActionListener(this);
        depositButoon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        depositButoon.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                depositButoon.setBorder(BorderFactory.createLoweredBevelBorder());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                depositButoon.setBorder(BorderFactory.createRaisedBevelBorder());
            }

        });

        JButton withdrawlButton = new JButton("Withdraw");
        withdrawlButton.setBounds(15, 250, getWidth() - 45, 50);
        withdrawlButton.setFont(new Font("Dialog", Font.BOLD, 22));
        withdrawlButton.setBackground(new Color(35, 233, 18));
        withdrawlButton.setForeground(Color.WHITE);
        withdrawlButton.setBorder(BorderFactory.createRaisedBevelBorder());
        withdrawlButton.addActionListener(this);
        withdrawlButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        withdrawlButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                withdrawlButton.setBorder(BorderFactory.createLoweredBevelBorder());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                withdrawlButton.setBorder(BorderFactory.createRaisedBevelBorder());
            }

        });

        JButton pastTransactionButton = new JButton("Show Transactions");
        pastTransactionButton.setBounds(15, 320, getWidth() - 45, 50);
        pastTransactionButton.setFont(new Font("Dialog", Font.BOLD, 22));
        pastTransactionButton.setBackground(new Color(213, 194, 0));
        pastTransactionButton.setForeground(Color.WHITE);
        pastTransactionButton.setBorder(BorderFactory.createRaisedBevelBorder());
        pastTransactionButton.addActionListener(this);
        pastTransactionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pastTransactionButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                pastTransactionButton.setBorder(BorderFactory.createLoweredBevelBorder());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pastTransactionButton.setBorder(BorderFactory.createRaisedBevelBorder());
            }

        });

        JButton transferButton = new JButton("Transfer");
        transferButton.setBounds(15, 390, getWidth() - 45, 50);
        transferButton.setFont(new Font("Dialog", Font.BOLD, 22));
        transferButton.setBackground(new Color(99, 0, 255));
        transferButton.setForeground(Color.WHITE);
        transferButton.setBorder(BorderFactory.createRaisedBevelBorder());
        transferButton.addActionListener(this);
        transferButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        transferButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                transferButton.setBorder(BorderFactory.createLoweredBevelBorder());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                transferButton.setBorder(BorderFactory.createRaisedBevelBorder());
            }

        });

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(15, 500, getWidth() - 45, 50);
        logoutButton.setFont(new Font("Dialog", Font.BOLD, 22));
        logoutButton.setBackground(new Color(255, 0, 0));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBorder(BorderFactory.createRaisedBevelBorder());
        logoutButton.addActionListener(this);
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                logoutButton.setBorder(BorderFactory.createLoweredBevelBorder());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logoutButton.setBorder(BorderFactory.createRaisedBevelBorder());
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
