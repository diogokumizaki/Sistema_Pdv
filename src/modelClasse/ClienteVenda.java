
package modelClasse;


public class ClienteVenda {
    
  
    
    private int codigo_cliente;
    private String nome;
    private double valor;
    private String forma_pagamento;
    private String data_compra;
    

    
    public ClienteVenda(){
    
    }

    
    
    public ClienteVenda(int codigo_cliente, String nome, double valor, String forma_pagamento, String data_compra) {
        this.codigo_cliente = codigo_cliente;
        this.nome = nome;
        this.valor = valor;
        this.forma_pagamento = forma_pagamento;
        this.data_compra = data_compra;
    }


    
    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public String getData_compra() {
        return data_compra;
    }

    public void setData_compra(String data_compra) {
        this.data_compra = data_compra;
    }
    
    
    
}
