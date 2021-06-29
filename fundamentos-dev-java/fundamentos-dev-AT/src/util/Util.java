package util;

import constants.Constants;
import enums.MessageTypesEnum;
import enums.OperationTypeEnum;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import main.Account;
import validation.DataValidation;

public final class Util {
    public static String getDate() {
        String formattedDate;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
        Date date = calendar.getTime();
        
        formattedDate = simpleDateFormat.format(date);
        return formattedDate; 
    }
    
    public static OperationTypeEnum getOperationType() {
        int option;
        OperationTypeEnum type = null;
        
        option = Util.readIntValue(Constants.OPERATIONS_TYPES_OPTIONS_MENU);
        while (!DataValidation.isValidOperationType(option)) {            
            Util.showMessage(MessageTypesEnum.ERR, Constants.INVALID_OPERATION);
            option = Util.readIntValue(Constants.OPERATIONS_TYPES_OPTIONS_MENU);
        }
        switch (option) {
            case 1:
                type = OperationTypeEnum.CREDIT;
                break;
            case 2:
                type = OperationTypeEnum.DEBIT;
                break;
        }
        return type;
    }
    
    public static int getAccountIndex(int accountNumber, ArrayList<Account> accounts) {
        int index = 0;
        
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                index = accounts.indexOf(account);
            }
        }
        return index;
    }
    
    public static Account getAccount(int accountNumber, ArrayList<Account> accounts) {
        Account account = null;
        
        for (Account each : accounts) {
            if (each.getAccountNumber() == accountNumber) {
                account = each;
            }
        }
        return account;
    }
    
    public static String readName(String msg) {
        String value;
        Scanner scanner = new Scanner(System.in);
        
        Util.showMessage(MessageTypesEnum.OUT, msg);
        value = scanner.nextLine();
        while(!DataValidation.isValidName(value)) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.INVALID_NAME);
            Util.showMessage(MessageTypesEnum.OUT, msg);
            value = scanner.nextLine();
        }
        return value;
    }
    
    public static int readIntValue(String menuOptions) {
        int value = 0;
        boolean isValidInput = false;
        Scanner scanner = new Scanner(System.in);
        
        do {            
            try {
                Util.showMessage(MessageTypesEnum.OUT, menuOptions);
                value = scanner.nextInt();
                while (!DataValidation.isPositiveNumber(value)) {
                    Util.showMessage(MessageTypesEnum.ERR, Constants.INVALID_NUMBER);
                    Util.showMessage(MessageTypesEnum.OUT, menuOptions);
                    value = scanner.nextInt();
                }
                isValidInput = true;
            } catch (InputMismatchException e) {
                Util.showMessage(MessageTypesEnum.ERR, Constants.INVALID_DATA);
                scanner.next();
            }
        } while (!isValidInput);
        return value;
    }
    
    public  static double readDoubleValue(String msg) {
        double value = 0;
        boolean isValidInput = false;
        Scanner scanner = new Scanner(System.in);
        
        do {
            try {
                Util.showMessage(MessageTypesEnum.OUT, msg);
                value = scanner.nextDouble();
                while (!DataValidation.isPositiveNumber(value)) {
                    Util.showMessage(MessageTypesEnum.ERR, Constants.INVALID_BALANCE);
                    Util.showMessage(MessageTypesEnum.OUT, msg);
                    value = scanner.nextDouble();
                }
                isValidInput = true;
            } catch (InputMismatchException e) {
                Util.showMessage(MessageTypesEnum.ERR, Constants.INVALID_DATA);
                scanner.next();
            }
        } while (!isValidInput);
        return value;
    }
    
    public static void showMessage(MessageTypesEnum type, String msg) {
        switch (type) {
            case OUT: System.out.println(msg); break;
            case ERR: System.err.println(msg); break;
            default: System.err.println(Constants.INVALID_MESSAGE_TYPE); break;
        }
    }
}
