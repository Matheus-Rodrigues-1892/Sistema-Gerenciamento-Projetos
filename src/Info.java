import java.util.ArrayList;
import java.util.Scanner;

public class Info{

    protected int id;
    protected String descricao;
    protected String dataInicial;
    protected String dataFinal;
    protected String horaInicial;
    protected String horaFinal;
    private Scanner input = new Scanner(System.in);
    protected ArrayList<Profissionais> listProfissionais = new ArrayList<Profissionais>();
    
    
    public Info() {
    }
    
    public Info(int id, String descricao, String dataInicial, String dataFinal, String horaInicial, String horaFinal, ArrayList<Profissionais> listProfissionais) {
        this.id = id;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.listProfissionais = listProfissionais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicial() {
        return dataInicial;
    }
    
    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }
    
    public String getDataFinal() {
        return dataFinal;
    }
    
    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }
    
    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }
    
    public ArrayList<Profissionais> getProfissional() {
        return listProfissionais;
    }

    public void setProfissionais(ArrayList<Profissionais> listProfissionais2) {
        this.listProfissionais = listProfissionais2;
    }
    
    public void infoMenu(){

        System.out.println("Insira a operação referente ao menu");
        
        System.out.println("\t1 - Descrição");
        System.out.println("\t2 - Data inicial e hora inicial");
        System.out.println("\t3 - Data final e hora final");
        System.out.println("\t4 - Coordenador");
        System.out.println("\t5 - Profissionais envolvidos no projeto");
        System.out.println("\t6 - Atividades");

    }

    public void geraId() {

        System.out.println("Digite o número de identificação");
        setId(input.nextInt());

    }

    public void descricao (){

        System.out.println("Digite a descrição:");
        setDescricao(input.nextLine());

    }

    public void dataInicial () {

        System.out.println("Digite a data da criação:");
        String dataInicial = input.nextLine();
        setDataInicial(dataInicial);

    }
    
    public void horaInicial(){
        
        System.out.println("Insira a hora");
        String horaInicial = input.nextLine();
        setHoraInicial(horaInicial);

    }

    public void dataFinal() {
        
        System.out.println("Digite a data de término:");
        String dataInicial = input.nextLine();
        setDataFinal(dataInicial);

    }
    
    public void horaFinal(){
        
        System.out.println("Insira a hora");
        String horaInicial = input.nextLine();
        setHoraFinal(horaInicial);

    }


    public void profissionaisEnvolvidos(int idAtividade) {

        Profissionais lProfissionais = new Profissionais();

        listProfissionais = lProfissionais.adicionarProfissional(idAtividade);

        setProfissionais(listProfissionais);
    }

    public void editProfissionaisEnvolvidos () {

        Profissionais profissional = new Profissionais();
        profissional.editUsers();

    }

    public ArrayList<Profissionais> editProfissionaisEnvolvidos (int idAtividade) {

        Profissionais profissional = new Profissionais();
        return profissional.editUser(idAtividade);

    }

    public void removeProfissionaisEnvolvidos() {

        Profissionais profissional = new Profissionais();

        profissional.removeUser();
        

    }

    public ArrayList<Profissionais> removeProfissionaisEnvolvidos(int idAtividade) {

        Profissionais profissional = new Profissionais();

        return profissional.removeUser(idAtividade);
        

    }

    /*public ArrayList<Profissionais> printProfissionaisProjeto (int idProjeto){

        Profissionais profissional = new Profissionais();

        return profissional.printProfissionaisProjetoEnvolvidos(idProjeto);
    }*/


    public void infoAtividade(){

        
        System.out.println("\t1 - Descrição: ");
        System.out.println("\t2 - Data inicial e hora inicial: ");
        System.out.println("\t3 - Data final e hora final: ");
        System.out.println("\t4 - Responsável: ");
        System.out.println("\t5 - Profissionais envolvidos na atividade: ");
        System.out.println("\t6 - Tarefas a serem realizadas: ");

        System.out.println("Insira a operação referente ao menu:");
    }

}
