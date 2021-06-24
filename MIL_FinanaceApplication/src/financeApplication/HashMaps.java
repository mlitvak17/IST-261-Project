package financeApplication;

import java.util.HashMap;
/**
 *
 * @author mauriciolitvak
 */
public class HashMaps {

        private final HashMap<String, Double> mlExpenses;
        private final HashMap<String, Double> mlIncome;
        
        private final HashMap<String, Double> jdExpenses;
        private final HashMap<String, Double> jdIncome;
        
        private final HashMap<String, Double> newUserExpenses;
        private final HashMap<String, Double> newUserIncome;
  
    public HashMaps() {
        mlExpenses = new HashMap<>();
        mlIncome = new HashMap<>();
        
        addInitialValuesToML();
        
        jdExpenses = new HashMap<>();
        jdIncome = new HashMap<>();
        
        addInitialValuesToJD();
        
        newUserExpenses = new HashMap<>();
        newUserIncome = new HashMap<>();
        
       
    }
    
    
    private void addInitialValuesToML() {
        mlExpenses.put("Groceries", 150.00);
        mlExpenses.put("Gas", 42.69);
        mlExpenses.put("Chiropracter", 30.00);
        mlExpenses.put("Dinner Out", 54.18);
        mlExpenses.put("Entertainment", 15.00);
        
        mlIncome.put("Paycheck", 1246.45);
    }
    
    private void addInitialValuesToJD() {
        jdExpenses.put("Groceries", 50.00);
        jdExpenses.put("Gas", 27.42);
        jdExpenses.put("Doctors", 5.00);
        jdExpenses.put("Dinner Out", 31.67);
        jdExpenses.put("Entertainment", 150.00);
        
        jdIncome.put("Paycheck", 986.76);    
    }
    
    public HashMap<String, Double> getMlExpenses() {
        return mlExpenses;
    }

    public HashMap<String, Double> getMlIncome() {
        return mlIncome;
    }

    public HashMap<String, Double> getJdExpenses() {
        return jdExpenses;
    }

    public HashMap<String, Double> getJdIncome() {
        return jdIncome;
    }

    public HashMap<String, Double> getNewUserExpenses() {
        return newUserExpenses;
    }

    public HashMap<String, Double> getNewUserIncome() {
        return newUserIncome;
    }
    
}