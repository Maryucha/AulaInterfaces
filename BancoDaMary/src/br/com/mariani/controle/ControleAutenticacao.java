package br.com.mariani.controle;

import br.com.mariani.interfaces.IAutenticavel;

/**
 *
 * @author maryucha
 */
public class ControleAutenticacao {
    private String senha;

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean autentica(String senha) {
        if (senha == this.senha) {
            System.out.println("Acesso liberado!");
            return true;
        }
        System.out.println("Acesso negado!");
        return false;
    }
    
    
    public boolean autentica(IAutenticavel a) {
        boolean autenticou = a.autentica(this.senha);
        if (autenticou) {
            return true;
        } else {
            return false;
        }
    }
}
