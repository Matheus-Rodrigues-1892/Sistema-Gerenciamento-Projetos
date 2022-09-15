import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Activities {
    private int idAtividade;
    private int idProjeto;
    private String descricao;
    private String tarefa;
    private String responsavel;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String horaInicial;
    private String horaFinal;

    User usuarioAlocado = new User ();
    ArrayList<Activities> listAtividades = new ArrayList<>();
    ArrayList<User> listUsuariosAlocados = new ArrayList<>();


    public Activities() {
    }

    public Activities(int idAtividade, String descricao, String tarefa, String responsavel, LocalDate dataInicial, LocalDate dataFinal, String horaInicial, String horaFinal, int idProjeto) {

        this.idAtividade = idAtividade;
        this.descricao = descricao;
        this.tarefa = tarefa;
        this.responsavel = responsavel;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.idProjeto = idProjeto;
    }

    
    
    public int activitiesIdAtividade() {
        Scanner input = new Scanner(System.in);

        System.out.println("\tDigite o número de identificação da atividade: ");
        idAtividade = input.nextInt();

        //input.close();

        return idAtividade;
    }

    public String activitiesDescricao() {

        Scanner input = new Scanner(System.in);

        System.out.println("\tInsira a descrição: ");
        descricao = input.nextLine();

        //input.close();

        return descricao;
    }

    public LocalDate activitiesDataInicial() {

        Scanner input = new Scanner(System.in);

        System.out.println("\tInsira a data inicial no seguinte formato dd/mm/aaaa: ");
        String data = input.nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate dataInicialFormatada = LocalDate.parse(data, formato);    

        //input.close();

        return dataInicialFormatada;
    }

    public LocalDate activitiesDataFinal() {

        Scanner input = new Scanner(System.in);

        System.out.println("\tInsira a data final no seguinte formato dd/mm/aaaa: ");
        String data = input.nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate dataFinalFormatada = LocalDate.parse(data, formato);    

        //input.close();

        return dataFinalFormatada;
    }

    public String activitiesHoraInicial() {

        Scanner input = new Scanner(System.in);

        System.out.println("\tInsira a hora inicial no formato 24h ");
        horaInicial = input.nextLine();

        //input.close();

        return horaInicial;
    }

    public String activitiesHoraFinal() {

        Scanner input = new Scanner(System.in);

        System.out.println("\tInsira a hora final no formato 24h ");
        horaFinal = input.nextLine();

        //input.close();

        return horaFinal;
    }
    

    public void createActivities(int idProjeto) {

        Scanner input = new Scanner(System.in);
    
        System.out.println("--------------------ATIVIDADE--------------------");

        idAtividade = activitiesIdAtividade();

        Boolean condicao = true;

        while (condicao) {

            System.out.println("Qual operação será realizada agora?");
            System.out.println("\t0 - Sair");
            System.out.println("\t1 - Adicionar descrição");
            System.out.println("\t2 - Adicionar data inicial e hora inicial");
            System.out.println("\t3 - Alocar membros");
            System.out.println("\t4 - Adicionar tarefas");
            System.out.println("\t5 - Adicionar data final e hora final");
            System.out.println("\t6 - Adicionar responsável");


            int opcao = input.nextInt();
            if(opcao == 0) {
                condicao = false;
                break;
            } else if (opcao == 1) {

                descricao = activitiesDescricao();
            } else if (opcao == 2) {
                
                dataInicial = activitiesDataInicial();
                horaInicial = activitiesHoraInicial();
            } else if (opcao == 3) {

                usuarioAlocado.mostrarAllUsers();
    
                String nomeUsuario = usuarioAlocado.usuarioNome();
                String cpf = usuarioAlocado.usuarioCpf();
                idAtividade = activitiesIdAtividade();

                usuarioAlocado.alocarUsuario(nomeUsuario, cpf, idAtividade);

    
            } else if (opcao == 4) {
                tarefa = activitiesTarefa();
            }
            
            else if (opcao == 5) {
                
                dataFinal = activitiesDataFinal();
                horaFinal = activitiesHoraFinal();
    
            } else if (opcao == 6) {

                String nomeUsuario = usuarioAlocado.usuarioNome();
                String cpf = usuarioAlocado.usuarioCpf();
                responsavel = usuarioAlocado.fornecerUsers(nomeUsuario, cpf);

                
            } else
                descricao = null;
                responsavel = null;
                tarefa = null;
                dataInicial = null;
                dataFinal = null;
                horaInicial = null;
                horaFinal = null;
    
            }
            Activities activities = new Activities(idAtividade, descricao, tarefa, responsavel, dataInicial, dataFinal, horaInicial, horaFinal, idProjeto);
    
            listAtividades.add(activities);

        //input.close();
        
    }

    public void alocarUsuario(String nome, String tipo, String cpf, int idAtividade, int idProjeto) {

        Scanner input = new Scanner (System.in);

        usuarioAlocado = new User(nome, tipo, cpf, idProjeto, idAtividade);
        listUsuariosAlocados.add(usuarioAlocado);

        //input.close();

    }

    public String activitiesTarefa() {

        Scanner input = new Scanner (System.in);
        System.out.println("Digite a tarefa:");
        String tarefa = input.nextLine();

        //input.close();

        return tarefa;


    }

    public void mostrarAtividades(int idProjeto, int idAtividade) {

        for (int i = 0; i < listAtividades.size(); i++) {

            if (idProjeto == listAtividades.get(i).idProjeto) {
                System.out.println("Descrição Atividade" + listAtividades.get(i).descricao);
            }
        }
    }

    public void removeActivities(int idAtividade) {
        
        for (int i = 0; i < listAtividades.size(); i++) {
            
            if (idAtividade == listAtividades.get(i).idAtividade) {
                Scanner input = new Scanner(System.in);

                System.out.println("Qual operação será removida agora?");
                System.out.println("\t1 - Remover descrição");
                System.out.println("\t2 - Remover data inicial e hora inicial");
                System.out.println("\t3 - Remover membros");
                System.out.println("\t4 - Remover tarefas");
                System.out.println("\t5 - Remover data final e hora final");
                System.out.println("\t6 - Remover responsável");
    
    
                int opcao = input.nextInt();
            
                if (opcao == 1) {
    
                    listAtividades.get(i).descricao = null;
                } else if (opcao == 2) {
                    
                    listAtividades.get(i).dataInicial = null;
                    listAtividades.get(i).horaInicial = null;
                } else if (opcao == 3) {
    
                    usuarioAlocado.mostrarAllUsers();
        
                    String nomeUsuario = usuarioAlocado.usuarioNome();
                    String cpf = usuarioAlocado.usuarioCpf();
                    //usuarioAlocado.removeUsers(nomeUsuario, cpf);
                    listUsuariosAlocados.get(i).removeUsersAlocados(nomeUsuario, cpf, idAtividade);
    
        
                } else if (opcao == 4) {

                    listAtividades.get(i).tarefa = null;

                } else if (opcao == 5) {
                    
                    listAtividades.get(i).dataFinal = null;
                    listAtividades.get(i).horaFinal = null;
        
                } else if (opcao == 6) {
                    listAtividades.get(i).responsavel = null;
                }
                //input.close();
        
            
            } else {
                System.out.println("Atividade não encontrada!");
            }
        }

    }

    public void editActivities(int idAtividade) {

        for (int i = 0; i < listAtividades.size(); i++) {
            
            if (idAtividade == listAtividades.get(i).idAtividade) {
                Scanner input = new Scanner(System.in);

                System.out.println("Qual operação será editada agora?");
                System.out.println("\t1 - Editar descrição");
                System.out.println("\t2 - Editar data inicial e hora inicial");
                System.out.println("\t3 - Editar membros");
                System.out.println("\t4 - Editar tarefas");
                System.out.println("\t5 - Editar data final e hora final");
                System.out.println("\t6 - Editar responsável");
    
    
                int opcao = input.nextInt();
            
                if (opcao == 1) {
                    descricao = activitiesDescricao();
                    listAtividades.get(i).descricao = descricao;

                } else if (opcao == 2) {
                    
                    dataInicial = activitiesDataInicial();
                    horaInicial = activitiesHoraInicial();
                    listAtividades.get(i).dataInicial = dataInicial;
                    listAtividades.get(i).horaInicial = horaInicial;

                } else if (opcao == 3) {
    
                    usuarioAlocado.mostrarAllUsers();
        
                    String nomeUsuario = usuarioAlocado.usuarioNome();
                    String cpf = usuarioAlocado.usuarioCpf();
                    listUsuariosAlocados.get(i).editUsers(nomeUsuario, cpf);
    
        
                } else if (opcao == 4) {

                    tarefa = activitiesTarefa();
                    listAtividades.get(i).tarefa = tarefa;

                } else if (opcao == 5) {
                    
                    dataFinal = activitiesDataFinal();
                    horaFinal = activitiesHoraFinal();
                    listAtividades.get(i).dataFinal = dataFinal;
                    listAtividades.get(i).horaFinal = horaInicial;
        
                } else if (opcao == 6) {

                    String nomeUsuario = usuarioAlocado.usuarioNome();
                    String cpf = usuarioAlocado.usuarioCpf();
                    responsavel = usuarioAlocado.fornecerUsers(nomeUsuario, cpf);
                }
                //input.close();
        
            
            } else {
                System.out.println("Atividade não encontrada!");
            }
        }
    }

    
}
