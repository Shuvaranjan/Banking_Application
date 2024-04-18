package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.*;

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

import org.w3c.dom.events.MouseEvent;

import Database.MyJDBC;
import Database.User;

public class RegisterGUI extends Baseframe {

    public RegisterGUI() {
        super("");
        init();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
       // setDefaultLookAndFeelDecorated(true);
       setBounds(0,0,1610,900);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);

        Container pane = getContentPane();
        pane.setLayout(null);
        pane.setBackground(Color.BLUE);

       


     
        JPanel p3 = new RoundedPanel2(30);
        p3.setBounds(750,85,500,680);
        p3.setOpaque(false);
        pane.add(p3);

      
        getContentPane().setBackground(Color.decode("#3F22DD"));
        // hide the title bar
        setUndecorated(true);

    
    }
    private void init() {
        JButton button = new JButton("X");
         button.setBounds(500,50,50,50);
        //add(button);
    }
    class RoundedPanel2 extends JPanel
    {
        private Color backgroundColor;
        private int cornerRadius = 20;

        public RoundedPanel2(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel2(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel2(int radius) {
            super();
            cornerRadius = radius;
        }

        public RoundedPanel2(int radius, Color bgColor) {
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
        ImageIcon icon = new ImageIcon("Banking\\src\\MEDIA\\icons8-registration-100.png");
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(icon);
        imgLabel.setBounds(950, 180, 200, 150);

        // create Banking app label
        JLabel BankingApplicationlabel = new JLabel("<html>Register</html>");
        BankingApplicationlabel.setBounds(820, 120, 350, 50);
        BankingApplicationlabel.setHorizontalAlignment(SwingConstants.CENTER);
        BankingApplicationlabel.setForeground(Color.WHITE);
        BankingApplicationlabel.setFont(new Font("Arial Black", Font.PLAIN, 30));
        
        ImageIcon icon2 = new ImageIcon("Banking\\src\\MEDIA\\bank (1).png");
        JLabel imgLabel2 = new JLabel();
        imgLabel2.setIcon(icon2);
        imgLabel2.setBounds(375, 80, 500, 550);
        add(imgLabel2);

        JLabel BankingApplicationlabel2 = new JLabel("<html><u>Banking Appilcation</u></html>");
        BankingApplicationlabel2.setBounds(330, 550, 350, 50);
        BankingApplicationlabel2.setHorizontalAlignment(SwingConstants.CENTER);
        BankingApplicationlabel2.setForeground(Color.WHITE);
        BankingApplicationlabel2.setFont(new Font("Arial Black", Font.PLAIN, 30));
        add(BankingApplicationlabel2);

        JPanel panel1 = new JPanel();
        panel1.setBounds(750, 120, 500, 50);
        panel1.setBackground(new Color(0, 0, 0, 150));

      

        // create Username Label
        JLabel Usernamelabel = new JLabel("Username: ");
        Usernamelabel.setBounds(790, 300, 120, 55);
        Usernamelabel.setForeground(Color.BLACK);
        Usernamelabel.setFont(new Font("Agency FB", Font.BOLD, 30));

        // create Username TextField
        JTextField UsernameField = new JTextField();
        UsernameField.setBounds(790, 350, 400, 25);
        UsernameField.setBorder(BorderFactory.createLoweredBevelBorder());
        UsernameField.setFont(new Font("Arial", Font.PLAIN, 15));
        UsernameField.setForeground(Color.decode("#FF5A00"));
        UsernameField.setOpaque(false);
        UsernameField.setBackground(Color.white);
        UsernameField.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                UsernameField.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                UsernameField.setBorder(BorderFactory.createLoweredBevelBorder());
                UsernameField.setBackground(Color.white);
            }


        });

      

        UsernameField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                UsernameField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                UsernameField.setBackground(Color.white);
            }
            
        });

        // create Password Label
        JLabel Passwordlabel = new JLabel("Password: ");
        Passwordlabel.setBounds(790, 380, 120, 55);
        Passwordlabel.setForeground(Color.BLACK);
        Passwordlabel.setFont(new Font("Agency FB", Font.BOLD, 30));

        // create Password TextField
        JPasswordField PasswordField = new JPasswordField();
        PasswordField.setBounds(790, 430, 400, 25);
        PasswordField.setBorder(BorderFactory.createLoweredBevelBorder());
        PasswordField.setFont(new Font("Arial", Font.PLAIN, 15));
        PasswordField.setForeground(Color.decode("#FF5A00"));
        PasswordField.setOpaque(false);
        PasswordField.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                PasswordField.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
               PasswordField.setBorder(BorderFactory.createLoweredBevelBorder());
               PasswordField.setBackground(Color.white);
            }

        });

        PasswordField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
               PasswordField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
               PasswordField.setBackground(Color.white);
            }
            
        });

        // create Confirm-Password Label
        JLabel ConfirmPasswordlabel = new JLabel("Confirm-Password: ");
        ConfirmPasswordlabel.setBounds(790, 470, 200, 55);
        ConfirmPasswordlabel.setForeground(Color.BLACK);
        ConfirmPasswordlabel.setFont(new Font("Agency FB", Font.BOLD, 30));

        // create Confirm-Password TextField
        JPasswordField ConfirmPasswordField = new JPasswordField();
        ConfirmPasswordField.setBounds(790, 520, 400, 25);
        ConfirmPasswordField.setBorder(BorderFactory.createLoweredBevelBorder());
        ConfirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 15));
        ConfirmPasswordField.setForeground(Color.decode("#FF5A00"));
        ConfirmPasswordField.setOpaque(false);
        ConfirmPasswordField.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                ConfirmPasswordField.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                ConfirmPasswordField.setBorder(BorderFactory.createLoweredBevelBorder());
                ConfirmPasswordField.setBackground(Color.white);
            }

        });

        ConfirmPasswordField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
               ConfirmPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
               ConfirmPasswordField.setBackground(Color.white);
            }
            
        });

         // show password
        JCheckBox showpassword = new JCheckBox("Show Password");
        showpassword.setBounds(1080, 560, 150, 20);
        showpassword.setOpaque(false);
        showpassword.setBorder(BorderFactory.createEmptyBorder());
        showpassword.setForeground(Color.BLACK);
        showpassword.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (showpassword.isSelected()) {
                    PasswordField.setEchoChar((char) 0);
                    ConfirmPasswordField.setEchoChar((char)0);
                } else {
                    PasswordField.setEchoChar('•');
                    ConfirmPasswordField.setEchoChar('•');
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
            public void mouseEntered(java.awt.event.MouseEvent e) {
                closeButton.setBackground(new Color(0, 0, 0));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                closeButton.setBackground(Color.decode("#3F22DD"));
            }

        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon("Banking\\src\\MEDIA\\icons8-question-mark-64.png");
                int a = JOptionPane.showConfirmDialog(RegisterGUI.this, "<html><p style=\"color: black; font-family: Roboto; font-size:15px\">Do you want to exit it ?</p></html>","",JOptionPane.YES_NO_OPTION,getDefaultCloseOperation(),icon);
                if (a == JOptionPane.YES_OPTION) {
                     // dispose this GUI
                     RegisterGUI.this.dispose();
                     // Launch Greeting GUI
                     new GreetingGUI().setVisible(true);
                }  
                else if (a == JOptionPane.NO_OPTION) {
                  //Nothing changes, just closes the dialog box
                }
                else{
                  //Nothing changes, just close the dialog box
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
            public void mouseEntered(java.awt.event.MouseEvent e) {
                minimizeButton.setBackground(Color.decode("#000000"));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
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


        // create Register Button
        JButton RegisterButton = new JButton("Register");
        RegisterButton.setBounds(930, 652, 120, 40);
        RegisterButton.setFont(new Font("", Font.BOLD, 22));
        RegisterButton.setBackground(Color.RED);
        RegisterButton.setForeground(Color.WHITE);
        RegisterButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        RegisterButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        RegisterButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                RegisterButton.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.decode("#FFE800")));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                RegisterButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
            }

        });
        RegisterButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // get username
                String username = UsernameField.getText();

                // get password
                String password = String.valueOf(PasswordField.getPassword());

                // get confirm-password
                String repassword = String.valueOf(ConfirmPasswordField.getPassword());

                
                if (username.equals("") && password.equals("") && repassword.equals("")) {
                
                    ImageIcon icon5 = new ImageIcon(
                            "Banking\\src\\MEDIA\\icons8-keyboard-50.png");
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Please Enter the empty fields...", "",
                            getDefaultCloseOperation(), icon5);
                } else if (!username.equals("") && password.equals("") && repassword.equals("")) {
                    ImageIcon icon5 = new ImageIcon(
                            "Banking\\src\\MEDIA\\icons8-keyboard-50.png");
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Please Enter the empty fields...", "",
                            getDefaultCloseOperation(), icon5);
                } else if (username.equals("") && !password.equals("") && repassword.equals("")) {
                    ImageIcon icon5 = new ImageIcon(
                            "Banking\\src\\MEDIA\\icons8-keyboard-50.png");
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Please Enter the empty fields...", "",
                            getDefaultCloseOperation(), icon5);
                } else if (!username.equals("") && !password.equals("") && repassword.equals("")) {
                    ImageIcon icon5 = new ImageIcon(
                            "Banking\\src\\MEDIA\\icons8-keyboard-50.png");
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Please Enter Confirm Password...", "",
                            getDefaultCloseOperation(), icon5);
                } else if (username.equals("") && !password.equals("") && !repassword.equals("")) {
                    ImageIcon icon5 = new ImageIcon(
                            "Banking\\src\\MEDIA\\icons8-keyboard-50.png");
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Please Enter Username...", "",
                            getDefaultCloseOperation(), icon5);
                } else if (!username.equals("") && password.equals("") && !repassword.equals("")) {
                    ImageIcon icon5 = new ImageIcon(
                            "Banking\\src\\MEDIA\\icons8-keyboard-50.png");
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Please Enter Password...", "",
                            getDefaultCloseOperation(), icon5);
                } else if (username.equals("") && password.equals("") && !repassword.equals("")) {
                    ImageIcon icon5 = new ImageIcon(
                            "Banking\\src\\MEDIA\\icons8-keyboard-50.png");
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Please Enter the empty fields...", "(empty)", getDefaultCloseOperation(), icon5);
                }

                
                
                
                // we will need to the validate user input
                else if (ValidateUserInput(username, password, repassword)) {
                     if (validatePassword(password)){
                        //if true- registration successfully
                    if (MyJDBC.register(username, password)) {
                        // register success
                        // dispose of this GUI
                        RegisterGUI.this.dispose();

                        // launch the Login GUI
                        LoginGUI loginGUI = new LoginGUI();
                        loginGUI.setVisible(true);

                        ImageIcon icon2 = new ImageIcon("Banking\\src\\MEDIA\\icons8-verified-account-50.png");
                        // create a result dialog
                        JOptionPane.showMessageDialog(loginGUI, "\t\t\tRegister Account Successfully...", "Done",
                                getDefaultCloseOperation(), icon2);
                    } else {
                     
                        ImageIcon icon = new ImageIcon("Banking\\src\\MEDIA\\icons8-warning-50.png");
                        JOptionPane.showMessageDialog(RegisterGUI.this, "ERROR: Username had already taken", "˙◠˙",
                                getDefaultCloseOperation(), icon);
                    }

                } else {
                    //if false- registration failed and show this message
                    ImageIcon icon1 = new ImageIcon("Banking\\src\\MEDIA\\icons8-warning-50.png");
                  JOptionPane.showMessageDialog(RegisterGUI.this, "<html><p style=\"color:red; font-size:15px; font-style: bold; font-family: Calibri; text-align: center;\">Please Enter a Strong Password...<br></p> <p style=\"color:black; font-size:11px;\">Make sure it's atleast 7 characters long, including a (1)number,</p>" + 
                  "<p style=\"color:black; font-size:11px;\"> (1)lowercase and (1)uppercase letter.</p></html>","😑",getDefaultCloseOperation(),icon1);
                }
                
            }
            else{
                    ImageIcon icon = new ImageIcon("Banking\\src\\MEDIA\\icons8-warning-50.png");
                    // Invalid userInput
                    JOptionPane.showMessageDialog(RegisterGUI.this,
                            "ERROR: username must be 6 characters Long\n" +
                                    "or/and password must be matched",
                            "Oops !", getDefaultCloseOperation(), icon);
                    }
           
         }
            

        });

        // create Register Label
        JLabel Registerlabel = new JLabel("<html><u>Already have an Account? Login here...</u></html>");
        Registerlabel.setBounds(850, 700, 350, 27);
        Registerlabel.setForeground(Color.BLACK);
        Registerlabel.setFont(new Font("Dialog", Font.BOLD, 16));
        Registerlabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                Registerlabel.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                Registerlabel.setForeground(Color.BLACK);
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                RegisterGUI.this.dispose();
                new LoginGUI().setVisible(true);
            }

        });

        // add all components
        add(BankingApplicationlabel);
        add(Usernamelabel);
        add(UsernameField);
        add(Passwordlabel);
        add(PasswordField);
        add(ConfirmPasswordlabel);
        add(ConfirmPasswordField);
        add(RegisterButton);
        add(panel1);
        add(Registerlabel);
        add(closeButton);
        add(imgLabel);
        add(showpassword);

    }

    private boolean ValidateUserInput(String username, String password, String repassword) {
        // all fields must have value
        if (username.length() == 0 || password.length() == 0 || repassword.length() == 0) {
            return false;
        }

        // username has to be atleast 6 characters Long
        if (username.length() < 6) {
            return false;
        }

        // password and rePassword must be same like username
        if (!password.equals(repassword)) {
            return false;
        }
        // passes validation
        return true;
    }

   

    //validation password
    private static boolean validatePassword(String password){
        if (password.length() >= 7) {
         if (checkPassword(password)) {
            return true;
            
         }else{
          
            return false;
         }   
        }
        else{
         
            return false;
        }
    }

    //password validate conditions
    private static boolean checkPassword(String password){
        boolean hasNum = false; 
        boolean hasCap = false;
        boolean hasLow = false;
        char c;
        for (int i = 0; i < password.length(); i++) {
            c = password.charAt(i);
            if (Character.isDigit(c)) {
                hasNum = true;
            }else if (Character.isUpperCase(c)) {
                hasCap = true;
            
            }else if (Character.isLowerCase(c)) {
                hasLow = true;

                
            }
            if (hasNum && hasCap && hasLow) {
                return true;
                
            }
             
            
        }
        return false;
    }
}
