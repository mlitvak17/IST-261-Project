package financeApplication;

import javax.swing.SwingUtilities;
/**
 *
 * @author mauriciolitvak
 */
public class FinanceApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FinanceCntl cntl = new FinanceCntl();
        });
    }
    
}
