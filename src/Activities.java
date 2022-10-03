import java.util.*;

public class Activities extends Info {
    private int idAtividade;
    private String responsavel;
    Info infoAtividade = new Info();
    ArrayList<Activities> listActivities = new ArrayList<>();
    ArrayList<String> listTarefas = new ArrayList<>();

    Scanner input = new Scanner(System.in);
    private int idProjeto;


    public Activities() {
    }

    public Activities(int idAtividade, int idProjeto, String descricao, String responsavel, String dataInicial, String dataFinal, String horaInicial, String horaFinal, ArrayList<Profissionais> listProfissionais) {

        super(idProjeto, descricao, dataInicial, dataFinal, horaInicial, horaFinal, listProfissionais);
        this.idAtividade = idAtividade;
        this.responsavel = responsavel;
    }

    public ArrayList<Activities> createActivities (int idProjeto) {

        geraId();

        Boolean condicao = true;

        while (condicao) {

            infoAtividade();
    
            int opcao = input.nextInt();
            if(opcao == 0) {
                condicao = false;
                break;
            } else if (opcao == 1) {

                descricao();

            } else if (opcao == 2) {
                
                dataInicial(); 
                horaInicial();
                

            } else if (opcao == 3) {

                dataFinal();
                horaFinal();
                
            } else if (opcao == 4) {
                
                responsavel = responsavelAtividade();
    
            } else if (opcao == 5) {

                geraId();
                idAtividade = getId();
                profissionaisEnvolvidos(idAtividade);
    
            } 

            
        }
        Activities activities = new Activities(infoAtividade.getId(), idProjeto, infoAtividade.getDescricao(), responsavel, infoAtividade.getDataInicial(), infoAtividade.getDataFinal(), infoAtividade.getHoraInicial(), infoAtividade.getHoraFinal(), infoAtividade.getProfissional());

        listActivities.add(activities);

        return listActivities;
    }

    private String responsavelAtividade() {
        
        System.out.println("Insira o responsável: ");
        return responsavel = input.nextLine();
    }

    public ArrayList<Activities> editarAcitivities(int idProjeto) {

        for (int j = 0; j < listActivities.size(); j++){

            if (listActivities.get(j).idProjeto == idProjeto){

                Boolean condicao = true;

                while (condicao) {

                    System.out.println("----------EDIÇÃO---------");
                    System.out.println("\t1 - ID");

                    infoAtividade();
            
                    int opcao = input.nextInt();
                    if(opcao == 0) {
                        condicao = false;
                        break;
                    } else if (opcao == 2) {

                        descricao();

                        listActivities.get(j).descricao = infoAtividade.getDescricao();

                    } else if (opcao == 2) {
                        
                        dataInicial(); 
                        horaInicial();

                        listActivities.get(j).dataInicial = infoAtividade.getDataInicial();
                        listActivities.get(j).horaInicial = infoAtividade.getHoraInicial();
                        

                    } else if (opcao == 3) {

                        dataFinal();
                        horaFinal();

                        listActivities.get(j).dataFinal = infoAtividade.getDataFinal();
                        listActivities.get(j).horaFinal = infoAtividade.getHoraFinal();
                        
                    } else if (opcao == 4) {
                        
                        responsavel = responsavelAtividade();

                        listActivities.get(j).responsavel = responsavel;
            
                    } else if (opcao == 5) {

                        geraId();
                        idAtividade = getId();
                        listActivities.get(j).listProfissionais = editProfissionaisEnvolvidos(idAtividade);
                    
                    } 

                }

            }
        }

        return listActivities;
    }

    public ArrayList<Activities> removeActivities(int idProjeto) {
        for (int j = 0; j < listActivities.size(); j++){

            if (listActivities.get(j).idProjeto == idProjeto){

                Boolean condicao = true;

                while (condicao) {

                    System.out.println("----------REMOÇÃO---------");
                    System.out.println("\t1 - ID");

                    infoAtividade();
            
                    int opcao = input.nextInt();
                    if(opcao == 0) {
                        condicao = false;
                        break;
                    } else if (opcao == 2) {

                        listActivities.get(j).descricao = null;

                    } else if (opcao == 2) {
                        
                        listActivities.get(j).dataInicial = null;
                        listActivities.get(j).horaInicial = null;
                        

                    } else if (opcao == 3) {

                        listActivities.get(j).dataFinal = null;
                        listActivities.get(j).horaFinal = null;
                        
                    } else if (opcao == 4) {
                        
                        responsavel = null;

                        listActivities.get(j).responsavel = responsavel;
            
                    } else if (opcao == 5) {

                        geraId();
                        idAtividade = getId();
                        listActivities.get(j).listProfissionais = removeProfissionaisEnvolvidos(idAtividade);        
                    } 

                }

            }
        }

        return listActivities;
    }
    
}

