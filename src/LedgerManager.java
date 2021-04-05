import java.util.Scanner;

public class LedgerManager {
	static int money = 0;

	Ledger ledger;
	
	Scanner sc;
	LedgerManager(Scanner sc){
		this.sc = sc;
	}
	public void addledger() {
		ledger = new Ledger();
		System.out.printf("My Money : %d\n",money);
		System.out.print("Select number 1(plus money) or 2(minus money) : ");

		int PlusorMinus = sc.nextInt();

		if(PlusorMinus == 1) {
			System.out.print("Add Date(Format:mmdd) : ");
			ledger.Date = sc.nextInt();
			System.out.print("How Much add : ");
			ledger.HowMuchAdd = sc.nextInt();
			money += ledger.HowMuchAdd;			
		}
		else {
			System.out.print("Use Date(Format:mmdd) : ");
			ledger.Date = sc.nextInt();
			System.out.print("Where Use : ");
			ledger.WhereUse = sc.next();
			System.out.print("How Much Use : ");
			ledger.HowMuchUse = sc.nextInt();
			money -= ledger.HowMuchUse;	
		}
	}

	public void deleteledger() {
		System.out.print("Date(Format:mmdd) : ");
		int date = sc.nextInt();
		if (ledger == null) {
			System.out.println("the Date has not been regisered ");
			return;
		}
		if(ledger.Date == date) {
			ledger = null;
			System.out.println("the Date is removed");
		}
	}

	public void editledger() {
		System.out.print("Date(Format:mmdd) : ");
		int date = sc.nextInt();
		if(ledger.Date == date) {
			System.out.println("the Date to be edited is " + date);
		}
	}

	public void viewledger() {
		System.out.print("Date(Format:mmdd) : ");
		int date = sc.nextInt();
		if(ledger.Date == date) {
			ledger.printinfo();
		}
	}


}
