package Ledger;

import java.util.Scanner;

public class Ledger {
	protected LedgerKind kind = LedgerKind.Personal;
	protected int Date;
	protected String WhereUse;
	protected int HowMuchAdd;
	protected int HowMuchUse;
	public static int money = 0;
	public static int Com_money = 0;
	public static int Emer_money = 0;

	public int getDate() {
		return Date;
	}

	public void setDate(int date) {
		Date = date;
	}

	public String getWhereUse() {
		return WhereUse;
	}

	public void setWhereUse(String whereUse) {
		WhereUse = whereUse;
	}

	public int getHowMuchAdd() {
		return HowMuchAdd;
	}

	public void setHowMuchAdd(int howMuchAdd) {
		HowMuchAdd = howMuchAdd;
	}

	public int getHowMuchUse() {
		return HowMuchUse;
	}

	public void setHowMuchUse(int howMuchUse) {
		HowMuchUse = howMuchUse;
	}
	
	public LedgerKind getKind() {
		return kind;
	}

	public void setKind(LedgerKind kind) {
		this.kind = kind;
	}

	public Ledger(){

	}
	
	public Ledger(LedgerKind kind){
		this.kind = kind;
	}

	public Ledger(int date) {
		this.Date = date;
	}

	public Ledger(int date, int howmuchadd) {
		this.Date = date;
		this.HowMuchAdd = howmuchadd;
	}

	public Ledger(int date, String whereuse, int howmuchuse) {
		this.Date = date;
		this.WhereUse = whereuse;
		this.HowMuchUse = howmuchuse;
	}
	
	public Ledger(LedgerKind kind, int date, String whereuse, int howmuchuse) {
		this.kind = kind;
		this.Date = date;
		this.WhereUse = whereuse;
		this.HowMuchUse = howmuchuse;
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
}