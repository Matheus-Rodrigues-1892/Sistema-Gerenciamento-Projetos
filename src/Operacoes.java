import java.util.Stack;

public class Operacoes {
   
    private Stack pilhaUndo;
    private Stack pilhaRedo;
    
    public Stack getPilhaUndo() {
        return pilhaUndo;
    }
    public void setPilhaUndo(Stack pilhaUndo) {
        this.pilhaUndo = pilhaUndo;
    }
    public Stack getPilhaRedo() {
        return pilhaRedo;
    }
    public void setPilhaRedo(Stack pilhaRedo) {
        this.pilhaRedo = pilhaRedo;
    }
    
    
}
