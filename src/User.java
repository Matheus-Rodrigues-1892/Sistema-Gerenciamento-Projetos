
import java.util.ArrayList;
import java.util.Scanner;

public class User {

    private String usuario;
    private String tipo;
    Scanner input = new Scanner(System.in);

    ArrayList<User> listUsuarios = new ArrayList<>();

    public User() {
    }

    public User(String usuario, String tipo) {
        this.usuario = usuario;
        this.tipo = tipo;
    }

    public void addUsers() {

        int opcao;

        System.out.println("Digite o nome do usuário: ");
        input = new Scanner(System.in);
        usuario = input.nextLine();

        System.out.println("--------------------TIPOS DE USUÁRIOS--------------------");
        System.out.println("\t1 - Aluno de Graduação");
        System.out.println("\t2 - Aluno de Mestrado");
        System.out.println("\t3 - Aluno de Doutorado");
        System.out.println("\t4 - Professor");
        System.out.println("\t5 - Pesquisador");
        System.out.println("\t6 - Profissional");
        System.out.println("\t7 - Técnico");
        System.out.println("--------------------------------------------------");

        System.out.println("Insira o tipo que será adicionado: ");
        opcao = input.nextInt();
        
        if (opcao == 1) {
            User user = new User(usuario, "Graduando");

            listUsuarios.add(user);
            setTipo("Graduando");

        } else if (opcao == 2) {
            
            User user = new User(usuario, "Mestrando");
            listUsuarios.add(user);
            setTipo("Mestrando");
        }
        else if (opcao == 3) {
            
            User user = new User(usuario, "Doutorando");
            listUsuarios.add(user);
            setTipo("Doutorando");
        } else if (opcao == 4) {
            
            User user = new User(usuario, "Professor");
            listUsuarios.add(user);
            setTipo("Professor");
        } else if (opcao == 5) {
            
            User user = new User(usuario, "Pesquisador");
            listUsuarios.add(user);
        } else if (opcao == 6) {
            
            System.out.println("\nQual tipo de profissional?");
                System.out.println("\t1 - Desenvolvedor");
                System.out.println("\t2 - Testador");
                System.out.println("\t3 - Analista");
                opcao = input.nextInt();

                if (opcao == 1) {
                    User user = new User(usuario,"Desenvolvedor");
                    listUsuarios.add(user);
                    setTipo("Desenvolvedor");
                } else if (opcao == 2) {
                    User user = new User (usuario, "Testador");
                    listUsuarios.add(user);
                    setTipo("Testador");
                } else if (opcao == 3) {
                    User user = new User(usuario, "Analista");
                    listUsuarios.add(user);
                    setTipo("Analista");
                }
        } else if (opcao == 7) {
            
            User user = new User(usuario, "Técnico");
            listUsuarios.add(user);
            setTipo("Técnico");
        } 

    }

    public void mostrarUsers() {

        for (int i = 0; i < listUsuarios.size(); i++) {
            System.out.println(listUsuarios.get(i).usuario + " | " + listUsuarios.get(i).tipo);
        }


    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
