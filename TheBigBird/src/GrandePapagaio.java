import java.util.ArrayList;
import java.util.Scanner;

public class GrandePapagaio {
    ArrayList<Usuario> listaDeUsuarios= new ArrayList<>();
    Scanner leitor= new Scanner(System.in);
    public Usuario criarUsuario() {
        // cria um novo usuario para o programa
        System.out.println("Digite um novo nome de usuário: ");
        String nome= leitor.nextLine();
        Usuario usuario = new Usuario(nome);
        listaDeUsuarios.add(usuario);
        System.out.println("Bem-Vindo(a) "+nome);
        return usuario;
    }
    public Usuario encontrarUsuario(String nome){
        for(Usuario usuarioEncontrar: listaDeUsuarios){
            if(nome.equals(usuarioEncontrar.getNome()))
                return usuarioEncontrar;

        }
        return null;
    }

    public void fazerPost(Usuario user){
        System.out.println("Digite seu post: ");
        String texto= leitor.nextLine();
        user.postar(user.getNome(),texto);
    }
    public void mural(Usuario user){
         user.leituraMural();
    }
    public void seguirUsuario(Usuario user){
        System.out.println("Digite o nome do usuário que deseja seguir: ");
        String nome= leitor.nextLine();
        try{
            Usuario usuarioSeguir= encontrarUsuario(nome);
            if(listaDeUsuarios.contains(usuarioSeguir))
                user.seguir(usuarioSeguir);
            else
               System.out.println("Usuário não encontrado");

        }
        catch( NullPointerException naoexiste){
            System.out.println("Usuario nao existe");
        }
    }
}
