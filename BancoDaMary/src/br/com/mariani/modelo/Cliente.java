package br.com.mariani.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class Cliente {

    private String nome;
    private String Cpf;
    private Conta conta;
    private Scanner entrada = new Scanner(System.in);
    private List<Conta> listaContas = new ArrayList<>();

    public Cliente() {

    }

    public Cliente(String nome, String Cpf) {

        this.nome = nome;
        this.Cpf = Cpf;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public List<Conta> getListaContas() {
        return listaContas;
    }

    public void setListaConta(List<Conta> listaContas) {
        this.listaContas = listaContas;
    }

    public Cliente criaCliente() {
        Cliente cliente = new Cliente();
        cliente.carregaCliente();
        return cliente;
    }

    public void carregaCliente() {
        System.out.print("Digite o nome do Cliente: ");
        this.setNome(entrada.nextLine());
        System.out.print("Digite o CPF: ");
        this.setCpf(entrada.nextLine());
//        /**
//         * atenção
//         */
        cadConta();

    }
    public void cadConta() {

        System.out.println("------------------CADASTRO DA CONTA------------");
        int escolha = 0;
        System.out.print("Escolha o tipo de conta:  "
                + "\n1 Conta Corrente: "
                + "\n2 Conta Poupança: "
                + "\n--------------------------------\n");
        escolha = entrada.nextInt();
        entrada.nextLine();
        switch (escolha) {
            case 1:
                listaContas.add(criaContaCorrente());
                this.setListaConta(listaContas);
                System.out.println("Parabéns você agora é um correntista!");
                break;
            case 2:
                listaContas.add(criaContaPoupanca());
                this.setListaConta(listaContas);
                System.out.println("Parabéns você agora é um poupador!");
                break;
            default:
                System.out.println("Escolha uma opção válida!");
                break;
        }
    }

    public void imprimeCliente() {
        System.out.println("---------------------------CLIENTE--------------------------");
        System.out.println("NOME [" + this.getNome() + "] | CPF [" + this.getCpf() + "]");
    }

    public Conta criaContaCorrente() {
        Conta contaCorrente = new ContaCorrente();
        contaCorrente.carregaConta();
        contaCorrente.setTipoConta("CONTA CORRENTE");
        return contaCorrente;
    }

    public Conta criaContaPoupanca() {
        Conta contaPoupanca = new ContaPoupanca();
        contaPoupanca.carregaConta();
        contaPoupanca.setTipoConta("CONTA POUPANÇA");
        return contaPoupanca;
    }

}
