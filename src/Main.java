
import java.util.Scanner;

public class Main {
    
    static Scanner input = new Scanner(System.in);
    
    
    public static void main(String[] args)  {
        
        
        System.out.println("=================================================");
        System.out.println("\tBem-vindo ao Sistema de Gerenciamento de Projetos");

        login();
        System.out.println("Selecione uma das opções abaixo:\n");
        menu();


    }
    
    public static void login() {
        
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
    
    public static void menu() {
        
        Boolean condicao = true;
        User user = new User();
        Project project = new Project();
        Activities activities = new Activities();
        
        while (condicao) {
            
            
            System.out.println("=============================MENU===============================");
            System.out.println("\t0 - Sair");
            System.out.println ("\t1 - Adicionar usuários");
            System.out.println("\t2 - Remover usuários");
            System.out.println("\t3 - Editar um usuário");
            System.out.println("\t4 - Criar um projeto");
            System.out.println("\t5 - Remover um projeto");
            System.out.println("\t6 - Editar um projeto");
            System.out.println("\t7 - Consultas");
            System.out.println("\t8 - Relatório de atividades e projetos");
            System.out.println("===============================================================");

            
            int opcao = input.nextInt();

            if (opcao == 0) {
                System.out.println("=================================\n\tObrigado por usar o sistema!");
                condicao = false;
                break;

            } else if (opcao == 1){
                user.addUsers();
                System.out.println("Usuário adicionado com sucesso!\n");

            } else if (opcao == 2) {

                String nome = user.usuarioNome();
                String cpf = user.usuarioCpf();
                user.removeUsers(nome, cpf);
        
            } else if (opcao == 3) {

                String nome = user.usuarioNome();
                String cpf = user.usuarioCpf();
                user.editUsers(nome, cpf);

            } else if (opcao == 4 ){

                System.out.println("Projetos só podem ser criados por um pesquisador ou um professor");
                System.out.println("Estes são os disponíveis: \n");
                user.mostrarAllUsersCoordenators();

                String nome = user.usuarioNome();
                //String cpf = user.usuarioCpf();
                
                project.createProject(nome);
                System.out.println("Projeto adicionado com sucesso!\n");
    
            } else if (opcao == 5) {

                int idProjeto = project.projectIdProjeto();
                project.removeProject(idProjeto);
                System.out.println("Projeto removido com sucesso!");
        
            } else if (opcao == 6) {

                project.editProject();
                System.out.println("Projeto editado com sucesso");

            } else if (opcao == 7) {
                int idProjeto = project.projectIdProjeto();
                activities.createActivities(idProjeto);
                System.out.println("Atividade criada com sucesso!");

            }  else if (opcao == 7) {

                System.out.println("\t1 - Consulta por usuário");
                System.out.println("\t2 - Consulta por projeto");
                System.out.println("\t3 - Consulta por atividade");

                opcao = input.nextInt();

                if (opcao == 1) {

                    user.mostrarAllUsers();
                } else if (opcao == 2) {

                    project.mostrarProjetos();
                } else if (opcao == 3) {

                    int idAtividade = activities.activitiesIdAtividade();
                    int idProjeto = project.projectIdProjeto();
                    activities.mostrarAtividades(idProjeto, idAtividade);

                }
                
            } else if (opcao == 8) {

                
            } 
        }
    }
    
}

