package Ledger;

import java.util.Scanner;

public interface LedgerInput {
	
	public void getUserInput(Scanner sc);
	
	public int getDate();
	public int getHowMuchAdd();
	public int getHowMuchUse();
	public LedgerKind getKind();
	
	public void setHowMuchAdd(int howMuchAdd);
	public void setHowMuchUse(int howMuchUse);
	public void setWhereUse(String whereUse);
	public void setDate(int Date);

	public void printinfo();
	
	public void setDate(int PlusorMinus, Scanner sc);
	public void setWhereUse(int PlusorMinus, Scanner sc);
	public void setmoney(int PlusorMinus, Scanner sc);
	
	public void setHowMuchUse(Scanner sc, int index );
	public void setHowMuchAdd(Scanner sc, int index);
	public void setWhereUse(Scanner sc);
}