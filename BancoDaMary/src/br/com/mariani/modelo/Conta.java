package br.com.mariani.modelo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public abstract class Conta {

    private Integer numConta;
    private double saldo;
    private int agencia;
    private String tipoConta;
    private Scanner entrada = new Scanner(System.in);
    private Random gerador = new Random();

    public Conta() {
    }

    public Conta(Integer numConta, double saldo, int agencia, String tipoConta) {
        this.numConta = numConta;
        this.saldo = saldo;
        this.agencia = agencia;
        this.tipoConta = tipoConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Integer getNumConta() {
        return numConta;
    }

    public void setNumConta(Integer numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void carregaConta() {
        this.setNumConta(gerador.nextInt(10000));
        System.out.println("O número da conta é: " + this.getNumConta());
        this.setAgencia(gerador.nextInt(10000));
        System.out.println("O número da conta é: " + this.getAgencia());
        System.out.println("Agora você deve realizar um depósito para iniciar sua conta!");
    }
    
    
    public void imprimeConta(){
        System.out.println("-----------------CONTA---------------");
        System.out.println("TIPO DE CONTA ["+this.getTipoConta()+"] | NÚMERO DA CONTA ["+this.getNumConta()+"] | AGENCIA ["+this.getAgencia()+"] | SALDO ["+this.getSaldo()+"]");
    }

    public abstract void sacar();

    public abstract void depositar();

    public abstract void transfetir();
}
