
package modelClasse;


public class Venda {
    
   
    private int codigo_venda;
    private String data_venda;
    private double valor;
    private String tipo_pagamento;
    private int codigo_cliente;

   
    public Venda() {
    }

    
    public Venda(double valor, String tipo_pagamento) {
        this.valor = valor;
        this.tipo_pagamento = tipo_pagamento;
    }

 
    public Venda(int codigo_venda, String data_venda, double valor, String tipo_pagamento) {
        this.codigo_venda = codigo_venda;
        this.data_venda = data_venda;
        this.valor = valor;
        this.tipo_pagamento = tipo_pagamento;
    }

  
    public Venda(int codigo_venda, String data_venda, double valor, String tipo_pagamento, int codigo_cliente) {
        this.codigo_venda = codigo_venda;
        this.data_venda = data_venda;
        this.valor = valor;
        this.tipo_pagamento = tipo_pagamento;
        this.codigo_cliente = codigo_cliente;
    }
    
 
    public int getCodigo_venda() {
        return codigo_venda;
    }

    public void setCodigo_venda(int codigo_venda) {
        this.codigo_venda = codigo_venda;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo_pagamento() {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(String tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    
    
    
}
