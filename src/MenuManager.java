import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManager {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LedgerManager ledgerManager = new LedgerManager(sc);
		
		selectMenu(sc, ledgerManager);
	}
	
	public static void selectMenu(Scanner sc, LedgerManager ledgerManager) {
		int num = -1;

		while (num != 5) {
			try {
				Menushow();
				num = sc.nextInt();
				switch(num) {
				case 1:
					ledgerManager.addledger();
					break;
				case 2:
					ledgerManager.deleteledger();
					break;
				case 3:
					ledgerManager.editledger();
					break;
				case 4:
					ledgerManager.viewledgers();
					break;
				default:
					continue;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Please integer between 1 and 5 !");
				if(sc.hasNext())
					sc.next();
				num = -1;
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
	public static void Menushow() {
		System.out.println("**** Ledger Management System Program ****");
		System.out.println("1.Add Ledger");
		System.out.println("2.Delete Ledger");
		System.out.println("3.Edit Ledger");
		System.out.println("4.View Ledgers");
		System.out.println("5.Exit");
		System.out.print("Select one number between 1-5 : ");
	}
}