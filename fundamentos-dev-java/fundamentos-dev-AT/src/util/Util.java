package util;

import constants.Constants;
import enums.MessageTypesEnum;
import java.util.InputMismatchException;
import java.util.Scanner;
import validation.DataValidation;

public final class Util {
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
