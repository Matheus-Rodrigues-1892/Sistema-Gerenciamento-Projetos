import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class MenuPrincipal extends User{
    
    HashMap<String, User> listUsuarioMap = new HashMap<>();
    HashMap<String, Profissional> listUsuarioProfissionalMap = new HashMap<>();
    HashMap<String, Coordenador> listUsuarioCoordenadorMap = new HashMap<>();
    
    ArrayList<Project> listProject = new ArrayList<Project>();
    ArrayList<Activities> listActivities = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    public void menu() {
        
        Boolean condicao = true;
        
        while (condicao) {
            
            
            System.out.println("=============================MENU===============================");
            System.out.println("\t0 - SAIR");
            System.out.println ("\t1 - Criar usuário");
            System.out.println("\t2 - Remover informações de usuários");
            System.out.println("\t3 - Editar informações de usuários");
            System.out.println("\t4 - Criar projeto");
            System.out.println("\t5 - Remover informações de projeto");
            System.out.println("\t6 - Editar informações de projeto");
            System.out.println("\t7 - Consultas");
            System.out.println("\t8 - Relatório de atividades e projetos");
            System.out.println("===============================================================");
            
            int opcao = input.nextInt();

            switch (opcao){

                case 0:

                    System.out.println("=================================\n\tObrigado por usar o sistema!=============================");
                    condicao = false;
                    break;
                case 1:
                    
                    criar();
                    break;

                case 2: 
                    remover();
                    break;
                
                case 3:
                    editar();
                    break;
                
                case 4:
                    int p = geraId();
                    Project projeto = new Project(p, null, null, null, null, null, null, null);
                    listProject.add(projeto);
                    //System.out.println(listProject.get(opcao));
                    projeto.createProject(listUsuarioMap, listUsuarioProfissionalMap, listUsuarioCoordenadorMap,listProject, p);
                    
                    break;

                case 5:
                    //projeto.geraId();
                    //projeto.removerProjeto(projeto.getId());
                    break;

                case 6:
                    //projeto.geraId();
                   //projeto.editarProjects(projeto.getId());
                    break;

                case 7:

                    relatorioUsuarios();
                    //projeto.toString();
                    break;

                default:
                    System.out.println("ERRO!");
                    break;
            }
        }
    }

    private int geraId() {

        System.out.println("Digite o número de identificação");
        return input.nextInt();
    }

    private void monitorarUsuario() throws NumberFormatException{

        menu();
    }

    private void criar (){

        monitorarUsuario();


        if (tipo.equals("Professor") || tipo.equals("Pesquisador")){
                        
            Coordenador coordenador = new Coordenador(nome, tipo, cpf, 0000, 0000, 0000);

            listUsuarioCoordenadorMap.put(cpf, coordenador);

        } else if (tipo.equals("Desenvolvedor") || tipo.equals("Testador") || tipo.equals("Analista")){

            Profissional profissional = new Profissional(nome, tipo, cpf, 0000, 0000, 0.00, 0000, 0000);
            listUsuarioProfissionalMap.put(cpf, profissional);

        } else {

            User usuario = new User(nome, tipo, cpf, 0000, 0000, 0000);
            listUsuarioMap.put(cpf, usuario);
        }

        System.out.println("Usuário criado com sucesso!\n");

    }

    private void remover() {

        cpf = usuarioCpf();

            System.out.println(listUsuarioMap.get(cpf));

            for (String i : listUsuarioMap.keySet()){

                if(i.equals(cpf)) removeUser(listUsuarioMap.get(i));

            }


            for (String i : listUsuarioProfissionalMap.keySet()){

                if(i.equals(cpf)) removeUser(listUsuarioProfissionalMap.get(i));

            }


            for (String i : listUsuarioCoordenadorMap.keySet()){

                if(i.equals(cpf)) removeUser(listUsuarioCoordenadorMap.get(i));

            }

            System.out.println("Informação removida com sucesso!\n");


    }

    private void editar() {

        cpf = usuarioCpf();

            System.out.println(listUsuarioMap.get(cpf));

            for (String i : listUsuarioMap.keySet()){

                if(i.equals(cpf)) editUsers(listUsuarioMap.get(i));

            }


            for (String i : listUsuarioProfissionalMap.keySet()){

                if(i.equals(cpf)) editProfissionais(listUsuarioProfissionalMap.get(i));

            }


            for (String i : listUsuarioCoordenadorMap.keySet()){

                if(i.equals(cpf)) editUsers(listUsuarioCoordenadorMap.get(i));

            }

            System.out.println("Informação editada com sucesso!\n");

    }
    
    public void editProfissionais(Profissional profissional) {

        System.out.println("------- EDITAR INFO PROFISSIONAIS ----------");
        menuProfissionais();
        int opcao = input.nextInt();

        switch (opcao) {
            case 1:
                nome = usuarioNome();
                profissional.nome = nome;
                break;
            
            case 2:
                cpf = usuarioCpf();
                profissional.cpf = cpf;
                break;

            case 3:
                tipo = usuarioTipo();
                profissional.tipo = tipo;
                break;
            case 4:
                profissional.bolsa = bolsaProfissional();
                break;
            case 5: 
                profissional.prazo = prazoBolsa();
                break;

            default:
                System.out.println("Usuário não encontrado.");
                break;
                
        }
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

            case 4:
                profissional.bolsa = 0;
                break;
            case 5: 
                profissional.prazo = 0;
                break;

            default:
                System.out.println("Usuário não encontrado.");
                break;
        }

    }


    private void relatorioUsuarios(){

        for (String i : listUsuarioMap.keySet()){

            System.out.println("NOME: " + listUsuarioMap.get(i).nome + " TIPO: " + listUsuarioMap.get(i).tipo);
        }

        for (String i : listUsuarioProfissionalMap.keySet()){
            
            System.out.println("NOME: " + listUsuarioProfissionalMap.get(i).nome + " TIPO: " + listUsuarioProfissionalMap.get(i).tipo);
        }

        for (String i : listUsuarioCoordenadorMap.keySet()){
        
            System.out.println("NOME: " + listUsuarioCoordenadorMap.get(i).nome + " TIPO: " + listUsuarioCoordenadorMap.get(i).tipo);
        }

    }

    private void relatorioProjetos(){
        for(int i = 0; i < listProject.size(); i++){

            System.out.println("ID: " + listProject.get(i).idProjeto);
            System.out.println("ID: " + listProject.get(i).idProjeto);

        }
    }

    protected void listaCoordenadores() {
        for (String i : listUsuarioCoordenadorMap.keySet()){

            System.out.println("NOME: " + listUsuarioCoordenadorMap.get(i).nome + "CPF: " + listUsuarioCoordenadorMap.get(i).cpf + "TIPO: " + listUsuarioCoordenadorMap.get(i).tipo);

        }
    }
}


                    
    
    
           
    

