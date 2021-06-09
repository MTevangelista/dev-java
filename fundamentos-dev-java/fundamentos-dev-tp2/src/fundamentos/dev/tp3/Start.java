package fundamentos.dev.tp3;

import constants.Constants;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {
    private static int counter = 0;
   
    public static void main(String[] args) {
        final int SIZE = 100;
        People[] peoples = new People[SIZE];
        int option;
        
        option = menu();
        while(option != 4) {
            start(option, peoples);
            showMessage(Constants.OUT, Constants.EMPTY_MESSAGE);
            option = menu();
        }
    }
    
    private static int menu() {
        int option;
        String options = Constants.MENU_OPTIONS;
        
        option = readIntValue(options);
        return option;
    }
    
    private static void start(int option, People[] peoples) {
        switch (option) {
            case 1:
                addTeacherInformation(peoples);
                break;
            case 2:
                addStudentInformation(peoples);
                break;
            case 3: 
                searchPeople(peoples);
                break;
            default:
                showMessage(Constants.ERR, Constants.INVALID_OPERATION);
        }
    }

    private static void addTeacherInformation(People[] peoples) {
        Teacher teacher = new Teacher();
                
        if (hasFreePosition(peoples)) {
            teacher.setName(readStringValue(Constants.ENTER_YOUR_NAME));
            teacher.setSubject(readStringValue(Constants.ENTER_YOUR_SUBJECT));
            teacher.setSalary(readDoubleValue(Constants.ENTER_YOUR_SALARY));
            teacher.setWorkHours(readDoubleValue(Constants.ENTER_YOUR_WORK_HOURS));
            peoples[counter] = teacher;
            showMessage(Constants.OUT, Constants.YOUR_CODE_IS + counter);
            counter++;
        } else {
            showMessage(Constants.ERR, Constants.ALL_POSITIONS_ARE_OCCUPIED);
        }
    }
    
    private static void addStudentInformation(People[] peoples) {
        Student student = new Student();
        
        if (hasFreePosition(peoples)) {
            student.setName(readStringValue(Constants.ENTER_YOUR_NAME));
            student.setFirstGrade(readDoubleGrade(Constants.ENTER_YOUR_FIRST_GRADE));
            student.setSecondGrade(readDoubleGrade(Constants.ENTER_YOUR_SECOND_GRADE));
            peoples[counter] = student;
            showMessage(Constants.OUT, Constants.YOUR_CODE_IS + counter);
            counter++;
        } else {
            showMessage(Constants.ERR, Constants.ALL_POSITIONS_ARE_OCCUPIED);
        }
    }

    private static boolean hasFreePosition(People[] peoples) {
        return counter != peoples.length;
    }
    
    private static void searchPeople(People[] peoples) {
        int peopleCode;
        String result;
        Student student = new Student();
        
        peopleCode = readIntValue(Constants.ENTER_STUDENT_CODE);
        result = student.checkSituation(peoples, peopleCode, counter);
        if (result.isEmpty()) {
            showMessage(Constants.ERR, Constants.PEOPLE_NOT_FOUND);
        } else {
            showMessage(Constants.OUT, result);
        }
    }
    
    private static int readIntValue(String msg) {
        int value = 0;
        boolean isValidValue = false;
        Scanner scanner = new Scanner(System.in);
        
        do {
            try {
                showMessage(Constants.OUT, msg);
                value = scanner.nextInt();
                isValidValue = true;
            } catch (InputMismatchException e) {
                showMessage(Constants.ERR, Constants.INVALID_DATA);
                scanner.next();
            }
        } while (!isValidValue);
        
        return value;
    }
    
    private static String readStringValue(String msg) {
        String value;
        Scanner scanner = new Scanner(System.in);
        
        showMessage(Constants.OUT, msg);
        value = scanner.next();
        return value;
    }
    
    private static double readDoubleGrade(String msg) {
        double value = 0;
        boolean isValidValue = false;
        Scanner scanner = new Scanner(System.in);
        
        do {
            try {
                showMessage(Constants.OUT, msg);
                value = scanner.nextDouble();
                while (!isValidGrade(value)) {
                    showMessage(Constants.ERR, Constants.INVALID_GRADE);
                    showMessage(Constants.OUT, msg);
                    value = scanner.nextDouble();
                }
                isValidValue = true;
            } catch (InputMismatchException e) {
                showMessage(Constants.ERR, Constants.INVALID_DATA);
                scanner.next();
            } catch (Exception e) {
                showMessage(Constants.ERR, Constants.INVALID_GRADE);
                scanner.next();
            }
        } while (!isValidValue);
        return value;
    }
    
    private static double readDoubleValue(String msg) {
        double value = 0;
        boolean isValidValue = false;
        Scanner scanner = new Scanner(System.in);
        
        do {
            try {
                showMessage(Constants.OUT, msg);
                value = scanner.nextDouble();
                isValidValue = true;
            } catch (InputMismatchException e) {
                showMessage(Constants.ERR, Constants.INVALID_DATA);
                scanner.next();
            }
        } while (!isValidValue);
        return value;
    }
    
    private static boolean isValidGrade(double grade) {
        boolean isValid = true;
        
        if ((grade < 0) || (grade > 10)) {
            isValid = false;
        }
        return isValid;
    }
    
    private static void showMessage(String type, String msg) {
        switch (type) {
            case Constants.OUT: System.out.println(msg); break;
            case Constants.ERR: System.err.println(msg); break;
            default: System.err.println(Constants.INVALID_MESSAGE_TYPE); break;
        }
    }
}
