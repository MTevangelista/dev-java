package main;

public class Operation {
    private String type;
    private String operationDate;
    private double value;

    public Operation() {}
    
    public Operation(String type, String operationDate, double value) {
        this.type = type;
        this.operationDate = operationDate;
        this.value = value;
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
        sb.append("Tipo da operação: ").append(type).append("\n");;
        sb.append("Data da operação: ").append(operationDate).append("\n");
        sb.append("Valor: ").append(value).append("\n");;
        return sb.toString();
    }

    
}
