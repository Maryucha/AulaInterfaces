/*
 * Nesse exercício vamos criar um sisteminha básico de calculadora. Para isso,
 *   criaremos uma interface chamada 

IOperacaoMatematica que irá definir um
 *   método chamado calcula(double valorUm, doublevalorDois). Depois disso
 *   crie classes para as seguintes operações: 
Soma, 
Subtração. 
Multiplicação.
Divisão 
Exponenciação. 
    Todas essas classes devem implementar a
 *   interface IOperacaoMatematica e o método calcula(). Além disso, crie um
 *   segunda 
interface chamada IImprimir que definir um método
 *   mostrarValor(double valor). As classes também devem implementar essa
 *   classe e o método dela.
 */
package br.com.mariani.modelo;

import br.com.mariani.interfaces.IImprimir;
import br.com.mariani.interfaces.IOperacaoMatematica;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class Subtracao implements IOperacaoMatematica, IImprimir{
    
    private double num1, num2, resutado;
    private Scanner entrada = new Scanner(System.in);

    public Subtracao() {
    }

    public Subtracao(double num1, double num2, double resutado) {
        this.num1 = num1;
        this.num2 = num2;
        this.resutado = resutado;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResutado() {
        return resutado;
    }

    public void setResutado(double resutado) {
        this.resutado = resutado;
    }
    
    

    @Override
    public double calcular() {
            System.out.println("---------------SOMA----------------");
        System.out.print("Digite o número 1: ");
        this.setNum1(entrada.nextDouble());
        entrada.nextLine();
        System.out.print("Digite o número 2: ");
        this.setNum2(entrada.nextDouble());
        entrada.nextLine();
        this.setResutado(this.getNum1() - this.getNum2());

        return resutado;

    }

    @Override
    public void mostrarValor() {
        System.out.println("-------------MOSTRAR CONTA-----------");
        System.out.println("["+this.getNum1()+"] - ["+this.getNum2()+"] = ["+this.getResutado()+"]");
    }

    
}
