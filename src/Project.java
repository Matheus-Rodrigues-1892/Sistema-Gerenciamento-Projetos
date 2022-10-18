
import java.util.*;
public class Project extends Info{
    
    private String status;
    private int idProjeto;
    private int idAtividade;
    private String coordenador;
    Scanner input = new Scanner (System.in);
    
    ArrayList<Activities> listActivities = new ArrayList<>();

    public Project(int idProjeto, String status, String descricao, String dataInicial, String dataFinal,
            String horaInicial, String horaFinal, String coordenador, ArrayList<Activities> listActivities) {

        super(idProjeto, descricao, dataInicial, dataFinal, horaInicial, horaFinal);
        this.status = status;
        this.coordenador = coordenador;
        this.listActivities = listActivities;
    }


    public Project createProject() {


        System.out.println("--------------------CRIAÇÃO--------------------");

        geraId();
        idProjeto = getId();
        System.out.println(idProjeto);

        status = projectStatus("Em processo de criação");

        System.out.println("Atual status: " + status+"\n");

        Boolean condicao = true;

        while (condicao) {

            infoMenu();
    
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

                coordenador = coordenadorProjeto();
    
            } else if (opcao == 5) {

                ProfissionalEnvolvido(idProjeto);

            } 
            else if (opcao == 6) {

                infoMenu(idProjeto);

                opcao = input.nextInt();

                Boolean condicao2 = true;

                while (condicao2) {

                    switch(opcao) {
                        case 0:
                            condicao2 = false;
                            break;
                        case 1:
                            geraId();
                            break;
    
                        case 2:
                            descricao();
                            break;
                        case 3:
                            dataInicial();
                            horaInicial();
                            break;
    
                        case 4:
                            dataFinal();
                            horaFinal();
                            break;
    
                        case 5:
                            setResponsavel(responsavelAtividade());
                            usuarioResponsavel(getResponsavel());
                            break;
    
                        case 6:
                            usuarioEnvolvido(idProjeto, getId());
                            break;
    
                        case 7:
                            adicionarTarefa(getId());
                            
                            break;
    
                        default: 
                            System.out.println("ERRO!");
                            break;
    
                    }
                }


                Activities activities = new Activities(idProjeto, getId(), getDescricao(), getDataInicial(), getDataFinal(), getHoraInicial(), getHoraFinal());

                listActivities.add(activities);
            

            }
        }

        System.out.println("Alterando status do projeto ...");
        status = projectStatus("Em andamento");
        System.out.println("Atual status: " + status);

        Project project = new Project(getId(), status, getDescricao(), getDataInicial(), getDataFinal(), getHoraInicial(), getHoraFinal(), coordenador, listActivities);

        System.out.println("--------------------------------------------------");
        return project;
        
    }


    public String projectStatus(String atualStatus) {

        return atualStatus;
    }

    public void editarProjects() {
        
        Boolean condicao = true;
        
        while (condicao) {
            
            System.out.println("----------EDIÇÃO---------");
            infoMenu();
            int opcao = input.nextInt();
            
            geraId();
            idProjeto = getId();
            int index = indexProjeto(getId());

            if(opcao == 0) {
                condicao = false;
                break;
            } else if (opcao == 1) {
                geraId();
                listProject.get(index).id = getId();

            }
            else if (opcao == 2) {

                descricao();

                listProject.get(index).descricao = getDescricao();

            } else if (opcao == 2) {
                
                dataInicial(); 
                horaInicial();

                listProject.get(index).dataInicial = getDataInicial();  
                listProject.get(index).horaInicial = getHoraInicial();              

            } else if (opcao == 3) {

                dataFinal();
                horaInicial();

                listProject.get(index).dataFinal = getDataFinal();  
                listProject.get(index).horaFinal = getHoraFinal();
                
            } else if (opcao == 4) {
                
                listProject.get(index).coordenador = coordenadorProjeto();
    
            } else if (opcao == 5) {

                ProfissionalEnvolvido(idProjeto);
    
            } 
            else if (opcao == 6) {

                geraId();
                idAtividade = getId();
                int indexAtv = indexAtividade(getId());

                infoMenu(idProjeto);

                opcao = input.nextInt();

                Boolean condicao2 = true;

                while (condicao2) {

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
                            setResponsavel(responsavelAtividade());

                            listActivities.get(indexAtv).responsavel = getResponsavel();
                            
                            break;
    
                        case 6:
                            ProfissionalEnvolvidoAtividade(idProjeto, getId());
                            break;
    
                        case 7:
                            editarTarefa(getId());
                            
                            break;
    
                        default: 
                            System.out.println("ERRO!");
                            break;
    
                    }
                }

            }

        }



    }

    private int indexProjeto(int id) {

        for (int i = 0; i < listProject.size(); i++){

            if(listProject.get(i).idProjeto == id){

                return i;
            }
        }
        return 0;
    }

    private int indexAtividade(int id){

        for (int i = 0; i < listActivities.size(); i++){

            if(listActivities.get(i).idAtividade == id){

                return i;
            }
        }
        return 0;

    }
    @Override
    public void ProfissionalEnvolvido(int idProjeto) {

        Profissional profissional = new Profissional();

        String cpf = profissional.usuarioCpf();

        for (String i : listUsuarioProfissionalMap.keySet()){

            if(i.equals(cpf)){
                listUsuarioProfissionalMap.get(i).idProjeto = idProjeto;
            }

        }
    }

    public void removerProjeto() {

        Boolean condicao = true;
        
        while (condicao) {
            
            System.out.println("---------REMOÇÃO---------");
            infoMenu();
            int opcao = input.nextInt();
            
            geraId();
            idProjeto = getId();
            int index = indexProjeto(getId());

            if(opcao == 0) {

                condicao = false;
                break;

            } else if (opcao == 1) {

                listProject.remove(index);
                System.out.println("Projeto removido");
                condicao = false;
                break;

            }
            else if (opcao == 2) {

                listProject.get(index).descricao = null;

            } else if (opcao == 2) {
                
                listProject.get(index).dataInicial = null;  
                listProject.get(index).horaInicial = null;              

            } else if (opcao == 3) {


                listProject.get(index).dataFinal = null;  
                listProject.get(index).horaFinal = null;
                
            } else if (opcao == 4) {
                
                listProject.get(index).coordenador = null;
    
            } else if (opcao == 5) {

                ProfissionalRemocao(idProjeto);
    
            } 
            else if (opcao == 6) {

                geraId();
                idAtividade = getId();
                int indexAtv = indexAtividade(getId());

                infoMenu(idProjeto);

                opcao = input.nextInt();

                Boolean condicao2 = true;

                while (condicao2) {

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
                            ProfissionalRemocaoAtividade(idProjeto, getId());
                            break;
    
                        case 7:
                            removerTarefa(getId());
                            break;
    
                        default: 
                            System.out.println("ERRO!");
                            break;
    
                    }
                }

            }

        }
    }

    @Override
    public String toString() {

        for(int i = 0; i < listProject.size(); i++){

            System.out.println("ID Projeto: " + listProject.get(i).idProjeto);
            System.out.println("Descrição: " + listProject.get(i));

            for(int j = 0; j < listActivities.size(); j++){
                if (listActivities.get(j).idProjeto == listProject.get(i).idProjeto){

                    System.out.println("ID Atividade: " + listActivities.get(j).idAtividade);
                    System.out.println("Descrição: " + listActivities.get(j));
                    toString(idAtividade);

                }
            }

        }

        return null;

    }



}
