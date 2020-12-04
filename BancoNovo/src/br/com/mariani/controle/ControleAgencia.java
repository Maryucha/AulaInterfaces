package br.com.mariani.controle;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.com.mariani.modelos.Cliente;
import br.com.mariani.modelos.Conta;

/**
 *
 * @author maryucha
 */
public class ControleAgencia {

    private Scanner entrada = new Scanner(System.in);
    private static List<Cliente> listaClientes = new ArrayList<>();
    private Integer menu = 0;

    public void agencia() {
        do {
            try {
                System.out.println("--------------AGENCIA BANCÁRIA------------"
                        + "\n1 Cadastrar Cliente: "
                        + "\n2 Mostrar Cliente: "
                        + "\n3 Cadastrar Nova Conta: "
                        + "\n4 Mostrar Contas: "
                        + "\n5 Desvincular Cliente: "
                        + "\n6 Depositar: "
                        + "\n7 Transferir: "
                        + "\n8 Sacar: "
                        + "\n9 Voltar: "
                        + "\n------------------------------------------------------\n");
                menu = entrada.nextInt();
                entrada.nextLine();
            } catch (HeadlessException | NumberFormatException e) {
                menu = null;
            }
            if (menu != null) {
                switch (menu) {
                    case 1:
                        cadCliente();
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
                        deposito(bucarCliente());
                        break;
                    case 7:
                        transferencia(bucarCliente());
                        break;

                    case 8:
                        sacar(bucarCliente());
                        break;

                    default:
                        System.out.println("Escolha uma opção válida!");
                        break;
                }
            }
        } while (menu != 9);
    }

    public void cadCliente() {
        System.out.println("--------CADASTRO DE NOVO CLIENTE----------");
        Cliente cliente = new Cliente();
        listaClientes.add(cliente.criaCliente());
    }

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

    public void mostrarContaPorCliente() {
        System.out.println("------------CONTAS DO CLIENTE----------");
        Cliente cliente = bucarCliente();
        
        do {
            for (int i = 0; i < cliente.getListaContas().size(); i++) {
                cliente.getListaContas().get(i).imprimeConta();
            }

        } while (cliente.getListaContas().size() < 1);

    }

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
                cadCliente();
            }
        }
    }

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

    public void deposito(Cliente cliente) {
        System.out.println("-----------DEPOSITAR-----------");
        Conta conta = cliente.buscaConta();
        System.out.print("Digite o valor que deseja depositar: ");
        conta.depositar(entrada.nextDouble());
        System.out.println("Depósito realizado com sucesso!");

    }

    public void transferencia(Cliente cliente) {
        System.out.println("--------------TRANSFERIR-----------------");
        Conta conta = cliente.buscaConta();
        System.out.print("Digite o valor que deseja Transferir ");
        double valor = entrada.nextDouble();
        conta.transfetir(cliente, valor);
        conta.setSaldo(conta.getSaldo() + valor);
        System.out.println("Transferência realizada com sucesso!");

    }

    private void sacar(Cliente cliente) {
        System.out.println("-------------SACAR-------------------");
        Conta conta = cliente.buscaConta();
        System.out.print("Digite o valor que deseja Sacar ");
        conta.sacar(entrada.nextDouble());
        entrada.nextLine();
    }

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
