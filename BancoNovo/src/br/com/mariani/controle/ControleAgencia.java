package br.com.mariani.controle;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.com.mariani.modelos.Cliente;

/**
 * 
 * Essa Classe tem o objetivo de encapsular os métodos referentes as ações da agencia bancária.
 * @author maryucha
 */
public class ControleAgencia {

    private Scanner entrada = new Scanner(System.in);
    private static List<Cliente> listaClientes = new ArrayList<>();
    Cliente cli = new Cliente();
    private Integer menu = 0;

    /**
     * Esse método roda o menu da agencia usando um switch
     *
     */
    public void agencia() {
        do {
            try {
                System.out.println("--------------AGENCIA BANCÁRIA------------"
                        + "\n1 Cadastrar Cliente: "
                        + "\n2 Mostrar Cliente: "
                        + "\n3 Cadastrar Nova Conta: "
                        + "\n4 Mostrar Contas: "
                        + "\n5 Desvincular Cliente: "
                        + "\n6 Terminal Eletrônico: "
                        + "\n7 Sair: "
                        + "\n------------------------------------------------------\n");
                menu = entrada.nextInt();
                entrada.nextLine();
            } catch (HeadlessException | NumberFormatException e) {
                menu = null;
            }
            if (menu != null) {
                switch (menu) {
                    case 1:
                        listaClientes.add(cli.criaCliente());
                        break;
                    case 2:
                        mostrarClientes();
                        break;
                    case 3:
                        cadNovaConta();
                        break;
                    case 4:
                        mostrarContaPorCliente();
                        break;
                    case 5:
                        desvincularCliente();
                        break;
                    case 6:
                        CaixaEletronico caixa = new CaixaEletronico();
                        caixa.terminalEletronico();
                        break;
                    case 7:
                        System.out.println("Até mais!");
                        break;
                    default:
                        System.out.println("Escolha uma opção válida!");
                        break;
                }
            }
        } while (menu != 7);
    }
/**
 * Esse método retorna todos os clientes e suas contas!
 */
    public void mostrarClientes() {
        System.out.println("------------Clientes CADASTRADOS----------");
        if (listaClientes.isEmpty()) {
            System.out.println("Ainda não temos Clientes cadastrados.");
        } else {
            for (int i = 0; i < listaClientes.size(); i++) {
                listaClientes.listIterator(i).next().imprimeCliente();
                try {
                    listaClientes.get(i).getListaContas().get(0).imprimeConta();
                    listaClientes.get(i).getListaContas().get(1).imprimeConta();
                } catch (Exception e) {
                    System.out.println("Seu cliente Tem apenas essa conta!");
                }
            }
        }
    }
/**
 * Esse método percorre a lista de clientes através do busca cliente
 * e trás as contas cadastradas na lista de contas desse cliente.
 * 
 */
    public void mostrarContaPorCliente() {
        System.out.println("------------CONTAS DO CLIENTE----------");
        Cliente cliente = bucarCliente();
        do {
            for (int i = 0; i < cliente.getListaContas().size(); i++) {
                cliente.getListaContas().get(i).imprimeConta();
            }

        } while (cliente.getListaContas().size() < 1);

    }
/**
 * Esse método cadastra uma nova conta para o cliente
 * @obs: pretendo fazer uma validação da existência do tipo de conta
 */
    public void cadNovaConta() {
        Cliente cliente = new Cliente();
        System.out.print("Digite o CPF do Cliente: ");
        String cpf = entrada.nextLine();
        for (int i = 0; i < listaClientes.size(); i++) {
            if (cpf.equalsIgnoreCase(listaClientes.get(i).getCpf())) {
                cliente.cadConta();
                return;
            } else {
                System.out.println("Cliente não encontrado!");
                cliente.criaCliente();
            }
        }
    }
/**
 * Esse método´percorre a lista de Clientes e remove ele pelo index;
 */
    public void desvincularCliente() {
        System.out.print("Digite o CPF do Cliente: ");
        String nome = entrada.nextLine();
        for (int i = 0; i < listaClientes.size(); i++) {
            if (nome.equalsIgnoreCase(listaClientes.get(i).getCpf())) {
                listaClientes.remove(i);
            } else {
                System.out.println("Cliente não encontrado!");
            }
        }
    }
/**
 * Esse método busca o meu cliente dentro do listaClientes dessa classe
 * @return cliente
 */
    public Cliente bucarCliente() {
        Cliente cliente;
        System.out.print("Digite o CPF do Cliente: ");
        String cpf = entrada.nextLine();
        for (int i = 0; i < listaClientes.size(); i++) {
            try {
                if (cpf.equals(listaClientes.get(i).getCpf())) {
                    cliente = listaClientes.get(i);
                    System.out.println("O nome do CLIENTE é [" + cliente.getNome() + "]");
                    return cliente;
                } else {
                    System.out.println("Buscando...");
                }
            } catch (Exception e) {
                System.out.println("Cliente não encontrado!");
            }
        }
        return null;
    }
}
