
import java.util.*;
public class Project extends Info{
    
    private String status;
    private int idProjeto;
    private String coordenador;
    Scanner input = new Scanner (System.in);
    
    Info infoProjeto = new Info();
    ArrayList<Activities> listActivities = new ArrayList<>();
    ArrayList<Project> listProjetos = new ArrayList<>();


    public Project(int idProjeto, String status, String descricao, String dataInicial, String dataFinal,
            String horaInicial, String horaFinal, ArrayList<Profissionais> listProfissionais, String coordenador, ArrayList<Activities> listActivities) {

        super(idProjeto, descricao, dataInicial, dataFinal, horaInicial, horaFinal, listProfissionais);
        this.idProjeto = idProjeto;
        this.status = status;
        this.coordenador = coordenador;
        this.listActivities = listActivities;
    }

    public Project() {
    }

    public void createProject() {


        System.out.println("--------------------CRIAÇÃO--------------------");

        input = new Scanner (System.in);
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
                System.out.println(getDescricao());

            } else if (opcao == 2) {
                
                dataInicial(); 
                horaInicial();
                

            } else if (opcao == 3) {

                dataFinal();
                horaInicial();
                
            } else if (opcao == 4) {

                coordenador = coordenadorProjeto();
    
            } else if (opcao == 5) {

                Profissionais profissionais = new Profissionais();
                listProfissionais = profissionais.adicionarProfissional(idProjeto);
    
            } 
            else if (opcao == 6) {

                System.out.println("Insira atividades desenvolvidas nesse projeto:");

                Activities activities = new Activities();

                listActivities = activities.createActivities(idProjeto);

            }
        }

        System.out.println("Alterando status do projeto ...");
        status = projectStatus("Em andamento");
        System.out.println("Atual status: " + status);

        Project project = new Project(getId(), status, getDescricao(), infoProjeto.getDataInicial(), infoProjeto.getDataFinal(), infoProjeto.getHoraInicial(), infoProjeto.getHoraFinal(), listProfissionais, coordenador, listActivities);

        listProjetos.add(project);
        
        System.out.println("--------------------------------------------------");


    }
    
    private String coordenadorProjeto() {

        System.out.println("Insira o coordenador do projeto: ");
        return coordenador = input.nextLine();

    }

    public String projectStatus(String atualStatus) {

        return atualStatus;
    }

    public void editarProjects() {
        
        Boolean condicao = true;
        
        while (condicao) {
            
            System.out.println("----------EDIÇÃO---------");
            System.out.println("\t1 - ID");
            infoMenu();
            System.out.println("Selecione a opção para ser editada: ");
            int opcao = input.nextInt();
            
            geraId();
            int id = infoProjeto.getId();
            int index = indexProjeto(id);

            if(opcao == 0) {
                condicao = false;
                break;
            } else if (opcao == 1) {
                geraId();


            }
            else if (opcao == 2) {

                descricao();

                listProjetos.get(index).descricao = infoProjeto.getDescricao();

            } else if (opcao == 2) {
                
                dataInicial(); 
                horaInicial();

                listProjetos.get(index).dataInicial = infoProjeto.getDataInicial();  
                listProjetos.get(index).horaInicial = infoProjeto.getHoraInicial();              

            } else if (opcao == 3) {

                dataFinal();
                horaInicial();

                listProjetos.get(index).dataFinal = infoProjeto.getDataFinal();  
                listProjetos.get(index).horaFinal = infoProjeto.getHoraFinal();
                
            } else if (opcao == 4) {
                
                coordenador = coordenadorProjeto();

                listProjetos.get(index).coordenador = coordenador;
    
            } else if (opcao == 5) {

                Profissionais profissionais = new Profissionais();
                listProjetos.get(index).listProfissionais = profissionais.editProfissionais();
    
            } 
            else if (opcao == 6) {

                System.out.println("Insira atividades desenvolvidas nesse projeto: ");

                Activities activities = new Activities();

                listActivities = activities.editarAcitivities(idProjeto);

            }

        }



    }

    private int indexProjeto(int id) {

        for (int i = 0; i <listProjetos.size(); i++){

            if(listProjetos.get(i).idProjeto == id){

                return i;
            }
        }
        return 0;
    }

    public void removerProjetos() {

        Boolean condicao = true;
        
        while (condicao) {
            
            System.out.println("----------REMOÇÃO---------");
            System.out.println("\t1 - ID");
            infoMenu();
            System.out.println("Selecione a opção para ser removida:");
            int opcao = input.nextInt();
            
            geraId();
            int id = infoProjeto.getId();
            int index = indexProjeto(id);

            if(opcao == 0) {
                condicao = false;
                break;
            } else if (opcao == 1) {
                geraId();


            }
            else if (opcao == 2) {

                listProjetos.get(index).descricao = null;

            } else if (opcao == 2) {

                listProjetos.get(index).dataInicial = null;  
                listProjetos.get(index).horaInicial = null;              

            } else if (opcao == 3) {

                listProjetos.get(index).dataFinal = null;  
                listProjetos.get(index).horaFinal = null;
                
            } else if (opcao == 4) {

                listProjetos.get(index).coordenador = null;
    
            } else if (opcao == 5) {

                Profissionais profissionais = new Profissionais();
                listProjetos.get(index).listProfissionais = profissionais.removeProfissionais();
    
            } 
            else if (opcao == 6) {

                Activities activities = new Activities();

                listActivities = activities.removeActivities(idProjeto);

            }

        }


    }

    public void printProjetos () {

        Profissionais profissionais = new Profissionais();

        for (int i = 0; i < listProjetos.size(); i++){

            System.out.println("ID: " + idProjeto + listProjetos.get(i).idProjeto + "DESCRIÇÃO: " + listProjetos.get(i).descricao);
            int id = listProjetos.get(i).idProjeto;
            profissionais.printProfissionaisProjetoEnvolvidos(id);
            

        }
        
    }

}
