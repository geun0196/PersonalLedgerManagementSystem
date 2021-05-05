import java.util.Scanner;

public class MenuManager {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LedgerManager ledgerManager = new LedgerManager(sc);
		int num = -1;

		while (num != 5) {
			System.out.println("**** Ledger Management System Program ****");
			System.out.println("1.Add Ledger");
			System.out.println("2.Delete Ledger");
			System.out.println("3.Edit Ledger");
			System.out.println("4.View Ledgers");
			System.out.println("5.Exit");
			System.out.print("Select one number between 1-5 : ");
			num = sc.nextInt();

			if (num == 1) {
				ledgerManager.addledger();	
			}

			else if (num == 2) {
				ledgerManager.deleteledger();
			}

			else if (num == 3) {
				ledgerManager.editledger();
			}

			else if (num == 4) {
				ledgerManager.viewledgers();
			}

			else
				continue;

		}
		System.out.println("프로그램을 종료합니다.");
	}
}