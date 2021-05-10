package Ledger;

import java.util.Scanner;

public class EmergencyLedger extends Ledger{
	
	public EmergencyLedger(){
	}
	
	public EmergencyLedger(LedgerKind kind){
		super(kind);
	}
	
	public void getUserInput(Scanner sc) {
		System.out.print("Select number 1(plus money) or 2(minus money) : ");
		int PlusorMinus = sc.nextInt();
		if(PlusorMinus == 1 || PlusorMinus == 2) {
			System.out.printf("MY MONEY : %d\n", Emer_money);
			setDate(PlusorMinus,sc);
			setmoney(PlusorMinus,sc);
		}
	}
	
	public void printinfo() {
		String lkind = getLedgerkind();
		System.out.println("kind:" + lkind + " date(m/dd):" + Date + " add:" + HowMuchAdd + " use:" + HowMuchUse + " location:" + WhereUse);
	}	
	
}