package transaction;

import managers.LockManager;

public class stepUnlock implements TranStep{
    Transaction t;
    String item;

    public stepUnlock(Transaction t, String item) {
        this.t = t;
        this.item = item;
    }
    
    @Override
    public void execute() {
        LockManager.instance().unlock(item, t);
    }
    
    public String toString(){
        return "UNLOCK( "+item+" )";
    }
    
}
