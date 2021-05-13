package tp1.oo;

import constants.Constants;

public class Student {
    private String name;
    private double firstGrade;
    private double secondGrade;
    
    public Student() {}
    
    public Student(String name, double firstGrade, double secondGrade) {
        this.name = name;
        this.firstGrade = firstGrade;
        this.secondGrade = secondGrade;
    }
    
    public void setName(String name) {this.name = name; }
    
    public String getName() { return name; }
    
    public void setFirstGrade(double firstGrade) { this.firstGrade = firstGrade; }
    
    public double getFirstGrade() { return firstGrade; }
    
    public void setSecondGrade(double secondGrade) { this.secondGrade = secondGrade; }
    
    public double getSecondGrade() { return secondGrade; }

    public double getStudentAverage() {
        return (this.firstGrade + this.secondGrade) / 2;
    }
    
    public String getStudentStatus() {
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
    public String toString() {
        return "Nome: "+this.name+"\n"+"AV1: "+this.firstGrade+"\n"+"AV2: "+this.secondGrade+"\n"+"Média: "+getStudentAverage()+"\n"+"Status: "+getStudentStatus()+"\n";
    }
}
