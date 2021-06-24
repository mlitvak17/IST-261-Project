package financeApplication;

import javax.swing.SwingUtilities;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

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
