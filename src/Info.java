import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Info extends MenuPrincipal{
    
    protected int id;
    protected String descricao;
    protected String dataInicial;
    protected String dataFinal;
    protected String horaInicial;
    protected String horaFinal;
    private String coordenador;
    protected String responsavel;
    
    private String tarefa;
    
    Scanner input = new Scanner(System.in);

    //public Info(){}
    
    public Info(int id, String descricao, String dataInicial, String dataFinal, String horaInicial, String horaFinal) {
        this.id = id;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }
    public void infoMenu(int idAtividade){

        System.out.println("=====================ATIVIDADE=============");
        System.out.println("\t0 - SAIR");
        System.out.println("\t1 - N° identificação Atividade");
        System.out.println("\t2 - Descrição ");
        System.out.println("\t3 - Data inicial e hora inicial ");
        System.out.println("\t4 - Data final e hora final ");
        System.out.println("\t5 - Responsável pela atividade");
        System.out.println("\t6 - Profissionais envolvidos na atividade ");
        System.out.println("\t7 - Alocar usuário ");
        System.out.println("\t8 - Alocar usuário");
        
        System.out.println("Insira a operação referente ao menu");
    }
    
    public void infoMenu(){

        System.out.println("=====================PROJETO=============");
        System.out.println("\t0 - SAIR");
        System.out.println("\t1 - N° identificação");
        System.out.println("\t2 - Descrição");
        System.out.println("\t3 - Data inicial e hora inicial");
        System.out.println("\t4 - Data final e hora final");
        System.out.println("\t5 - Coordenador");
        System.out.println("\t6 - Profissionais envolvidos no projeto");
        System.out.println("\t7 - Atividades");
        System.out.println("\t8 - Alocar usuário");
        
        System.out.println("Insira a operação referente ao menu");
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
    
    public String getResponsavel() {
        return responsavel;
    }
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void geraId() {

        System.out.println("Digite o número de identificação");
        setId(input.nextInt());
        
    }
    
    public void descricao (){
        input = new Scanner(System.in);
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

    protected void coordenadorProjeto(HashMap<String, Coordenador> listUsuarioCoordenadorMap, int idProjeto) {

        listaCoordenadores();
        System.out.println("Insira o CPF do coordenador do projeto: ");
        cpf = usuarioCpf();
        listUsuarioCoordenadorMap.get(cpf).idProjeto = idProjeto;
        System.out.println("Coordenador inserido...");

    }

    protected void responsavelAtividade(int idAtividade) {

        String cpfResponsavel = usuarioCpf();

        if (listUsuarioCoordenadorMap.get(cpfResponsavel).cpf == cpfResponsavel){
                        
            listUsuarioCoordenadorMap.get(cpfResponsavel).responsavel = idAtividade;

        } else if (listUsuarioProfissionalMap.get(cpfResponsavel).cpf == cpfResponsavel){
                        
            listUsuarioProfissionalMap.get(cpfResponsavel).responsavel = idAtividade;

        } else if (listUsuarioMap.get(cpfResponsavel).cpf == cpfResponsavel){
                        
            listUsuarioMap.get(cpfResponsavel).responsavel = idAtividade;
        }

        System.out.println("Responsável inserido...");

    }

    public void usuarioEnvolvido(HashMap<String, User> listUsuarioMap, HashMap<String, Profissional> listUsuarioProfissionalMap, HashMap<String, Coordenador> listUsuarioCoordenadorMap, int idProjeto) {

        cpf = usuarioCpf();

        for (String i : listUsuarioMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioMap.get(i).idProjeto = idProjeto;
            }

        }

        for (String i : listUsuarioProfissionalMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioProfissionalMap.get(i).idProjeto = idProjeto;
            }

        }

        for (String i : listUsuarioCoordenadorMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioCoordenadorMap.get(i).idProjeto = idProjeto;
            }

        }
    }

    public void usuarioEnvolvido(HashMap<String, User> listUsuarioMap, HashMap<String, Profissional> listUsuarioProfissionalMap, HashMap<String, Coordenador> listUsuarioCoordenadorMap, int idProjeto, int idAtividade) {

        cpf = usuarioCpf();

        for (String i : listUsuarioMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioMap.get(i).idAtividade = idAtividade;
            }

        }

        for (String i : listUsuarioProfissionalMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioProfissionalMap.get(i).idAtividade = idAtividade;
            }

        }

        for (String i : listUsuarioCoordenadorMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioCoordenadorMap.get(i).idAtividade = idAtividade;
            }

        }
    }

    public void profissionalEnvolvido(HashMap<String, Profissional> listUsuarioProfissionalMap, int idProjeto) {


        cpf = usuarioCpf();

        for (String i : listUsuarioProfissionalMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioProfissionalMap.get(i).idProjeto = idProjeto;
            }

        }
    }

    public void profissionalRemocao(HashMap<String, Profissional> listUsuarioProfissionalMap, int idProjeto) {


        cpf = usuarioCpf();

        for (String i : listUsuarioProfissionalMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioProfissionalMap.get(i).idProjeto = 0000;
            }

        }
    }

    public void coordenadorProjetoRemocao(HashMap<String, Coordenador> listUsuarioCoordenadorMap, int idProjeto) {


        cpf = usuarioCpf();

        for (String i : listUsuarioCoordenadorMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioCoordenadorMap.get(i).idProjeto = 0000;
            }

        }
    }

    public void profissionalEnvolvidoAtividade(HashMap <String, Profissional>listUsuarioProfissionalMap,int idProjeto, int idAtividade) {


        cpf = usuarioCpf();

        for (String i : listUsuarioProfissionalMap.keySet()){

            if(i.equals(cpf) && listUsuarioProfissionalMap.get(i).idProjeto == idProjeto){
                listUsuarioProfissionalMap.get(i).idAtividade = idAtividade;

                System.out.println("Insira a tarefa:");
                tarefa = input.nextLine();
                listUsuarioProfissionalMap.get(i).tarefa = tarefa;
            }

        }
    }

    public void profissionalRemocaoAtividade(HashMap <String, Profissional>listUsuarioProfissionalMap,int idProjeto, int idAtividade) {


        cpf = usuarioCpf();

        for (String i : listUsuarioProfissionalMap.keySet()){

            if(i.equals(cpf) && listUsuarioProfissionalMap.get(i).idProjeto == idProjeto){
                listUsuarioProfissionalMap.get(i).idAtividade = 0000;
                listUsuarioProfissionalMap.get(i).tarefa = null;

            }

        }
    }

    public void usuarioEnvolvidoRemocao(HashMap<String, User> listUsuarioMap, HashMap<String, Profissional> listUsuarioProfissionalMap, HashMap<String, Coordenador> listUsuarioCoordenadorMap, int idProjeto) {

        String cpf = usuarioCpf();

        for (String i : listUsuarioMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioMap.get(i).idProjeto = 0000;
            }

        }

        for (String i : listUsuarioProfissionalMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioProfissionalMap.get(i).idProjeto = 0000;
            }

        }

        for (String i : listUsuarioCoordenadorMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioCoordenadorMap.get(i).idProjeto = 0000;
            }

        }
    }



    public void usuarioEnvolvidoRemocao(HashMap<String, User> listUsuarioMap, HashMap<String, Profissional> listUsuarioProfissionalMap, HashMap<String, Coordenador> listUsuarioCoordenadorMap, int idProjeto, int idAtividade) {

        String cpf = usuarioCpf();

        for (String i : listUsuarioMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioMap.get(i).idAtividade = 0000;
            }

        }

        for (String i : listUsuarioProfissionalMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioProfissionalMap.get(i).idAtividade = 0000;
            }

        }

        for (String i : listUsuarioCoordenadorMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioCoordenadorMap.get(i).idAtividade = 0000;
            }

        }
    }

    

    public String toString(int idAtividade){

        for(int i = 0; i < listUsuarioProfissionalMap.size(); i++){

            cpf = indexCpf(idAtividade);

            if(idAtividade == listUsuarioProfissionalMap.get(cpf).idAtividade) {
                System.out.println("Nome: " + listUsuarioProfissionalMap.get(cpf).nome);
            }
        }

        return null;
    }

    public String indexCpf(int idAtividade){
        
        for (String i : listUsuarioProfissionalMap.keySet()) {

            if(listUsuarioProfissionalMap.get(i).idAtividade == idAtividade) return i;

        }

        return null;
    }

    @Override
    protected void listaCoordenadores() {
        for (String i : listUsuarioCoordenadorMap.keySet()){

            System.out.println("NOME: " + listUsuarioCoordenadorMap.get(i).nome + "CPF: " + listUsuarioCoordenadorMap.get(i).cpf + "TIPO: " + listUsuarioCoordenadorMap.get(i));

        }
    }

    



}
