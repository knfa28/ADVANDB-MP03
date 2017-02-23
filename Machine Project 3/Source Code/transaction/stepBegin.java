package transaction;

import managers.TimestampManager;

public class stepBegin implements TranStep {
    Transaction t;

    public stepBegin(Transaction t) {
        this.t = t;
    }
    
    @Override
    public void execute() {
        t.setTimestamp(TimestampManager.getTimetampManager().timeStamp());
        t.started = "started";
    }
    
    @Override
    public String toString(){
        return "BEGIN()";
    }
    
}
