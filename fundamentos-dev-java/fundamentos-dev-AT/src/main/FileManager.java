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
    private static String fileName;
    
    public static void setFileName(String name) {
        fileName = name;
    }
    
    public static Scanner openTheReading() {
        Scanner scanner = null;
        
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException ex) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.FILE_OPEN_ERROR);
        }
        return scanner;
    }
    
    public static void readFile(Scanner scanner, ArrayList<Account> accounts) {
        String line;
        String[] fields;
        
        while (scanner.hasNext()) {
            line = scanner.nextLine();
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
    }
    
    public static Formatter openTheRecording() {
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
