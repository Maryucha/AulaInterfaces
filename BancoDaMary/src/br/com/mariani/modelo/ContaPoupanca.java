package br.com.mariani.modelo;

/**
 *
 * @author maryucha
 */
public class ContaPoupanca extends Conta {

    @Override
    public void sacar(double valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void depositar(double valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transfetir(Cliente destino, double valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
//     public Conta pegarConta() {
//        System.out.println("Qual a conta deseja: ");
//        String tipoConta = entrada.nextLine();
//        for (int i = 0; i < listaContas.size(); i++) {
//            if (tipoConta.equalsIgnoreCase(listaContas.get(i).getTipoConta())){
//               return listaContas.get(i);  
//            }else{
//                System.out.println("Conta não registrada!");
//               
//            }
//        }
//       return null; 
//    } 

    
}
