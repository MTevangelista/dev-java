package banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    public static void main(String[] args) {
        ContaPF contaPF = new ContaPF(2, 100, "MT", "111.222.333-44", 1000);
        ContaPJ contaPJ = new ContaPJ(3, 5000, "SE", "111.222.333/2144");
        List<Conta> contas = new ArrayList<>();
        
        contas.add(contaPF);
        contas.add(contaPJ);
        System.out.println(contas.get(0).calculaSaldo());
        System.out.println(contas.get(1).calculaSaldo());
        
        System.out.println(contaPF);
        System.out.println(contaPJ);
        
        if (contaPF instanceof ContaPF) {
            System.out.println("Conta PF");
        } else {
            System.out.println("Conta PJ");
        }
    }
}
