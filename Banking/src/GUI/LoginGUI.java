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

        getContentPane().setBackground(Color.decode("#3F22DD"));
        // hide the title bar
        setUndecorated(true);
        addGuiComponents();
    }

    @Override
    protected void addGuiComponents() {
        ImageIcon icon1 = new ImageIcon("Banking\\src\\MEDIA\\bank (3).png");
        this.setIconImage(icon1.getImage());
        ImageIcon icon = new ImageIcon("Banking\\src\\MEDIA\\user (2).png");
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(icon);
        imgLabel.setBounds(150, 80, 200, 150);

        // create Banking app label
        JLabel BankingApplicationlabel = new JLabel("<html><u>Banking Appilcation</u></html>");
        BankingApplicationlabel.setBounds(28, 20, 350, 50);
        BankingApplicationlabel.setHorizontalAlignment(SwingConstants.CENTER);
        BankingApplicationlabel.setForeground(Color.WHITE);
        BankingApplicationlabel.setFont(new Font("Arial Black", Font.PLAIN, 25));

        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 22, 500, 50);
        panel1.setBackground(new Color(0, 0, 0, 95));

        // create Username Label
        JLabel Usernamelabel = new JLabel("Username: ");
        Usernamelabel.setBounds(18, 260, 120, 55);
        Usernamelabel.setForeground(Color.WHITE);
        Usernamelabel.setFont(new Font("Agency FB", Font.BOLD, 30));

        // create Username TextField
        JTextField UsernameField = new JTextField();
        UsernameField.setBounds(140, 282, 250, 25);
        UsernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
        UsernameField.setFont(new Font("Arial", Font.PLAIN, 15));
        UsernameField.setForeground(Color.decode("#FDEA00"));
        UsernameField.setOpaque(false);
        UsernameField.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                UsernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
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
        Passwordlabel.setBounds(18, 360, 120, 55);
        Passwordlabel.setForeground(Color.WHITE);
        Passwordlabel.setFont(new Font("Agency FB", Font.BOLD, 30));

        // create Password TextField
        JPasswordField PasswordField = new JPasswordField();
        PasswordField.setBounds(140, 380, 250, 25);
        PasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
        PasswordField.setFont(new Font("Arial", Font.PLAIN, 15));
        PasswordField.setForeground(Color.decode("#FDEA00"));
        PasswordField.setOpaque(false);
        PasswordField.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                PasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
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
        showpassword.setBounds(280, 420, 150, 20);
        showpassword.setOpaque(false);
        showpassword.setBorder(BorderFactory.createEmptyBorder());
        showpassword.setForeground(Color.WHITE);
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
        closeButton.setBounds(394, -5, 30, 26);
        closeButton.setBackground(Color.decode("#3F22DD"));
        closeButton.setForeground(Color.RED);
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
                    dispose();
                  
                    ImageIcon icon8 = new ImageIcon("Banking\\src\\MEDIA\\icons8-smiling-80.png");
                    JOptionPane.showMessageDialog(LoginGUI.this,
                            "<html><p style=\"color:red; font-size:25px; font-family:Agency FB; text-align:center;\">'Thank You'<br></p> <p style=\"color:black; font-size:15px; \">For using our Application</p></html>",
                            ":)", getDefaultCloseOperation(), icon8);
                    System.exit(0);
                            
                } else if (a == JOptionPane.NO_OPTION) {
                    // Nothing changes, just closes the dialog box
                } else {
                    // Nothing changes, just close the dialog box
                }

            }

        });

        // create Login Button
        JButton LoginButton = new JButton("𝐋𝐨𝐠𝐢𝐧");
        LoginButton.setBounds(150, 495, 100, 40);
        LoginButton.setFont(new Font("", Font.BOLD, 22));
        LoginButton.setBackground(Color.RED);
        LoginButton.setForeground(Color.WHITE);
        LoginButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        LoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        LoginButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                LoginButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.WHITE));
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
        JLabel Registerlabel = new JLabel("<html><u>Don't have an Account ? Register here...</u></html>");
        Registerlabel.setBounds(60, 560, 350, 27);
        Registerlabel.setForeground(Color.WHITE);
        Registerlabel.setFont(new Font("Dialog", Font.BOLD, 16));
        Registerlabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                Registerlabel.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Registerlabel.setForeground(Color.WHITE);
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
