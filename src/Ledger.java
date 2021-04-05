
public class Ledger {
	int Date;
	int HowMuchAdd;
	String WhereUse;
	int HowMuchUse;
	
	public Ledger(){
	
	}
	
	public Ledger(int date) {
		this.Date = date;
	}
	
	
	public Ledger(int date, int howmuchadd, String whereuse, int howmuchuse) {
		this.Date = date;
		this.HowMuchAdd = howmuchadd;
		this.WhereUse = whereuse;
		this.HowMuchUse = howmuchuse;
	}
	
	public void printinfo() {
			System.out.println("date(m/dd):" + Date + " add:" + HowMuchAdd + " use:" + HowMuchUse);
	}
}