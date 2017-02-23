package transaction;

public class stepCommit implements TranStep{
    
    Transaction t;
    @Override
    
    
    public void execute() {
        t.commit();
    }

    public stepCommit(Transaction t) {
        this.t = t;
    }
    
    @Override
    public String toString(){
        return "COMMIT";
    }
}
