public class Coordenador extends User{

    private String coordenador;
    
    public Coordenador (String nome, String tipo, String cpf,int idProjeto, int idAtividade, String responsavel, String coordenador){
        super(nome, tipo, cpf, idProjeto, idAtividade, responsavel);
        this.coordenador = coordenador;
    }
    
    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    
}
