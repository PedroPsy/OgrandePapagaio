import java.util.*;

public class Usuario {
    private String nome;
    private final ArrayList<Post> listaDePosts= new ArrayList<>();
    private final ArrayList<Usuario> usuarioSeguidos= new ArrayList<>();

    public Usuario(String nome){
        this.nome= nome;
        //listaDeUsuarios.add();
    }

    public ArrayList<Post> getListaDePosts(){
        return listaDePosts;
    }

    public void seguir(Usuario usuarioSeguir){
        if(usuarioSeguidos.contains(usuarioSeguir))
            System.out.println("Você já segue este usuário");
        usuarioSeguidos.add(usuarioSeguir);
        System.out.println(getNome()+ " segue "+ usuarioSeguir.getNome());
    }
    public void postar(String nome, String texto){
        Post post = new Post(nome, texto);
        post.postagem();
        listaDePosts.add(post);
        System.out.println("Post realizado com sucesso no mural de "+ nome);
    }

    public ArrayList<Usuario> getUsuarioSeguidos() {
        return usuarioSeguidos;
    }

    public void leituraMural(){
        verPosts();
        for(Usuario x: usuarioSeguidos) {
            x.verPosts();
        }
    }
    public void verPosts(){
        for(Post posts: listaDePosts){
            posts.postagem();
        }
    }

    public String getNome() {
        return nome;
    }
}
