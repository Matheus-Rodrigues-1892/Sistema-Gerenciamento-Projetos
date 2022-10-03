import java.util.ArrayList;
import java.util.Scanner;

public class Profissionais extends User {

    private int bolsa;
    private int prazo;
    Scanner input = new Scanner(System.in);

    ArrayList <Profissionais> listProfissionaisEnvolvidos= new ArrayList<>();
    protected String tarefaProfissional;

    public Profissionais(String nome, String cpf, String tipo, int idProjeto, int bolsa, int prazo) {
        super(nome, cpf, tipo);

        this.idProjeto = idProjeto;
        this.bolsa = bolsa;
        this.prazo = prazo;
    }

    public Profissionais(String nome, String tipo, String cpf, int idProjeto, int idAtividade, int bolsa, int prazo, String tarefaProfissional) {
        super(nome, tipo, cpf);

        this.idProjeto = idProjeto;
        this.idAtividade = idAtividade;
        this.bolsa = bolsa;
        this.prazo = prazo;
        this.tarefaProfissional = tarefaProfissional;
    }

    public Profissionais(String nome, String tipo, String cpf, int idProjeto, int idAtividade, String tarefaProfissional) {
        super(nome, tipo, cpf);

        this.idProjeto = idProjeto;
        this.idAtividade = idAtividade;
        this.tarefaProfissional = tarefaProfissional;
    }

    public Profissionais() {
    }

    public Profissionais(String nome, String cpf, String tipo) {
    }

    protected ArrayList <Profissionais> adicionarProfissional(int idProjeto){

        
        nome = usuarioNome();
        cpf = usuarioCpf();
        
        for (int i = 0; i < listUsuarios.size(); i++){
            
            if (nome.equals(listUsuarios.get(i).nome) || cpf.equals(listUsuarios.get(i).cpf)){
        
                bolsa = bolsaProfissional();
                prazo = prazoBolsa();

                Profissionais profissional = new Profissionais(nome, cpf, tipo, idProjeto, 0000, bolsa, prazo, null);

                listProfissionaisEnvolvidos.add(profissional);

                System.out.println(listProfissionaisEnvolvidos.get(0).nome + listProfissionaisEnvolvidos.get(0).cpf);

                return listProfissionaisEnvolvidos;

            }
        }
        
        System.out.println("Profissional não encontrado");
        return null;

    }

    /*protected ArrayList <Profissionais> adicionarProfissional(int idAtividade){

        
        nome = usuarioNome();
        cpf = usuarioCpf();
        
        for (int i = 0; i < listUsuarios.size(); i++){
            
            if (listUsuarios.get(i).nome.equals(nome) && listUsuarios.get(i).cpf.equals(cpf)){
                
                geraId();
                int idProjeto = getId();

                String tarefa = tarefaAtividade();

                Profissionais profissional = new Profissionais(nome, cpf, tipo, idProjeto, idAtividade, tarefa);

                listProfissionaisEnvolvidos.add(profissional);

                return listProfissionaisEnvolvidos;

            }
        }
        
        System.out.println("Profissional não encontrado");
        return null;

    }*/


    
    private String tarefaAtividade() {
        
        System.out.println("Insira a tarefa: ");
        return tarefaProfissional = input.nextLine();

    }

    private int prazoBolsa() {

        System.out.println("Insira o prazo da bolsa");
        return prazo = input.nextInt();
    }

    private int bolsaProfissional() {

        System.out.println("Insira o valor da bolsa: ");
        return bolsa = input.nextInt();

    }

    //---------------------REMOÇÃO DAS INFO RELACIONADAS AOS PROFISSIONAIS
    protected ArrayList<Profissionais> removeProfissionais() {

        nome = usuarioNome();
        cpf = usuarioCpf();


        menuUsers();
        int opcao = input.nextInt();

        for (int i = 0; i < listUsuarios.size(); i++) {
            
            if (nome.equals(listUsuarios.get(i).nome) && cpf.equals(listUsuarios.get(i).cpf)) {

                int index = indexProfissionaisUsuario(i);
                
                if (opcao == 1) {

                    listUsuarios.get(i).nome = null;
                    listProfissionaisEnvolvidos.get(index).nome = null;

                } else if (opcao == 2) {

                    listUsuarios.get(i).cpf = null;
                    listProfissionaisEnvolvidos.get(index).cpf = null;

                } else if (opcao == 3) {

                    listUsuarios.get(i).tipo = null;
                    listProfissionaisEnvolvidos.get(index).tipo = null;

                } else if (opcao == 4){

                    listProfissionais.get(index).idProjeto = 0000;

                } else if (opcao == 5) {

                    listProfissionaisEnvolvidos.get(index).bolsa = 0000;

                } else if (opcao == 6) {

                    listProfissionaisEnvolvidos.get(index).prazo = 0000;

                }
            } else {

                System.out.println("Usuário não encontrado.");

            }
        }

        return listProfissionaisEnvolvidos;
    }

    protected ArrayList<Profissionais> removeUser(int idAtividade) {

        nome = usuarioNome();
        cpf = usuarioCpf();

        menuUsers();
        int opcao = input.nextInt();

        for (int i = 0; i < listUsuarios.size(); i++) {
            
            if (nome.equals(listProfissionaisEnvolvidos.get(i).nome) && cpf.equals(listUsuarios.get(i).cpf) && listProfissionaisEnvolvidos.get(i).idAtividade == idAtividade) {
                
                if (opcao == 1) {

                    listUsuarios.get(i).nome = null;
                    listProfissionaisEnvolvidos.get(i).nome = null;

                } else if (opcao == 2) {

                    listUsuarios.get(i).cpf = null;
                    listProfissionaisEnvolvidos.get(i).cpf = null;

                } else if (opcao == 4){

                    listProfissionais.get(i).tarefaProfissional = null;

                }
            } else {

                System.out.println("Usuário não encontrado.");

            }

        }

        return listProfissionais;

    }

    //-----------------------EDIÇÃO DAS INFO DOS PROFISSIONAIS USANDO OVERRIDE

    protected ArrayList<Profissionais> editProfissionais() {

        nome = usuarioNome();
        cpf = usuarioCpf();
        menuUsers();

        for (int i = 0; i < listUsuarios.size(); i++) {
            
            System.out.println("--------EDIÇÃO PROFISSIONAIS----------");

            if (nome.equals(listUsuarios.get(i).nome) && cpf.equals(listUsuarios.get(i).cpf)) {
                    
                menuUsers();
                int opcao = input.nextInt();
                int index = indexProfissionaisUsuario(i);
    
                if (opcao == 1) {
        
                    nome = usuarioNome();
                    listUsuarios.get(i).nome = nome;
                    listProfissionaisEnvolvidos.get(index).nome = nome;
        
                } else if (opcao == 2) {
        
                    cpf = usuarioCpf();
                    listUsuarios.get(i).cpf = cpf;
                    listProfissionaisEnvolvidos.get(index).cpf = cpf;
        
                } else if (opcao == 3) {
        
                    tipo = usuarioTipo();
                    listUsuarios.get(i).tipo = tipo;
                    listProfissionaisEnvolvidos.get(index).tipo = tipo;
        
                } else if (opcao == 4){

                    geraId();
                    int idProjeto = getId();
                    listProfissionaisEnvolvidos.get(index).idProjeto = idProjeto;
                    
                }else if (opcao == 5) {
        
                    bolsa = bolsaProfissional();
                    listProfissionaisEnvolvidos.get(index).bolsa = bolsa;

                } else if (opcao == 6) {
        
                    prazo = prazoBolsa();
                    listProfissionaisEnvolvidos.get(index).prazo = prazo;
                        
                }
            }else {
                System.out.println("Usuário não encontrado.");
                    
            }

        }

        return listProfissionaisEnvolvidos;

    }

    protected ArrayList<Profissionais> editUser(int idAtividade) {

        nome = usuarioNome();
        cpf = usuarioCpf();

        menuUsers();
        int opcao = input.nextInt();

        for (int i = 0; i < listUsuarios.size(); i++) {
            
            if (nome.equals(listProfissionaisEnvolvidos.get(i).nome) && cpf.equals(listUsuarios.get(i).cpf) && listProfissionaisEnvolvidos.get(i).idAtividade == idAtividade) {
                
                if (opcao == 1) {
                    nome = usuarioNome();
                    listUsuarios.get(i).nome = nome;
                    listProfissionaisEnvolvidos.get(i).nome = nome;

                } else if (opcao == 2) {

                    cpf = usuarioCpf();
                    listUsuarios.get(i).cpf = cpf;
                    listProfissionaisEnvolvidos.get(i).cpf = cpf;

                } else if (opcao == 3){

                    tarefaProfissional = tarefaAtividade();
                    listProfissionais.get(i).tarefaProfissional = tarefaProfissional;

                }
            } else {

                System.out.println("Usuário não encontrado.");
                
            }
        }
        
        return listProfissionais;

    }

    private int indexProfissionaisUsuario(int i)
    {
        for (int j = 0; j < listProfissionaisEnvolvidos.size(); j++){
            
            if (listProfissionaisEnvolvidos.get(j) == listUsuarios.get(i)){
                return j;
            }
        }
        return 0;
    }

//------------------------SELECIONAR PROFISSIONAIS-----

    protected int selecionarProfissional(String nome, String cpf, int idProjeto, int idAtividade2){

        for (int j = 0; j < listProfissionaisEnvolvidos.size(); j++){
            
            if (listProfissionaisEnvolvidos.get(j).nome.equals(nome) && listProfissionaisEnvolvidos.get(j).idProjeto == idProjeto && listProfissionaisEnvolvidos.get(j).idAtividade == idAtividade){

                return j;

            }
        }
        return 0;

    }

    public void printProfissionaisProjetoEnvolvidos(int idProjeto) {

        for (int i = 0; i < listProfissionaisEnvolvidos.size(); i++){

            if (listProfissionaisEnvolvidos.get(i).idProjeto == idProjeto){
                System.out.println("PROFISSIONAL: " + listProfissionaisEnvolvidos.get(i).nome + "BOLSA: " + listProfissionaisEnvolvidos.get(i).bolsa);
            }
        }
    }
}
