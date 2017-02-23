package transaction;

import managers.LockManager;

public class stepReadLock implements TranStep{
    
    Transaction t;
    String item;

    public stepReadLock(Transaction t, String item) {
        this.t = t;
        this.item = item;
    }

    @Override
    public void execute() {
        LockManager.instance().readLock(item, t);
        
    }
    
    @Override
    public String toString(){
         return "rl( "+item+" )";
    }
    
}
