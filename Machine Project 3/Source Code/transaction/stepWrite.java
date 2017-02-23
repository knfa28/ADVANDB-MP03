package transaction;

public class stepWrite implements TranStep{
    
    Transaction t;
    String item;

    public stepWrite(Transaction t, String item) {
        this.t = t;
        this.item = item;
    }
    
    
    @Override
    public void execute() {
       //do something :))
    }
    
    @Override
     public String toString(){
        return "w( "+item+" )";
    }
    
}
