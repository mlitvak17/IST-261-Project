package financeApplication;

import java.util.List;

/**
 *
 * @author mauriciolitvak
 */
public class FinanceCntl {
    
    private static final int STARTING_INDEX_OF_DISPLAY = 0;
    private final LoginCredentialsList credentialsList;
    private final HashMaps hashMaps;
    private final FinanceUI financeUI;
    
    public FinanceCntl() {
        credentialsList = new LoginCredentialsList();
        hashMaps = new HashMaps();
        financeUI = new FinanceUI(this);
    }
    
    LoginCredential getLoginCredentials(int index) {
        return credentialsList.getLoginCredentials().get(index);
    }
    
    int getListSize() {
        return credentialsList.getLoginCredentials().size();
    }
    
    public String getArrayList() {
        return credentialsList.getLoginCredentials().toString();
    }
    
    void addNewItemToEndOfList(String firstName, String lastName, String email, String password) {
        credentialsList.getLoginCredentials().add(new LoginCredential(firstName, lastName, email, password));
    }
    
    void replaceElementInArrayList(int index, String firstName, String lastName, String email, String password) {
        credentialsList.getLoginCredentials().set(index, new LoginCredential(firstName, lastName, email, password));
    }
    
    public Double getExpense(String email, String expenseName) {
        if ("johndoe@gmail.com".equals(email)) {
            return hashMaps.getJdExpenses().get(expenseName);        
        }        
        else if ("mml5604@psu.edu".equals(email)) {
            return hashMaps.getMlExpenses().get(expenseName);
        }
        else {
            return hashMaps.getNewUserExpenses().get(expenseName);
        } 
    }
    
    public Double getIncome(String email, String incomeName) {
        if ((email) == "johndoe@gmail.com") {
            return hashMaps.getJdIncome().get(incomeName);
        }        
        if ((email) == "mml5604@psu.edu") {
            return hashMaps.getJdIncome().get(incomeName);
        }
        else {
            return hashMaps.getNewUserIncome().get(incomeName);
        } 
    }
    
    public void clearHashMap(String email) {
        if ("johndoe@gmail.com".equals(email)) {
            hashMaps.getJdExpenses().clear();
            hashMaps.getJdIncome().clear();
        }        
        if ("mml5604@psu.edu".equals(email)) {
            hashMaps.getMlExpenses().clear();
            hashMaps.getMlIncome().clear();
        }
        else {
            hashMaps.getNewUserExpenses().clear();
            hashMaps.getNewUserIncome().clear();
        } 
    }
    
    public void addExpense(String email, String expenseName, Double expenseCost) {
        if ("johndoe@gmail.com".equals(email)) {
            hashMaps.getJdExpenses().put(expenseName, expenseCost);
        }        
        if ("mml5604@psu.edu".equals(email)) {
            hashMaps.getMlExpenses().put(expenseName, expenseCost);
        }
        else {
            hashMaps.getNewUserExpenses().put(expenseName, expenseCost);
        } 
    }
    
    public void addIncome(String email, String incomeName, Double incomeAmount) {
        if ("johndoe@gmail.com".equals(email)) {
            hashMaps.getJdIncome().put(incomeName, incomeAmount);
        }        
        if ("mml5604@psu.edu".equals(email)) {
            hashMaps.getMlIncome().put(incomeName, incomeAmount);
        }
        else {
            hashMaps.getNewUserIncome().put(incomeName, incomeAmount);
        } 
    }
    
    public double getTotalExpenses(String email) {
        double expenseTotal = 0;
        if ("johndoe@gmail.com".equals(email)) {
        
            for (Double jd : hashMaps.getJdExpenses().values()) {
                expenseTotal += jd;
            }
        }
        if ("mml5604@psu.edu".equals(email)) {
            for (Double ml : hashMaps.getMlExpenses().values()) {
                expenseTotal += ml;
            }   
        }
        else {
            for (Double newUser : hashMaps.getNewUserExpenses().values()) {
                expenseTotal += newUser;
            }
        }
        return expenseTotal;
    }
    
    public double getTotalIncome(String email) {
        double incomeTotal = 0;
        if ("johndoe@gmail.com".equals(email)) {
        
            for (Double jd : hashMaps.getJdIncome().values()) {
                incomeTotal += jd;
            }
        }
        if ("mml5604@psu.edu".equals(email)) {
            for (Double ml : hashMaps.getMlIncome().values()) {
                incomeTotal += ml;
            }   
        }
        else {
            for (Double newUser : hashMaps.getNewUserIncome().values()) {
                incomeTotal += newUser;
            }
        }
        return incomeTotal;
        
    }
    
    public double getBalance(String email) {
        return getTotalIncome(email) - getTotalExpenses(email);
    }
    
    public String getKeysAndValuesExpenses(String email) {
        String keysAndValues = "";
        if ("johndoe@gmail.com".equals(email)) {
        
            for (String i : hashMaps.getJdExpenses().keySet()) {
                keysAndValues += (i + ": $" + hashMaps.getJdExpenses().get(i) + " \n");
            }
        }
        if ("mml5604@psu.edu".equals(email)) {
            for (String i : hashMaps.getMlExpenses().keySet()) {
                keysAndValues += (i + ": $" + hashMaps.getMlExpenses().get(i) + " \n");
            }   
        }
        else {
            for (String i : hashMaps.getNewUserExpenses().keySet()) {
                keysAndValues += (i + ": $" + hashMaps.getNewUserExpenses().get(i) + " \n");
            }
        }
        return keysAndValues;
    }
    
    public String getKeysAndValuesIncome(String email) {
        String keysAndValues = "";
        if ("johndoe@gmail.com".equals(email)) {
        
            for (String i : hashMaps.getJdIncome().keySet()) {
                keysAndValues += (i + ": $" + hashMaps.getJdIncome().get(i) + " \n");
            }
        }
        if ("mml5604@psu.edu".equals(email)) {
            for (String i : hashMaps.getMlIncome().keySet()) {
                keysAndValues += (i + ": $" + hashMaps.getMlIncome().get(i) + " \n");
            }   
        }
        else {
            for (String i : hashMaps.getNewUserIncome().keySet()) {
                keysAndValues += (i + ": $" + hashMaps.getNewUserIncome().get(i) + " \n");
            }
        }
        return keysAndValues;
    }

}