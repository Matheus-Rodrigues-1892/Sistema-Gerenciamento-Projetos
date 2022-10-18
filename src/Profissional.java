public class Profissional extends User{

    private double bolsa;
    private int prazo;
    String tarefa;

    public Profissional(String nome, String tipo, String cpf, int idProjeto, int idAtividade, double bolsa, int prazo, int responsavel) {
        
        super(nome, tipo, cpf, idProjeto, idAtividade, responsavel);
        this.bolsa = bolsa;
        this.prazo = prazo;
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

    @Override
    protected void removeUser(User profissional) {

        System.out.println("------- REMOVER INFO PROFISSIONAL ----------");
        menuUsers();
        int opcao = input.nextInt();

        switch (opcao) {
            case 1:
                profissional.nome = null;
                break;
            
            case 2:
                profissional.cpf = null;
                break;

            case 3:
                profissional.tipo = null;
                break;

            default:
                System.out.println("Usuário não encontrado.");
                break;
        }

    }

   

}
