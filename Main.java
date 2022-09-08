
import java.util.Scanner;

public class Main {
   
    private static int idProjeto;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Projetos");
        System.out.println("Selecione uma das opções abaixo");
        menu();


    }

    /**
     * 
     */
    public static void menu() {

        Boolean condicao = true;
        int opcao;
        User user = new User();
        Project project = new Project ();
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
            System.out.println("\t7 - Criar uma atividade");
            System.out.println("\t8 - Remover uma atividade");
            System.out.println("\t9 - Editar uma atividade");
            System.out.println("\t10 - Associar projetos à atividades vice-versa");
            System.out.println("\t11 - Relatório de atividades e projetos");
            System.out.println("===============================================================");


            
            opcao = input.nextInt();
            if (opcao == 0) {
                condicao = false;
                break;
            } else if (opcao == 1){
                user.addUsers();
                System.out.println("Usuário adicionado com sucesso!\n");
                //user.mostrarUsers();
            } else if (opcao == 4 ){

                idProjeto = project.createProject();
                
                System.out.println("Projeto adicionado com sucesso!\n");
    

            } else if (opcao == 11) {
                user.mostrarUsers();
                project.mostrarProjetos();
                activities.mostrarAtividades(idProjeto);
            }


        }
    }
}

