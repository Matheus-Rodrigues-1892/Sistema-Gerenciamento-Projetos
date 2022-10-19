
import java.util.Scanner;

public class User{
    
    protected String nome;
    protected String tipo;
    protected String cpf;
    protected int idProjeto;
    protected int idAtividade;
    protected double bolsa;
    protected int prazo;
    protected int responsavel;

    Scanner input = new Scanner(System.in);
    
    public User(){}


    public User(String nome, String tipo, String cpf, int idProjeto, int idAtividade, int responsavel) {
         this.nome = nome;
         this.tipo = tipo;
         this.cpf = cpf;
         this.idProjeto = idProjeto;
         this.idAtividade = idAtividade;
         this.responsavel = responsavel;
     } 

     /*public User(String nome, String tipo, String cpf, int idProjeto, int idAtividade) {
        this.nome = nome;
        this.tipo = tipo;
        this.cpf = cpf;
        this.idProjeto = idProjeto;
        this.idAtividade = idAtividade;
    } */

    protected void editUsers(User usuario) {

        System.out.println("------- EDITAR INFO USUÁRIO ----------");
        menuUsers();
        int opcao = input.nextInt();

        switch (opcao) {
            case 1:
                nome = usuarioNome();
                usuario.nome = nome;
                break;
            
            case 2:
                cpf = usuarioCpf();
                usuario.cpf = cpf;
                break;

            case 3:
                tipo = usuarioTipo();
                usuario.tipo = tipo;
                break;

            default:
                System.out.println("Usuário não encontrado.");
                break;
                
        }


    }

    protected void removeUser(User usuario) {

        System.out.println("------- REMOVER INFO USUÁRIO ----------");
        menuUsers();
        int opcao = input.nextInt();

        switch (opcao) {
            case 1:
                usuario.nome = null;
                break;
            
            case 2:
                usuario.cpf = null;
                break;

            case 3:
                usuario.tipo = null;
                break;

            default:
                System.out.println("Usuário não encontrado.");
                break;
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

    protected void menuProfissionais(){

        System.out.println("\t1 - Nome");
        System.out.println("\t2 - CPF");
        System.out.println("\t3 - Tipo");
        System.out.println("\t4 - Bolsa");
        System.out.println("\t5 - Prazo de vigência da bolsa");
    }

    public double bolsaProfissional(){
        System.out.println("Valor em R$:");
        return input.nextDouble();
    }

    public int prazoBolsa(){
        System.out.println("Prazo em dias:");
        return input.nextInt();
    }
    
    protected void menuUsers(){

        System.out.println("\t1 - Nome");
        System.out.println("\t2 - CPF");
        System.out.println("\t3 - Tipo");
        
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
        

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }

    public double getBolsa() {
        return bolsa;
    }

    public void setBolsa(int bolsa) {
        this.bolsa = bolsa;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }


}
