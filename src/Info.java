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

        System.out.println("\t0 - SAIR");
        System.out.println("\t1 - N° identificação Atividade");
        System.out.println("\t2 - Descrição ");
        System.out.println("\t3 - Data inicial e hora inicial ");
        System.out.println("\t4 - Data final e hora final ");
        System.out.println("\t5 - Responsável pela atividade");
        System.out.println("\t6 - Profissionais envolvidos na atividade ");
        System.out.println("\t7 - Tarefas a serem realizadas ");
        
        System.out.println("Insira a operação referente ao menu");
    }
    
    public void infoMenu(){

        System.out.println("\t0 - SAIR");
        System.out.println("\t1 - N° identificação");
        System.out.println("\t1 - Descrição");
        System.out.println("\t2 - Data inicial e hora inicial");
        System.out.println("\t3 - Data final e hora final");
        System.out.println("\t4 - Coordenador");
        System.out.println("\t5 - Profissionais envolvidos no projeto");
        System.out.println("\t6 - Atividades");
        
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

    protected String coordenadorProjeto() {

        System.out.println("Insira o coordenador do projeto: ");
        return coordenador = input.nextLine();

    }

    protected String responsavelAtividade() {

        System.out.println("Insira o responsável pela atividade: ");
        return responsavel = input.nextLine();

    }

    public void adicionarTarefa(int idAtividade){

        cpf = usuarioCpf();

        for (String i : listUsuarioMap.keySet()){

            if(cpf.equals(i) && idAtividade == listUsuarioProfissionalMap.get(i).idAtividade){
                System.out.println("Insira a atividade:");
                tarefa = input.nextLine();
                listUsuarioProfissionalMap.get(i).tarefa = tarefa;
            }

        }

    }

    public void editarTarefa(int idAtividade){

        cpf = usuarioCpf();

        for (String i : listUsuarioMap.keySet()){

            if(cpf.equals(i) && idAtividade == listUsuarioProfissionalMap.get(i).idAtividade){
                System.out.println("Edite a tarefa:");
                tarefa = input.nextLine();
                listUsuarioProfissionalMap.get(i).tarefa = tarefa;
            }

        }

    }

    public void removerTarefa(int idAtividade){

        cpf = usuarioCpf();

        for (String i : listUsuarioMap.keySet()){

            if(cpf.equals(i) && idAtividade == listUsuarioProfissionalMap.get(i).idAtividade){
                listUsuarioProfissionalMap.get(i).tarefa = null;
            }

        }

    }

    

    public void usuarioEnvolvido(int idProjeto) {

        cpf = usuarioCpf();

        for (String i : listUsuarioMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioMap.get(i).idProjeto = idProjeto;
            }

        }
    }

    public void ProfissionalEnvolvido(int idProjeto) {


        cpf = usuarioCpf();

        for (String i : listUsuarioProfissionalMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioProfissionalMap.get(i).idProjeto = idProjeto;
            }

        }
    }

    public void ProfissionalRemocao(int idProjeto) {


        cpf = usuarioCpf();

        for (String i : listUsuarioProfissionalMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioProfissionalMap.get(i).idProjeto = 0000;
            }

        }
    }

    public void ProfissionalEnvolvidoAtividade(int idProjeto, int idAtividade) {

        Profissional profissional = new Profissional();

        String cpf = profissional.usuarioCpf();

        for (String i : listUsuarioProfissionalMap.keySet()){

            if(i.equals(cpf) && listUsuarioProfissionalMap.get(i).idProjeto == idProjeto){
                listUsuarioProfissionalMap.get(i).idAtividade = idAtividade;
            }

        }
    }

    public void ProfissionalRemocaoAtividade(int idProjeto, int idAtividade) {


        cpf = usuarioCpf();

        for (String i : listUsuarioProfissionalMap.keySet()){

            if(i.equals(cpf) && listUsuarioProfissionalMap.get(i).idProjeto == idProjeto){
                listUsuarioProfissionalMap.get(i).idAtividade = 0000;
            }

        }
    }



    public void usuarioEnvolvido(int idProjeto, int idAtividade) {

        User user = new User();

        String cpf = user.usuarioCpf();

        for (String i : listUsuarioMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioMap.get(i).idProjeto = idProjeto;
                listUsuarioMap.get(i).idAtividade = idAtividade;
            }

        }
    }

    public void usuarioRemovido (int idProjeto){

        String cpf = usuarioCpf();

        for (String i : listUsuarioMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioMap.get(i).idProjeto = 0000;
            }

        }
    
    }

    public void usuarioRemovido(int idProjeto, int idAtividade) {

        String cpf = usuarioCpf();

        for (String i : listUsuarioMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioMap.get(i).idProjeto = 0000;
                listUsuarioMap.get(i).idAtividade = 0000;
            }

        }
    }

    public void usuarioResponsavel (String responsavel){

        String cpf = usuarioCpf();

        for (String i : listUsuarioMap.keySet()){

            if(i.equals(cpf)){

                responsavel = input.nextLine();
                listUsuarioMap.get(i).responsavel = responsavel;
            }

        }

        for (String i : listUsuarioProfissionalMap.keySet()){

            if(i.equals(cpf)){

                responsavel = input.nextLine();
                listUsuarioProfissionalMap.get(i).responsavel = responsavel;
            }

        }

        for (String i : listUsuarioCoordenadorMap.keySet()){

            if(i.equals(cpf)){

                responsavel = input.nextLine();
                listUsuarioCoordenadorMap.get(i).responsavel = responsavel;
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

    



}
