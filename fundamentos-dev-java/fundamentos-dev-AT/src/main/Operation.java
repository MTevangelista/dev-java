package main;

public class Operation {
    private int accountNumber;
    private String type;
    private String operationDate;
    private double value;

    public Operation() {}
    
    public Operation(int accountNumber, String type, String operationDate, double value) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.operationDate = operationDate;
        this.value = value;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Número da conta: ").append(accountNumber).append("\n");
        sb.append("Tipo da operação: ").append(type).append("\n");;
        sb.append("Data da operação: ").append(operationDate).append("\n");
        sb.append("Valor: ").append(value).append("\n");;
        return sb.toString();
    }

    
}
