import java.util.*;

import Ledger.CommercialLedger;
import Ledger.EmergencyLedger;
import Ledger.Ledger;
import Ledger.LedgerInput;
import Ledger.LedgerKind;
import Ledger.PersonalLedger;

public class LedgerManager {
	ArrayList<LedgerInput> ledgers = new ArrayList<LedgerInput>();
	Scanner sc;
	
	LedgerManager(){

	}
	
	LedgerManager(Scanner sc){
		this.sc = sc;
	}

	public void addledger() {
		int kind = 0;
		LedgerInput ledgerInput;
		while (kind != 1 && kind != 2 && kind != 3) {
			System.out.println("1. Personal Ledger");
			System.out.println("2. Commecial Ledger");
			System.out.println("3. Emergency Ledger");
			System.out.print("Select num for ledger kind between 1 and 3 :");
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
				System.out.print("Select num for ledger kind between 1 and 3 :");
			}
		}
	}

	public void deleteledger() {
		System.out.print("Kind(Personal/Commercial/Emergency) : ");
		String kind = sc.next();
		System.out.print("Date(Format:mmdd) : ");
		int date = sc.nextInt();
		System.out.print("Howmuch : ");
		int much = sc.nextInt();
		int index = -1;

		for(int i = 0; i < ledgers.size(); i++) {
			if(ledgers.get(i).getDate() == date && ledgers.get(i).getKind().name().equals(kind) && (ledgers.get(i).getHowMuchUse() == much || ledgers.get(i).getHowMuchAdd() == much)) {
				index = i;
				break;
			}			
		}

		if(index >= 0) {
			if(ledgers.get(index).getKind() == LedgerKind.Personal) {
				if(ledgers.get(index).getHowMuchUse() == much) {
					ledgers.remove(index);
					System.out.println("Minus " + much + " is removed");
					Ledger.money = Ledger.money + much;
				}	
				else{
					ledgers.remove(index);
					System.out.println("Add " + much + " is removed");
					Ledger.money = Ledger.money - much; 	
				}
			}
			
			else if(ledgers.get(index).getKind() == LedgerKind.Commercial) {
				if(ledgers.get(index).getHowMuchUse() == much) {
					ledgers.remove(index);
					System.out.println("Minus " + much + " is removed");
					Ledger.Com_money = Ledger.Com_money + much;
				}	
				else{
					ledgers.remove(index);
					System.out.println("Add " + much + " is removed");
					Ledger.Com_money = Ledger.Com_money - much; 	
				}
			}
			else {
				if(ledgers.get(index).getHowMuchUse() == much) {
					ledgers.remove(index);
					System.out.println("Minus " + much + " is removed");
					Ledger.Emer_money = Ledger.Emer_money + much;
				}	
				else{
					ledgers.remove(index);
					System.out.println("Add " + much + " is removed");
					Ledger.Emer_money = Ledger.Emer_money - much; 	
				}
			}
			
		}
		else{
			System.out.println("the Date has not been regisered ");
			return;
		}
	}

	public void editledger() {
		System.out.print("Kind(Personal/Commercial/Emergency) : ");
		String kind = sc.next();
		System.out.print("Date(Format:mmdd) : ");
		int date = sc.nextInt();
		System.out.print("much : ");
		int much = sc.nextInt();
		
		int index = -1;
		for(int i = 0; i < ledgers.size(); i++) {
			if(ledgers.get(i).getDate() == date && ledgers.get(i).getKind().name().equals(kind) && (ledgers.get(i).getHowMuchUse() == much || ledgers.get(i).getHowMuchAdd() == much)) {
				index = i;
		}
		
		for(int j = 0; j < ledgers.size(); j++) {
			LedgerInput ledgerInput = ledgers.get(j);
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
						if(ledgers.get(j).getKind() == LedgerKind.Personal) {
							System.out.println("How much change add : ");
							int HowMuchAdd = sc.nextInt();
							int current = ledgerInput.getHowMuchAdd();
							ledgerInput.setHowMuchAdd(HowMuchAdd);
							Ledger.money = Ledger.money + (HowMuchAdd-current); 
						}
						else if(ledgers.get(j).getKind() == LedgerKind.Commercial) {
							System.out.println("How much change add : ");
							int HowMuchAdd = sc.nextInt();
							int current = ledgerInput.getHowMuchAdd();
							ledgerInput.setHowMuchAdd(HowMuchAdd);
							Ledger.Com_money = Ledger.Com_money + (HowMuchAdd-current); 
						}
						else if(ledgers.get(j).getKind() == LedgerKind.Emergency) {
							System.out.println("How much change add : ");
							int HowMuchAdd = sc.nextInt();
							int current = ledgerInput.getHowMuchAdd();
							ledgerInput.setHowMuchAdd(HowMuchAdd);
							Ledger.Emer_money = Ledger.Emer_money + (HowMuchAdd-current); 
						}
					}

					else if (num == 2) {
						if(ledgers.get(j).getKind() == LedgerKind.Personal) {
							System.out.println("How much change use : ");
							int HowMuchUse = sc.nextInt();
							int current = ledgerInput.getHowMuchUse();
							ledgerInput.setHowMuchUse(HowMuchUse);
							Ledger.money = Ledger.money + (current - HowMuchUse);
						}
						else if(ledgers.get(j).getKind() == LedgerKind.Commercial) {
							System.out.println("How much change use : ");
							int HowMuchUse = sc.nextInt();
							int current = ledgerInput.getHowMuchUse();
							ledgerInput.setHowMuchUse(HowMuchUse);
							Ledger.Com_money = Ledger.Com_money + (current - HowMuchUse);
						}
						else if(ledgers.get(j).getKind() == LedgerKind.Emergency) {
							System.out.println("How much change use : ");
							int HowMuchUse = sc.nextInt();
							int current = ledgerInput.getHowMuchUse();
							ledgerInput.setHowMuchUse(HowMuchUse);
							Ledger.Emer_money = Ledger.Emer_money + (current - HowMuchUse);
						}
					}

					else if (num == 3) {
							System.out.println("Using location : ");
							String WhereUse = sc.next();
							ledgerInput.setWhereUse(WhereUse);
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
