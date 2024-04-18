package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

import Database.User;

public class BankingAppGUI extends Baseframe implements ActionListener {
    
    private JTextField currentbalancField;
    private JRadioButton rb ;

    

    public JTextField getCurrentBalanceField() {
        return currentbalancField;
    }

    public BankingAppGUI(User user) {
        
        super("𝐁𝐚𝐧𝐤𝐢𝐧𝐠™", user);
        
       // getContentPane().setBackground(Color.decode("#181818"));
       
          // set size (pixels)
          //setSize(420, 600);
          setExtendedState(JFrame.MAXIMIZED_BOTH);
          setUndecorated(true);

          // terminate program whenm GUI is closed
          setDefaultCloseOperation(EXIT_ON_CLOSE);
  
          // set layout to null to have absolute layout which allows us to manually,
          // specify the size and position of each GUi component
          setLayout(null);
  
          // prevent GUI form being Resisized
          setResizable(false);
  
          // launch the GUI center the of the Screen
          setLocationRelativeTo(null);
  
          Container pane = getContentPane();
          pane.setLayout(null);
          pane.setBackground(Color.BLUE);
  
  
       
          JPanel p3 = new RoundedPanel(30);
          p3.setBounds(542,85,450,640);
          p3.setOpaque(false);
          p3.setBackground(Color.decode("#222222"));
          pane.add(p3);
          getContentPane().setBackground(Color.decode("#FFFFFF"));
        
  
    }
    class RoundedPanel extends JPanel
    {
        private Color backgroundColor;
        private int cornerRadius = 20;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(1, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(Color.WHITE);
            graphics.drawRoundRect(1, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }
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
        welcomeMessagelabel.setBounds(655, 100, getWidth() - 400, 40);
        welcomeMessagelabel.setFont(new FontUIResource("Dialog", Font.PLAIN, 16));
        welcomeMessagelabel.setForeground(Color.WHITE);

        // create currentBalance label
        JLabel currentbalanceLabel = new JLabel("<html><u>Current Balance</u></html>");
        currentbalanceLabel.setBounds(667, 150, getWidth() - 400, 30);
        currentbalanceLabel.setFont(new FontUIResource("Dialog", Font.BOLD, 22));
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
        currentbalancField.setBounds(575, 200, getWidth() - 420, 40);
        currentbalancField.setFont(new Font("Dialog", Font.BOLD, 28));
        currentbalancField.setHorizontalAlignment(SwingConstants.RIGHT);
        currentbalancField.setEditable(false);
      
        
  // create Gui close button
  JButton closeButton = new JButton("x");
  closeButton.setBounds(1510, -5, 30, 26);
  closeButton.setBackground(Color.decode("#FFFFFF"));
  closeButton.setForeground(Color.BLACK);
  closeButton.setFont(new Font("Arial Black", Font.PLAIN, 18));
  closeButton.setBorder(BorderFactory.createEmptyBorder());
  closeButton.addMouseListener(new MouseAdapter() {

    @Override
    public void mouseEntered(MouseEvent e) {
        closeButton.setBackground(Color.decode("#F30000"));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        closeButton.setBackground(Color.decode("#FFFFFF"));
    }
    
  });
  closeButton.addActionListener(new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent e) {
         ImageIcon icon = new ImageIcon("Banking\\src\\MEDIA\\icons8-question-mark-64.png");
         int a = JOptionPane.showConfirmDialog(BankingAppGUI.this,
                 "<html><h2 style=\"color: black; font-family:Roboto;\">Do you want to exit it ?</h2></html>",
                 "", JOptionPane.YES_NO_OPTION, getDefaultCloseOperation(), icon);
         if (a == JOptionPane.YES_OPTION) {
             // dispose this GUI
           BankingAppGUI.this.dispose();
           // Launch Greeting GUI
           new GreetingGUI().setVisible(true);
            
                     
         } else if (a == JOptionPane.NO_OPTION) {
             // Nothing changes, just closes the dialog box
         } else {
            
             return;
         }

     }

 });
  add(closeButton);
        /* ----------------------------Add buttons--------------------------- */
        JButton depositButoon = new JButton("Deposit");
        depositButoon.setBounds(576, 280, getWidth() - 420, 50);
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
        withdrawlButton.setBounds(576, 350, getWidth() - 420, 50);
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
        pastTransactionButton.setBounds(576, 420, getWidth() - 420, 50);
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
        transferButton.setBounds(576, 490, getWidth() - 420, 50);
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
        logoutButton.setBounds(576, 640, getWidth() - 420, 50);
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
            if (Buttonpressed.equalsIgnoreCase("Withdraw")) {
                bankingAppDialog.addRadiobutton();
            }
            if (Buttonpressed.equalsIgnoreCase("beneficiaryLabel")) {
                bankingAppDialog.addUserField();
            }
           

        } 
        else if (Buttonpressed.equalsIgnoreCase("Show Transactions")) {
            bankingAppDialog.addPastTransactionComponenets();
        }
        // make the app dilog visible
        bankingAppDialog.setVisible(true);

        
    }
    

}
