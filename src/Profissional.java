public class Profissional extends User{

    private double bolsa;
    private int prazo;
    String tarefa;

    public Profissional(String nome, String tipo, String cpf, int idProjeto, int idAtividade, double bolsa, int prazo, String responsavel, String tarefa) {
        
        super(nome, tipo, cpf, idProjeto, idAtividade, responsavel);
        this.bolsa = bolsa;
        this.prazo = prazo;
        this.tarefa = tarefa;
    }

    public Profissional() {
    }

    public double getBolsa() {
        return bolsa;
    }

    public void setBolsa(double bolsa) {
        this.bolsa = bolsa;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

   

}
