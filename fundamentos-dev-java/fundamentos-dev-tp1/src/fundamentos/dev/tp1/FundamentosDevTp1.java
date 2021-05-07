package fundamentos.dev.tp1;

import constants.Constants;
import java.util.Scanner;

public class FundamentosDevTp1 {
   private static int counter = 0;
   
    public static void main(String[] args) {
        final int SIZE = 100; 
        String[] names = new String[SIZE];
        double[] av1 = new double[SIZE];
        double[] av2 = new double[SIZE];
        int option;
        
        option = menu();
        while(option != 4) {
            start(option, names, av1, av2);
            showMessage(Constants.OUT, Constants.EMPTY_MESSAGE);
            option = menu();
        }
    }
    
    private static void start(int option, String[] names, double[] av1, double[] av2) {
        switch (option) {
            case 1:
                addStudentInformation(names, av1, av2);
                break;
            case 2:
                searchStudent(names, av1, av2);
                break;
            case 3: 
                searchAllStudents(names, av1, av2);
                break;
            default:
                showMessage(Constants.ERR, Constants.INVALID_OPERATION);
        }
    }
    
    private static boolean hasFreePosition(String[] names) {
        return counter != names.length;
    }
    
    private static void addStudentInformation(String[] names, double[] av1, double[] av2) {
        double grade1, grade2;
        String name;
        
        if (hasFreePosition(names)) {
            name = readStringValue(Constants.ENTER_YOUR_NAME);
            grade1 = readDoubleValue(Constants.ENTER_YOUR_FIRST_GRADE);
            grade2 = readDoubleValue(Constants.ENTER_YOUR_SECOND_GRADE);
            names[counter] = name;
            av1[counter] = grade1;
            av2[counter] = grade2;
            showMessage(Constants.OUT, Constants.YOUR_CODE_IS + counter);
            counter++;
        } else {
            showMessage(Constants.ERR, Constants.ALL_POSITIONS_ARE_OCCUPIED);
        }
    }
    
    private static void searchStudent(String[] names, double[] av1, double[] av2) {
        int studentCode;
        
        studentCode = readIntValue(Constants.ENTER_STUDENT_CODE);        
        for (int i = 0; i < counter; i++) {
            if (i == studentCode) {
                showStudent(names, av1, av2, i);
                break;
            }
        }
    }
    
    private static void searchAllStudents(String[] names, double[] av1, double[] av2) {
        for (int i = 0; i < counter; i++) {
            showStudent(names, av1, av2, i);
        }
    }
    
    private static void showStudent(String[] names, double[] av1, double[] av2, int index) {
        double average;
        String result, status;
        
        average = getStudentAverage(av1[index], av2[index]);
        status = getStudentStatus(average);
        result = "Nome: "+names[index]+"\n"+"AV1: "+av1[index]+"\n"+"AV2: "+av2[index]+"\n"+"Média: "+average+"\n"+"Status: "+status+"\n";
        showMessage(Constants.OUT, result);
    }
    
    private static int menu() {
        int option;
        String options = Constants.MENU_OPTIONS;
        
        option = readIntValue(options);
        return option;
    }
    
    private static int readIntValue(String msg) {
        int value;
        Scanner scanner = new Scanner(System.in);
        
        showMessage(Constants.OUT, msg);
        value = scanner.nextInt();
        return value;
    }
    
    private static double readDoubleValue(String msg) {
        double value;
        Scanner scanner = new Scanner(System.in);
        
        showMessage(Constants.OUT, msg);
        value = scanner.nextDouble();
        while (!isValidGrade(value)) {
            showMessage(Constants.ERR, Constants.INVALID_GRADE);
            showMessage(Constants.OUT, msg);
            value = scanner.nextDouble();
        }
        return value;
    }
    
    private static double getStudentAverage(double grade1, double grade2) {
        return (grade1 + grade2) / 2;
    }
    
    private static boolean isValidGrade(double grade) {
        boolean isValid = true;
        
        if ((grade < 0) || (grade > 10)) {
            isValid = false;
        }
        return isValid;
    }
    
    private static String readStringValue(String msg) {
        String value;
        Scanner scanner = new Scanner(System.in);
        
        showMessage(Constants.OUT, msg);
        value = scanner.next();
        return value;
    }
    
    private static String getStudentStatus(double average) {
        String status;
        
        if (average >= 7) {
            status = Constants.APPROVED;
        } else if ((average >= 4) && (average < 7)) {
            status = Constants.FINAL_EXAM;
        } else {
            status = Constants.REPROVED;
        }
        return status;
    }
    
    private static void showMessage(String type, String msg) {
        switch (type) {
            case Constants.OUT: System.out.println(msg); break;
            case Constants.ERR: System.err.println(msg); break;
            default: System.err.println(Constants.INVALID_MESSAGE_TYPE); break;
        }
    }
}
