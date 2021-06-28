package validation;

import main.Account;
import java.util.ArrayList;

public final class DataValidation {
    public static boolean isValidOperationType(int option) {
        boolean isValidOption = false;
        
        if ((option == 1) || (option == 2)) {
            isValidOption = true;
        }
        return isValidOption;
    }
    
    public static boolean isValidName(String name) {
        String[] splittedName = name.split(" ");
        return splittedName.length >= 2;
    }
    
    /**
     * Fields and methods to match bytes, shorts, ints, and longs
     */
    public static boolean isPositiveNumber(double number) {
        return number >= 0;
    }
    
    public static boolean hasRepeatedAccount(int accountNumber, ArrayList<Account> accounts) {
        boolean hasAccount = false;
        
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                hasAccount = true;
                break;
            }
        }
        return hasAccount;
    }
    
    public static boolean canRemoveAccount(int accountNumber, ArrayList<Account> accounts) {
        boolean canRemove = false;
        
        for (Account account : accounts) {
            if ((account.getAccountNumber() == accountNumber) && (account.getAccountBalance() == 0)) {
                canRemove = true;
            }
        }
        return canRemove;
    }
}
