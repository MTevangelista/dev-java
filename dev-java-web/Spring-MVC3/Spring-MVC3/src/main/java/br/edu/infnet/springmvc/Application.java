package br.edu.infnet.springmvc;

import br.edu.infnet.springmvc.model.negocio.Aluno;
import br.edu.infnet.springmvc.model.negocio.Disciplina;
import br.edu.infnet.springmvc.model.negocio.Email;
import br.edu.infnet.springmvc.model.negocio.Endereco;
import br.edu.infnet.springmvc.model.repository.IAlunoRepository;
import br.edu.infnet.springmvc.model.repository.IDisciplinaRepository;
import br.edu.infnet.springmvc.model.repository.IEmailRepository;
import br.edu.infnet.springmvc.model.repository.IEnderecoRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public CommandLineRunner teste1(IAlunoRepository alunoRepository,
                                    IEnderecoRepository enderecoRepository) {
        return (String[] args) -> {
            
            Aluno aluno;
//            aluno = new Aluno("LP", "2299999999");
//            Endereco endereco = new Endereco("Rua xyz", "Santa Catarina", "PS", "RJ", "229000");
//            aluno.setEndereco(endereco);
//            alunoRepository.save(aluno);
//            System.out.println("Aluno salvo:" + aluno);
//            System.out.println(endereco);

//            aluno = alunoRepository.findById(1).get();
//            System.out.println(aluno);
//            System.out.println(aluno.getEndereco());
//            alunoRepository.delete(aluno);
        };
    }    
    
    @Bean
    public CommandLineRunner teste2(IAlunoRepository alunoRepository,
                                    IEnderecoRepository enderecoRepository,
                                    IEmailRepository emailRepository) {
        return (String[] args) -> {
            
            Aluno aluno;
//            aluno = new Aluno("LP", "2299999999");
//            Endereco endereco = new Endereco("Rua xyz", "Santa Catarina", "PS", "RJ", "229000");
//            aluno.setEndereco(endereco);
//            alunoRepository.save(aluno);
//            System.out.println("Aluno salvo:" + aluno);
//            System.out.println(endereco);
//            emailRepository.save(new Email("lpmaia@gmail.com", aluno));
//            emailRepository.save(new Email("lpmaia@training.com.br", aluno));
//            System.out.println("Emails gravados");

//            aluno = alunoRepository.findById(1).get();
//            System.out.println(aluno);
//            System.out.println(aluno.getEndereco());
//            System.out.println(aluno.getEmails());
//            alunoRepository.delete(aluno);
        };
    }      
    
    @Bean
    public CommandLineRunner teste3(IAlunoRepository alunoRepository,
                                    IDisciplinaRepository disciplinaRepository,
                                    IEnderecoRepository enderecoRepository) {
        return (String[] args) -> {
            
//            Aluno aluno = new Aluno("Larissa", "2299999999");
//            Endereco endereco = new Endereco("Rua xyz", "Santa Catarina", "PS", "RJ", "229000");
//            aluno.setEndereco(endereco);
//            alunoRepository.save(aluno);
//            System.out.println("Aluno salvo:" + aluno);
//            System.out.println(endereco);
//            Set<Disciplina> disciplinas = new HashSet<>();
//            Disciplina disciplina = disciplinaRepository.findById(1).get();
//            disciplinas.add(disciplina);
//            disciplina = disciplinaRepository.findById(2).get();
//            disciplinas.add(disciplina);
//            aluno.setEndereco(endereco);
//            aluno.setDisciplinas(disciplinas);
//            alunoRepository.save(aluno);
//            System.out.println("Aluno gravado: " + aluno);
//            System.out.println(disciplinas);

//            Aluno aluno = alunoRepository.findById(4).get();
//            System.out.println(aluno);
//            System.out.println(aluno.getEndereco());
//            System.out.println(aluno.getDisciplinas());
//            alunoRepository.delete(aluno);
        };
    }            

    @Bean
    public CommandLineRunner teste4(IAlunoRepository alunoRepository,
                                    IDisciplinaRepository disciplinaRepository) {
        return (String[] args) -> {
            
            Aluno aluno = alunoRepository.findById(1).get();
            System.out.println(aluno);
            System.out.println(aluno.getEndereco());
            System.out.println(aluno.getDisciplinas());
            Disciplina disciplina = disciplinaRepository.findById(3).get();
            Set<Disciplina> disciplinas = aluno.getDisciplinas();
            disciplinas.add(disciplina);
            aluno.setDisciplinas(disciplinas);
            alunoRepository.save(aluno);
            System.out.println("Aluno gravado: " + aluno);
            System.out.println(aluno.getDisciplinas());
        };
    }            
}