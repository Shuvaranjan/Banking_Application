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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GreetingGUI extends JFrame {
    /* create thank you greeting */
    public GreetingGUI() {

        
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        getContentPane().setBackground(Color.decode("#C70000"));
        addComponents();

    }

    private void addComponents() {
        JButton closebuttonLabel = new JButton("x");
        closebuttonLabel.setBounds(380, -5, 20, 20);
        closebuttonLabel.setBackground(Color.decode("#C70000"));
        closebuttonLabel.setForeground(Color.BLACK);
        closebuttonLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
        closebuttonLabel.setBorder(BorderFactory.createEmptyBorder());

        closebuttonLabel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }

        });

        closebuttonLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                closebuttonLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closebuttonLabel.setForeground(Color.BLACK);
            }

        });

        JPanel panel = new JPanel();
        panel.setBounds(20, 40, 360, 120);

        JLabel lbl1 = new JLabel(
                "<html><p style=\"color: red; font-size:25px; font-family:Agency FB; text-align:center;\">'Thank You'<br></p><p style=\"color:black; font-size:15px; \">For using our Application</p></html>");
        lbl1.setBounds(70, 50, 250, 100);
        // add these components
        add(closebuttonLabel);
        add(lbl1);

        getContentPane().add(panel);
    }

  
}
