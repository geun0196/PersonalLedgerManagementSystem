package Ledger;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Ledger implements LedgerInput {
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
	
	public abstract void printinfo();
	
	public void setDate(int PlusorMinus, Scanner sc) {
		if(PlusorMinus == 1) {
			System.out.print("Add Date(Format:mmdd) : ");
			int Date = sc.nextInt();
			this.setDate(Date);
		}
		else {
			System.out.print("Use Date(Format:mmdd) : ");
			int Date = sc.nextInt();
			this.setDate(Date);
		}
	}
	
	public void setWhereUse(int PlusorMinus, Scanner sc) {
		if(PlusorMinus == 2 && this.getKind() == LedgerKind.Personal) {
			sc.nextLine();
			System.out.print("Where Use : ");
			String WhereUse = sc.nextLine();
			this.setWhereUse(WhereUse);
		}
		else if(PlusorMinus == 2 && this.getKind() == LedgerKind.Commercial) {
			sc.nextLine();
			System.out.print("Partner Company : ");
			String WhereUse = sc.nextLine();
			this.setWhereUse(WhereUse);
		}
	}
	
	public void setmoney(int PlusorMinus, Scanner sc) {
		int HowMuchAdd = -1, HowMuchUse = -1;
		while(HowMuchAdd < 0 || HowMuchUse < 0) {
			try {
				if(this.getKind() == LedgerKind.Personal) {
					if(PlusorMinus == 1) {
						System.out.print("How Much add : ");
						HowMuchAdd = sc.nextInt();
						this.setHowMuchAdd(HowMuchAdd);
						money += HowMuchAdd;
					}
					else {
						System.out.print("How Much Use : ");
						HowMuchUse = sc.nextInt();
						this.setHowMuchUse(HowMuchUse);
						money -= HowMuchUse;
					}
					break;
				}
				else if(this.getKind() == LedgerKind.Commercial) {
					if(PlusorMinus == 1) {
						System.out.print("How Much add(¸¸) : ");
						HowMuchAdd = sc.nextInt();
						this.setHowMuchAdd(HowMuchAdd);
						Com_money += HowMuchAdd;
					}
					else {
						System.out.print("How Much Use(¸¸) : ");
						HowMuchUse = sc.nextInt();
						this.setHowMuchUse(HowMuchUse);
						Com_money -= HowMuchUse;
					}
					break;
				}
				else {
					if(PlusorMinus == 1) {
						System.out.print("How Much add : ");
						HowMuchAdd = sc.nextInt();
						this.setHowMuchAdd(HowMuchAdd);
						Emer_money += HowMuchAdd;
					}
					else {
						System.out.print("How Much Use : ");
						HowMuchUse = sc.nextInt();
						this.setHowMuchUse(HowMuchUse);
						Emer_money -= HowMuchUse;
					}
					break;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Please input Money!");
				if(sc.hasNext())
					sc.next();
				HowMuchAdd = -1; HowMuchUse = -1;
			}
		}
		
	}
	
	public void setHowMuchAdd(Scanner sc, int index) {
		System.out.println("How much change add : ");
		int HowMuchAdd = sc.nextInt();
		int current = this.getHowMuchAdd();
		this.setHowMuchAdd(HowMuchAdd);
		if(this.getKind() == LedgerKind.Personal)
			Ledger.money = Ledger.money + (HowMuchAdd-current); 
		else if(this.getKind() == LedgerKind.Commercial)
			Ledger.Com_money = Ledger.Com_money + (HowMuchAdd-current);
		else
			Ledger.Emer_money = Ledger.Emer_money + (HowMuchAdd-current); 
			
	}
		
	public void setHowMuchUse(Scanner sc, int index ) {
		System.out.println("How much change use : ");
		int HowMuchUse = sc.nextInt();
		int current = this.getHowMuchUse();
		this.setHowMuchUse(HowMuchUse);
		if(this.getKind() == LedgerKind.Personal)
			Ledger.money = Ledger.money + (current - HowMuchUse);
		else if(this.getKind() == LedgerKind.Commercial)
			Ledger.Com_money = Ledger.Com_money + (current - HowMuchUse);
		else
			Ledger.Emer_money = Ledger.Emer_money + (current - HowMuchUse);
	}

	public void setWhereUse(Scanner sc) {
		sc.nextLine();
		System.out.println("Using : ");
		String WhereUse = sc.nextLine();
		this.setWhereUse(WhereUse);
	}
	
	public String getLedgerkind() {
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
		return lkind;
	}

	
}