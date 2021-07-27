package main;

import constants.Constants;
import enums.MenuOptionsTypeEnum;
import enums.MessageTypesEnum;
import enums.OperationTypeEnum;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import util.Util;
import validation.DataValidation;

public final class Main {
    public static void main(String[] args) {
        final int END = 5;
        int option;
        ArrayList<Account> accounts = new ArrayList();
        
        setUpFile(accounts);
        option = menu(MenuOptionsTypeEnum.USER_OPTIONS);
        while (option != END) {
            start(option, accounts);
            Util.showMessage(MessageTypesEnum.OUT, Constants.EMPTY_MESSAGE);
            option = menu(MenuOptionsTypeEnum.USER_OPTIONS);
        }
        updateAccountsFile(accounts);
    }
    
    private static void setUpFile(ArrayList<Account> accounts) {
        Scanner accountsScanner;
        Scanner operationsScanner;
        
        accountsScanner = FileManager.openTheReading(Constants.ACCOUNTS_FILE_NAME);
        operationsScanner = FileManager.openTheReading(Constants.OPERATIONS_FILE_NAME);
        if (accountsScanner == null) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.FILE_READ_ERROR);
            return;
        }
        FileManager.readFile(accounts, accountsScanner, operationsScanner);
        FileManager.CloseFile(accountsScanner);
        FileManager.CloseFile(operationsScanner);
    }
    
    private static void updateAccountsFile(ArrayList<Account> accounts) {
        Formatter exit = FileManager.openTheRecording(Constants.ACCOUNTS_FILE_NAME);
        Formatter exit2 = FileManager.openTheRecording(Constants.OPERATIONS_FILE_NAME);
        
        FileManager.saveAccount(exit, accounts);
        FileManager.saveOperation(exit2, accounts);
        FileManager.CloseFile(exit);
        FileManager.CloseFile(exit2);
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
                editAccount(accounts);
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
        int accountNumber;
        
        accountNumber = Util.readIntValue(Constants.ENTER_YOUR_ACCOUNT_NUMBER);
        if (DataValidation.hasRepeatedAccount(accountNumber, accounts)) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.ACCOUNT_ALREADY_EXISTS);
            return;
        }
        accountType = menu(MenuOptionsTypeEnum.ACCOUNT_TYPES_MENU);
        switch (accountType) {
            case 1:
                setAccountPFData(accounts, accountNumber);
                break;
            case 2: 
                setAccountPJData(accounts, accountNumber);
                break;
            default:
                Util.showMessage(MessageTypesEnum.ERR, Constants.INVALID_OPERATION);
                break;
        }
    }

    private static void setAccountPFData(ArrayList<Account> accounts, int accountNumber) {
        AccountPF accountPF = new AccountPF();

        accountPF.setAccountNumber(accountNumber);
        accountPF.setName(Util.readName(Constants.ENTER_YOUR_ACCOUNT_HOLDER_NAME));
        accountPF.setCPF(String.valueOf(Util.readIntValue(Constants.ENTER_YOUR_CPF)));
        accountPF.setAccountBalance(Util.readDoubleValue(Constants.ENTER_YOUR_ACCOUNT_BALANCE));
        accountPF.setSpecialCheck(Util.readDoubleValue(Constants.ENTER_YOUR_SPECIAL_CHECK));
        accounts.add(accountPF);
        Util.showMessage(MessageTypesEnum.OUT, Constants.ACCOUNT_REGISTER_SUCCESSFULLY);
    }
    
    private static void setAccountPJData(ArrayList<Account> accounts, int accountNumber) {
        AccountPJ accountPJ = new AccountPJ();

        accountPJ.setAccountNumber(accountNumber);
        accountPJ.setName(Util.readName(Constants.ENTER_YOUR_COMPANY_NAME));
        accountPJ.setCNPJ(String.valueOf(Util.readIntValue(Constants.ENTER_YOUR_CNPJ)));
        accountPJ.setAccountBalance(Util.readDoubleValue(Constants.ENTER_YOUR_ACCOUNT_BALANCE));
        accounts.add(accountPJ);
        Util.showMessage(MessageTypesEnum.OUT, Constants.ACCOUNT_REGISTER_SUCCESSFULLY);
    }
    
    private static void editAccount(ArrayList<Account> accounts) {
        int accountNumber;
        double operationValue = 0;
        OperationTypeEnum operationType;
        Account account;
        
        if (!DataValidation.accountExists(accounts)) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.LIST_IS_EMPTY);
            return;
        }
        accountNumber = Util.readIntValue(Constants.ENTER_YOUR_ACCOUNT_NUMBER);
        if (!DataValidation.hasRepeatedAccount(accountNumber, accounts)) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.ACCOUNT_NOT_FOUND);
            return;
        }
        account = Util.getAccount(accountNumber, accounts);
        operationType = Util.getOperationType();
        switch (operationType) {
            case CREDIT:
                operationValue = Util.readDoubleValue(Constants.ENTER_YOUR_OPERATION_VALUE);
                account.setAccountBalance(account.getAccountBalance() + operationValue);
                setOperationData(accountNumber, Constants.CREDIT, operationValue, accounts);
                break;
            case DEBIT:
                operationValue = Util.readDoubleValue(Constants.ENTER_YOUR_OPERATION_VALUE);
                if (account instanceof AccountPF) {
                    if (!DataValidation.canDebitBeDone(operationValue, operationValue, operationValue)) {
                        Util.showMessage(MessageTypesEnum.OUT, Constants.INVALID_DEBIT_OPERATION_SPECIAL_CHECK);
                        return;
                    }
                    account.setAccountBalance(account.getAccountBalance() - operationValue);
                    setOperationData(accountNumber, Constants.DEBIT, operationValue, accounts);
                } else {
                    if (!DataValidation.accountHasBalance(account)) {
                        Util.showMessage(MessageTypesEnum.OUT, Constants.INVALID_DEBIT_OPERATION);
                        return;
                    }
                    account.setAccountBalance(account.getAccountBalance() - operationValue);
                    setOperationData(accountNumber, Constants.DEBIT, operationValue, accounts);
                }
                break;
        }
    }
    
    private static void setOperationData(int accountNumber, String type, double operationValue, ArrayList<Account> accounts) {
        Operation operation = new Operation();
        
        operation.setOperationDate(Util.getDate());
        operation.setType(type);
        operation.setValue(operationValue);
        
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                account.getOperations().add(operation);
            }
        }
    }
    
    private static void removeAccount(ArrayList<Account> accounts) {
        int accountNumber;
        int accountIndex;
        
        if (!DataValidation.accountExists(accounts)) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.LIST_IS_EMPTY);
            return;
        }
        accountNumber = Util.readIntValue(Constants.ENTER_YOUR_ACCOUNT_NUMBER);
        if (!DataValidation.hasRepeatedAccount(accountNumber, accounts)) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.ACCOUNT_NOT_FOUND);
            return;
        }
        if (!DataValidation.canRemoveAccount(accountNumber, accounts)) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.ACCOUNT_CANNOT_REMOVED);
            return;
        }
        accountIndex = Util.getAccountIndex(accountNumber, accounts);
        accounts.remove(accountIndex);
        Util.showMessage(MessageTypesEnum.OUT, Constants.ACCOUNT_REMOVED_SUCCESSFULLY);
    }
    
    private static void ShowReportOptions(ArrayList<Account> accounts) {
        int option;

        if (!DataValidation.accountExists(accounts)) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.LIST_IS_EMPTY);
            return;
        }
        option = menu(MenuOptionsTypeEnum.MANAGEMENT_REPORTS);
        switch (option) {
            case 1:
                getNegativeBalanceAccounts(accounts);
                break;
            case 2: 
                getAccountsByBalance(accounts);
                break;
            case 3:
                getAccountsByType(accounts);
                break;
            case 4:
                getAccountOperation(accounts);
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
        
        Util.showMessage(MessageTypesEnum.OUT, Constants.ACCOUNT_PJ);
        for (Account account : accounts) {
            if (account instanceof AccountPJ) {
                Util.showMessage(MessageTypesEnum.OUT, account.toString());
            }
        }
    }
    
    private static void getAccountOperation(ArrayList<Account> accounts) {
        int accountNumber;
        
        accountNumber = Util.readIntValue(Constants.ENTER_YOUR_ACCOUNT_NUMBER);
        if (!DataValidation.hasRepeatedAccount(accountNumber, accounts)) {
            Util.showMessage(MessageTypesEnum.ERR, Constants.ACCOUNT_NOT_FOUND);
            return;
        }
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                for (Operation operation : account.getOperations()) {
                    Util.showMessage(MessageTypesEnum.OUT, operation.toString());
                }
            }
        }
    }
}
