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

	public void printinfo();
}
