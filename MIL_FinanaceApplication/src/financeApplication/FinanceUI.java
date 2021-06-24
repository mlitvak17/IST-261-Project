package financeApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import java.awt.event.*;
import javax.swing.JPasswordField;

/**
 *
 * @author mauriciolitvak
 */
public class FinanceUI implements ActionListener {

    private final JLabel timeLabel;
    private final JLabel dateLabel;
    
    public String currentUser;
    
    JTextField signInEmailTextField = new JTextField("Email", SwingConstants.CENTER);
    JPasswordField signInPasswordTextField = new JPasswordField("", SwingConstants.CENTER);
    
    JLabel incomeLabel = new JLabel("", SwingConstants.RIGHT);
    
    
    JLabel expenseLabel = new JLabel("", SwingConstants.RIGHT);
    
    JLabel expensesKeysAndValuesLabel = new JLabel("", SwingConstants.CENTER);
    JLabel incomeKeysAndValuesLabel = new JLabel("", SwingConstants.CENTER);
    
    JLabel balanceLabel = new JLabel("", SwingConstants.RIGHT);
    
    private final FinanceCntl cntl;

    JFrame splashScreen = new JFrame();
    JFrame createAccountSignIn = new JFrame();
    JFrame createAccount = new JFrame();
    JFrame signIn = new JFrame();
    JFrame homeScreen = new JFrame();
    JFrame addExpense = new JFrame();
    JFrame addIncome = new JFrame();
    Color backgroundColor = new Color(128, 0, 128);

    public FinanceUI(FinanceCntl financeCntl) {
        this.cntl = financeCntl;
        timeLabel = new JLabel();
        dateLabel = new JLabel();
        splashScreen();
        timer();
        createAccountSignIn();
        createAccount();
        signIn();
        homeScreen();
        addExpense();
        addIncome();

    }
    
    private void addExpense() {
        addExpense.setTitle("Finance Application");
        addExpense.setSize(475, 350);
        addExpense.setLocationRelativeTo(null);
        addExpense.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addExpense.setResizable(false);
        addExpense.setVisible(false);
        addExpense.setBackground(backgroundColor);
        
        JPanel addExpensePanel = new JPanel(new GridLayout(4, 1));
        addExpensePanel.setBackground(backgroundColor);
        
        JLabel titleLabel = new JLabel("Add Expense", SwingConstants.CENTER);
        titleLabel.setForeground(Color.RED);
        titleLabel.setFont(new Font("", Font.BOLD, 20));
        
        JTextField nameTextField = new JTextField("Name");
        nameTextField.setHorizontalAlignment(JTextField.CENTER);
        nameTextField.setPreferredSize(new Dimension(140, 40));
        
        JTextField costTextField = new JTextField("Cost");
        costTextField.setHorizontalAlignment(JTextField.CENTER);
        costTextField.setPreferredSize(new Dimension(140, 40));
                
        JButton expenseButton = new JButton("+Expense");
        expenseButton.setForeground(Color.RED);
        expenseButton.setFont(new Font("", Font.ITALIC, 15));
        
        expenseButton.addActionListener(event -> addExpense(currentUser, nameTextField.getText(), Double.parseDouble(costTextField.getText())));

        addExpensePanel.add(titleLabel);
        addExpensePanel.add(nameTextField);
        addExpensePanel.add(costTextField);
        addExpensePanel.add(expenseButton);
        
        
        addExpense.getContentPane().add(addExpensePanel, SwingConstants.CENTER);
    }
    
    private void addIncome() {
        addIncome.setTitle("Finance Application");
        addIncome.setSize(475, 350);
        addIncome.setLocationRelativeTo(null);
        addIncome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addIncome.setResizable(false);
        addIncome.setVisible(false);
        addIncome.setBackground(backgroundColor);
        
        JPanel addIncomePanel = new JPanel(new GridLayout(4, 1));
        addIncomePanel.setBackground(backgroundColor);
        
        JLabel titleLabel = new JLabel("Add Income", SwingConstants.CENTER);
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setFont(new Font("", Font.BOLD, 20));
        
        JTextField nameTextField = new JTextField("Name");
        nameTextField.setHorizontalAlignment(JTextField.CENTER);
        nameTextField.setPreferredSize(new Dimension(140, 40));
        
        JTextField costTextField = new JTextField("Amount");
        costTextField.setHorizontalAlignment(JTextField.CENTER);
        costTextField.setPreferredSize(new Dimension(140, 40));
                
        JButton incomeButton = new JButton("+Income");
        incomeButton.setForeground(Color.GREEN);
        incomeButton.setFont(new Font("", Font.ITALIC, 15));
        
        incomeButton.addActionListener(event -> addIncome(currentUser, nameTextField.getText(), Double.parseDouble(costTextField.getText())));

        addIncomePanel.add(titleLabel);
        addIncomePanel.add(nameTextField);
        addIncomePanel.add(costTextField);
        addIncomePanel.add(incomeButton);
        
        
        addIncome.getContentPane().add(addIncomePanel, SwingConstants.CENTER);
    }
    
    private void homeScreen() {
        homeScreen.setTitle("Finance Application");
        homeScreen.setSize(600, 800);
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeScreen.setResizable(false);
        homeScreen.setVisible(false);
        homeScreen.setBackground(backgroundColor);
        
        JPanel quitPanel = new JPanel();
        quitPanel.setBackground(backgroundColor);
        
        JButton quitButton = new JButton(" Quit ");
        quitButton.setForeground(Color.RED);
        quitButton.setFont(new Font("", Font.BOLD, 15));
        
        quitButton.addActionListener(event -> quit());
        quitPanel.add(quitButton);
        
        
        JPanel logOutPanel = new JPanel();
        logOutPanel.setBackground(backgroundColor);
        
        JButton logOutButton = new JButton("LogOut");
        logOutButton.setForeground(Color.GRAY);
        logOutButton.setFont(new Font("", Font.BOLD, 15));
        
        logOutButton.addActionListener(event -> logOut());
        
        logOutPanel.add(logOutButton);
        
        
        JPanel centerPanel = new JPanel(new GridLayout(6, 2));
        centerPanel.setBackground(backgroundColor);
        
        centerPanel.add(new JLabel(""));
        centerPanel.add(new JLabel(""));
        
        centerPanel.add(new JLabel("Income:", SwingConstants.LEFT)).setForeground(Color.WHITE);
        incomeLabel.setForeground(Color.GREEN);
        centerPanel.add(incomeLabel);
        
        centerPanel.add(incomeKeysAndValuesLabel);
        centerPanel.add(new JLabel("", SwingConstants.RIGHT));
        
        centerPanel.add(new JLabel("Expenses:", SwingConstants.LEFT)).setForeground(Color.WHITE);
        expenseLabel.setForeground(Color.RED);
        centerPanel.add(expenseLabel);
        
        centerPanel.add(expensesKeysAndValuesLabel);
        centerPanel.add(new JLabel("", SwingConstants.RIGHT));
        
        centerPanel.add(new JLabel("Balance:", SwingConstants.LEFT)).setForeground(Color.WHITE);
        centerPanel.add(balanceLabel);
        
        
        JPanel southPanel = new JPanel(new GridLayout(1, 1, 1, 1));
        southPanel.setBackground(backgroundColor);
        
        JButton clearButton = new JButton("Clear");
        clearButton.setForeground(Color.RED);
        clearButton.setFont(new Font("", Font.BOLD, 15));
        
        JButton expenseButton = new JButton("+Expense");
        expenseButton.setForeground(Color.RED);
        expenseButton.setFont(new Font("", Font.ITALIC, 15));
        
        JButton incomeButton = new JButton("+Income");
        incomeButton.setForeground(Color.GREEN);
        incomeButton.setFont(new Font("", Font.ITALIC, 15));
        
        
        clearButton.addActionListener(event -> cntl.clearHashMap(currentUser));
        expenseButton.addActionListener(event -> goToAddExpense());
        incomeButton.addActionListener(event -> goToAddIncome());
        
        southPanel.add(clearButton);
        southPanel.add(expenseButton);
        southPanel.add(incomeButton);
        
        
        homeScreen.getContentPane().add(quitPanel, BorderLayout.EAST);
        homeScreen.getContentPane().add(logOutPanel, BorderLayout.WEST);
        homeScreen.getContentPane().add(centerPanel);
        homeScreen.getContentPane().add(southPanel, BorderLayout.SOUTH);
        
    }
    
    private void signIn() {
        signIn.setTitle("Finance Application");
        signIn.setSize(500, 350);
        signIn.setLocationRelativeTo(null);
        signIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signIn.setResizable(false);
        signIn.setVisible(false);
        signIn.setBackground(backgroundColor);
        
        JPanel quitPanel = new JPanel();
        quitPanel.setBackground(backgroundColor);
        
        JButton quitButton = new JButton("Quit");
        quitButton.setForeground(Color.RED);
        quitButton.setFont(new Font("", Font.BOLD, 15));
        
        quitButton.addActionListener(event -> quit());
        quitPanel.add(quitButton);
        
        JPanel helpPanel = new JPanel();
        helpPanel.setBackground(backgroundColor);
        
        JButton helpButton = new JButton("Help");
        helpButton.setForeground(Color.GRAY);
        helpButton.setFont(new Font("", Font.BOLD, 15));
        
        helpButton.addActionListener(event -> signInHelp());
        
        helpPanel.add(helpButton);
        
        JPanel centerPanel = new JPanel(new GridLayout(6, 1, 1, -20));
        centerPanel.setBackground(backgroundColor);
        
        
        signInEmailTextField.setHorizontalAlignment(JTextField.CENTER);
        signInEmailTextField.setPreferredSize(new Dimension(140, 40));
        
        JLabel infoLabel = new JLabel("Enter your login credentials", SwingConstants.CENTER);
        infoLabel.setFont(new Font("Palatino", Font.BOLD, 20));
        infoLabel.setForeground(Color.white);
        
        JLabel passwordLabel = new JLabel("Password:", SwingConstants.CENTER);
        passwordLabel.setFont(new Font("Palatino", Font.BOLD | Font.ITALIC, 13));
        passwordLabel.setForeground(Color.white);
        
        
        signInPasswordTextField.setHorizontalAlignment(JTextField.CENTER);
        
        centerPanel.add(new JLabel(""));
        centerPanel.add(infoLabel);
        centerPanel.add(signInEmailTextField);
        centerPanel.add(passwordLabel);
        centerPanel.add(signInPasswordTextField);
        centerPanel.add(new JLabel(""));
        
        JPanel southPanel = new JPanel();
        southPanel.setBackground(backgroundColor);
        
        JButton signInButton = new JButton("Sign In");
        
        signInButton.addActionListener(event -> signInPressed(signInEmailTextField.getText(), signInPasswordTextField.getText()));
        
        southPanel.add(signInButton);
        
        signIn.getContentPane().add(quitPanel, BorderLayout.EAST);
        signIn.getContentPane().add(helpPanel, BorderLayout.WEST);
        signIn.getContentPane().add(centerPanel, BorderLayout.CENTER);
        signIn.getContentPane().add(southPanel, BorderLayout.SOUTH);

        
        
    }
    
    private void createAccount() {
        createAccount.setTitle("Finance Application");
        createAccount.setSize(500, 350);
        createAccount.setLocationRelativeTo(null);
        createAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createAccount.setResizable(false);
        createAccount.setVisible(false);
        createAccount.setBackground(backgroundColor);
        
        JPanel backPanel = new JPanel();
        backPanel.setBackground(backgroundColor);

        JButton backButton = new JButton("< Back");
        backButton.setForeground(Color.GRAY);
        backButton.setFont(new Font("", Font.BOLD, 15));
        
        backButton.addActionListener((ActionEvent event) -> goToCreateAccountSignInJFrame());
        
        backPanel.add(backButton);
        
        
        JPanel quitPanel = new JPanel();
        quitPanel.setBackground(backgroundColor);
        
        JButton quitButton = new JButton("  Quit  ");
        quitButton.setForeground(Color.RED);
        quitButton.setFont(new Font("", Font.BOLD, 15));
        
        quitButton.addActionListener(event -> quit());
        quitPanel.add(quitButton);
        
        
        JPanel northPanel = new JPanel();
        northPanel.setBackground(backgroundColor);

        JTextField firstNameTextField = new JTextField("First Name");
        firstNameTextField.setHorizontalAlignment(JTextField.CENTER);
        firstNameTextField.setPreferredSize(new Dimension(140, 40));

        JTextField lastNameTextField = new JTextField("Last Name");
        lastNameTextField.setHorizontalAlignment(JTextField.CENTER);
        lastNameTextField.setPreferredSize(new Dimension(140, 40));
         
        northPanel.add(firstNameTextField);
        northPanel.add(lastNameTextField);
        
        
        JPanel centerPanel = new JPanel(new GridLayout(5, 1, 0, 0));
        centerPanel.setBackground(backgroundColor);
        
        
        JLabel infoLabel = new JLabel("Enter your information", SwingConstants.CENTER);
        infoLabel.setFont(new Font("", Font.BOLD, 20));
        infoLabel.setForeground(Color.white);
        centerPanel.add(infoLabel);
        
        JTextField emailTextField = new JTextField("Email", SwingConstants.CENTER);
        emailTextField.setHorizontalAlignment(JTextField.CENTER);
        centerPanel.add(emailTextField);

        JLabel passwordLabel = new JLabel("Create a Password:", SwingConstants.CENTER);
        passwordLabel.setFont(new Font("", Font.ITALIC, 15));
        passwordLabel.setForeground(Color.white);
        centerPanel.add(passwordLabel);
        
        

        JPasswordField passwordTextField = new JPasswordField("", SwingConstants.CENTER);
        passwordTextField.setHorizontalAlignment(JTextField.CENTER);
        centerPanel.add(passwordTextField); 
        
        centerPanel.add(new JLabel(""));
        
        JPanel southPanel = new JPanel();
        southPanel.setBackground(backgroundColor);
        
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setFont(new Font("", Font.BOLD, 20));
        createAccountButton.setPreferredSize(new Dimension(200,40));
        
        createAccountButton.addActionListener(event -> {
            createUser(firstNameTextField.getText(), lastNameTextField.getText()
                    , emailTextField.getText(), passwordTextField.getText());
        });
        
        southPanel.add(createAccountButton);
        
        
        createAccount.getContentPane().add(backPanel, BorderLayout.WEST);
        createAccount.getContentPane().add(quitPanel, BorderLayout.EAST);
        createAccount.getContentPane().add(northPanel, BorderLayout.NORTH);
        createAccount.getContentPane().add(centerPanel, BorderLayout.CENTER);
        createAccount.getContentPane().add(southPanel, BorderLayout.SOUTH);
        
    }
    
    private void createAccountSignIn() {
        createAccountSignIn.setTitle("Finance Application");
        createAccountSignIn.setSize(500, 350);
        createAccountSignIn.setLocationRelativeTo(null);
        createAccountSignIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createAccountSignIn.setResizable(false);
        createAccountSignIn.setVisible(false);
        createAccountSignIn.setBackground(backgroundColor);

        JPanel createAcctSignInTitlePanel = new JPanel(new GridLayout(1, 1, 1, 250));
        createAcctSignInTitlePanel.setBackground(backgroundColor);

        JLabel createAcctSignInLabel = new JLabel("Create Account / Sign In", SwingConstants.CENTER);
        createAcctSignInLabel.setForeground(Color.white);

        createAcctSignInLabel.setFont(new Font("Palatino", Font.BOLD, 30));
        createAcctSignInTitlePanel.add(createAcctSignInLabel);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 3, -10, 0));
        buttonsPanel.setBackground(backgroundColor);

        JButton createAccountButton = new JButton("Create Account");
        JButton signInButton = new JButton("Sign In");
        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("", Font.BOLD, 15));
        quitButton.setForeground(Color.RED);    
        
        createAccountButton.addActionListener(event -> goToCreateAccountJFrame());
        signInButton.addActionListener(event -> goToSignInJFrame());
        quitButton.addActionListener(event -> quit());
        

        buttonsPanel.add(createAccountButton);
        buttonsPanel.add(signInButton);
        buttonsPanel.add(quitButton);
        
        createAccountSignIn.getContentPane().add(createAcctSignInTitlePanel, BorderLayout.CENTER);
        createAccountSignIn.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);

    }

    private void splashScreen() {
        splashScreen.setTitle("Finance Application");
        splashScreen.setSize(500, 350);
        splashScreen.setLocationRelativeTo(null);
        splashScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        splashScreen.setBackground(backgroundColor);

        splashScreen.setVisible(true);
        splashScreen.setResizable(false);

        JPanel timeDatePanel = new JPanel(new GridLayout(1, 2, 265, 1));
        timeDatePanel.add(timeLabel);
        timeLabel.setForeground(Color.WHITE);
        timeDatePanel.add(dateLabel);
        dateLabel.setForeground(Color.WHITE);
        timeDatePanel.setBackground(backgroundColor);

        JPanel splashScreenPanel = new JPanel(new GridLayout(2, 1, 1, -190));
        JLabel mauricioLitvakLabel = new JLabel("Mauricio I. Litvak's", SwingConstants.CENTER);
        JLabel financeApplicationLabel = new JLabel("Finance Application", SwingConstants.CENTER);

        mauricioLitvakLabel.setFont(new Font("Palatino", Font.BOLD | Font.ITALIC, 30));
        financeApplicationLabel.setFont(new Font("Palatino", Font.BOLD, 45));
        mauricioLitvakLabel.setForeground(Color.WHITE);
        financeApplicationLabel.setForeground(Color.WHITE);

        splashScreenPanel.add(mauricioLitvakLabel, BorderLayout.CENTER);
        splashScreenPanel.add(financeApplicationLabel, BorderLayout.CENTER);

        splashScreenPanel.setBackground(backgroundColor);

        JPanel continuePanel = new JPanel();
        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(event -> goToCreateAccountSignInJFrame());
        continuePanel.add(continueButton);
        continuePanel.setBackground(backgroundColor);

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

        DateTimeFormatter myFormatTime = DateTimeFormatter.ofPattern("hh:mm:ss a");
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
        
        currentUser = signInEmailTextField.getText();
        
        if (cntl.getTotalIncome(currentUser) == 0) {
            incomeLabel.setText("$000.00");
        }
        else {
            incomeLabel.setText("$" + cntl.getTotalIncome(currentUser));
        }
        
        if (cntl.getTotalExpenses(currentUser) == 0) {
            expenseLabel.setText("$000.00");
        }
        else {
            expenseLabel.setText("$" + cntl.getTotalExpenses(currentUser));
        }
        
        if (cntl.getBalance(currentUser) > 0) {
            balanceLabel.setForeground(Color.GREEN);
            balanceLabel.setText("+$" + cntl.getBalance(currentUser));
        }
        else if (cntl.getBalance(currentUser) < 0){
            balanceLabel.setForeground(Color.RED);
            balanceLabel.setText("-$" + cntl.getBalance(currentUser));
        }
        
        else {
            balanceLabel.setForeground(Color.GRAY);
            balanceLabel.setText("$000.00");
        }
        
        expensesKeysAndValuesLabel.setText(cntl.getKeysAndValuesExpenses(currentUser));
        incomeKeysAndValuesLabel.setText(cntl.getKeysAndValuesIncome(currentUser));
        
    }

    public void goToCreateAccountSignInJFrame() {
        createAccountSignIn.setVisible(true);
        splashScreen.setVisible(false);
        createAccount.setVisible(false);
    }
    
    public void goToCreateAccountJFrame() {
        createAccountSignIn.setVisible(false);
        splashScreen.setVisible(false);
        createAccount.setVisible(true);
    }
    
    public void goToSignInJFrame() {
        createAccountSignIn.setVisible(false);
        splashScreen.setVisible(false);
        createAccount.setVisible(false);
        signInEmailTextField.setText("Email");
        signInPasswordTextField.setText("");
        signIn.setVisible(true);
        homeScreen.setVisible(false);
        addExpense.setVisible(false);
        addIncome.setVisible(false);
    }
    
    public void goToHomeScreen() {
        createAccountSignIn.setVisible(false);
        splashScreen.setVisible(false);
        createAccount.setVisible(false);
        signIn.setVisible(false);
        homeScreen.setVisible(true);
        addExpense.setVisible(false);
        addIncome.setVisible(false);
    }
    
    public void goToAddExpense() {
        createAccountSignIn.setVisible(false);
        splashScreen.setVisible(false);
        createAccount.setVisible(false);
        signIn.setVisible(false);
        homeScreen.setVisible(false);
        addExpense.setVisible(true);
        addIncome.setVisible(false);
    }
    
    public void goToAddIncome() {
        createAccountSignIn.setVisible(false);
        splashScreen.setVisible(false);
        createAccount.setVisible(false);
        signIn.setVisible(false);
        homeScreen.setVisible(false);
        addExpense.setVisible(false);
        addIncome.setVisible(true);
    }
    
    public void quit() {
        System.exit(0);
    }
    
    public void signInPressed(String email, String password) {
        String newEmail = "Email: " + email + ";";
        String newPassword = "Pass: " + password + "";
        String arrayList = cntl.getArrayList();
        int temp = 0;
        int listSize = cntl.getListSize();
        int indexOfCredentials = 0;
        
        
        
        if (arrayList.contains(newEmail)) {
            while (temp < listSize) {
                if (cntl.getLoginCredentials(temp).toString().contains(newEmail)) {
                    indexOfCredentials = temp;
                    temp = listSize;   
                }
                else {
                    temp += 1;
                }
            }
            if (cntl.getLoginCredentials(indexOfCredentials).toString().contains(newPassword)) {
                if (password.length() == 0) {
                    JOptionPane.showMessageDialog(new javax.swing.JFrame(), "Invalid Password"
                            + "\n(Passwords must be at least 8 characters)");    
                }
                else {
                    
                    currentUser = email;
                    goToHomeScreen();
                }  
            }
            else {
                JOptionPane.showMessageDialog(new javax.swing.JFrame(), "Invalid Password: '" + password 
                     + "' \n(Tip: Passwords are case sensitive)");  
            }    
        }
        else {
            JOptionPane.showMessageDialog(new javax.swing.JFrame(), "Invalid email address '"
                    + email + "'\n(Tip: Emails are Case Sensitive)");
        }
    }
    
    public void signInHelp() {
        JOptionPane.showMessageDialog(new javax.swing.JFrame(), "Ensure you are typing your password correctly.\n"
                + "Your Email and Password are both case sensitive.");
    }
    
    public void logOut() {
        goToSignInJFrame();
    }
    
    public void createUser(String firstName, String lastName, String email, String password) {
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(new javax.swing.JFrame(), "Invalid Password;\nPassword must be at least 8 characters long.");
        }
        else {
            cntl.addNewItemToEndOfList(firstName, lastName, email, password);
            goToSignInJFrame();
        }
    }
    
    public void addExpense(String email, String expenseName, Double expenseCost) {
        cntl.addExpense(email, expenseName, expenseCost);
        goToHomeScreen();
        
    }
    
    public void addIncome(String email, String incomeName, Double incomeAmount) {
        cntl.addIncome(email, incomeName, incomeAmount);
        goToHomeScreen();
        
    }
}
