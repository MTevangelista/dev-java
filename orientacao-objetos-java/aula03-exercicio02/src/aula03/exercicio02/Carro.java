/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio2;

/**
 *
 * @author ericson
 */
public class Carro {
    private String modelo;
    
    private Motor motor;
    
    // Método construtor
    public Carro(String modelo, float cilindrada){
        this.modelo = modelo;
        motor = new Motor(cilindrada);
    }
    
    public void velocidadeMaxima(){
        System.out.println("cilindrada = " + motor.getCilindrada());
        if(motor.getCilindrada() <= (float) 1.0){
            System.out.println(modelo + " possui velocidade Máxima é 140 Km/h");
        }else if (motor.getCilindrada() <= (float) 1.6){
            System.out.println(modelo + " possui velocidade Máxima é 180 Km/h");
        }else if (motor.getCilindrada() <= (float) 2.0){
            System.out.println(modelo + " possui velocidade Máxima é 220 Km/h");
        }else {
            System.out.println(modelo + " possui velocidade Máxima é 260 Km/h");
        }
    }
    
    public static void main(String args[]){
        Carro c1 = new Carro("Fox", (float) 1.0);
        c1.velocidadeMaxima();
        Carro c2 = new Carro("Fiesta", (float) 1.6);
        c2.velocidadeMaxima();
        Carro c3 = new Carro("Focus", (float) 2.0);
        c3.velocidadeMaxima();
        Carro c4 = new Carro("Jetta", (float) 2.5);
        c4.velocidadeMaxima();
    }
}
