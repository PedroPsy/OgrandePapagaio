import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @org.junit.jupiter.api.Test
    void seguir() {
        Usuario user = new Usuario("Pedro");
        assertEquals(0, user.getUsuarioSeguidos().size());

        Usuario userTeste= new Usuario("Joao");
        user.seguir(userTeste);
        assertEquals(1, user.getUsuarioSeguidos().size());

        assertEquals(0, userTeste.getUsuarioSeguidos().size());
        userTeste.seguir(user);
        assertEquals(1, userTeste.getUsuarioSeguidos().size());

    }

    @org.junit.jupiter.api.Test
    void postar() {
        Usuario user = new Usuario("Pedro");
        assertEquals(0,user.getListaDePosts().size());


        user.postar(user.getNome(), "Olá Mundo!!");
        assertEquals(1,user.getListaDePosts().size());
    }

    @org.junit.jupiter.api.Test
    void leituraMural() {
        Usuario user = new Usuario("Pedro");
        user.postar(user.getNome(), "Olá Mundo!!");
        Usuario userTeste= new Usuario("Joao");
        userTeste.postar(userTeste.getNome(), "Java é legal demais !!");
        user.seguir(userTeste);
        user.leituraMural();
    }

    @org.junit.jupiter.api.Test
    void verPosts() {
        Usuario user = new Usuario("Pedro");
        user.postar(user.getNome(), "Olá Mundo!!");
        user.postar(user.getNome(), "Java é legal !!");
        assertEquals(2, user.getListaDePosts().size());
        user.verPosts();
    }

    @org.junit.jupiter.api.Test
     void getNome() {
        Usuario user = new Usuario("Pedro");
        assertEquals("Pedro", user.getNome());

        Usuario userTeste= new Usuario("Joao");
        assertEquals("Joao", userTeste.getNome());

    }
}