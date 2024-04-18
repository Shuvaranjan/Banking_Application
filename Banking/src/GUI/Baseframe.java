package GUI;

import javax.swing.JFrame;

import Database.User;

public abstract class Baseframe extends JFrame {
    //store user information
    protected User user;
    public Baseframe(String title) {
        initialize(title);
    }
    public Baseframe(String title, User user){
        //initialize user
        this.user = user;
        initialize(title);
    }

    private void initialize(String title) {

        // instantiate JFrame properties and add to the title bar
        setTitle(title);

        
        // set size (pixels)
        setSize(800, 600);

        // terminate program whenm GUI is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set layout to null to have absolute layout which allows us to manually,
        // specify the size and position of each GUi component
        setLayout(null);

        // prevent GUI form being Resisized
        setResizable(false);

        // launch the GUI center the of the Screen
        setLocationRelativeTo(null);

        addGuiComponents();

        

    }

    // this method will need to defined by subclass when class is being inherited
    // from
    protected abstract void addGuiComponents();
}
