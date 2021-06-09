package fundamentos.dev.tp3;

public class Teacher extends People{
    private String subject;
    private double salary;
    private double workHours;
    
    public Teacher() {}
    
    public Teacher(String name, double salary, String subject, double workHours) {
        super(name);
        this.salary = salary;
        this.subject = subject;
        this.workHours = workHours;
    }
    
    public double getSalary() { return salary; }
    
    public void setSalary(double salary) { this.salary = salary; }
    
    public String getSubject() { return subject; }
    
    public void setSubject(String subject) { this.subject = subject; }
    
    public double getWorkHours() { return workHours; }
    
    public void setWorkHours(double workHours) { this.workHours = workHours; }
    
    private double calculateBonus(double bonus) {
        return salary + (salary * bonus);
    }
    
    private double calculateSalary() {
        double totalSalary = 0;
        
        if (workHours <= 40) {
            totalSalary = calculateBonus(0.10);
        } else if (workHours > 40) {
            totalSalary = calculateBonus(0.20);
        }
        
        return totalSalary;
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
        sb.append("Disciplina: ").append(subject).append("\n");
        sb.append("Salário base: R$ ").append(salary).append("\n");
        sb.append("Horas de trabalho: ").append(workHours).append("\n");
        sb.append("Salário total: ").append(calculateSalary()).append("\n");
        return super.toString() + sb.toString();
    }
}
