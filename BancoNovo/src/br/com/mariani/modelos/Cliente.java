package br.com.mariani.modelos;

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
    private Scanner entrada = new Scanner(System.in);
    private static List<Conta> listaContas = new ArrayList<>();

    public Cliente() {

    }

    public Cliente(String nome, String Cpf, Conta conta, String senha) {
        this.nome = nome;
        this.Cpf = Cpf;
        this.listaContas = listaContas;
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

    public List<Conta> getListaContas() {
        return listaContas;
    }

    public void setListaConta(List<Conta> listaContas) {
        this.listaContas = listaContas;
    }

    public Cliente criaCliente() {
        Cliente cliente = new Cliente();
        cliente.carregaCliente();
        System.out.println("Cliente cadastrado com Sucesso!");
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
                + "\n-----------------------------------------------------\n");
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

    public Conta buscaConta() {
        Conta conta=null;
        System.out.print("Digite o tipo da conta: ");
        String tipoContaLista = entrada.nextLine();  
        for (int i = 0; i < listaContas.size(); i++) {
            if(tipoContaLista.equalsIgnoreCase(listaContas.get(i).getTipoConta())){
                 conta = listaContas.get(i);
                   return conta;
            }else{
                 conta = listaContas.get(i);
                    return conta;
            }
        }
        return null;
    }

    public Conta criaContaCorrente() {
        Conta contaCorrente = new ContaCorrente();
        contaCorrente.carregaConta();
        contaCorrente.setTipoConta("001");
        return contaCorrente;
    }

    public Conta criaContaPoupanca() {
        Conta contaPoupanca = new ContaPoupanca();
        contaPoupanca.carregaConta();
        contaPoupanca.setTipoConta("002");
        return contaPoupanca;
    }

}
