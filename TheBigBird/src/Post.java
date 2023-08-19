import java.time.LocalDate;

public class Post {
    private LocalDate dataDeCriacao;
    private final String texto;
    private final String nome;

    public Post(String nome, String texto){
        this.nome= nome;
        this.texto= texto;
        dataDeCriacao= LocalDate.now();

    }

    public void postagem(){
        System.out.println("> "+getNome()+ " -> "+ getTexto()+ "  data: "+ getDataDeCriacao());
    }

    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }

    public String getNome() {
        return nome;
    }

    public String getTexto() {
        return texto;
    }
}
