package br.com.mariani.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  Essa classe modela o meu objeto do tipo cliente
 * ela tem:
 * Nome
 * Cpf
 * listaContas
 * @author maryucha
 */
public class Cliente {

    private String nome;
    private String Cpf;
    private Scanner entrada = new Scanner(System.in);
    private List<Conta> listaContas = new ArrayList<>();

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
    /**
     * Esse método instancia um novo objeto do tipo cliente
     * e seta seus atribustos chamando o método carrega cliente
     * @return 
     */
    public Cliente criaCliente() {
        Cliente cliente = new Cliente();
        cliente.carregaCliente();
        System.out.println("Cliente cadastrado com Sucesso!");
        return cliente;
    }
    /**
     * método responsavel por setar os atributos do objeto cliente 
     * e também cadastra a conta para o cliente invocando o cadConta
     */
    public void carregaCliente() {
        System.out.print("Digite o nome do Cliente: ");
        this.setNome(entrada.nextLine());
        System.out.print("Digite o CPF: ");
        this.setCpf(entrada.nextLine());
        cadConta();
    }
    /**
     * Esse método permite que eu escolha o tipo de conta que meu cliente vai receber
     */
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
    /**
     * Esse método imprime os atributos do cliente
     */
    public void imprimeCliente() {
        System.out.println("---------------------------CLIENTE--------------------------");
        System.out.println("NOME [" + this.getNome() + "] | CPF [" + this.getCpf() + "]");
    }
    /**
     * Esse método é o responsável pela busca da conta do meu cliente validando
     * pelo cpf
     * @OBS pretendo implementar uma validação aqui de que se já existir um determinado 
     * tipo de conta o cliente não pode cadastrar outra
     * @return 
     */
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
    
    /**
     * Esse método instancia o objeto conta corrente para a lista de contas do cliente
     * e já seta o tipo da conta;
     * @return contaCorrente
     */
    public Conta criaContaCorrente() {
        Conta contaCorrente = new ContaCorrente();
        contaCorrente.carregaConta();
        contaCorrente.setTipoConta("001");
        return contaCorrente;
    }
    /**
     * Esse método instância o objeto conta corrente para lista de contas do cliente se seta o tipo de conta
     * @return contaPoupanca
     */
    public Conta criaContaPoupanca() {
        Conta contaPoupanca = new ContaPoupanca();
        contaPoupanca.carregaConta();
        contaPoupanca.setTipoConta("002");
        return contaPoupanca;
    }

}
