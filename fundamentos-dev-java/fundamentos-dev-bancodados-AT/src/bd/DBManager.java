package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.AccountPJ;
import main.Operation;
import util.Util;

public class DBManager {
    
    public static String getAllAccounts(Connection conn) {
        String response = "";
        String comando = "SELECT * FROM accountspj";
        
        try {
            PreparedStatement ps = conn.prepareStatement(comando);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString("account_number");
                String name = rs.getString("account_name");
                String balance = rs.getString("account_balance");
                String cnpj = rs.getString("account_cnpj");
                response += accountNumber +" "+ name +" "+ balance +" "+ cnpj +"\n";
            }    
        } catch (SQLException e) {
            System.out.println("Erro: conexão");
        }
        return response;
    }
    
    public static String getAllOperations(Connection conn, int accountNumber) {
        String response = "";
        String comando = "SELECT * FROM operations WHERE account_number = '"+accountNumber+"'";
        
        try {
            PreparedStatement ps = conn.prepareStatement(comando);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String operationType = rs.getString("operation_type");
                String operationDate = rs.getString("operation_date");
                String operationValue = rs.getString("operation_value");
                response += operationType +" "+ operationDate +" "+ operationValue +"\n";
            }    
        } catch (SQLException e) {
            System.out.println("Erro: conexão");
        }
        return response;
    }
    
    public static void addAccountPJ(Connection conn, AccountPJ accountpj) {
        String comando = "INSERT INTO accountspj (account_number, account_name, account_balance, account_cnpj) VALUES ('"+accountpj.getAccountNumber()+"', '"+accountpj.getName()+"', '"+accountpj.getAccountBalance()+"', '"+accountpj.getCNPJ()+"')";

        try {
            PreparedStatement ps = conn.prepareStatement(comando);
            int status = ps.executeUpdate();
            if (status > 0) {
                System.out.println("Atualização realizada");
            } else {
                System.out.println("Atualização não realizada");
            }
        } catch (SQLException e) {
            System.out.println("Erro: comando SQL" + e);
        }
    }
    
    public static void updateAccountPJ(Connection conn, int accountNumber, double accountBalance, String type) {
        String comando = "UPDATE accountspj SET account_balance = '"+accountBalance+"' WHERE account_number = '"+accountNumber+"'";
        
        try {
            PreparedStatement ps = conn.prepareStatement(comando);
            int status = ps.executeUpdate();
            if (status > 0) {
                Operation operation = new Operation(type, Util.getDate(), accountBalance);
                addOperation(conn, operation, accountNumber);
                System.out.println("Atualização realizada");
            } else {
                System.out.println("Atualização não realizada");
            }
        } catch (SQLException e) {
            System.out.println("Erro: comando SQL");
        }
    }

    public static void removeAccountPJ (Connection conn, int accountNumber) {
        String comando = "DELETE FROM accountspj WHERE account_number = '"+accountNumber+"'";
        
        try {
            PreparedStatement ps = conn.prepareStatement(comando);
            int status = ps.executeUpdate();
            if (status > 0) {
                System.out.println("Exclusão realizada");
            } else {
                System.out.println("Exclusão não realizada");
            }
        } catch (SQLException e) {
            System.out.println("Erro: comando SQL");
        }
    }
    
    private static void addOperation(Connection conn, Operation operation, int account_number) {
        String comando = "INSERT INTO operations (operation_type, operation_date, operation_value, account_number) VALUES('"+operation.getType()+"', '"+operation.getOperationDate()+"', '"+operation.getValue()+"', '"+account_number+"')";
        
        try {
            PreparedStatement ps = conn.prepareStatement(comando);
            int status = ps.executeUpdate();
            if (status > 0) {
                System.out.println("Atualização realizada");
            } else {
                System.out.println("Atualização não realizada");
            }
        } catch (SQLException e) {
            System.out.println("Erro: comando SQL" + e);
        }
    }
}
