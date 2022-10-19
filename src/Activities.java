import java.util.ArrayList;
import java.util.HashMap;

public class Activities extends Info{


    public Activities(int idProjeto, int idAtividade, String descricao, String dataInicial, String dataFinal, String horaInicial,
            String horaFinal) {

        
        super(idProjeto, descricao, dataInicial, dataFinal, horaInicial, horaFinal);
        this.idAtividade = idAtividade;
    }


    public void criarActivities(HashMap<String, User> listUsuarioMap, HashMap<String, Profissional> listUsuarioProfissionalMap, HashMap<String, Coordenador> listUsuarioCoordenadorMap, ArrayList<Project> listProject, ArrayList<Activities> listActivities, int idProjeto, int idAtividade) {

        Boolean condicao2 = true;

        while (condicao2) {
                    
            int indexAtv = indexAtividade(idAtividade);
            infoMenu(idProjeto);
            int opcao = input.nextInt();

            switch(opcao) {
                case 0:
                    condicao2 = false;
                    break;
                case 1:
                    geraId();
                    listActivities.get(indexAtv).idAtividade = getId();
                    break;

                case 2:
                    descricao();
                    listActivities.get(indexAtv).descricao = getDescricao();
                    break;

                case 3:
                    dataInicial();
                    horaInicial();
                    listActivities.get(indexAtv).dataInicial = getDataInicial();
                    listActivities.get(indexAtv).horaInicial = getHoraInicial();

                    break;

                case 4:
                    dataFinal();
                    horaFinal();
                    listActivities.get(indexAtv).dataFinal = getDataFinal();
                    listActivities.get(indexAtv).horaFinal = getHoraFinal();

                    break;

                case 5:
                    responsavelAtividade(idAtividade);
                    
                    break;

                case 6:
                    profissionalEnvolvidoAtividade(listUsuarioProfissionalMap, idProjeto, getId());
                    break;

                case 7:

                    usuarioEnvolvido(listUsuarioMap, listUsuarioProfissionalMap, listUsuarioCoordenadorMap, idProjeto, idAtividade);
                    
                    break;

                default: 
                    System.out.println("ERRO!");
                    break;

            }
        }
    }

    public void removeActivities(HashMap<String, User> listUsuarioMap, HashMap<String, Profissional> listUsuarioProfissionalMap, HashMap<String, Coordenador> listUsuarioCoordenadorMap, ArrayList<Project> listProject, ArrayList<Activities> listActivities, int idProjeto, int idAtividade) {

        
        int indexAtv = indexAtividade(idAtividade);

                
        Boolean condicao2 = true;
                
        while (condicao2) {
            infoMenu(idProjeto);
            
            int opcao = input.nextInt();

            switch(opcao) {
                case 0:
                    condicao2 = false;
                    break;
                case 1:
                    geraId();
                    listActivities.remove(indexAtv);
                    System.out.println("Atividade removida!");
                    break;
    
                case 2:
                    listActivities.get(indexAtv).descricao = null;
                    break;

                case 3:

                    listActivities.get(indexAtv).dataInicial = null;
                    listActivities.get(indexAtv).horaInicial = null;

                    break;
    
                case 4:

                    listActivities.get(indexAtv).dataFinal = null;
                    listActivities.get(indexAtv).horaFinal = null;

                    break;
    
                case 5:

                    listActivities.get(indexAtv).responsavel = null;
                            
                    break;
    
                case 6:
                    profissionalRemocaoAtividade(listUsuarioProfissionalMap, idProjeto,idAtividade);
                    break;
    
                case 7:
                    usuarioEnvolvidoRemocao(listUsuarioMap, listUsuarioProfissionalMap, listUsuarioCoordenadorMap, idProjeto, idAtividade);
                    break;
    
                default: 
                    System.out.println("ERRO!");
                    break;

            }
    
                    
                
        }
    }

    private int indexAtividade(int id){

        for (int i = 0; i < listActivities.size(); i++){

            if(listActivities.get(i).idAtividade == id){

                return i;
            }
        }
        return 0;

    }

    
    
}
