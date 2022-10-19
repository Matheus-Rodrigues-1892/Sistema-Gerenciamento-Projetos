
import java.util.*;
public class Project extends Info{
    
    private String status;
    int idProjeto;
    private int idAtividade;
    Activities activities;
    Scanner input = new Scanner (System.in);

    public Project(int idProjeto, String status, String descricao, String dataInicial, String dataFinal,
            String horaInicial, String horaFinal, ArrayList<Activities> listActivities) {

        super(idProjeto, descricao, dataInicial, dataFinal, horaInicial, horaFinal);
        this.status = status;
        this.listActivities = listActivities;
    }


    public void createProject(HashMap<String, User> listUsuarioMap, HashMap<String, Profissional> listUsuarioProfissionalMapHashMap, HashMap<String, Coordenador> listUsuarioCoordenadorMap, ArrayList<Project> listProject, int idProjeto) {

        System.out.println("--------------------CRIAÇÃO--------------------");

        status = projectStatus("Em processo de criação");

        System.out.println("Atual status: " + status+"\n");

        Boolean condicao = true;

        while (condicao) {

            System.out.println("=====================PROJETO=============");
            System.out.println("\t0 - SAIR");
            System.out.println("\t1 - Descrição");
            System.out.println("\t2 - Data inicial e hora inicial");
            System.out.println("\t3 - Data final e hora final");
            System.out.println("\t4 - Coordenador");
            System.out.println("\t5 - Profissionais envolvidos no projeto");
            System.out.println("\t6 - Atividades");
            System.out.println("\t7 - Alocar usuário");

        
            System.out.println("Insira a operação referente ao menu");
    
            int opcao = input.nextInt();
            int index = indexProjeto(idProjeto);

            if(opcao == 0) {
                condicao = false;
                break;
            } else if (opcao == 1) {

                descricao();
                listProject.get(index).descricao = getDescricao();

            } else if (opcao == 2) {
                
                listProject.get(index).dataInicial = getDataInicial(); 
                listProject.get(index).horaInicial = getHoraInicial();
    
            } else if (opcao == 3) {

                listProject.get(index).dataFinal = getDataFinal(); 
                listProject.get(index).horaFinal = getHoraFinal();
                
            } else if (opcao == 4) {

                coordenadorProjeto(listUsuarioCoordenadorMap, idProjeto);
    
            } else if (opcao == 5) {

                profissionalEnvolvido(listUsuarioProfissionalMap, idProjeto);

            } 
            else if (opcao == 6) {

                geraId();
    
                activities = new Activities(idProjeto, getId(),null, null, null, null, null);
            
                listActivities.add(activities);

                activities.criarActivities(listUsuarioMap, listUsuarioProfissionalMap, listUsuarioCoordenadorMap, listProject, listActivities, idProjeto, getId());

            } else if (opcao == 7){
                usuarioEnvolvido(listUsuarioMap, listUsuarioProfissionalMapHashMap, listUsuarioCoordenadorMap, idProjeto);
            }
        }

        System.out.println("Alterando status do projeto ...");
        status = projectStatus("Em andamento");
        System.out.println("Atual status: " + status);

        System.out.println("Projeto iniciado!!!");

        System.out.println("--------------------------------------------------");

        
    }


    public String projectStatus(String atualStatus) {

        return atualStatus;
    }

    public void editarProjects(HashMap<String, User> listUsuarioMap, HashMap<String, Profissional> listUsuarioProfissionalMap, HashMap<String, Coordenador> listUsuarioCoordenadorMap, ArrayList<Project> listProject, int idProjeto) {
        
        Boolean condicao = true;
        
        while (condicao) {
            
            System.out.println("----------EDIÇÃO---------");
            infoMenu();
            int opcao = input.nextInt();
            int index = indexProjeto(idProjeto);
            

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

            } else if (opcao == 3) {
                
                dataInicial(); 
                horaInicial();

                listProject.get(index).dataInicial = getDataInicial();  
                listProject.get(index).horaInicial = getHoraInicial();              

            } else if (opcao == 4) {

                dataFinal();
                horaInicial();

                listProject.get(index).dataFinal = getDataFinal();  
                listProject.get(index).horaFinal = getHoraFinal();
                
            } else if (opcao == 5) {
                
                coordenadorProjeto(listUsuarioCoordenadorMap, idProjeto);

    
            } else if (opcao == 6) {

                profissionalEnvolvido(listUsuarioProfissionalMap, idProjeto);
    
            } 
            else if (opcao == 7) {
                
                geraId();
                activities.criarActivities(listUsuarioMap, listUsuarioProfissionalMap, listUsuarioCoordenadorMap, listProject, listActivities, idProjeto, getId());

            }

        }



    }

    private int indexProjeto(int idP) {

        for (int i = 0; i < listProject.size(); i++){

            if(listProject.get(i).id == idP){

                return i;
            }
        }
        return 0;
    }

    public void removerProjeto(HashMap<String, User> listUsuarioMap, HashMap<String, Profissional> listUsuarioProfissionalMap, HashMap<String, Coordenador> listUsuarioCoordenadorMap, ArrayList<Project> listProject, int idProjeto) {

        Boolean condicao = true;
        
        while (condicao) {
            
            System.out.println("---------REMOÇÃO---------");
            infoMenu();
            int opcao = input.nextInt();
            int index = indexProjeto(idProjeto);

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

            } else if (opcao == 3) {
                
                listProject.get(index).dataInicial = null;  
                listProject.get(index).horaInicial = null;              

            } else if (opcao == 4) {


                listProject.get(index).dataFinal = null;  
                listProject.get(index).horaFinal = null;
                
            } else if (opcao == 5) {
                
                coordenadorProjetoRemocao(listUsuarioCoordenadorMap, idProjeto);
    
            } else if (opcao == 6) {

                profissionalRemocao(listUsuarioProfissionalMap, idProjeto);
    
            } else if (opcao == 7) {

                geraId();
                activities.removeActivities(listUsuarioMap, listUsuarioProfissionalMap, listUsuarioCoordenadorMap, listProject, listActivities, idProjeto, getId());

            } else if (opcao == 8){

                usuarioEnvolvidoRemocao(listUsuarioMap, listUsuarioProfissionalMap, listUsuarioCoordenadorMap, idProjeto);
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
