import java.util.ArrayList;
import java.util.Scanner;

public class Profissionais {
    
    
    private int bolsa;
    private int prazo;
    private int idProjeto;
    private int idAtividade;
    private String nome;
    private String cargo;
    private String tarefas;

    ArrayList<Profissionais> listProfissionaisProjeto = new ArrayList<>();
    ArrayList<Profissionais> listProfissionaisAtividade = new ArrayList<>();
    ArrayList<String> listTarefas = new ArrayList<>();

    
    Scanner input = new Scanner(System.in);
    
    
    public Profissionais() {
    }
    
    public Profissionais(String nome, String cargo, int bolsa, int prazo, int idProjeto) {
        this.bolsa = bolsa;
        this.prazo = prazo;
        this.nome = nome;
        this.cargo = cargo;
        this.idProjeto = idProjeto;
    }
    
    public Profissionais(String nome, String cargo, String tarefas, int idAtividade) {
        this.nome = nome;
        this.cargo = cargo;
        this.tarefas = tarefas;
        this.idAtividade = idAtividade;
        
    }

    public void profissionaisProjeto(int idProjeto) {

        Profissionais profissionais = new Profissionais();
        int idProjetoAssociado = idProjeto;

        input = new Scanner(System.in);

        System.out.println("Nome do profissional: ");
        nome = input.nextLine();

        System.out.println("Qual tipo de profissional?");
        System.out.println("\t1 - Desenvolvedor");
        System.out.println("\t2 - Testador");
        System.out.println("\t3 - Analista");
        int opcao = input.nextInt();

        System.out.println("Valor da bolsa em R$:");
        bolsa = input.nextInt();

        System.out.println("Prazo de vigência da bolsa (em dias):");
        prazo = input.nextInt();

        if (opcao == 1) {

            profissionais = new Profissionais(nome,"Desenvolvedor", bolsa, prazo, idProjetoAssociado);

        } else if (opcao == 2) {

            profissionais = new Profissionais(nome,"Testador", bolsa, prazo, idProjetoAssociado);

        } else if (opcao == 3) {
            
            profissionais = new Profissionais(nome,"Analista", bolsa, prazo, idProjetoAssociado);

        }

        listProfissionaisProjeto.add(profissionais);

    }

    public void profissionaisTarefas (int idAtividade) {

        Profissionais profissionais = new Profissionais();
        int idAtividadeAssociada = idAtividade;

        input = new Scanner(System.in);

        System.out.println("Nome do profissional: ");
        nome = input.nextLine();

        System.out.println("Qual tipo de profissional?");
        System.out.println("\t1 - Desenvolvedor");
        System.out.println("\t2 - Testador");
        System.out.println("\t3 - Analista");
        int opcao = input.nextInt();

    
        while (true) {

            System.out.println("\tInsira a tarefa relacionada a este profissional: ");
            input = new Scanner(System.in);
            tarefas = input.nextLine();
            listTarefas.add(tarefas);

            System.out.println("\n");

            System.out.println("Deseja inserir outra tarefa (S/N)?");
            input = new Scanner(System.in);
            String cond = input.nextLine();
            if (cond.equals("N")) {
                break;
            }

        }

        if (opcao == 1) {

            profissionais = new Profissionais(nome,"Desenvolvedor", tarefas, idAtividadeAssociada);

        } else if (opcao == 2) {

            profissionais = new Profissionais(nome,"Testador", tarefas, idAtividadeAssociada);

        } else if (opcao == 3) {
            
            profissionais = new Profissionais(nome,"Analista", tarefas, idAtividadeAssociada);

        }

        listProfissionaisAtividade.add(profissionais);
    }

    public void mostrarProfissionaisProjeto(int id) {

        for (int i = 0; i < listProfissionaisProjeto.size(); i++) {
            
            if (listProfissionaisProjeto.get(i).idProjeto == id) {
                
                System.out.println("Nome: " + listProfissionaisProjeto.get(i).nome + "\n" + "Cargo: " + listProfissionaisProjeto.get(i).cargo + "\n" + "Valor da bolsa: R$ " + listProfissionaisProjeto.get(i).bolsa + "\n");
            }
        }
    }

    public void mostrarProfissionaisAtividade(int id) {

        for (int i = 0; i < listProfissionaisAtividade.size(); i++) {
            
            if(listProfissionaisAtividade.get(i).idAtividade == id) {
                
                System.out.println("\tNome: " + listProfissionaisAtividade.get(i).nome + "\n" + "\tCargo: " + listProfissionaisAtividade.get(i).cargo + "\n");
                for (String tarefaAssociada:listTarefas) {
                    System.out.println("\tTarefa: " + tarefaAssociada);
                }
            }
        }
    }


    
}
