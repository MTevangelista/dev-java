package tp1.oo;

import constants.Constants;
import java.util.Scanner;

public class Principal {
   private static int counter = 0;
   
    public static void main(String[] args) {
        final int SIZE = 100;
        Student[] students = new Student[SIZE];
        int option;
        
        option = menu();
        while(option != 4) {
            start(option, students);
            showMessage(Constants.OUT, Constants.EMPTY_MESSAGE);
            option = menu();
        }
    }
    
    private static void start(int option, Student[] students) {
        switch (option) {
            case 1:
                addStudentInformation(students);
                break;
            case 2:
                searchStudent(students);
                break;
            case 3: 
                searchAllStudents(students);
                break;
            default:
                showMessage(Constants.ERR, Constants.INVALID_OPERATION);
        }
    }
    
    private static boolean hasFreePosition(Student[] students) {
        return counter != students.length;
    }
    
    private static void addStudentInformation(Student[] students) {
        Student student = new Student();
        
        if (hasFreePosition(students)) {
            student.setName(readStringValue(Constants.ENTER_YOUR_NAME));
            student.setFirstGrade(readDoubleValue(Constants.ENTER_YOUR_FIRST_GRADE));
            student.setSecondGrade(readDoubleValue(Constants.ENTER_YOUR_SECOND_GRADE));
            students[counter] = student;
            showMessage(Constants.OUT, Constants.YOUR_CODE_IS + counter);
            counter++;
        } else {
            showMessage(Constants.ERR, Constants.ALL_POSITIONS_ARE_OCCUPIED);
        }
    }
    
    private static void searchStudent(Student[] students) {
        int studentCode;
        
        studentCode = readIntValue(Constants.ENTER_STUDENT_CODE);        
        for (int i = 0; i < counter; i++) {
            if (i == studentCode) {
                showMessage(Constants.OUT, students[i].toString());
                break;
            }
        }
    }
    
    private static void searchAllStudents(Student[] students) {
        for (int i = 0; i < counter; i++) {
            showMessage(Constants.OUT, students[i].toString());
        }
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
     
    private static void showMessage(String type, String msg) {
        switch (type) {
            case Constants.OUT: System.out.println(msg); break;
            case Constants.ERR: System.err.println(msg); break;
            default: System.err.println(Constants.INVALID_MESSAGE_TYPE); break;
        }
    }
}
