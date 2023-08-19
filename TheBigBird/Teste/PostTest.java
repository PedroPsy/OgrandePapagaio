import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @Test
    void postagem() {
        Post post= new Post("Pedro", "Olá Mundo!!");
        assertEquals("Pedro", post.getNome());

        LocalDate data= LocalDate.now();
        assertEquals(data, post.getDataDeCriacao());

        assertEquals("Olá Mundo!!", post.getTexto());
    }

    @Test
    void getDataDeCriacao() {
        Post post= new Post("Pedro", "Olá Mundo!!");
        LocalDate data= LocalDate.now();
        assertEquals(data, post.getDataDeCriacao());
    }

    @Test
    void getNome() {
        Post post= new Post("Pedro", "Olá Mundo!!");
        assertEquals("Pedro", post.getNome());
    }

    @Test
    void getTexto() {
        Post post= new Post("Pedro", "Olá Mundo!!");
        assertEquals("Olá Mundo!!", post.getTexto());
    }
}