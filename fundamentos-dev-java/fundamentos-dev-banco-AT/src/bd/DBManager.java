package bd;

import enums.AccountTypeEnum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.Account;
import main.AccountPF;
import main.AccountPJ;

public class DBManager {
    public static void saveAccount(Connection conn, ArrayList<Account> accounts) {
        String account_id;
        
        for (Account account : accounts) {
            account_id = addAccount(conn, account);
            if (account instanceof AccountPF) {
                addAccountPF(conn, (AccountPF) account, account_id);
            } else if (account instanceof AccountPJ) {
                addAccountPJ(conn, (AccountPJ) account, account_id);
            }
        }
    }
    
    public static String addAccount(Connection conn, Account account) {
        String response = "";
        String comando = "INSERT INTO accounts(account_name, account_number, account_balance) values('"+account.getName()+"', '"+account.getAccountNumber()+"', '"+account.getAccountBalance()+"')";
        
        try {
            PreparedStatement ps = conn.prepareStatement(comando);
            ResultSet rs = ps.executeQuery();
            int status = ps.executeUpdate();
            if (status > 0) {
                while (rs.next()) {
                    String id = rs.getString("account_id");
                    response = id;
                }
                System.out.println("Atualização realizada");
            } else {
                System.out.println("Atualização não realizada");
            }
        } catch (SQLException e) {
            System.out.println("Erro: comando SQL");
        }
        return response;
    }
    
    private static void addAccountPF(Connection conn, AccountPF accountpf, String account_id ) {
        String comando = "INSERT INTO accountspf SET account_id = '"+account_id+"', cpf = '"+accountpf.getCPF()+"', special_check = '"+accountpf.getSpecialCheck()+"'";

        try {
            PreparedStatement ps = conn.prepareStatement(comando);
            ResultSet rs = ps.executeQuery();
            int status = ps.executeUpdate();
            if (status > 0) {
                System.out.println("Atualização realizada");
            } else {
                System.out.println("Atualização não realizada");
            }
        } catch (SQLException e) {
            System.out.println("Erro: comando SQL");
        }
    }
    
    private static void addAccountPJ(Connection conn, AccountPJ accountpj, String account_id ) {
        String comando = "INSERT INTO accountspf SET account_id = '"+account_id+"', cpf = '"+accountpj.getCNPJ()+"'";

        try {
            PreparedStatement ps = conn.prepareStatement(comando);
            ResultSet rs = ps.executeQuery();
            int status = ps.executeUpdate();
            if (status > 0) {
                System.out.println("Atualização realizada");
            } else {
                System.out.println("Atualização não realizada");
            }
        } catch (SQLException e) {
            System.out.println("Erro: comando SQL");
        }
    }
}
