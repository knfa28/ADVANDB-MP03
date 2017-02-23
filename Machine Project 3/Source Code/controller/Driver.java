package controller;

import managers.IsolationLevels;
import transaction.Query1;
import transaction.Query2;
import transaction.TranStep;
import transaction.Transaction;
import transaction.stepBegin;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws Exception {
        
        final ArrayList<Transaction> tranList = new ArrayList<Transaction>();
	tranList.add(new Query2(1,IsolationLevels.readCommited));
	tranList.add(new Query1(2,IsolationLevels.readUncommited));
	tranList.add(new Query1(3,IsolationLevels.readCommited));
	tranList.add(new Query2(4,IsolationLevels.readUncommited));

	boolean finished;
        
        do {
            String[][] transactions = new String[tranList.size()][];
            int max = 0;
            for(int i = 0; i < tranList.size(); i++) {
                transactions[i] = tranList.get(i).toString().split("\n");
            
                if( transactions[i].length > max ) {
                    max = transactions[i].length;
                }
            }
            
            for(int i = 0; i < max; i++ ) {
                for(int j = 0; j < transactions.length; j++ ) {
                    if( j > 0 ) {
                        System.out.print("\t");
                    }
                    
                    if( i < transactions[j].length) {
                        System.out.print(transactions[j][i]);
                    } else {
                        System.out.print("\t\t");
                    }
		}
                
                System.out.println();
            }

            Scanner sc = new Scanner(System.in);
            System.out.print("Which transaction? ");
            final int tNo = sc.nextInt() - 1;

            (new Thread(){
                public void run() {
                    tranList.get(tNo).step();
		}
		}).start();
		Thread.sleep(100);

            finished = true;
            for(Transaction t : tranList ) {
                finished = finished && t.isFinished();
            }
	} while(!finished);
    }
    
}
