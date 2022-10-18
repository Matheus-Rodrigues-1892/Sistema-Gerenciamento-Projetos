import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class MenuPrincipal extends User{
    
    HashMap<String, User> listUsuarioMap = new HashMap<>();
    HashMap<String, Profissional> listUsuarioProfissionalMap = new HashMap<>();
    HashMap<String, Coordenador> listUsuarioCoordenadorMap = new HashMap<>();
    Project projeto;
    ArrayList<Project> listProject = new ArrayList<Project>();
    Scanner input = new Scanner(System.in);

    public void menu() {
        
        Boolean condicao = true;
        
        while (condicao) {
            
            
            System.out.println("=============================MENU===============================");
            System.out.println("\t0 - Sair");
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

                    System.out.println("=================================\n\tObrigado por usar o sistema!");
                    condicao = false;
                    break;
                case 1:
                    nome = usuarioNome();
                    setNome(nome);
                    cpf = usuarioCpf();
                    setCpf(cpf);
                    tipo = usuarioTipo();
                    setTipo(tipo);


                    if (tipo.equals("Professor") || tipo.equals("Pesquisador")){
                        
                        Coordenador coordenador = new Coordenador(nome, tipo, cpf, 0000, 0000, null, null);

                        listUsuarioCoordenadorMap.put(cpf, coordenador);

                    } else if (tipo.equals("Desenvolvedor") || tipo.equals("Testador") || tipo.equals("Analista")){

                        Profissional profissional = new Profissional(nome, tipo, cpf, 0000, 0000, 0.00, 0000, null, null);
                        listUsuarioProfissionalMap.put(cpf, profissional);
                    } else {

                        User usuario = new User(nome, tipo, cpf, 0000, 0000, null);

                        listUsuarioMap.put(cpf, usuario);
                    }


                    System.out.println("Usuário adicionado com sucesso!\n");
                    break;

                case 2: 

                    cpf = usuarioCpf();

                    for (String i : listUsuarioMap.keySet()){

                        if(i.equals(cpf)){
                            removeUser(listUsuarioMap.get(i));
                        }

                    }

                    break;

                case 3:

                    cpf = usuarioCpf();

                    for (String i : listUsuarioMap.keySet()){

                        if(i.equals(cpf)){
                            editUsers(listUsuarioMap.get(i));
                        }

                    }

                    break;

                case 4:
                    projeto = new Project(opcao, cpf, cpf, cpf, tipo, responsavel, nome, cpf, null);
                    projeto.createProject();
                    
                    break;

                case 5:
                    projeto.removerProjeto();
                    break;

                case 6:
                    projeto.editarProjects();
                    break;

                case 7:
                    projeto.toString();

                default:
                    System.out.println("ERRO!");
                    break;
            }
        }
    }
}


                    
    
    
           
    

