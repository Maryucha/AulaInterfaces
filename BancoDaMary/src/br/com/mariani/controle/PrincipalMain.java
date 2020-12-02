package br.com.mariani.controle;

import java.awt.HeadlessException;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class PrincipalMain {

    public static void main(String[] args) {
        ControleContas banco = new ControleContas();
        CaixaEletronico caixa = new CaixaEletronico();
        Scanner entrada = new Scanner(System.in);
        
        Integer menu = 0;
        do {
            try {
                System.out.println("-------------AGENCIA BANCÁRIA------------"
                        + "\n1 Atendimento: "
                        + "\n2 Caixa Eletrônico: "
                        + "\n3 Sair: "
                        + "\n-------------------------------------------------------\n");
                menu = entrada.nextInt();
                entrada.nextLine();
            } catch (HeadlessException | NumberFormatException e) {
                menu = null;
            }
            if (menu != null) {
                switch (menu) {
                    case 1:
                        banco.gerencia();
                        break;
                    case 2:
                        caixa.menuCaixa();
                        break;
                    case 3:
                        System.out.println("Volte Sempre!");
                        break;
                    default:
                        System.out.println("Escolha uma opção Válida!");
                        break;
                }
            }
        } while (menu != 3);
    }
}
