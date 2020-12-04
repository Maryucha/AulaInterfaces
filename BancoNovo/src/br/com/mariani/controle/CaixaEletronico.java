package br.com.mariani.controle;

import br.com.mariani.modelos.Cliente;
import br.com.mariani.modelos.Conta;
import java.awt.HeadlessException;
import java.util.Scanner;

/**
 * Essa classe representa o Caixa eletronico e suas funções ela trabalha em
 * conjunto com a classe Controle da agência
 *
 * @author maryucha
 */
public class CaixaEletronico {

    private Scanner entrada = new Scanner(System.in);
    private ControleAgencia agencia = new ControleAgencia();
    private Integer menu = 0;

    /**
     * Esse método é o menu do caixa eletrônico
     */
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

    /**
     * Esse método deposita um valor na conta do cliente que foi buscado;
     *
     * @param cliente
     */
    public void deposito(Cliente cliente) {
        System.out.println("-----------DEPOSITAR-----------");
        Conta conta = cliente.buscaConta();
        System.out.print("Digite o valor que deseja depositar: ");
        conta.depositar(entrada.nextDouble());
        System.out.println("Depósito realizado com sucesso!");

    }

    /**
     * Esse método busca um cliente de Origem e sua conta de Origem depois busca
     * o cliente de destino e a sua conta de destino depois ele adiciona o valor
     * a conta de origem e subtrai a taxa mais o valor da conta destino
     */
    public void transferencia() {
        System.out.println("--------------TRANSFERIR-----------------");
        System.out.println("CONTA DE ORIGEM: ");
        Cliente clienteOrigem = agencia.bucarCliente();
        Conta contaOrigem = clienteOrigem.buscaConta();
        System.out.println("CONTA DE DESTINO: ");
        Cliente clienteDestino = agencia.bucarCliente();
        Conta contaDestino = clienteDestino.buscaConta();

        System.out.print("Digite o valor que deseja Transferir ");
        double valor = entrada.nextDouble();
        contaDestino.transfetir(clienteDestino, clienteOrigem, valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);
        contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
        System.out.println("Transferência realizada com sucesso!");

    }

    /**
     * Esse método realiza a busca da conta do cliente e subtrai um valor da
     * conta atualizando o saldo
     *
     * @param cliente
     */
    private void sacar(Cliente cliente) {
        System.out.println("-------------SACAR-------------------");
        Conta conta = cliente.buscaConta();
        System.out.print("Digite o valor que deseja Sacar ");
        conta.sacar(entrada.nextDouble());
        entrada.nextLine();
    }
}
