package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import constants.Constants;
import enums.AccountTypeEnum;
import enums.MessageTypesEnum;
import util.Util;

public class FileManager {
    public static Scanner openTheReading(String fileName) {
        Scanner scanner = null;
        
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException ex) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.FILE_OPEN_ERROR);
        }
        return scanner;
    }

    public static Scanner openTheReading2(String fileName) {
        Scanner scanner = null;
        
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException ex) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.FILE_OPEN_ERROR);
        }
        return scanner;
    }
    
    public static ArrayList<Operation> readFileOperation(Scanner scanner) {
        String line;
        String[] fields;
        ArrayList<Operation> operations = null;
        
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            fields = line.split(";");
            Operation operation = new Operation(Integer.parseInt(fields[0]), fields[1], fields[1], Double.parseDouble(fields[3]));
            operations.add(operation);
        }
        return operations;
    }
    
//    public static void readFileOperation(Scanner scanner, ArrayList<Operation> operations, ArrayList<Account> accounts) {
//        String line;
//        String[] fields;
//        
//        while (scanner.hasNext()) {
//            line = scanner.nextLine();
//            fields = line.split(";");
//            Operation operation = new Operation(Integer.parseInt(fields[0]), fields[1], fields[1], Double.parseDouble(fields[3]));
//            operations.add(operation);
//        }
//        
//        for (Account account : accounts) {
//                for (Operation operation : operations) {
//                    if (account.getAccountNumber() == operation.getAccountNumber()) {
//                        account.getOperations().add(operation);
//                    }
//                }
//        }
//    }
    
    public static void readFile(Scanner accountsScanner, ArrayList<Account> accounts, Scanner operationsScanner) {
        String line;
        String[] fields;
        ArrayList<Operation> operations;
        
        while (accountsScanner.hasNext()) {
            line = accountsScanner.nextLine();
            fields = line.split(";");
            if (fields[0] == AccountTypeEnum.PF.toString()) {
                // String name,                   int accountNumber,                   double accountBalance,                   String cpf,                   double specialCheck
                AccountPF accountPF = new AccountPF(fields[1], Integer.parseInt(fields[2]), Double.parseDouble(fields[3]), fields[4], Double.parseDouble(fields[5]));
                accounts.add(accountPF);
            } else {
                // String name,                   int accountNumber,                   double accountBalance,                   String cnpj)
                AccountPJ accountPJ = new AccountPJ(fields[1], Integer.parseInt(fields[2]), Double.parseDouble(fields[3]), fields[4]);
                accounts.add(accountPJ);
            }
        }

        operations = readFileOperation(operationsScanner);
        if (operations != null) {
            for (Account account : accounts) {
               for (Operation operation : operations) {
                    if (account.getAccountNumber() == operation.getAccountNumber()) {
                        account.getOperations().add(operation);
                    }
                }
            }
        }
    }
    
    public static Formatter openTheRecording(String fileName) {
        Formatter exit = null;
        
        try {
            exit = new Formatter(fileName);
        } catch (FileNotFoundException ex) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.FILE_NOT_FOUND);
        }
        return exit;
    }
    
    public static void saveAccount(Formatter exit, ArrayList<Account> accounts) {
        for (Account account : accounts) {
            if (account instanceof AccountPF) {
                exit.format("%s;%s;%s;%s;%s;%s\n", AccountTypeEnum.PF, account.getName(), account.getAccountNumber(), account.getAccountBalance(), ((AccountPF) account).getCPF(), ((AccountPF) account).getSpecialCheck());
            } else if (account instanceof AccountPJ) {
                exit.format("%s;%s;%s;%s;%s\n", AccountTypeEnum.PJ, account.getName(), account.getAccountNumber(), account.getAccountBalance(), ((AccountPJ) account).getCNPJ());
            }
        }
    }
    
    public static void saveOperation(Formatter exit, ArrayList<Operation> operations) {
        for (Operation operation : operations) {
            exit.format("%s;%s;%s;%s\n", operation.getAccountNumber(), operation.getType(), operation.getOperationDate(), operation.getValue());
        }
    }

    public static void CloseFile(Formatter exit) {
        if (exit != null) {
            exit.close();
        }
    }
    
    public static void CloseFile(Scanner scanner) {
        if (scanner != null) {
            scanner.close();
        }        
    }
}
