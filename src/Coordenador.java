public class Coordenador extends User{

    private String coordenador;
    
    public Coordenador (String nome, String tipo, String cpf,int idProjeto, int idAtividade, int responsavel){
        super(nome, tipo, cpf, idProjeto, idAtividade, responsavel);
    }
    
    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }
    @Override
    protected void removeUser(User coordenador) {

        System.out.println("------- REMOVER INFO COORDENADOR ----------");
        menuUsers();
        int opcao = input.nextInt();

        switch (opcao) {
            case 1:
                coordenador.nome = null;
                break;
            
            case 2:
                coordenador.cpf = null;
                break;

            case 3:
                coordenador.tipo = null;
                break;

            default:
                System.out.println("Usuário não encontrado.");
                break;
        }

    }

    
}
