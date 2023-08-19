import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        GrandePapagaio usuarioPapagaio= new GrandePapagaio();


        final int menuPrincipal=0;
        final int seguir=3;
        final int menuInicial= 4;
        final int sair=5;
        //Algumas opcoes do programa para facilitar o manuseio

        Usuario userPrincipal= null;
        //váriavel que será utilizada para iniciar o programa, logo ela será atribuida a um valor de Usuário que existe e deixará de ser null

        int opcao= menuInicial;  // opcao da rede social inicia no menuinicial
        System.out.println("-------- O GrandePapagaio ----------");

        while(opcao != sair){
            while (opcao== menuInicial) {
                try {
                    //do {
                        System.out.println("1. Criar um usuário\n2. Entrar com um usuário\n5. Sair");
                        opcao = leitor.nextInt();
                        leitor.nextLine();
                    //}while(opcao<0 || opcao>sair);
                }
                catch (InputMismatchException error) {
                    System.out.println(error.getMessage());
                    opcao= sair;// Se entrar na exceçao encerra o programa
                }

                //Se o usuário criar um novo usuário cairá no case 1: e irá criar um novo user que será atribuido a variável userPrincipal

                switch (opcao) {
                    case 1:
                        //Criar um novo usuário
                        // userPrincipal recebe usuario novo para operar na Rede social
                        userPrincipal = usuarioPapagaio.criarUsuario();
                        break;

                    case 2:
                        //Procura um usuário existente
                        System.out.println("Digite seu nome de usuário: ");
                        String nome= leitor.nextLine();
                        try{
                            userPrincipal = usuarioPapagaio.encontrarUsuario(nome);
                            if(userPrincipal== null) {
                                opcao = menuInicial;//
                                System.out.println("Usuário não existe ");
                            }
                            else
                                opcao= menuPrincipal;
                        }
                        catch(NullPointerException naoexiste){
                            System.out.println(naoexiste.getMessage());
                            opcao= sair;
                            // SE CAIR NA EXCEÇÃO ELE ENCERRA O PROGRAMA
                        }
                        break;
                }
            }
            //Inicio do menu principal com as opcoes disponiveis
            try {
                do {
                    // Tratamento de erro simples para o uso da rede social
                    System.out.println("1. Postar\n2. Leitura\n3. Seguir\n4. Menu Inical\n5. Sair");
                    opcao = leitor.nextInt();
                    leitor.nextLine();
                } while(opcao<=0 || opcao>5);
            }
            catch(InputMismatchException erroDadoInvalido){
                System.out.println(erroDadoInvalido.getMessage());
                // se cair na EXCEPTION de InputMismatchException o programa fecha
                opcao= sair;
            }


            switch (opcao){
                case 1:
                    // fazer um novo post
                    usuarioPapagaio.fazerPost(userPrincipal);
                    break;

                case 2:
                    // ler o mural
                    usuarioPapagaio.mural(userPrincipal);
                    break;

                case seguir:
                    // seguir um usuário
                    usuarioPapagaio.seguirUsuario(userPrincipal);

                    break;
            }
        }
        //Fim do programa
        System.out.println("******** FIM DO PROGRAMA ********");
        leitor.close();
    }
}