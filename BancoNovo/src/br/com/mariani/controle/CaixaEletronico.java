package br.com.mariani.controle;

import br.com.mariani.modelos.Cliente;
import br.com.mariani.modelos.Conta;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                        transferencia(agencia.bucarCliente());
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
}
