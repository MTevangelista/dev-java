package main;

import bd.DBConnection;
import bd.DBManager;
import constants.Constants;
import enums.MenuOptionsTypeEnum;
import enums.MessageTypesEnum;
import java.sql.Connection;
import java.util.ArrayList;
import util.Util;
import validation.DataValidation;

public final class Main {
    public static void main(String[] args) {
        final int END = 5;
        int option;
        Connection connection;
        ArrayList<Account> accounts = new ArrayList();
        
        connection = DBConnection.openConnection();   
        if (connection == null) {
            System.out.println("Erro: conexão");
            return;
        }
        
        option = menu(MenuOptionsTypeEnum.USER_OPTIONS);
        while (option != END) {
            start(option, accounts);
            Util.showMessage(MessageTypesEnum.OUT, Constants.EMPTY_MESSAGE);
            option = menu(MenuOptionsTypeEnum.USER_OPTIONS);
        }
        DBManager.saveAccount(connection, accounts);
        DBConnection.closeConnection();
    }
    
    private static int menu(MenuOptionsTypeEnum optionsType) {
        int option;
        String menuOptions = "";
        
        switch (optionsType) {
            case USER_OPTIONS:
                menuOptions = Constants.USER_OPTIONS_MENU;
                break;
            case ACCOUNT_TYPES_MENU:
                menuOptions = Constants.ACCOUNT_TYPES_OPTIONS_MENU;
                break;
            case MANAGEMENT_REPORTS:
                menuOptions = Constants.MANAGEMENT_REPORTS_MENU;
                break;
            default:
                Util.showMessage(MessageTypesEnum.ERR, Constants.INVALID_MESSAGE_TYPE);
                break;
        }
        option = Util.readIntValue(menuOptions);
        return option;
    }
    
    private static void start(int option, ArrayList<Account> accounts) {
        switch (option) {
            case 1:
                registerAccount(accounts);
                break;
            case 2:
                break;
            case 3:
                removeAccount(accounts);
                break;
            case 4:
                ShowReportOptions(accounts);
                break;
            default:
                Util.showMessage(MessageTypesEnum.OUT, Constants.INVALID_OPERATION);
                break;
        }
    }
    
    private static void registerAccount(ArrayList<Account> accounts) {
        int accountType; 
        
        accountType = menu(MenuOptionsTypeEnum.ACCOUNT_TYPES_MENU);
        switch (accountType) {
            case 1:
                setAccountPFData(accounts);
                break;
            case 2: 
                setAccountPJData(accounts);
                break;
            default:
                Util.showMessage(MessageTypesEnum.ERR, Constants.INVALID_OPERATION);
                break;
        }
    }

    private static void setAccountPFData(ArrayList<Account> accounts) {
        AccountPF accountPF = new AccountPF();

        accountPF.setAccountNumber(Util.readIntValue(Constants.ENTER_YOUR_ACCOUNT_NUMBER));
        if (DataValidation.hasRepeatedAccount(accountPF.getAccountNumber(), accounts)) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.ACCOUNT_ALREADY_EXISTS);
        } else {
            accountPF.setName(Util.readName(Constants.ENTER_YOUR_ACCOUNT_HOLDER_NAME));
            accountPF.setCPF(String.valueOf(Util.readIntValue(Constants.ENTER_YOUR_CPF)));
            accountPF.setAccountBalance(Util.readDoubleValue(Constants.ENTER_YOUR_ACCOUNT_BALANCE));
            accountPF.setSpecialCheck(Util.readDoubleValue(Constants.ENTER_YOUR_SPECIAL_CHECK));
            accounts.add(accountPF);
            Util.showMessage(MessageTypesEnum.OUT, Constants.ACCOUNT_REGISTER_SUCCESSFULLY);
        }
    }
    
    private static void setAccountPJData(ArrayList<Account> accounts) {
        AccountPJ accountPJ = new AccountPJ();

        accountPJ.setAccountNumber(Util.readIntValue(Constants.ENTER_YOUR_ACCOUNT_NUMBER));
        if (DataValidation.hasRepeatedAccount(accountPJ.getAccountNumber(), accounts)) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.ACCOUNT_ALREADY_EXISTS);
        } else {
            accountPJ.setName(Util.readName(Constants.ENTER_YOUR_COMPANY_NAME));
            accountPJ.setCNPJ(String.valueOf(Util.readIntValue(Constants.ENTER_YOUR_CNPJ)));
            accountPJ.setAccountBalance(Util.readDoubleValue(Constants.ENTER_YOUR_ACCOUNT_BALANCE));
            accounts.add(accountPJ);
            Util.showMessage(MessageTypesEnum.OUT, Constants.ACCOUNT_REGISTER_SUCCESSFULLY);
        }
    }
   
    private static int getAccountIndex(int accountNumber, ArrayList<Account> accounts) {
        int index = 0;
        
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                index = accounts.indexOf(account);
            }
        }
        return index;
    }
    
    private static void removeAccount(ArrayList<Account> accounts) {
        int accountNumber;
        int accountIndex;
        
        accountNumber = Util.readIntValue(Constants.ENTER_YOUR_ACCOUNT_NUMBER);
        if (DataValidation.canRemoveAccount(accountNumber, accounts)) {
            accountIndex = getAccountIndex(accountNumber, accounts);
            accounts.remove(accountIndex);
            Util.showMessage(MessageTypesEnum.OUT, Constants.ACCOUNT_REMOVED_SUCCESSFULLY);
        } else {
            Util.showMessage(MessageTypesEnum.ERR, Constants.ACCOUNT_CANNOT_REMOVED);
        }
    }
    
    private static void ShowReportOptions(ArrayList<Account> accounts) {
        int option;
        
        option = menu(MenuOptionsTypeEnum.MANAGEMENT_REPORTS);
        switch (option) {
            case 1:
                // Listar clientes com saldo negativo
                getNegativeBalanceAccounts(accounts);
                break;
            case 2: 
                // Listar os clientes que tem saldo acima de um determinado valor
                getAccountsByBalance(accounts);
                
                break;
            case 3:
                // Listar todas as contas separadas por tipo
                getAccountsByType(accounts);
                break;
            case 4:
                // Listar as operações realizadas em uma determinada conta
                break;
        }
    }
    
    private static void getNegativeBalanceAccounts(ArrayList<Account> accounts) {
        for (Account account : accounts) {
            if (account.getAccountBalance() < 0) {
                Util.showMessage(MessageTypesEnum.OUT, account.toString());
            }
        }
    }
    
    private static void getAccountsByBalance(ArrayList<Account> accounts) {
        for (Account account : accounts) {
            if (account.getAccountBalance() > 100) {
                Util.showMessage(MessageTypesEnum.OUT, account.toString());
            }
        }
    }
    
    private static void getAccountsByType(ArrayList<Account> accounts) {
        Util.showMessage(MessageTypesEnum.OUT, Constants.ACCOUNT_PF);        
        for (Account account : accounts) {
            if (account instanceof AccountPF) {
                Util.showMessage(MessageTypesEnum.OUT, account.toString());
            }
        }
        Util.showMessage(MessageTypesEnum.OUT, Constants.ACCOUNT_PF);
        for (Account account : accounts) {
            if (account instanceof AccountPJ) {
                Util.showMessage(MessageTypesEnum.OUT, account.toString());
            }
        }
    }
}
