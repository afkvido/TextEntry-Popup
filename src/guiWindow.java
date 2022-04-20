import javax.swing.*;
import java.awt.*;


public class guiWindow {

    protected JLabel textLabel;

    protected JTextField textField;

    protected JButton button;

    protected Boolean built;

    protected JFrame frame;

    private void createWindow () {




        //Create and set up the window.
        frame = new JFrame("MessageEngine");


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        // Text Label
        textLabel = new JLabel("<html>Enter text.<p/><html/>", SwingConstants.CENTER);
        textLabel.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(textLabel, BorderLayout.NORTH);


        // Text Box
        textField = new JTextField("", SwingConstants.CENTER);
        textField.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(textField, BorderLayout.CENTER);


        // Button
        button = new JButton("Input message");
        button.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(button, BorderLayout.SOUTH);



        // Ready the window for Display

        frame.setLocationRelativeTo(null);
        frame.pack();



    }





    public void show () {
        frame.setVisible(true);
    }


    public void hide () {
        frame.setVisible(false);
    }



    public guiWindow () {
        createWindow();
    }

}