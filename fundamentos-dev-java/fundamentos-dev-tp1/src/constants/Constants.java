package constants;

public class Constants {
    
    // Message Types   
    public static final String OUT = "out";
    public static final String ERR = "err";
    
    // Input Messages
    public static final String ENTER_YOUR_NAME = "Entre com o seu nome: ";
    public static final String ENTER_YOUR_FIRST_GRADE = "Entre com a nota da AV1: ";
    public static final String ENTER_YOUR_SECOND_GRADE = "Entre com a nota da AV2: ";
    public static final String ENTER_STUDENT_CODE = "Entre com o código do aluno: ";
    
    // OUT Messages
    public static final String EMPTY_MESSAGE = "";
    public static final String YOUR_CODE_IS = "O seu código é: ";

    // ERR Messages
    public static final String ALL_POSITIONS_ARE_OCCUPIED = "todas as posições estão ocupadas";
    public static final String INVALID_OPERATION = "Operação inválida!";
    public static final String INVALID_MESSAGE_TYPE = "O tipo da mensagem é inválido!";
    public static final String INVALID_GRADE = "Nota inválida!";
    
    // Menu
    public static final String MENU_OPTIONS = "[1] Registrar as notas de um novo aluno\n"
                + "[2] Consultar boletim de um aluno\n"
                + "[3] Consultar notas da turma\n"
                + "[4] Sair";
    
    // Student status
    public static final String APPROVED = "Aprovado";
    public static final String FINAL_EXAM = "Prova final";
    public static final String REPROVED = "Reprovado";
}
