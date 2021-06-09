package fundamentos.dev.tp3;

import constants.Constants;

public class Student extends People {
    private double firstGrade;
    private double secondGrade;
    
    public Student() {}
    
    public Student(String name, double firstGrade, double secondGrade) {
        super(name);
        this.firstGrade = firstGrade;
        this.secondGrade = secondGrade;
    }
    
    public double getFirstGrade() { return firstGrade; }
    
    public void setFirstGrade(double firstGrade) { this.firstGrade = firstGrade; }
    
    public double getSecondGrade() { return secondGrade; }
    
    public void setSecondGrade(double secondGrade) { this.secondGrade = secondGrade; }
    
    private double getStudentAverage() {
        return (firstGrade + secondGrade) / 2;
    }
    
    private String getStudentStatus() {
        String status;
        
        if (getStudentAverage() >= 7) {
            status = Constants.APPROVED;
        } else if ((getStudentAverage() >= 4) && (getStudentAverage() < 7)) {
            status = Constants.FINAL_EXAM;
        } else {
            status = Constants.REPROVED;
        }
        return status;
    }
    
    @Override
    public String checkSituation(People[] peoples, int peopleCode, int counter) {
        String people = "";
        
        for (int i = 0; i < counter; i++) {
            if (i == peopleCode) {
                people = peoples[i].toString();
                break;
            }
        }
        return people; 
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AV1: ").append(firstGrade).append("\n");
        sb.append("AV2: ").append(secondGrade).append("\n");
        sb.append("Média: ").append(getStudentAverage()).append("\n");
        sb.append("Status: ").append(getStudentStatus()).append("\n");
        return super.toString() + sb.toString();
    }
    
//    @Override
//    public String toString() {
//        return super.toString() + "AV1: "+firstGrade+"\n"+"AV2: "+secondGrade+"\n"+"\n"+"Média: "+getStudentAverage()+"\n"+"Status: "+getStudentStatus()+"\n";
//    }
}  
