package domain;

public class Livro {
    private Long id;
    private String titulo;
    private String autor;
    private Integer ano;
    private Float preco;
    private Editora editora;

    public Livro(Long id) { this.id = id; }

    public Livro(String t, String a, Integer ano, Float p, Editora e) {
        this.titulo = t;
        this.autor = a;
        this.ano = ano;
        this.preco = p;
        this.editora = e;
    }

    public Livro(Long id, String t, String a, Integer ano, Float p, Editora e) {
        this(t,a,ano,p,e);
        this.id = id;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public Integer getAno() { return ano; }
    public Float getPreco() { return preco; }
    public Editora getEditora() { return editora; }

    public void setId(Long id) { this.id = id; }
}