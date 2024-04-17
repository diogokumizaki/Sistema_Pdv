
package modelClasse;


public class Cliente {
    
   
    private int codigo_cliente;
    private String nome;
    private String sobrenome;
    private String data_nasc;
    private String cpf;
    private String rg;
    private String bairro;
    private String endereco;
    private String numero;
    private String telefone;
    private String data_cadastro;

   
    public Cliente() {
    }


    public Cliente(String nome, String sobrenome, String data_nasc, String rg, String cpf, String bairro, String endereco, String numero, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.data_nasc = data_nasc;
        this.rg = rg;
        this.cpf = cpf;
        this.bairro = bairro;
        this.endereco = endereco;
        this.numero = numero;
        this.telefone = telefone;
    }


    public Cliente(int codigo_cliente, String nome, String sobrenome, String data_nasc, String rg, String cpf, String bairro, String endereco, String numero, String telefone) {
        this.codigo_cliente = codigo_cliente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.data_nasc = data_nasc;
        this.rg = rg;
        this.cpf = cpf;
        this.bairro = bairro;
        this.endereco = endereco;
        this.numero = numero;
        this.telefone = telefone;
    }
    

    public Cliente(int codigo_cliente, String nome, String sobrenome, String data_nasc, String rg, String cpf, String bairro, String endereco, String numero, String telefone, String data_cadastro) {
        this.codigo_cliente = codigo_cliente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.data_nasc = data_nasc;
        this.rg = rg;
        this.cpf = cpf;
        this.bairro = bairro;
        this.endereco = endereco;
        this.numero = numero;
        this.telefone = telefone;
        this.data_cadastro = data_cadastro;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
    
    
    
}
