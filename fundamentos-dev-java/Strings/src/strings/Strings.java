package strings;

public class Strings {
 
    public static void main(String[] args) {
        String nome = "MT";
        String[] campos;
        
        for (int i = 0; i < nome.length(); i++) {
            System.out.println(nome.charAt(i));
        }
        campos = nome.split(" ");
        System.out.println(campos[0]);
        System.out.println(campos[1]);
        System.out.println(campos[2]);
        System.out.println(nome.isEmpty());
    }
   
}
