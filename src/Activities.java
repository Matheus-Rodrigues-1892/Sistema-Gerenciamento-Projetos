import java.util.ArrayList;

public class Activities extends Info{


    public Activities(int idProjeto, int idAtividade, String descricao, String dataInicial, String dataFinal, String horaInicial,
            String horaFinal) {

        
        super(idProjeto, descricao, dataInicial, dataFinal, horaInicial, horaFinal);
        this.idAtividade = idAtividade;
    }


    public ArrayList<Activities> removeActivities(int idProjeto) {
        return null;
    }

    public ArrayList<Activities> editarAcitivities(int idProjeto) {
        return null;
    }

    
    
}
