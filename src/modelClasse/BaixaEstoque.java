
package modelClasse;


public class BaixaEstoque {
    
   
    
    private int codigo;
    private int quantidade;

  
    
    public BaixaEstoque() {
    }

   
    
    public BaixaEstoque(int codigo, int quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

 
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
