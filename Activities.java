import java.util.*;
//import java.text.DateFormat;

public class Activities {
    private int idAtividade;
    private int idProjeto;
    private String descricao;
    private String dataInicial;
    private String dataFinal;
    private String horaInicial;
    private String horaFinal;
    
    Profissionais profissionais = new Profissionais();
    ArrayList<Activities> listAtividades = new ArrayList<>();

    Scanner input = new Scanner(System.in);
    
    public Activities() {
    }

    public Activities(int idAtividade, String descricao, String dataInicial, String dataFinal, String horaInicial,
            String horaFinal, Profissionais profissionais, int idProjeto) {

        this.idAtividade = idAtividade;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.profissionais = profissionais;
        this.idProjeto = idProjeto;
    }




    public void createActivities(int idProjeto) {
    
        System.out.println("--------------------ATIVIDADE--------------------");

        System.out.println("\tDigite o número de identificação da atividade: ");
        idAtividade = input.nextInt();
        
        input = new Scanner(System.in);

        System.out.println("\tInsira a descrição: ");
        descricao = input.nextLine();

        System.out.println("\tInsira a data inicial no seguinte formato dd/mm/aaaa: ");
        dataInicial = input.nextLine();
        //dataInicialFormato = new SimpleDateFormat(dataInicial);
        
        System.out.println("\tInsira a hora inicial no formato 24h ");
        horaInicial = input.nextLine();

        System.out.println("\tInsira a data final no seguinte formato dd/mm/aaaa: ");
        dataFinal = input.nextLine();
        //dataFinalFormato = new SimpleDateFormat(dataFinal);

        System.out.println("\tInsira a hora final no formato 24h ");
        horaFinal = input.nextLine();

        System.out.println("Insira os profissionais envolvidos nessa atividade: ");
        while (true) {

            profissionais.profissionaisTarefas(idAtividade);

            System.out.println("Deseja inserir outro profissional(S/N)?");
            String cond = input.nextLine();
            if (cond.equals("N")) {
                break;
            }

        }

        Activities activities = new Activities(idAtividade, descricao, dataInicial, dataFinal, horaInicial, horaFinal, profissionais, idProjeto);

        listAtividades.add(activities);
    }

    public void mostrarAtividades(int idProjeto) {

        for (int i = 0; i < listAtividades.size(); i++) {
            /*System.out.println("Número de identificação da atividade: " + listAtividades.get(i).idAtividade + "\n" + "Data Inicial: " + listAtividades.get(i).dataInicial + "\n" + "Hora Inicial: " + listAtividades.get(i).horaInicial + "\n" + "Data final: " + listAtividades.get(i).dataFinal + "\n" + "Hora Final: " + listAtividades.get(i).horaFinal + "\n" + "Descricão: " + listAtividades.get(i).descricao + "\n" + "Tarefas: " + listAtividades.get(i));
            */

            if (listAtividades.get(i).idProjeto == idProjeto) {

                System.out.println("\tNúmero de identificação da atividade: " + listAtividades.get(i).idAtividade + "\tDescricão: " + "\n" + listAtividades.get(i).descricao + "\n");
    
                System.out.println("Profissionais envolvidos neste atividade: ");
                profissionais.mostrarProfissionaisAtividade(listAtividades.get(i).idAtividade);
            }

        }

    }

    
}
