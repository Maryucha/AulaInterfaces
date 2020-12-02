package br.com.mariani.controle;

import br.com.mariani.modelo.Divisao;
import br.com.mariani.modelo.Exponenciacao;
import br.com.mariani.modelo.Multiplicacao;
import br.com.mariani.modelo.Soma;
import br.com.mariani.modelo.Subtracao;
import java.awt.HeadlessException;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class ControleCalculadora {

    private Soma sm = new Soma();
    private Subtracao sb = new Subtracao();
    private Divisao dv = new Divisao();
    private Multiplicacao mt = new Multiplicacao();
    private Exponenciacao ex = new Exponenciacao();
    private Scanner entrada = new Scanner(System.in);

    public void executar() {
        Integer menu = 0;
        do {
            try {
                System.out.println("==========MENU CALCULADORA========"
                        + "\n1 SOMA: "
                        + "\n2 SUBTRAÇÃO: "
                        + "\n3 MULTIPLICAÇÃO: "
                        + "\n4 DIVISÃO: "
                        + "\n5 EXPONÊNCIAÇÃO: "
                        + "\n6 SAIR: "
                        + "\n===================================");
                menu = entrada.nextInt();
                entrada.nextLine();
            } catch (HeadlessException | NumberFormatException e) {
                menu = null;
            }
            if (menu != null) {
                switch (menu) {
                    case 1:
                        sm.calcular();
                        sm.mostrarValor();
                        break;
                    case 2:
                        sb.calcular();
                        sb.mostrarValor();
                        break;
                    case 3:
                        mt.calcular();
                        mt.mostrarValor();
                        break;
                    case 4:
                        dv.calcular();
                        dv.mostrarValor();

                        break;
                    case 5:
                        ex.calcular();
                        ex.mostrarValor();
                        break;
                    case 6:
                        System.out.println("Até mais!");
                        break;
                    default:
                        System.out.println("Escolha uma opção válida!");
                        break;
                }
            }

        } while (menu != 6);
    }

}
