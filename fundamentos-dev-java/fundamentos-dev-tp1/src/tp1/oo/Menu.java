package tp1.oo;

import java.util.Scanner;

public class Menu {
    private int option;
    
    public Menu() {}
    

    public void setOption(int option) { this.option = option; }
    
    public int getOption() { return option; }
    
    private static int menu() {
        int option;
        String options = constants.Constants.MENU_OPTIONS;
        
        option = readIntValue(options);
        return option;
    }
    
    private static int readIntValue(String msg) {
        int value;
        Scanner scanner = new Scanner(System.in);
        
        showMessage(constants.Constants.OUT, msg);
        value = scanner.nextInt();
        return value;
    }
}
