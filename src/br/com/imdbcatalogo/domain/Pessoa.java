package domain;

public abstract class Pessoa {
    private Long id;
    private String nome;
    private String dataNascimento;
    private String nacionalidade;
    private String email;
    private String telefone;

    //Construtor
    public Pessoa(String nome, String dataNascimento , String nacionalidade, String email, String telefone) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.telefone = telefone;
    }

    //Construtor Vazio
    public Pessoa(){}

    //Getters & Setters
    public Long getId(){
        return id;
    }
    public void setId(String id){
        this.id=this.id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String  getNacionalidade(){
        return nacionalidade;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}