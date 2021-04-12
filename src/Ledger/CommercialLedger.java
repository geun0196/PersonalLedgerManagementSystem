package Ledger;

import java.util.Scanner;

public class CommercialLedger extends Ledger {

	public void getUserInput(Scanner sc) {
		System.out.print("Select number 1(plus money) or 2(minus money) : ");

		int PlusorMinus = sc.nextInt();

		if(PlusorMinus == 1) {
			System.out.print("Add Date(Format:mmdd) : ");
			int Date = sc.nextInt();
			this.setDate(Date);

			System.out.print("How Much add : ");
			int HowMuchAdd = sc.nextInt();
			this.setHowMuchAdd(HowMuchAdd);
		}
		
		else {
			System.out.print("Use Date(Format:mmdd) : ");
			int Date = sc.nextInt();
			this.setDate(Date);

			System.out.print("Where Use : ");
			String WhereUse = sc.next();
			this.setWhereUse(WhereUse);

			System.out.print("How Much Use : ");
			int HowMuchUse = sc.nextInt();
			this.setHowMuchUse(HowMuchUse);
		}
	}
	
	public void printinfo() {
		System.out.println("date(m/dd):" + Date + " add:" + HowMuchAdd + " use:" + HowMuchUse + " location:" + WhereUse + "(Commercial Ledger)");
	}

}