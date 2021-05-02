package Ledger;

import java.util.Scanner;

public class CommercialLedger extends Ledger {
	protected String Company;
	
	public CommercialLedger(){
	}
	
	public CommercialLedger(LedgerKind kind){
		super(kind);
	}

	public void getUserInput(Scanner sc) {
		System.out.print("Select number 1(plus money) or 2(minus money) : ");

		int PlusorMinus = sc.nextInt();

		if(PlusorMinus == 1) {
			System.out.printf("MY MONEY(�鸸) : %d\n", Com_money);
			System.out.print("Add Date(Format:mmdd) : ");
			int Date = sc.nextInt();
			this.setDate(Date);

			System.out.print("How Much add(�鸸) : ");
			int HowMuchAdd = sc.nextInt();
			this.setHowMuchAdd(HowMuchAdd);
			Com_money += HowMuchAdd;
		}
		
		else {
			System.out.printf("MY MONEY(�鸸) : %d\n", Com_money);
			System.out.print("Use Date(Format:mmdd) : ");
			int Date = sc.nextInt();
			this.setDate(Date);

			System.out.print("Which partner company : ");
			String company = sc.next();
			this.Company = company;

			System.out.print("How Much Use(�鸸) : ");
			int HowMuchUse = sc.nextInt();
			this.setHowMuchUse(HowMuchUse);
			Com_money -= HowMuchUse;
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
		System.out.println("kind:" + lkind + " date(m/dd):" + Date + " add(�鸸):" + HowMuchAdd + " use(�鸸):" + HowMuchUse + " Partner company:" + Company);
	}

}