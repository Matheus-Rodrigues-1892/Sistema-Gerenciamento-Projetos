
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
//import java.text.SimpleDateFormat;



public class Project {

    private String status;
    private int idProjeto;
    private String descricao;
    private String coordenador;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String horaInicial;
    private String horaFinal;

    User usuarioAssociado = new User();
    Activities activities = new Activities();
    ArrayList<Integer> listProjetosCriado = new ArrayList<>();
    ArrayList<Project> listProjetos = new ArrayList<>();
    //ArrayList<Profissionais> listProfissionaisAssociados = new ArrayList<>();


    public Project(String status, int idProjeto, String descricao, LocalDate dataInicial, LocalDate dataFinal,
            String horaInicial, String horaFinal, String coordenador) {
        this.status = status;
        this.idProjeto = idProjeto;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.coordenador = coordenador;
    }

    public Project() {
    }

    public void createProject(String nome) {

        Scanner input = new Scanner (System.in);

        System.out.println("--------------------PROJETO--------------------");

        idProjeto = projectIdProjeto();

        listProjetosCriado.add(idProjeto);

        Boolean check = verificarProjeto(idProjeto);

        if (!check) {
            System.out.println("Projeto já criado, agora você poderá editar ou remover");
            //input.close();
            return;
        }

        status = projectStatus("Em processo de criação");

        System.out.println("Atual status: " + status);

        Boolean condicao = true;

        while (condicao) {

            System.out.println("Qual operação será realizada agora?");
            System.out.println("\t0 - Sair");
            System.out.println("\t1 - Adicionar descrição");
            System.out.println("\t2 - Adicionar data inicial e hora inicial");
            System.out.println("\t3 - Adicionar membros");
            System.out.println("\t4 - Adicionar atividades");
            System.out.println("\t5 - Adicionar data final e hora final");
    
            int opcao = input.nextInt();
            if(opcao == 0) {
                condicao = false;
                break;
            } else if (opcao == 1) {
    
                descricao = projectDescricao();
            } else if (opcao == 2) {
                
                dataInicial = projectDataInicial();
                horaInicial = projectHoraInicial();
            } else if (opcao == 3) {
                
                String nomeUsuario = usuarioAssociado.usuarioNome();
                String cpf = usuarioAssociado.usuarioCpf();
                int idProjeto = projectIdProjeto();
                
                usuarioAssociado.associarUsuarioProjeto(nomeUsuario, cpf, idProjeto);
    
            } else if (opcao == 4) {
                activities.createActivities(idProjeto);
    
            } else if (opcao == 5) {
    
                dataFinal = projectDataFinal();
                horaFinal = projectHoraFinal();
    
            } else {
                descricao = null;
                dataInicial = null;
                dataFinal = null;
                horaInicial = null;
                horaFinal = null;
    
            }
        }

        //input.close();
        
        System.out.println("Alterando status do projeto ...");
        status = projectStatus("Em andamento");
        System.out.println("Atual status: " + status);

        Project project = new Project(status, idProjeto, descricao, dataInicial, dataFinal, horaInicial, horaFinal, nome);

        listProjetos.add(project);
        
        System.out.println("--------------------------------------------------");


    }


    private Boolean verificarProjeto(int idProjeto) {
        for (int i = 1; i < listProjetosCriado.size(); i++) {
            if (listProjetosCriado.get(i) == idProjeto) {
                return false;
            }
        }
        return true;
    }

    public void removeProject(int idProjeto) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < listProjetos.size(); i++) {
            
            if (listProjetos.get(i).idProjeto == idProjeto) {
                
                System.out.println("Qual informação será removida?");
                System.out.println("\t1 - Número de identificação");
                System.out.println("\t2 - Descrição");
                System.out.println("\t3 - Data Inicial");
                System.out.println("\t4 - Data Final");
                System.out.println("\t5 - Hora Inicial");
                System.out.println("\t6 - Hora Inicial");
                System.out.println("\t7 - Membros");
                System.out.println("\t8 - Atividades");

                int opcao = input.nextInt();
                
                if (opcao == 1) {
                    
                    //idProjeto = projectIdProjeto();
                    listProjetos.get(i).idProjeto = 0000;

                } else if (opcao == 2) {

                    listProjetos.get(i).descricao = null;

                } else if (opcao == 3) {

                    listProjetos.get(i).dataInicial = null;

                } else if (opcao == 4) {

                    listProjetos.get(i).dataFinal = null;

                } else if (opcao == 5) {

                    listProjetos.get(i).horaInicial = null;

                } else if (opcao == 6) {

                    listProjetos.get(i).horaFinal = null;

                } else if (opcao == 7) {

                    usuarioAssociado.mostrarAllUsers();
        
                    String nomeUsuario = usuarioAssociado.usuarioNome();
                    String cpf = usuarioAssociado.usuarioCpf();
                    idProjeto = projectIdProjeto();

                    usuarioAssociado.removeProjetosAssociados(nomeUsuario, cpf, idProjeto);
        
                } else if (opcao == 8) {
                    int idAtividade = activities.activitiesIdAtividade();

                    activities.mostrarAtividades(idProjeto, idAtividade);

                    activities.removeActivities(idAtividade);

                }
                
                    
                    System.out.println("Remoção realizada com sucesso!");
                    
            }else {
                System.out.println("Projeto não encontrado.");
                
            }
                
        }

    }

    public void editProject() {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < listProjetos.size(); i++) {
            
            if (listProjetos.get(i).idProjeto == idProjeto) {
                
                System.out.println("Qual informação será editada?");
                System.out.println("\t1 - Número de identificação");
                System.out.println("\t2 - Descrição");
                System.out.println("\t3 - Data Inicial");
                System.out.println("\t4 - Data Final");
                System.out.println("\t5 - Hora Inicial");
                System.out.println("\t6 - Hora Inicial");
                System.out.println("\t7 - Membros");
                System.out.println("\t8 - Atividades");

                int opcao = input.nextInt();
                
                if (opcao == 1) {
                    
                    idProjeto = projectIdProjeto();
                    listProjetos.get(i).idProjeto = idProjeto;

                } else if (opcao == 2) {

                    descricao = projectDescricao();
                    listProjetos.get(i).descricao = descricao;

                } else if (opcao == 3) {

                    dataInicial = projectDataInicial();
                    listProjetos.get(i).dataInicial = null;

                } else if (opcao == 4) {

                    dataFinal = projectDataFinal();
                    listProjetos.get(i).dataFinal = dataFinal;

                } else if (opcao == 5) {

                    horaInicial = projectHoraInicial();
                    listProjetos.get(i).horaInicial = horaInicial;

                } else if (opcao == 6) {

                    horaFinal = projectHoraFinal();
                    listProjetos.get(i).horaFinal = horaFinal;

                } else if (opcao == 7) {

                    usuarioAssociado.mostrarAllUsers();
        
                    String nomeUsuario = usuarioAssociado.usuarioNome();
                    String cpf = usuarioAssociado.usuarioCpf();
                    //int idProjeto = projectIdProjeto();
                    //usuarioAssociado.removeUsers(nomeUsuario, cpf);
                    usuarioAssociado.editUsers(nomeUsuario, cpf);
                } else if (opcao == 8) {

                    int idAtividade = activities.activitiesIdAtividade();
                    activities.mostrarAtividades(idProjeto, idAtividade);
                    activities.editActivities(idAtividade);
                }

                System.out.println("Edição realizada com sucesso!");
                
            } else {
                System.out.println("Projeto não encontrado.");
                
            }
            
        }
    }

    public void mostrarProjetos() {
        for (int i = 0; i < listProjetos.size(); i++) {
            System.out.println("Número de identificação do Projeto: " + listProjetos.get(i).idProjeto + "\n" + "Descricão: " + listProjetos.get(i).descricao + "\n");
            
        }

    }

    public String projectStatus(String atualStatus) {

        return atualStatus;
    }

    public int projectIdProjeto() {

        Scanner input = new Scanner(System.in);

        System.out.println("\tDigite o número de identificação do Projeto: ");
        idProjeto = input.nextInt();
        //input.close();

        return idProjeto;
    }

    public String projectDescricao() {

        Scanner input = new Scanner(System.in);

        System.out.println("\tInsira a descrição: ");
        descricao = input.nextLine();
        //input.close();

        return descricao;
    }

    public LocalDate projectDataInicial() {

        Scanner input = new Scanner(System.in);

        System.out.println("\tInsira a data inicial no seguinte formato dd/mm/aaaa: ");
        String data = input.nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate dataInicialFormatada = LocalDate.parse(data, formato);    

        //input.close();

        return dataInicialFormatada;
    }

    public LocalDate projectDataFinal() {

        Scanner input = new Scanner(System.in);

        System.out.println("\tInsira a data final no seguinte formato dd/mm/aaaa: ");
        String data = input.nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate dataFinalFormatada = LocalDate.parse(data, formato);    

        input.close();

        return dataFinalFormatada;
    }

    public String projectHoraInicial() {

        Scanner input = new Scanner(System.in);

        System.out.println("\tInsira a hora inicial no formato 24h: ");
        horaInicial = input.nextLine();
        //input.close();

        return horaInicial;
    }

    public String projectHoraFinal() {

        Scanner input = new Scanner(System.in);
        
        System.out.println("\tInsira a hora final no formato 24h ");
        horaFinal = input.nextLine();
        //input.close();

        return horaFinal;        
    }

    
}
