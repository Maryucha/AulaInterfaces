package br.com.mariani.modelo;

/**
 *
 * @author maryucha
 */
public abstract class FormasGeometricas {
        
    private String forma;

    public FormasGeometricas(String forma) {
        this.forma = forma;
    }
    
    public abstract String getForma();

    public abstract void setForma(String forma);
    
    
}
