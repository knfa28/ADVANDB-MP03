package transaction;

import managers.LockManager;

public class stepWriteLock implements TranStep{
    Transaction t;
    String item;

    public stepWriteLock(Transaction t, String item) {
        this.t = t;
        this.item = item;
    }
    
    @Override
    public void execute() {
        LockManager.instance().writeLock(item, t);
    }
    
    @Override
    public String toString(){
        return "wl( "+ item+" )";
    }
}
