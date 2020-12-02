package br.com.mariani.controle;

import br.com.mariani.modelo.Cliente;
import br.com.mariani.modelo.Conta;
import br.com.mariani.modelo.ContaCorrente;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class ControleContas {

    private List<Cliente> listaClientes = new ArrayList<>();
    Cliente cliente = new Cliente();
    private Scanner entrada = new Scanner(System.in);
    private Integer menu = 0;

    public void cadCliente() {
        System.out.println("-----------------NOVO CLIENTE------------");
        listaClientes.add(cliente.criaCliente());
    }

    private void mostarClientes() {
        System.out.println("------------Clientes CADASTRADOS----------");
        if (listaClientes.isEmpty()) {
            System.out.println("Ainda não temos Clientes cadastrados.");
        } else {
            for (int i = 0; i < listaClientes.size(); i++) {
                listaClientes.listIterator(i).next().imprimeCliente();
            }
        }
    }

    public void mostrarContaCliente() {
        System.out.println("------------CONTA DO CLIENTE----------");
        System.out.print("Digite o nome do Cliente: ");
        String nome = entrada.nextLine();
        for (int i = 0; i < listaClientes.size(); i++) {
            if (nome.equalsIgnoreCase(listaClientes.get(i).getNome())) {
                listaClientes.listIterator(i).next().getListaContas().listIterator().next().imprimeConta();
            } else {
                System.out.println("Cliente não cadastrado!");
            }
        }
    }

    private void desvincularCliente() {
        System.out.print("Digite o nome do Cliente: ");
        String nome = entrada.nextLine();
        for (int i = 0; i < listaClientes.size(); i++) {
            if (nome.equalsIgnoreCase(listaClientes.get(i).getNome())) {
                listaClientes.remove(i);
            } else {
                System.out.println("Cliente não encontrado!");
            }
        }
    }

    private void cadNovaConta() {
        System.out.print("Digite o nome do Cliente: ");
        String nome = entrada.nextLine();
        for (int i = 0; i < listaClientes.size(); i++) {
            if (nome.equalsIgnoreCase(listaClientes.get(i).getNome())) {
                cliente.cadConta();
            } else {
                System.out.println("Cliente não encontrado!");
                cadCliente();
            }
        }
    }
    
      public Cliente buscarCliente(Cliente cliente) {
        System.out.print("Digite o cpf do Cliente: ");
        String cpf = entrada.nextLine();
        for (int i = 0; i < listaClientes.size(); i++) {
            if (cpf.equalsIgnoreCase(listaClientes.get(i).getCpf())) {
                System.out.println("Cliente encontradao");
                cliente = listaClientes.get(i);
            } else {
                System.out.println("Cliente não cadastrado!");
            }
        }
        return cliente;
    }

    public Conta buscaConta(Cliente cliente) {
        Conta cc = new ContaCorrente();
        buscarCliente(cliente);
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getNome() == cliente.getNome()) {
                cc = listaClientes.get(i).pegarConta();
                return cc;
            } else {
                System.out.println("Conta não encontrada");

            }
        }
        return null;
    }
    
    public void vaiDepositar(Cliente cliente, Conta conta){
        double saldo=0;
        buscaConta(cliente).depositar(5000);
        for(int i=0;i<listaClientes.size();i++){
            saldo= listaClientes.listIterator(i).next().pegarConta().getSaldo();
            System.out.println("saldo "+saldo);
        }
    }

    public void gerencia() {
        do {
            try {
                System.out.println("==========MENU BANCO==========="
                        + "\n1 Cadastrar Cliente: "
                        + "\n2 Mostrar Cientes: "
                        + "\n3 Criar Conta para Cliente: "
                        + "\n4 Mostrar Conta de Cliente: "
                        + "\n5 Desvincular Cliente: "
                        + "\n6 Voltar: "
                        + "\n----------------------------------------");
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
                        mostarClientes();
                        break;
                    case 3:
                        cadNovaConta();
                        break;
                    case 4:
                        mostrarContaCliente();
                        break;
                    case 5:
                        desvincularCliente();
                        break;
                    case 6:
                        vaiDepositar(cliente, conta);
                        break;
                    case 7:
                        System.out.println("Voltar para menu principal.");
                        break;
                    default:
                        System.out.println("Escolha uma opção Válida!");
                        break;
                }
            }
        } while (menu != 6);
    }

  
    

}
