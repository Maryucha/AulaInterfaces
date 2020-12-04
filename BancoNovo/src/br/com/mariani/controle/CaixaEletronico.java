package br.com.mariani.controle;

import br.com.mariani.modelos.Cliente;
import br.com.mariani.modelos.Conta;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author maryucha
 */
public class CaixaEletronico {

    private Scanner entrada = new Scanner(System.in);
    private ControleAgencia agencia = new ControleAgencia();
    private Integer menu = 0;

    public void terminalEletronico() {
        do {
            try {
                System.out.println("--------------AGENCIA BANCÁRIA------------"
                        + "\n1 SACAR: "
                        + "\n2 DEPOSITAR: "
                        + "\n3 TRANSFERIR: "
                        + "\n4 Voltar: "
                        + "\n------------------------------------------------------\n");
                menu = entrada.nextInt();
                entrada.nextLine();
            } catch (HeadlessException | NumberFormatException e) {
                menu = null;
            }
            if (menu != null) {
                switch (menu) {
                    case 1:
                        sacar(agencia.bucarCliente());
                        break;
                    case 2:
                        deposito(agencia.bucarCliente());
                        break;
                    case 3:
                        transferencia();
                        break;
                    case 4:
                        System.out.println("Voltar para agência!");
                    default:
                        System.out.println("Escolha uma opção válida!");
                        break;
                }
            }
        } while (menu != 4);
    }

    public void deposito(Cliente cliente) {
        System.out.println("-----------DEPOSITAR-----------");
        Conta conta = cliente.buscaConta();
        System.out.print("Digite o valor que deseja depositar: ");
        conta.depositar(entrada.nextDouble());
        System.out.println("Depósito realizado com sucesso!");

    }

    public void transferencia() {
        System.out.println("--------------TRANSFERIR-----------------");
        System.out.println("CONTA DE ORIGEM: ");
        Cliente clienteOrigem=agencia.bucarCliente();
        Conta contaOrigem = clienteOrigem.buscaConta();
        System.out.println("CONTA DE DESTINO: ");
        Cliente clienteDestino=agencia.bucarCliente();
        Conta contaDestino = clienteDestino.buscaConta();
        
        System.out.print("Digite o valor que deseja Transferir ");
        double valor = entrada.nextDouble();
        contaDestino.transfetir(clienteDestino, clienteOrigem, valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);
        contaOrigem.setSaldo(contaOrigem.getSaldo()-valor); 
        System.out.println("Transferência realizada com sucesso!");

    }

    private void sacar(Cliente cliente) {
        System.out.println("-------------SACAR-------------------");
        Conta conta = cliente.buscaConta();
        System.out.print("Digite o valor que deseja Sacar ");
        conta.sacar(entrada.nextDouble());
        entrada.nextLine();
    }
    public Conta entraNaConta(Cliente cliente){
        System.out.println("--------------SUA CONTA--------------");
        Conta conta=cliente.buscaConta();
        return conta;
    }
}
