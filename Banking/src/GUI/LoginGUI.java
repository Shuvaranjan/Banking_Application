package GUI;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Database.MyJDBC;
import Database.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// This GUI will allow user to login or launch the register GUI
//This extends from the Basefrom which means will need to define our own addGuiComponent()

public class LoginGUI extends Baseframe {
    

    public LoginGUI() {
         super("");
        init();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
       // setDefaultLookAndFeelDecorated(true);
        //setSize(1500, 2000);
        setBounds(0,0,1610,900);
       //setExtendedState(JFrame.MAXIMIZED_BOTH);

        Container pane = getContentPane();
        pane.setLayout(null);
        pane.setBackground(Color.BLUE);


     
        JPanel p3 = new RoundedPanel(30);
        p3.setBounds(750,85,500,680);
        p3.setOpaque(false);
        pane.add(p3);
       

        getContentPane().setBackground(Color.decode("#3F22DD"));
        // hide the title bar
        setUndecorated(true);
        addGuiComponents();
    }
    private void init() {
        JButton button = new JButton("X");
         button.setBounds(500,50,50,50);
        //add(button);
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
        ImageIcon icon1 = new ImageIcon("Banking\\src\\MEDIA\\bank (3).png");
        this.setIconImage(icon1.getImage());
        ImageIcon icon = new ImageIcon("Banking\\src\\MEDIA\\user (2).png");
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(icon);
        imgLabel.setBounds(950, 180, 200, 150);

        ImageIcon icon2 = new ImageIcon("Banking\\src\\MEDIA\\bank (1).png");
        JLabel imgLabel2 = new JLabel();
        imgLabel2.setIcon(icon2);
        imgLabel2.setBounds(375, 80, 500, 550);
        add(imgLabel2);

        // create Banking app label
        JLabel BankingApplicationlabel = new JLabel("<html>Login</html>");
        BankingApplicationlabel.setBounds(820, 120, 350, 50);
        BankingApplicationlabel.setHorizontalAlignment(SwingConstants.CENTER);
        BankingApplicationlabel.setForeground(Color.WHITE);
        BankingApplicationlabel.setFont(new Font("Arial Black", Font.PLAIN, 35));


        JLabel BankingApplicationlabel2 = new JLabel("<html><u>Banking Appilcation</u></html>");
        BankingApplicationlabel2.setBounds(320, 550, 420, 50);
        BankingApplicationlabel2.setHorizontalAlignment(SwingConstants.CENTER);
        BankingApplicationlabel2.setForeground(Color.WHITE);
        BankingApplicationlabel2.setFont(new Font("Arial Black", Font.PLAIN, 35));

        add(BankingApplicationlabel2);

        JPanel panel1 = new JPanel();
        panel1.setBounds(750, 120, 500, 50);
        panel1.setBackground(new Color(0, 0, 0, 150));

      

        // create Username Label
        JLabel Usernamelabel = new JLabel("Username: ");
        Usernamelabel.setBounds(798, 360, 120, 55);
        Usernamelabel.setForeground(Color.BLACK);
        Usernamelabel.setFont(new Font("Agency FB", Font.BOLD, 30));

        // create Username TextField
        JTextField UsernameField = new JTextField();
        UsernameField.setBounds(920, 382, 260, 25);
        UsernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
        UsernameField.setFont(new Font("Arial", Font.PLAIN, 15));
        UsernameField.setForeground(Color.decode("#FF5A00"));
        UsernameField.setOpaque(false);
        UsernameField.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                UsernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLUE));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                UsernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
            }

        });

        UsernameField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                UsernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
            }

        });
        // create Password Label
        JLabel Passwordlabel = new JLabel("Password: ");
        Passwordlabel.setBounds(798, 460, 120, 55);
        Passwordlabel.setForeground(Color.BLACK);
        Passwordlabel.setFont(new Font("Agency FB", Font.BOLD, 30));

        // create Password TextField
        JPasswordField PasswordField = new JPasswordField();
        PasswordField.setBounds(920, 480, 260, 25);
        PasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
        PasswordField.setFont(new Font("Arial", Font.PLAIN, 15));
        PasswordField.setForeground(Color.decode("#FF5A00"));
        PasswordField.setOpaque(false);
        PasswordField.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                PasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLUE));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                PasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
            }

        });

        PasswordField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                PasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
            }

        });

        // show password
        JCheckBox showpassword = new JCheckBox("Show Password");
        showpassword.setBounds(1080, 518, 150, 20);
        showpassword.setOpaque(false);
        showpassword.setBorder(BorderFactory.createEmptyBorder());
        showpassword.setForeground(Color.BLACK);
        showpassword.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (showpassword.isSelected()) {
                    PasswordField.setEchoChar((char) 0);
                } else {
                    PasswordField.setEchoChar('•');
                }
            }

        });

        // create Gui close button
        JButton closeButton = new JButton("x");
        closeButton.setBounds(1510, -5, 30, 26);
        closeButton.setBackground(Color.decode("#3F22DD"));
        closeButton.setForeground(Color.WHITE);
        closeButton.setFont(new Font("Arial Black", Font.PLAIN, 18));
        closeButton.setBorder(BorderFactory.createEmptyBorder());
        closeButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                closeButton.setBackground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closeButton.setBackground(Color.decode("#3F22DD"));
            }

        });
        closeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon("Banking\\src\\MEDIA\\icons8-question-mark-64.png");
                int a = JOptionPane.showConfirmDialog(LoginGUI.this,
                        "<html><h2 style=\"color: black; font-family:Roboto;\">Do you want to exit it ?</h2></html>",
                        "", JOptionPane.YES_NO_OPTION, getDefaultCloseOperation(), icon);
                if (a == JOptionPane.YES_OPTION) {
                    // dispose this GUI
                  LoginGUI.this.dispose();
                  // Launch Greeting GUI
                  new GreetingGUI().setVisible(true);
                   
                            
                } else if (a == JOptionPane.NO_OPTION) {
                    // Nothing changes, just closes the dialog box
                } else {
                   
                    return;
                }

            }

        });

        JButton minimizeButton = new JButton("_");
        minimizeButton.setBounds(1470, -5, 30, 24);
        minimizeButton.setBackground(Color.decode("#3F22DD"));
        minimizeButton.setForeground(Color.WHITE);
        minimizeButton.setFont(new Font("Arial Black", Font.PLAIN, 18));
        minimizeButton.setBorder(BorderFactory.createEmptyBorder());
        minimizeButton.addMouseListener(new MouseAdapter() {

          

            @Override
            public void mouseEntered(MouseEvent e) {
                minimizeButton.setBackground(Color.decode("#000000"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                minimizeButton.setBackground(Color.decode("#3F22DD"));
            }
            
        });
        minimizeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               setExtendedState(JFrame.ICONIFIED);
            }
            
        });

       add(minimizeButton);

        // create Login Button
        JButton LoginButton = new JButton("𝐋𝐨𝐠𝐢𝐧");
        LoginButton.setBounds(950, 645, 100, 40);
        LoginButton.setFont(new Font("", Font.BOLD, 22));
        LoginButton.setBackground(Color.RED);
        LoginButton.setForeground(Color.WHITE);
        LoginButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        LoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        LoginButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                LoginButton.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.decode("#FFE800")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                LoginButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
            }

        });
        LoginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // get username
                String username = UsernameField.getText();

                // get password
                String password = String.valueOf(PasswordField.getPassword());

                // Validate_Login
                User user = MyJDBC.validateLogin(username, password);
                if (username.equals("") && password.equals("")) {
                    ImageIcon icon5 = new ImageIcon("Banking\\src\\MEDIA\\icons8-keyboard-50.png");
                    JOptionPane.showMessageDialog(LoginGUI.this, "Please Enter the empty fields !", "",
                            getDefaultCloseOperation(), icon5);
                            
                } else if (username.equals("") && !password.equals("")) {
                    ImageIcon icon5 = new ImageIcon( "Banking\\src\\MEDIA\\icons8-keyboard-50.png");
                    JOptionPane.showMessageDialog(LoginGUI.this, "Please Enter the Username...", "",
                            getDefaultCloseOperation(), icon5);
                } else if (!username.equals("") && password.equals("")) {
                    ImageIcon icon5 = new ImageIcon( "Banking\\src\\MEDIA\\icons8-keyboard-50.png");
                    JOptionPane.showMessageDialog(LoginGUI.this, "Please Enter the Password...", "",
                            getDefaultCloseOperation(), icon5);
                } else if (user != null) {
                    // means valid Login
                    // dispose this GUI
                    LoginGUI.this.dispose();

                    // launch bank app GUI
                    BankingAppGUI bankingAppGUI = new BankingAppGUI(user);
                    bankingAppGUI.setVisible(true);
                    ImageIcon img1 = new ImageIcon("Banking\\src\\MEDIA\\icons8-verified-account-50.png");
                    JOptionPane.showMessageDialog(bankingAppGUI, "Login Successfully !", "",
                            getDefaultCloseOperation(), img1);
                } else {
                    ImageIcon img2 = new ImageIcon("Banking\\src\\MEDIA\\login failed.png");
                    JOptionPane.showMessageDialog(LoginGUI.this,  "Login Failed...\n" +
                                "Please Enter a Valided  Username and Password",
                            "ERROR !", getDefaultCloseOperation(), img2);
                    UsernameField.setText(null);
                    PasswordField.setText(null);

                }
            }

        });

        // create Register Label
        JLabel Registerlabel = new JLabel("<html><u>Don't have an Account? Register here...</u></html>");
        Registerlabel.setBounds(850, 700, 350, 27);
        Registerlabel.setForeground(Color.BLACK);
        Registerlabel.setFont(new Font("Dialog", Font.BOLD, 16));
        Registerlabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                Registerlabel.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Registerlabel.setForeground(Color.BLACK);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                LoginGUI.this.dispose();
                new RegisterGUI().setVisible(true);
            }

        });

        // add all components
        add(BankingApplicationlabel);
        add(Usernamelabel);
        add(UsernameField);
        add(Passwordlabel);
        add(PasswordField);
        add(LoginButton);
        add(panel1);
        add(Registerlabel);
        add(closeButton);
        add(imgLabel);
        add(showpassword);

    }

}
