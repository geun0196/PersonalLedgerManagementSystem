package Manager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import Gui.WindowFrame;
import Ledger.Ledger;
import Log.EventLogger;

public class MenuManager {
	static EventLogger logger = new EventLogger("log.txt");
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		LedgerManager ledgerManager = getObject("ledgermanager.ser");
		if(ledgerManager == null) {
			ledgerManager = new LedgerManager(sc);
		}
		
		WindowFrame frame = new WindowFrame(ledgerManager);
		ledgerManager.getset();
		selectMenu(sc, ledgerManager);
		ledgerManager.putset();
		putObject(ledgerManager, "ledgermanager.ser");
	}
	
	public static void selectMenu(Scanner sc, LedgerManager ledgerManager) {
		int num = -1;

		while (num != 5) {
			try {
				Menushow();
				num = sc.nextInt();
				switch(num) {
				case 1:
					ledgerManager.addledger(sc);
					logger.log("add a Ledger");
					break;
				case 2:
					ledgerManager.deleteledger(sc);
					logger.log("delete a Ledger");
					break;
				case 3:
					ledgerManager.editledger(sc);
					logger.log("edit a Ledger");
					break;
				case 4:
					ledgerManager.viewledgers();
					logger.log("view Ledgers");
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
	
	public static LedgerManager getObject(String filename) {
		LedgerManager ledgerManager = null; 
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			
			ledgerManager = (LedgerManager) in.readObject();
			
			in.close();
			file.close();
		} catch (FileNotFoundException e) {
			return ledgerManager;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ledgerManager;
	}
	
	public static void putObject(LedgerManager ledgerManager, String filename) {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(ledgerManager);
			
			out.close();
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}