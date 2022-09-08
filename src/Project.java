
import java.util.*;
//import java.text.SimpleDateFormat;



public class Project {

    private int idProjeto;
    private String descricao;
    private String dataInicial;
    private String dataFinal;
    private String horaInicial;
    private String horaFinal;
    //private SimpleDateFormat dataInicialFormato;
    //private SimpleDateFormat dataFinalFormato;

    Activities activities = new Activities();
    Profissionais profissionais = new Profissionais();

    ArrayList<Project> listProjetos = new ArrayList<>();

    Scanner input = new Scanner(System.in);



    public Project(int idProjeto, String descricao, String dataInicial, String dataFinal, String horaInicial, String horaFinal, Profissionais profissionais, Activities activities) {
        this.idProjeto = idProjeto;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.profissionais = profissionais;
        this.activities = activities;
    }

    public Project() {
    }

    /**
     * 
     */
    public int createProject() {
        input = new Scanner(System.in);
        System.out.println("--------------------PROJETO--------------------");

        System.out.println("\tDigite o número de identificação: ");
        idProjeto = input.nextInt();
        
        input = new Scanner(System.in);

        System.out.println("\tInsira a descrição: ");
        descricao = input.nextLine();

        System.out.println("\tInsira a data inicial no seguinte formato dd/mm/aaaa: ");
        dataInicial = input.nextLine();
        //dataInicialFormato = new SimpleDateFormat(dataInicial);
        
        System.out.println("\tInsira a hora inicial no formato 24h: ");
        horaInicial = input.nextLine();

        System.out.println("\tInsira a data final no seguinte formato dd/mm/aaaa: ");
        dataFinal = input.nextLine();
        //dataFinalFormato = new SimpleDateFormat(dataFinal);

        System.out.println("\tInsira a hora final no formato 24h ");
        horaFinal = input.nextLine();

        System.out.println("\tInsira os profissionais envolvidos nesse projeto: ");
        while (true) {

            profissionais.profissionaisProjeto(idProjeto);

            System.out.println("Deseja inserir outro profissional (S/N)?");
            String cond = input.nextLine();
            if (cond.equals("N")) {
                break;
            }

        }

        System.out.println("\tInsira as atividades envolvidos presente neste projeto: ");
                while (true) {

                    activities.createActivities(idProjeto);

                    System.out.println("Deseja inserir outra atividade (S/N)?");
                    input = new Scanner(System.in);
                    String cond = input.nextLine();
                    if (cond.equals("N")) {
                        break;
                    }
                }

        

        Project project = new Project(idProjeto, descricao, dataInicial, dataFinal, horaInicial, horaFinal, profissionais, activities);

        listProjetos.add(project);
        
        System.out.println("--------------------------------------------------");

        return idProjeto;

    }

    public void mostrarProjetos() {

        for (int i = 0; i < listProjetos.size(); i++) {
            System.out.println("Número de identificação do Projeto: " + listProjetos.get(i).idProjeto + "\n" + "Descricão: " + listProjetos.get(i).descricao + "\n");
            
            System.out.println("Profissionais envolvidos neste projeto: ");
            profissionais.mostrarProfissionaisProjeto(listProjetos.get(i).idProjeto);

            System.out.println("\tAtividades desenvolvidas neste projeto: ");
            activities.mostrarAtividades(listProjetos.get(i).idProjeto);
        }

    }

    
    
}
