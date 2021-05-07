package tp1.oo;

public class Student {
    private String name;
    private double firstGrade;
    private double secondGrade;
    private double average;
    private String status;
    
    public Student() {}
    
    public Student(String name, double firstGrade, double secondGrade, double average, String status) {
        this.name = name;
        this.firstGrade = firstGrade;
        this.secondGrade = secondGrade;
        this.average = average;
        this.status = status;
    }
    
    public void setName(String name) {this.name = name; }
    
    public String getName() { return name; }
    
    public void setFirstGrade(double firstGrade) { this.firstGrade = firstGrade; }
    
    public double getFirstGrade() { return firstGrade; }
    
    public void setSecondGrade(double secondGrade) { this.secondGrade = secondGrade; }
    
    public double getSecondGrade() { return secondGrade; }
    
    public void setAverage(double average) { this.average = average; }
    
    public double getAverage() { return average; }
    
    public void setStatus(String status) { this.status = status; }
    
    public String getStatus() { return status; } 
}
