package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.aufgabe1;

public class CheckThenAct {
	private static boolean productavail = true;

	public static void main(String[] args) {
		customer1.start();
		customer2.start();
	}
	
	static Thread customer1 = new Thread(new Runnable() { 
		public void run() {
			if(productavail) {
				System.out.println("Customer1 Ihr ticket wurde in den Warenkorb gelegt");
			}
			try {
				System.out.println("Customer1 wartet");
				Thread.sleep(2000);
			} catch (InterruptedException e) { }
			System.out.println("Nutzer möchte nun bestellen");
			if(productavail) {
				System.out.println("Viel Spaß mit ihrem Produkt");
			} else {
				System.out.println("Das von Ihnen gewünschte Produkt ist leider ausverkauft");
			}

			System.out.println("Customer1 ist fertig");
		}   
	});
	static Thread customer2 = new Thread(new Runnable() { 
		public void run() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) { }
			System.out.println("Customer2 Legt ein Produkt in sein Warenkorb");
			System.out.println("Customer2 kauft das Produkt.");
			productavail = false;
			System.out.println("Customer2 happy");
		}   
	});
}
