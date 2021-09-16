package br.edu.infnet.ExemploFeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExemploFeignApplication implements CommandLineRunner{
        
        @Autowired
        private ViaCepService vp;
        
        @Autowired
        private CNPJService cs;
                
	public static void main(String[] args) {
		SpringApplication.run(ExemploFeignApplication.class, args);
	}
        
        @Override
        public void run(String... args) throws Exception {

            if (args.length > 0) {
                    String cep = args[0];
                    System.out.println("Obter CEP ---> " + cep);
                    Endereco end = vp.buscaEnderecoPor(cep);
                    System.out.println(end);
                    
                    String cnpj = args[1];
                    System.out.println("Obter CNPJ ---> " + cnpj);
                    Empresa emp = cs.buscaEmpresaPor(cnpj);
                    System.out.println(emp);
            }
        }
}
