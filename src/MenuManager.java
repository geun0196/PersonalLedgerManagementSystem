import java.util.Scanner;

public class MenuManager {

	public static void main(String[] args) {
		int num = 0;
		int money = 0;
		Scanner sc = new Scanner(System.in);
		
		while (num != 6) {
			System.out.println("1.Add Ledger");
			System.out.println("2.Delete Ledger");
			System.out.println("3.Edit Ledger");
			System.out.println("4.View Ledger");
			System.out.println("5.Show a Menu");
			System.out.println("6.Exit");
			System.out.print("Select one number between 1-6 : ");
			num = sc.nextInt();
			
			if (num == 1) {
				System.out.printf("My Money : %d\n",money);
				System.out.print("Select number 1(add money) or 2(minus money) : ");
				
				int AddorMinus = sc.nextInt();
				
				if(AddorMinus == 1) {
					System.out.print("Add Date(Format:mmdd) : ");
					int AddDate = sc.nextInt();
					System.out.print("How Much add : ");
					int HowMuchAdd = sc.nextInt();
					money += HowMuchAdd;
				}
				else {
					System.out.print("Use Date(Format:mmdd) : ");
					int UseDate = sc.nextInt();
					System.out.print("Where Use : ");
					String WhereUse = sc.next();
					System.out.print("How Much Use : ");
					int HowMuchUse = sc.nextInt();
					money -= HowMuchUse;
				}	
			}
			
			else if (num == 2) {
				System.out.print("add or minus : ");
				String AddorMinus = sc.next();
				System.out.print("Date(Format:mmdd) : ");
				int date = sc.nextInt();
			}
			
			else if (num == 3) {
				System.out.print("add or minus : ");
				String AddorMinus = sc.next();
				System.out.print("Date(Format:mmdd) : ");
				int date = sc.nextInt();
			}
			
			else if (num == 4) {
				System.out.print("add or minus : ");
				String AddorMinus = sc.next();
				System.out.print("Date(Format:mmdd) : ");
				int date = sc.nextInt();
			}
			
			else if (num == 6)
				break;
			
		}
	}
}
