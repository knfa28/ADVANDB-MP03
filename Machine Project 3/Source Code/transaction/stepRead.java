package transaction;

import java.sql.ResultSet;

public class stepRead implements TranStep{
    String query;
    String[] items;
    ResultSet rs;
   

    public stepRead(String query, String[] items) {
        this.query = query;
        this.items = items;
    }
    
    @Override
    public void execute() {
        //insert sql codes here and it'll return the result set since read lang naman
    }
    
    public ResultSet getResultSet(){
        return rs;
    }
    
     @Override
    	public String toString() {
		String ret = "";
		for( int i = 0; i < items.length; i++ ) {
			if( i > 0 ) {
				ret += ";";
			}
			ret += "read(" + items[i] + ")";
		}
		return ret;
	}
    
}
