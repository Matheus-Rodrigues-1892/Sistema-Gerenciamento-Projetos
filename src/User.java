
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    
    private String usuario;
    private String tipo;
    private String cpf;
    private int idProjeto;
    private int idAtividade;
    private int bolsa;
    private int prazo;
    Scanner input = new Scanner(System.in);
    
    ArrayList<User> listUsuarios = new ArrayList<>();
    ArrayList<User> listUsuariosProjetos = new ArrayList<>();
    ArrayList<User> listUsuariosAtividades = new ArrayList<>();
    
    public User() {
    } 
     public User(String usuario, String tipo, String cpf,int bolsa, int prazo, int idProjeto) {
         this.usuario = usuario;
         this.tipo = tipo;
         this.cpf = cpf;
         this.idProjeto = idProjeto;
         this.bolsa = bolsa;
         this.prazo = prazo;
     }

    public User(String usuario, String tipo, String cpf, int idProjeto, int idAtividade) {
         this.usuario = usuario;
         this.tipo = tipo;
         this.cpf = cpf;
         this.idProjeto = idProjeto;
         this.idAtividade = idAtividade;
     } 
    

    public void addUsers() {

        usuario = usuarioNome();

        cpf = usuarioCpf();

        tipo = usuarioTipo(usuario, cpf);

        User user = new User(usuario, tipo, cpf, 00000, 00000, 00000);

        listUsuarios.add(user);

    }

    public String fornecerTiposUsers (String nome, String cpf){
        for (int i = 0; i < listUsuarios.size(); i++){

            if (nome.equals(listUsuarios.get(i).usuario) && cpf.equals(listUsuarios.get(i).cpf)) {

                return listUsuarios.get(i).tipo;
            } else {
                System.out.println("Usuário inválido");
            }
        }
        return null;
    }

    public String fornecerUsers (String nome, String cpf){
        for (int i = 0; i < listUsuarios.size(); i++){

            if (nome.equals(listUsuarios.get(i).usuario) && cpf.equals(listUsuarios.get(i).cpf)) {

                return listUsuarios.get(i).tipo;
            } else {
                System.out.println("Usuário inválido");
            }
        }
        return null;
    }

    public void removeUsers(String nome, String cpf) {
        for (int i = 0; i < listUsuarios.size(); i++) {
            
            if (nome.equals(listUsuarios.get(i).usuario) && cpf.equals(listUsuarios.get(i).cpf)) {
                
                mostrarUsers(nome, cpf);
                System.out.println("Qual informação será removida?");
                System.out.println("\t1 - Nome");
                System.out.println("\t2 - Tipo");
                System.out.println("\t3 - CPF");
                System.out.println("\t4 - Valor da bolsa");
                System.out.println("\t5 - Prazo de vigência da bolsa");
                System.out.println("");

                int opcao = input.nextInt();

                if (opcao == 1) {

                    listUsuarios.get(i).usuario = null;

                } else if (opcao == 2) {

                    listUsuarios.get(i).cpf = null;

                } else if (opcao == 3) {

                    
                    listUsuarios.get(i).tipo = null;

                } 
                
            } else {
                System.out.println("Usuário não encontrado.");
                
            }
        }
    }

    public void editUsers(String nome, String cpf) {

        for (int i = 0; i < listUsuarios.size(); i++) {
            
            if (nome.equals(listUsuarios.get(i).usuario) && cpf.equals(listUsuarios.get(i).cpf)) {
                
                System.out.println("Qual informação será modificada?");
                System.out.println("\t1 - Nome");
                System.out.println("\t2 - Tipo");
                System.out.println("\t3 - CPF");
                System.out.println("\t4 - Bolsa");
                System.out.println("\t5 - Prazo de vigência da bolsa");

                int opcao = input.nextInt();

                if (opcao == 1) {

                    usuario = usuarioNome();
                    listUsuarios.get(i).usuario = usuario;

                } else if (opcao == 2) {

                    cpf = usuarioCpf();
                    listUsuarios.get(i).cpf = cpf;

                } else if (opcao == 3) {

                    tipo = usuarioTipo(listUsuarios.get(i).usuario, cpf);
                    listUsuarios.get(i).tipo = tipo;

                } else if (opcao == 4) {

                    bolsa = bolsa();
                    listUsuarios.get(i).bolsa = bolsa;
                } else if (opcao == 5) {

                    prazo = prazoBolsa();
                    listUsuarios.get(i).prazo = prazo;
                }

                System.out.println("Edição realizada com sucesso!");
                
            } else {
                System.out.println("Usuário não encontrado.");
                
            }
        }

    }

    public void mostrarUsers(String nome, String cpf) {
        
        for (int i = 0; i < listUsuarios.size(); i++) {

            if (nome.equals(listUsuarios.get(i).usuario) && cpf.equals(listUsuarios.get(i).cpf)) {
                System.out.println("Nome: " + listUsuarios.get(i).usuario + "\n" + "Tipo: " + listUsuarios.get(i).tipo);

            }
        }
    }

    public void mostrarAllUsers() {

        for (int i = 0; i < listUsuarios.size(); i++) {
            System.out.println("Nome: " + listUsuarios.get(i).usuario + "\n" + "Tipo: " + listUsuarios.get(i).tipo);
        }
    }

    public void mostrarAllUsersCoordenators() {

        for (int i = 0; i < listUsuarios.size(); i++) {
            if (listUsuarios.get(i).tipo == "Pesquisador" || listUsuarios.get(i).tipo == "Professor")
            System.out.println("Nome: " + listUsuarios.get(i).usuario + " CPF: " + listUsuarios.get(i).cpf + " Tipo: " + listUsuarios.get(i).tipo);
        }

        
    }

    public String usuarioNome() {

        input = new Scanner(System.in);

        System.out.println("Digite o nome do usuário: ");
        usuario = input.nextLine();
        return usuario;
    }

    public String usuarioCpf() {

        input = new Scanner(System.in);

        System.out.println("Digite o CPF do usuário (somente números): ");
        cpf = input.nextLine();

        return cpf;

    }

    public String usuarioTipo(String nome, String cpf)
    {
        input = new Scanner(System.in);
        int opcao;

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
            
            System.out.println("\nQual tipo de profissional?");
                System.out.println("\t1 - Desenvolvedor");
                System.out.println("\t2 - Testador");
                System.out.println("\t3 - Analista");
                opcao = input.nextInt();

                if (opcao == 1) {
                    return "Desenvolvedor";

                } else if (opcao == 2) {

                    return "Testador";
                } else if (opcao == 3) {

                    return "Analista";
                }
        } else if (opcao == 7) {
            
            return "Técnico";

        }
        return "Não informado"; 
    }

    public void associarUsuarioProjeto(String nome, String cpf, int idProjeto) {

        for(int i = 0; i < listUsuarios.size(); i++) {
            
            if (listUsuarios.get(i).cpf.equals(cpf) && listUsuarios.get(i).usuario.equals((nome))) {
                listUsuarios.get(i).idProjeto = idProjeto;
            }
        }

    } 

    public void alocarUsuario (String nome, String cpf, int idAtividade) {

        for(int i = 0; i < listUsuarios.size(); i++) {
            
            if (listUsuarios.get(i).cpf.equals(cpf) && listUsuarios.get(i).usuario.equals(nome)) {
                listUsuarios.get(i).idAtividade = idAtividade;
            }
        }
    }

    public int prazoBolsa() {

        Scanner input = new Scanner(System.in);
        System.out.println("Valor da bolsa (em R$):");
        int prazo = input.nextInt();

        //input.close();
        return prazo;
    }

    public int bolsa() {

        Scanner input = new Scanner(System.in);
        System.out.println("Prazo de vigência da bolsa (em dias):");

        int bolsa = input.nextInt();

        //input.close();
        return bolsa;
    }
    public void removeProjetosAssociados(String nomeUsuario, String cpf, int idProjeto) {

        for (int i = 0; i < listUsuarios.size(); i++) {
            if (listUsuarios.get(i).cpf.equals(cpf) && listUsuarios.get(i).usuario.equals(nomeUsuario) && listUsuarios.get(i).idProjeto == idProjeto) {
                listUsuarios.get(i).idProjeto = 00000;
            }
        }
    }

    public void removeUsersAlocados(String nomeUsuario, String cpf, int idAtividade) {

        for (int i = 0; i < listUsuarios.size(); i++) {
            if (listUsuarios.get(i).cpf.equals(cpf) && listUsuarios.get(i).usuario.equals(nomeUsuario) && listUsuarios.get(i).idAtividade == idAtividade) {
                listUsuarios.get(i).idAtividade = 00000;
            }
        }
    }


}
