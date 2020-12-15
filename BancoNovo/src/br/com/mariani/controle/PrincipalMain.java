package br.com.mariani.controle;

/**
 * Essa classe é a main do projeto
 * ela instancia a classe controle que é responsável por todo o código
 * @author maryucha
 */
public class PrincipalMain {
    public static void main(String[] args) throws InterruptedException {
        ControleAgencia agencia =new ControleAgencia();
        agencia.agencia();
    }
}
