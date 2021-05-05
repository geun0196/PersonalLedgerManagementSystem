package Ledger;

import java.util.Scanner;

public abstract class Ledger {
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
}