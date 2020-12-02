package br.com.mariani.modelo;

import br.com.mariani.interfaces.ITributavel;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class ContaCorrente extends Conta implements ITributavel{
    private Scanner entrada = new Scanner(System.in);

    @Override
    public void sacar(double saque) {
        double novoSaldo=0;
        System.out.println("--------SACAR----------");
        System.out.println("EXTRATO: "+super.getSaldo());
        System.out.print("Digite o valor que deseja sacar ");
        saque=entrada.nextDouble();
        entrada.nextLine();
        if(super.getSaldo()>saque){
            novoSaldo=(super.getSaldo()-saque);
            super.setSaldo(novoSaldo);
            System.out.println("Seu saldo atual é  R$"+this.getSaldo());
        }else{
            System.out.println("Seu saldo é insuficiente");
        }
        
    }

    @Override
    public void depositar(double valor) {
        double novoSaldo=0;
        System.out.println("EXTRATO: "+super.getSaldo());
        System.out.print("Digite o valor que deseja depositar ");
        valor=entrada.nextDouble();
        entrada.nextLine();
        novoSaldo=(super.getSaldo()+valor);
            super.setSaldo(novoSaldo);
            System.out.println("Seu saldo atual é  R$"+this.getSaldo());
    }

    @Override
    public void transfetir(Cliente destino, double valor) {
        if (super.getSaldo() >= (valor + 4)) {
            double saldo= super.getSaldo();
            saldo -= (valor + 4);
            System.out.println("Transferencia de R$" + valor + " realizada para ");
            destino.pegarConta().depositar(valor);
            
        }
        System.out.println("Saldo insuficiente!");
        
    }

    @Override
    public double imposto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
