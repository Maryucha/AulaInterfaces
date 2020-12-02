package br.com.mariani.controle;


import br.com.mariani.modelo.Cliente;
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
    private Integer menu = 0;
    private List<Cliente> listaClientes = new ArrayList<>();

//    public void loginCaixa() {
//        String nome = "";
//        String senha = "";
//        boolean teste = false;
//
//        System.out.println("-------------------ACESSO-----------------");
//        System.out.print("Digite seu nome: ");
//        nome = entrada.nextLine();
//        System.out.print("Digite sua senha: ");
//        senha = entrada.nextLine();
//        do {
//             System.out.println("entrou no do");
//            for (int i = 0; i < listaClientes.size(); i++) {
//                System.out.println("entrou no for");
//                if (nome.equalsIgnoreCase(listaClientes.get(i).getNome())) {
//                    if (listaClientes.get(i).autentica(senha) == true) {
//                        System.out.println("BEM VINDO AO BANCO DA UXA!");
//                        menuCaixa();
//                        teste = true;
//                    } else {
//                        System.out.println("Senha Incorreta!");
//                    }
//                } else {
//                    System.out.println("Cliente não cadastrado!");
//                }
//            }
//
//        } while (teste != true);
//    }

    public void menuCaixa() {
        do {
            try {
                System.out.println("-------------TERMINAL ELETRÔNICO------------"
                        + "\n1 Extrato: "
                        + "\n2 Sacar: "
                        + "\n3 Depositar: "
                        + "\n4 Transferir: "
                        + "\n5 Voltar: "
                        + "\n-------------------------------------------------------\n");
                menu = entrada.nextInt();
                entrada.nextLine();
            } catch (HeadlessException | NumberFormatException e) {
                menu = null;
            }
            if (menu != null) {
                switch (menu) {
                    case 1:
                       
                        break;
                    case 2:
                        
                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:
                        System.out.println("Voltar para menu principal.");
                        break;
                    default:
                        System.out.println("Escolha uma opção Válida!");
                        break;
                }
            }
        } while (menu != 5);
    }
}
