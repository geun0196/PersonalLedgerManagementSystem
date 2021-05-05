package Ledger;

import java.util.Scanner;

public class PersonalLedger extends Ledger implements LedgerInput{
	
	public PersonalLedger(){
	}
	
	public PersonalLedger(LedgerKind kind){
		super(kind);
	}
	
	public void getUserInput(Scanner sc) {
		System.out.print("Select number 1(plus money) or 2(minus money) : ");

		int PlusorMinus = sc.nextInt();

		if(PlusorMinus == 1) {
			System.out.printf("MY MONEY : %d\n", money);
			System.out.print("Add Date(Format:mmdd) : ");
			int Date = sc.nextInt();
			this.setDate(Date);

			System.out.print("How Much add : ");
			int HowMuchAdd = sc.nextInt();
			this.setHowMuchAdd(HowMuchAdd);
			money += HowMuchAdd;
		}
		
		else {
			System.out.printf("MY MONEY : %d\n", money);
			System.out.print("Use Date(Format:mmdd) : ");
			int Date = sc.nextInt();
			this.setDate(Date);
			
			System.out.print("Where Use : ");
			String WhereUse = sc.next();
			this.setWhereUse(WhereUse);
			
			System.out.print("How Much Use : ");
			int HowMuchUse = sc.nextInt();
			this.setHowMuchUse(HowMuchUse);
			
			money -= HowMuchUse;
		}
	}
	
	public void printinfo() {
		String lkind = "none";
		switch(this.kind) {
		case Personal:
			lkind = "personal";
			break;
		case Commercial:
			lkind = "commercial";
			break;
		case Emergency:
			lkind = "Emergency";
			break;
		default:
		}
		System.out.println("kind:" + lkind + " date(m/dd):" + Date + " add:" + HowMuchAdd + " use:" + HowMuchUse + " location:" + WhereUse);
	}	
	
}
