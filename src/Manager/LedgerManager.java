package Manager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Ledger.CommercialLedger;
import Ledger.EmergencyLedger;
import Ledger.Ledger;
import Ledger.LedgerInput;
import Ledger.LedgerKind;
import Ledger.PersonalLedger;

public class LedgerManager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4672223611087433373L;
		
	int temp_per, temp_com, temp_emer;
	public void putset() {
		temp_per = Ledger.money;
		temp_com = Ledger.Com_money;
		temp_emer = Ledger.Emer_money;
	}
	public void getset() {
		Ledger.money = temp_per;
		Ledger.Com_money = temp_com;
		Ledger.Emer_money = temp_emer;
	}
	
	ArrayList<LedgerInput> ledgers = new ArrayList<LedgerInput>();
	transient Scanner sc;
	
	LedgerManager(Scanner sc){
		this.sc = sc;
	}
	
	public void addledger(String date, String much, String where) {
		LedgerInput ledgerInput = new PersonalLedger(LedgerKind.Personal);
		ledgerInput.getUserInput(sc);
		ledgers.add(ledgerInput);
	}
	
	public void addledger(LedgerInput ledgerInput) {
		ledgers.add(ledgerInput);
	}
	
	public void addledger(Scanner sc) {
		int kind = 0;
		LedgerInput ledgerInput;
		while (kind != 1 && kind != 2 && kind != 3) {
			try {
				Addmenu();
				kind = sc.nextInt();
				if (kind == 1) {
					ledgerInput = new PersonalLedger(LedgerKind.Personal);
					ledgerInput.getUserInput(sc);
					ledgers.add(ledgerInput);
					break;
				}
				
				else if(kind == 2) {
					ledgerInput = new CommercialLedger(LedgerKind.Commercial);
					ledgerInput.getUserInput(sc);
					ledgers.add(ledgerInput);
					break;
				}
				
				else if(kind == 3) {
					ledgerInput = new EmergencyLedger(LedgerKind.Emergency);
					ledgerInput.getUserInput(sc);
					ledgers.add(ledgerInput);
					break;
				}
				
				else {
					System.out.println("Please put kind between 1 and 3 !");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Please integer between 1 and 3 !");
				if(sc.hasNext())
					sc.next();
				kind = 0;
			}
		}
	}

	public void deleteledger(Scanner sc) {
		sc.nextLine();
		System.out.print("Kind(Personal/Commercial/Emergency) : ");
		String kind = sc.nextLine();
		System.out.print("Date(Format:mm/dd) : ");
		String date = sc.nextLine();
		System.out.print("much : ");
		int much = sc.nextInt();
		int index = findindex(kind, date, much);
		removefromLedgers(index, much);
	}
	
	public int findindex(String kind, String date, int much) {
		int index = -1;

		for(int i = 0; i < ledgers.size(); i++) {
			if(ledgers.get(i).getDate().equals(date)&& ledgers.get(i).getKind().name().equals(kind) && (ledgers.get(i).getHowMuchUse() == much || ledgers.get(i).getHowMuchAdd() == much)) {
				index = i;
				break;
			}			
		}
		return index;
	}
	
	public void removefromLedgers(int index, int much) {
		if(index >= 0) {
			if(ledgers.get(index).getHowMuchUse() == much) {		
				if(ledgers.get(index).getKind() == LedgerKind.Personal) 
					Ledger.money = Ledger.money + much;
				else if(ledgers.get(index).getKind() == LedgerKind.Commercial)
					Ledger.Com_money = Ledger.Com_money + much;
				else
					Ledger.Emer_money = Ledger.Emer_money + much;
				
				ledgers.remove(index);
				System.out.println("Use " + much + " is removed");
			}	
			else{
				if(ledgers.get(index).getKind() == LedgerKind.Personal) 
					Ledger.money = Ledger.money - much; 
				else if(ledgers.get(index).getKind() == LedgerKind.Commercial)
					Ledger.Com_money = Ledger.Com_money - much; 
				else
					Ledger.Emer_money = Ledger.Emer_money - much;
				
				ledgers.remove(index);
				System.out.println("Add " + much + " is removed");
			}
		}

		else{
			System.out.println("the Date has not been regisered ");
			return;
		}
	}
	
	public void editledger(Scanner sc) {
		System.out.print("Kind(Personal/Commercial/Emergency) : ");
		String kind = sc.next();
		sc.nextLine();
		System.out.print("Date(Format:mm/dd) : ");
		String date = sc.nextLine();
		System.out.print("much : ");
		int much = sc.nextInt();
		
		int index = findindex(kind, date, much);
		for(int j = 0; j < ledgers.size(); j++) {
			LedgerInput ledger = ledgers.get(j);
			if(index == j) {
				int num = -1;
				while (num != 4) {
					Editmenu();
					num = sc.nextInt();
					
					switch(num) {
					case 1:
						ledger.setHowMuchAdd(sc, j);
						break;
					case 2:
						ledger.setHowMuchUse(sc, j);
						break;
					case 3:
						ledger.setWhereUse(sc);
						break;
					default:
						continue;
					}
				}
				break;
			}
		}
	}
	
	public void viewledgers() {
		for(int i = 0; i < ledgers.size(); i++) {
			ledgers.get(i).printinfo();
		}
	}
	
	public int size() {
		return ledgers.size();
	}
	
	public LedgerInput get(int index) {
		return ledgers.get(index);
	}
	
	public void Addmenu() {
		System.out.println("1. Personal Ledger");
		System.out.println("2. Commecial Ledger");
		System.out.println("3. Emergency Ledger");
		System.out.print("Select num for ledger kind between 1 and 3 :");
	}
	
	public void Editmenu() {
		System.out.println("**** Ledger Info Eidt Menu ****");
		System.out.println("1.Edit Add");
		System.out.println("2.Edit Use");
		System.out.println("3.Edit Using location");
		System.out.println("4.Exit");
		System.out.print("Select one number between 1 - 4 : ");
	}
	
}
