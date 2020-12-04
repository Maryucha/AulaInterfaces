package br.com.mariani.modelos;

import java.util.Random;
import java.util.Scanner;

/**
 * Essa é a classe que modela a conta
 * nela temos:
 * numConta que é sorteado por um random;
 * agencia sorteado por um random
 * tipo de conta String
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

    public Conta(Integer numConta, double saldo, int agencia, String tipoConta, Cliente cliente) {
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
    
    /**
     * Esse método seta os parametros da conta quando chamado
     */
    public void carregaConta() {
        this.setNumConta(gerador.nextInt(10000));
        System.out.println("O número da CONTA é: " + this.getNumConta());
        this.setAgencia(gerador.nextInt(10000));
        System.out.println("O número da AGENCIA é: " + this.getAgencia());
        System.out.println("Agora você deve realizar um depósito para iniciar sua conta!");
    }
    
    /**
     * esse método é um retorno de todos os atributos da conta
     */
    public void imprimeConta(){
        System.out.println("-----------------CONTA---------------");
        System.out.println("TIPO DE CONTA ["+this.getTipoConta()+"] | NÚMERO DA CONTA ["+this.getNumConta()+"] | AGENCIA ["+this.getAgencia()+"] | SALDO ["+this.getSaldo()+"]");
    }
    /**
     * Esse método será implementado nas classes que vão estender conta
     * e quando as classes filhas forem instanciadas esse método for invocado ele pedira um valor como parametro;
     * @param valor 
     */
    public abstract void sacar(double valor);
    /**
     *  Esse método será implementado nas classes que vão estender conta
     * e quando as classes filhas forem instanciadas esse método for invocado ele pedira um valor como parametro;
     * @param valor 
     */
    public abstract void depositar(double valor);
    /**
     * Esse método será implementado nas classes que vão estender conta
     * e quando as classes filhas forem instanciadas esse método for invocado ele pedira um valor, um cliente de origem e um cliente de destino;
     * @param destino
     * @param origem
     * @param valor 
     */
    public abstract void transfetir(Cliente destino, Cliente origem, double valor);
    
}


