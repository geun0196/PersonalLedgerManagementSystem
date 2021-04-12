import java.util.*;

import Ledger.CommercialLedger;
import Ledger.Ledger;

public class LedgerManager {
	ArrayList<Ledger> ledgers = new ArrayList<Ledger>();
	Scanner sc;
	
	LedgerManager(){

	}
	
	LedgerManager(Scanner sc){
		this.sc = sc;
	}

	public void addledger() {
		int kind = 0;
		Ledger ledger;
		while (kind != 1 && kind != 2) {
			System.out.println("1. Personal Ledger");
			System.out.println("2. Commecial Ledger");
			System.out.print("Select num for ledger kind between 1 and 2 :");
			kind = sc.nextInt();
			if (kind == 1) {
				ledger = new Ledger();
				ledger.getUserInput(sc);
				ledgers.add(ledger);
				break;
			}
			
			else if(kind == 2) {
				ledger = new CommercialLedger();
				ledger.getUserInput(sc);
				ledgers.add(ledger);
				break;
			}
			else {
				System.out.print("Select num for ledger kind between 1 and 2 :");
			}
		}
	}

	public void deleteledger() {
		System.out.print("Date(Format:mmdd) : ");
		int date = sc.nextInt();
		System.out.print("Howmuch : ");
		int much = sc.nextInt();
		int index = -1;

		for(int i = 0; i < ledgers.size(); i++) {
			if(ledgers.get(i).getDate() == date && (ledgers.get(i).getHowMuchUse() == much || ledgers.get(i).getHowMuchAdd() == much)) {
				index = i;
				break;
			}			
		}

		if(index >= 0) {
			ledgers.remove(index);
			System.out.println("Add(or)Minus " + much + " is removed");
		}
		else{
			System.out.println("the Date has not been regisered ");
			return;
		}
	}

	public void editledger() {
		System.out.print("Date(Format:mmdd) : ");
		int date = sc.nextInt();
		System.out.print("much : ");
		int much = sc.nextInt();
		
		int index = -1;
		for(int i = 0; i < ledgers.size(); i++) {
			if(ledgers.get(i).getDate() == date && (ledgers.get(i).getHowMuchUse() == much || ledgers.get(i).getHowMuchAdd() == much)) {
				index = i;
		}
		
		for(int j = 0; j < ledgers.size(); j++) {
			Ledger ledger = ledgers.get(j);
			if(index == j) {
				int num = -1;

				while (num != 4) {
					System.out.println("**** Ledger Info Eidt Menu ****");
					System.out.println("1.Edit Add");
					System.out.println("2.Edit Use");
					System.out.println("3.Edit Using location");
					System.out.println("4.Exit");
					System.out.print("Select one number between 1 - 4 : ");
					num = sc.nextInt();

					if (num == 1) {
						System.out.println("How much Add : ");
						int HowMuchAdd = sc.nextInt();
						ledger.setHowMuchAdd(HowMuchAdd);
						   
					}

					else if (num == 2) {
						System.out.println("How much Use : ");
						int HowMuchUse = sc.nextInt();
						ledger.setHowMuchUse(HowMuchUse);
					}

					else if (num == 3) {
						System.out.println("Using location : ");
						String WhereUse = sc.next();
						ledger.setWhereUse(WhereUse);
					}

					else
						continue;

					}
				break;
				}
			}
		}
	}
	public void viewledgers() {
		for(int i = 0; i < ledgers.size(); i++) {
			ledgers.get(i).printinfo();
		}
	}
}
