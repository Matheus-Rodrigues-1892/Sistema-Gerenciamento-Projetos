
import java.util.ArrayList;
import java.util.Scanner;

public class User extends Info{
    
    protected String nome;
    protected String tipo;
    protected String cpf;
    protected int idProjeto;
    
    protected int idAtividade;
    protected int bolsa;
    protected int prazo;
    Scanner input = new Scanner(System.in);
    
    protected static ArrayList<User> listUsuarios = new ArrayList<>();
    ArrayList<User> listUsuariosProjetos = new ArrayList<>();
    ArrayList<User> listUsuariosAtividades = new ArrayList<>();
    
    public User() {
    } 

    public User(String nome, String cpf, String tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipo = tipo;
    }

    public User(String nome, String tipo, String cpf, int idProjeto, int idAtividade) {
         this.nome = nome;
         this.tipo = tipo;
         this.cpf = cpf;
         this.idProjeto = idProjeto;
         this.idAtividade = idAtividade;
     } 
    
//Adicionar usuários
    protected void adicionarUsers() {

        nome = usuarioNome();
        cpf = usuarioCpf();
        tipo = usuarioTipo();

        if (tipo.equals("Professor")){

            User usuario = new Professores(nome, cpf, tipo);
            listUsuarios.add(usuario);

        } else if(tipo.equals("Pesquisador")){

            User usuario = new Pesquisador(nome, cpf, tipo);
            listUsuarios.add(usuario);

        } else if(tipo.equals("Desenvolvedor") || tipo.equals("Testador") || tipo.equals("Analista")){

            User usuario = new Profissionais(nome, cpf, tipo);
            listUsuarios.add(usuario);

        } else {

            User usuario = new User(nome, cpf, tipo);
            listUsuarios.add(usuario);

        }


    }

    protected void editUsers() {

        nome = usuarioNome();
        cpf = usuarioCpf();
        System.out.println("------- EDITAR INFO USUÁRIO ----------");
        menuUsers();
        int opcao = input.nextInt();

        for (int i = 0; i < listUsuarios.size(); i++) {
            
            if (nome.equals(listUsuarios.get(i).nome) || cpf.equals(listUsuarios.get(i).cpf)) {
                

                if (opcao == 1) {

                    nome = usuarioNome();
                    listUsuarios.get(i).nome = nome;

                } else if (opcao == 2) {

                    cpf = usuarioCpf();
                    listUsuarios.get(i).cpf = cpf;

                } else if (opcao == 3) {

                    tipo = usuarioTipo();
                    listUsuarios.get(i).tipo = tipo;

                    
                }
            } else {

            System.out.println("Usuário não encontrado.");

            }
        }

    }

    protected void removeUser() {

        nome = usuarioNome();
        cpf = usuarioCpf();
        System.out.println("------- REMOVER INFO USUÁRIO ----------");
        menuUsers();
        int opcao = input.nextInt();

        for (int i = 0; i < listUsuarios.size(); i++) {
            
            if (nome.equals(listUsuarios.get(i).nome) && cpf.equals(listUsuarios.get(i).cpf)) {
                
                if (opcao == 1) {

                    listUsuarios.get(i).nome = null;

                } else if (opcao == 2) {

                    listUsuarios.get(i).cpf = null;

                } else if (opcao == 3) {

                    listUsuarios.get(i).tipo = null;

                } else {

                System.out.println("Usuário não encontrado.");

                }
            }
        }

    }

    
    protected String usuarioNome() {

        input = new Scanner(System.in);

        System.out.println("Digite o nome do usuário: ");
        nome = input.nextLine();
        return nome;
    }

    protected String usuarioCpf() {

        input = new Scanner(System.in);

        System.out.println("Digite o CPF do usuário (somente números): ");
        cpf = input.nextLine();

        return cpf;

    }
    
    protected void menuUsers(){

        System.out.println("\t1 - Nome");
        System.out.println("\t2 - Tipo");
        System.out.println("\t3 - CPF");
        System.out.println("\t4 - Bolsa");
        System.out.println("\t5 - Prazo de vigência da bolsa");
    }

    protected void menuUsuarioTipo() {
        System.out.println("--------------------TIPOS DE USUÁRIOS--------------------");
        System.out.println("\t1 - Graduando");
        System.out.println("\t2 - Mestrando");
        System.out.println("\t3 - Doutorando");
        System.out.println("\t4 - Professor");
        System.out.println("\t5 - Pesquisador");
        System.out.println("\t6 - Desenvolvedor");
        System.out.println("\t7 - Analista");
        System.out.println("\t8 - Testador");
        System.out.println("\t9 - Técnico");
        System.out.println("--------------------------------------------------");
    }

    protected String usuarioTipo(){

        System.out.println("Para cadastrar um usuário você informar sua função na universidade:\n");
        menuUsuarioTipo();
        int opcao = input.nextInt();

        if (opcao == 1) {

            return "Graduando";

        } else if (opcao == 2) {
            
            return "Mestrando";
        }
        else if (opcao == 3) {

            return "Doutorando";

        } else if (opcao == 4) {

            return "Professor";
            
        } else if (opcao == 5) {
            
            return "Pesquisador";

        } else if (opcao == 6) {
    
            return "Desenvolvedor";

        } else if (opcao == 7) {

            return "Testador";

        } else if (opcao == 8) {

            return "Analista";

        } else if (opcao == 9) {

            return "Técnico";
            
        }
        return null;

    }

    public User adicionarProfissional(String nomeProfissional, String cpfProfissional, int id) {

        for (int i = 0; i < listUsuarios.size(); i++){

            if (listUsuarios.get(i).nome.equals(nomeProfissional) && listUsuarios.get(i).cpf.equals(cpfProfissional)){

                listUsuarios.get(i).idProjeto = id;

                return listUsuarios.get(i);
            }
        }
        
        System.out.println("Profissional não encontrado");
        return null;
    }

    public void mostrarUsers () {

        for(int i = 0; i < listUsuarios.size(); i++){
            System.out.println("NOME: " + listUsuarios.get(i).nome + " CPF: " + listUsuarios.get(i).cpf + " TIPO: "+ listUsuarios.get(i).tipo);
        }
    }


}
