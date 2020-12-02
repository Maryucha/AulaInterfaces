package br.com.mariani.interfaces;

/**
 *
 * @author maryucha
 */
public interface IAutenticavel {
     public void setSenha(String senha);
    
    public boolean autentica(String senha);
}
