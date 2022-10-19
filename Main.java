
import java.util.Scanner;

public class Main extends MenuPrincipal{
    
    Scanner input = new Scanner(System.in);
    public static void main(String[] args)  {
        
        
        System.out.println("=================================================");
        System.out.println("\tBem-vindo ao Sistema de Gerenciamento de Projetos");

        //login();
        System.out.println("Selecione uma das opções abaixo:\n");
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.menu();


    }
    
    public void login() {
        
        String usuarioNome;
        int senha;
        String opcao;
        int novaSenha = 123;
        Boolean cond = true;
        
        while (cond) {

            input = new Scanner(System.in);
            System.out.println("Faça o login:");
            
            System.out.println("Digite o nome do usuário:");
            usuarioNome = input.nextLine();

    
            System.out.println("Senha: ");
            senha = input.nextInt();
    
            if (usuarioNome.equals("admin") && senha == novaSenha) {
                System.out.println("Login realizado com sucesso!\n");
                cond = false;
            } else {
                input = new Scanner(System.in);
                System.out.println("Nome de usuário ou senha incorretos\nEsqueceu a senha?(S/N)");
                opcao = input.nextLine();
    
                if(opcao.equals("S")) {
                    System.out.println("Digite a nova senha:");
                    novaSenha = input.nextInt();
                    senha = novaSenha;
                }
    
            }
        }

    }
}
    
    

