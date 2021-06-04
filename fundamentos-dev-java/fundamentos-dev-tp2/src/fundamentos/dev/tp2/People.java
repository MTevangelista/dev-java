package fundamentos.dev.tp2;

public class People {
    private String name;
    
    public People() {}
    
    public People(String name) {
        this.name = name;
    }
    
    public String getName() { return name; }
    
    public void setName(String name) { this.name = name; }
    
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
        return "Nome: "+name+"\n";
    }
    
}
