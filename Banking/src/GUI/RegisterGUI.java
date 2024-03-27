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
        getContentPane().setBackground(Color.decode("#3F22DD"));
        // hide the title bar
        setUndecorated(true);
    }

    @Override
    protected void addGuiComponents() {

        ImageIcon icon1 = new ImageIcon("Banking\\src\\MEDIA\\bank (3).png");
        this.setIconImage(icon1.getImage());
        ImageIcon icon = new ImageIcon("Banking\\src\\MEDIA\\icons8-registration-100.png");
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(icon);
        imgLabel.setBounds(180, 72, 200, 150);

        // create Banking app label
        JLabel BankingApplicationlabel = new JLabel("<html><u>Banking Appilcation</u></html>");
        BankingApplicationlabel.setBounds(28, 20, 350, 50);
        BankingApplicationlabel.setHorizontalAlignment(SwingConstants.CENTER);
        BankingApplicationlabel.setForeground(Color.WHITE);
        BankingApplicationlabel.setFont(new Font("Arial Black", Font.PLAIN, 25));

        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 22, 500, 50);
        panel1.setBackground(new Color(0, 0, 0, 150));

        // create Username Label
        JLabel Usernamelabel = new JLabel("Username: ");
        Usernamelabel.setBounds(18, 170, 150, 55);
        Usernamelabel.setForeground(Color.WHITE);
        Usernamelabel.setFont(new Font("Agency FB", Font.BOLD, 30));

        // create Username TextField
        JTextField UsernameField = new JTextField();
        UsernameField.setBounds(18, 222, 370, 30);
        UsernameField.setBorder(BorderFactory.createLoweredBevelBorder());
        UsernameField.setFont(new Font("Arial", Font.PLAIN, 15));
        UsernameField.setForeground(Color.BLACK);
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
        Passwordlabel.setBounds(18, 270, 150, 55);
        Passwordlabel.setForeground(Color.WHITE);
        Passwordlabel.setFont(new Font("Agency FB", Font.BOLD, 30));

        // create Password TextField
        JPasswordField PasswordField = new JPasswordField();
        PasswordField.setBounds(18, 320, 370, 30);
        PasswordField.setBorder(BorderFactory.createLoweredBevelBorder());
        PasswordField.setFont(new Font("Arial", Font.PLAIN, 15));
        PasswordField.setForeground(Color.BLACK);
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
        ConfirmPasswordlabel.setBounds(18, 365, 200, 55);
        ConfirmPasswordlabel.setForeground(Color.WHITE);
        ConfirmPasswordlabel.setFont(new Font("Agency FB", Font.BOLD, 30));

        // create Confirm-Password TextField
        JPasswordField ConfirmPasswordField = new JPasswordField();
        ConfirmPasswordField.setBounds(18, 420, 370, 30);
        ConfirmPasswordField.setBorder(BorderFactory.createLoweredBevelBorder());
        ConfirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 15));
        ConfirmPasswordField.setForeground(Color.BLACK);
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

        // create Gui close button
        JButton closeButton = new JButton("x");
        closeButton.setBounds(394, -5, 30, 26);
        closeButton.setBackground(Color.decode("#3F22DD"));
        closeButton.setForeground(Color.RED);
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
                  dispose();
                  ImageIcon icon8 = new ImageIcon("Banking\\src\\MEDIA\\icons8-smiling-80.png");
                  JOptionPane.showMessageDialog(RegisterGUI.this, "<html><p style=\"color:red; font-size:25px; font-family:Agency FB; text-align:center;\">'Thank You'<br></p> <p style=\"color:black; font-size:15px;\">For using our Application</p></html>", ":)", getDefaultCloseOperation(), icon8);
                  System.exit(0);
                }  
                else if (a == JOptionPane.NO_OPTION) {
                  //Nothing changes, just closes the dialog box
                }
                else{
                  //Nothing changes, just close the dialog box
                }
            }

        });

        // create Register Button
        JButton RegisterButton = new JButton("Register");
        RegisterButton.setBounds(150, 490, 120, 40);
        RegisterButton.setFont(new Font("", Font.BOLD, 22));
        RegisterButton.setBackground(Color.RED);
        RegisterButton.setForeground(Color.WHITE);
        RegisterButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        RegisterButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        RegisterButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                RegisterButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.WHITE));
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
                   // else if(ValidateUserInput(password, repassword)){
                        
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
        Registerlabel.setBounds(60, 550, 350, 27);
        Registerlabel.setForeground(Color.WHITE);
        Registerlabel.setFont(new Font("Dialog", Font.BOLD, 16));
        Registerlabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                Registerlabel.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                Registerlabel.setForeground(Color.WHITE);
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

    }

    private boolean ValidateUserInput(String username, String password, String repassword) {
        // all fields must have value
        if (username.length() == 0 || password.length() == 0 || repassword.length() == 0) {
            return false;
        }

        // username has to be atleast 6 characters Long
        if (username.length() <= 6) {
            return false;
        }

        // password and rePassword must be same like username
        if (!password.equals(repassword)) {
            return false;
        }
        // passes validation
        return true;
    }

    private boolean ValidateUserInput(String password, String repassword){
        if (!password.equals(repassword)) {
            return false;
        }

        return true;
    }
}
