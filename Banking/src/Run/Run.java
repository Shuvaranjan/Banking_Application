
package Run;

import java.math.BigDecimal;
import Database.User;
import GUI.BankingAppGUI;
import GUI.LoginGUI;
import GUI.RegisterGUI;

public class Run extends javax.swing.JFrame {

  public static void main(String args[]) {

  
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        //display the GUI
        new splashscreen.SplashScreen(null, true).setVisible(true);
        new LoginGUI().setVisible(true);
       

      }
    });
  }

}
