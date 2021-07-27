package constants;

public final class Constants {
    
    // File name
    public static final String FILE_NAME = "accounts.txt";
    
    // Input Messages
    public static final String ENTER_YOUR_ACCOUNT_BALANCE = "Entre com o saldo da conta: ";
    public static final String ENTER_YOUR_ACCOUNT_NUMBER = "Entre com o número da conta: ";
    
    // AccountPJ Input Messages 
    public static final String ENTER_YOUR_ACCOUNT_HOLDER_NAME = "Entre com o nome do correntista: ";
    public static final String ENTER_YOUR_CPF = "Entre com o seu CPF: ";
    public static final String ENTER_YOUR_SPECIAL_CHECK = "Entre com o seu saldo especial: ";

    // AccountPF Input Messages
    public static final String ENTER_YOUR_COMPANY_NAME = "Entre com o nome da empresa: ";
    public static final String ENTER_YOUR_CNPJ = "Entre com o seu CNPJ: ";
    
    // OUT Messages
    public static final String EMPTY_MESSAGE = "";
    public static final String ACCOUNT_REMOVED_SUCCESSFULLY = "Conta removida com sucesso";
    public static final String ACCOUNT_REGISTER_SUCCESSFULLY = "Conta cadastrada com sucesso!";
    public static final String ACCOUNT_PF = "Contas - Pessoas Físicas";
    public static final String ACCOUNT_PJ = "Contas - Pessoas Jurídicas";

    // ERR Messages
    public static final String FILE_READ_ERROR = "Erro: não foi possível ler o arquivo";
    public static final String FILE_OPEN_ERROR = "Erro: abertura do arquivo";
    public static final String FILE_NOT_FOUND = "Erro: arquivo não encontrado";
    public static final String INVALID_NAME = "Erro: o nome precisa ter pelo menos dois campos";
    public static final String INVALID_OPERATION = "Operação inválida!";
    public static final String INVALID_MESSAGE_TYPE = "O tipo da mensagem é inválido!";
    public static final String INVALID_DATA = "Erro: dado inválido!";
    public static final String INVALID_BALANCE = "Erro: saldo precisa ser maior ou igual a 0";
    public static final String INVALID_NUMBER = "Erro: número precisa ser um inteiro";
    public static final String ACCOUNT_ALREADY_EXISTS = "Erro: conta já existe";
    public static final String ACCOUNT_CANNOT_REMOVED = "Conta não pode ser removida";
    
    // User menu options 
    public static final String USER_OPTIONS_MENU = "[1] Cadastrar conta\n"
                + "[2] Alterar conta\n"
                + "[3] Excluir conta\n"
                + "[4] Relatórios gerenciais\n"
                + "[5] Sair";
    
    // Account type options 
    public static final String ACCOUNT_TYPES_OPTIONS_MENU = "[1] Conta PF\n"
                + "[2] Conta PJ\n";
    
    // Management reports
    public static final String MANAGEMENT_REPORTS_MENU = "[1] Listar clientes com saldo negativo\n"
                + "[2] Listar os clientes que tem saldo acima de um determinado valor\n"
                + "[3] Listar todas as contas separadas por tipo\n"
                + "[4] Listar as operações realizadas em uma determinada conta\n";
}