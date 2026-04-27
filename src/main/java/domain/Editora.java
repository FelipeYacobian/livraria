package domain;

public class Editora {
    private Long id;
    private String CNPJ;
    private String nome;

    public Editora(Long id) { this.id = id; }

    public Editora(String CNPJ, String nome) {
        this.CNPJ = CNPJ;
        this.nome = nome;
    }

    public Editora(Long id, String CNPJ, String nome) {
        this.id = id;
        this.CNPJ = CNPJ;
        this.nome = nome;
    }

    public Long getId() { return id; }
    public String getCNPJ() { return CNPJ; }
    public String getNome() { return nome; }

    public void setId(Long id) { this.id = id; }
    public void setCNPJ(String cnpj) { this.CNPJ = cnpj; }
    public void setNome(String nome) { this.nome = nome; }
}