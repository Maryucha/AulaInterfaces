package br.com.mariani.controle;

import br.com.mariani.modelo.Cliente;
import br.com.mariani.modelo.Conta;
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
    private List<Conta> listaContas= new ArrayList<>();
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
    
    public void mostrarContaCliente(){
        System.out.println("------------CONTA DO CLIENTE----------");
        System.out.print("Digite o nome do Cliente: ");
        String nome = entrada.nextLine();
        for (int i = 0; i < listaClientes.size(); i++) {
            if (nome.equalsIgnoreCase(listaClientes.get(i).getNome())) {
                listaClientes.listIterator(i).next().getListaContas().listIterator().next().imprimeConta();
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

    public void agenciaBancaria() {
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
                        cliente.cadConta();
                        break;
                    case 4:
                        mostrarContaCliente();
                        break;
                    case 5:
                        desvincularCliente();
                        break;    
                    case 6:
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
