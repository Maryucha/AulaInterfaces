/*
 * Nesse exercício vamos criar um sisteminha básico de calculadora. Para isso,
 *   criaremos uma interface chamada 

IOperacaoMatematica que irá definir um
 *   método chamado calcula(double valorUm, doublevalorDois). Depois disso
 *   crie classes para as seguintes operações: 
Soma, 
Subtração. 
Multiplicação.
Divisão 
Exponenciação. 
    Todas essas classes devem implementar a
 *   interface IOperacaoMatematica e o método calcula(). Além disso, crie um
 *   segunda 
interface chamada IImprimir que definir um método
 *   mostrarValor(double valor). As classes também devem implementar essa
 *   classe e o método dela.
 */
package br.com.mariani.interfaces;

/**
 *
 * @author maryucha
 */
public interface IImprimir {

    public void mostrarValor();
}
