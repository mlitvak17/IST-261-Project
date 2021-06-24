package financeApplication;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

/**
 *
 * @author mauriciolitvak
 */
public class FinanceUI implements ActionListener {
    
     
    private JLabel timeLabel;
    private JLabel dateLabel;
    
    JFrame splashScreen = new JFrame();
    JFrame createAccountSignIn = new JFrame();


    public FinanceUI() {
        timeLabel = new JLabel();
        dateLabel = new JLabel();
        splashScreen();
        timer();
        createAccountSignIn();
        
        
    }   
    
    private void createAccountSignIn() {
        createAccountSignIn.setTitle("Finance Application");
        createAccountSignIn.setSize(500, 350);
        createAccountSignIn.setLocationRelativeTo(null);
        createAccountSignIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createAccountSignIn.setVisible(false);
        
        JPanel tempMessage = new JPanel();
        JLabel inProgress = new JLabel("To be Developed in the next Deliverable:");
        inProgress.setFont(new Font("Palatino", Font.BOLD | Font.ITALIC, 12));
        JLabel nextDeliverableCreateAccountSignIn = new JLabel("Creating Account, Signing In, and Quitting App");
        nextDeliverableCreateAccountSignIn.setFont(new Font("Palatino", Font.ITALIC, 12));
        tempMessage.add(inProgress);
        tempMessage.add(nextDeliverableCreateAccountSignIn);
        createAccountSignIn.getContentPane().add(tempMessage);
    }
    
    
    private void splashScreen() {
        splashScreen.setTitle("Finance Application");
        splashScreen.setSize(500, 350);
        splashScreen.setLocationRelativeTo(null);
        splashScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        splashScreen.setVisible(true);
        
        JPanel timeDatePanel = new JPanel(new GridLayout(1, 2, 258, 1));
       
        timeDatePanel.add(timeLabel);
        timeDatePanel.add(dateLabel);
        
        
        JPanel splashScreenPanel = new JPanel(new GridLayout(1, 1, 1, 250));
        JLabel splashScreenLabel = new JLabel("Mauricio Litvak's Finance Application", SwingConstants.CENTER);
        splashScreenLabel.setFont(new Font("Palatino", Font.BOLD | Font.ITALIC, 24));
        
        splashScreenPanel.add(splashScreenLabel);

        
        JPanel continuePanel = new JPanel();
        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(event -> goToCreateAccountSignInJFrame());
        continuePanel.add(continueButton);
        
        
        splashScreen.getContentPane().add(timeDatePanel, BorderLayout.NORTH);
        splashScreen.getContentPane().add(splashScreenPanel, BorderLayout.CENTER);
        splashScreen.getContentPane().add(continuePanel, BorderLayout.SOUTH);
        
        
    }
    
    private String getDate() {
        LocalDateTime myTimeDateObj = LocalDateTime.now();
        
        DateTimeFormatter myFormatDate = DateTimeFormatter.ofPattern("E, MMM. dd, yyyy");
        String formattedDate = myTimeDateObj.format(myFormatDate);
        
        return formattedDate;    
    }    
    
    
    private String getTime() {
        LocalDateTime myTimeDateObj = LocalDateTime.now();
            
        DateTimeFormatter myFormatTime = DateTimeFormatter.ofPattern("h:mm:ss a");
        String formattedTime = myTimeDateObj.format(myFormatTime);
     
        return formattedTime;    
    }
    
     public final void timer() {
        Timer timer = new Timer(1000, this);
        timer.setInitialDelay(1);
        timer.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent hello) {
        timeLabel.setText(getTime());
        dateLabel.setText(getDate());
        
    }
    
    public void goToCreateAccountSignInJFrame() {
        createAccountSignIn.setVisible(true);
        splashScreen.setVisible(false);
        
    }
    
    
}
