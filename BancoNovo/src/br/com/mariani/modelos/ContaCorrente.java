package br.com.mariani.modelos;

import br.com.mariani.interfaces.ITributavel;
import java.util.Scanner;

/**
 * Essa classe representa a conta corrente e ela implementa a Interface ITributável e extende a classe conta
 * @author maryucha
 */
public class ContaCorrente extends Conta implements ITributavel {

    private Scanner entrada = new Scanner(System.in);

    @Override
    public void sacar(double saque) {
        double novoSaldo = 0;
        System.out.println("--------SACAR----------");
        System.out.println("EXTRATO: " + super.getSaldo());
        if (super.getSaldo() > saque) {
            novoSaldo = (super.getSaldo() - saque);
            super.setSaldo(novoSaldo);
            System.out.println("Seu saldo atual é  R$" + this.getSaldo());
        } else {
            System.out.println("Seu saldo é insuficiente");
        }

    }

    @Override
    public void depositar(double valor) {
        double novoSaldo = 0;
        System.out.println("EXTRATO ANTERIOR: " + super.getSaldo());
        novoSaldo = (super.getSaldo() + valor);
        super.setSaldo(novoSaldo);
        System.out.println("Seu saldo atual é  R$" + this.getSaldo());
    }

    @Override
    public void transfetir(Cliente destino,Cliente origem, double valor) {
        double saldo = super.getSaldo();
        if (this.getSaldo() >= (valor + 4)) {
            saldo -= (valor + 4);
            super.setSaldo(saldo);
            System.out.println("Transferencia de R$" + valor + " realizada para " + destino.getNome());
        } else {
            System.out.println("Saldo insuficiente!");
        }

    }

    @Override
    public void calcularImposto() {
        System.out.println("--------------DECLARAÇÃO DE IMPOSTO--------------");
        double valorImposto = 100;
        double novoSaldo = 0;
        if (super.getSaldo() >= valorImposto) {
            novoSaldo = super.getSaldo() - valorImposto;
            super.setSaldo(novoSaldo);
            System.out.println("Seu Saldo agora é R$" + super.getSaldo());
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

}
