package de.hsmannheim.tpe.ss16.gruppe13.uebung2.eisdielePt1;

import java.util.Scanner;

public class IchWillEIs {

	public static void main(String[] args) {
		RegionalEis eis1 = new RegionalEis(null, 0, null, null, args, args);
		Scanner scanner = new Scanner(System.in);
		eis1.begruessen();
		String order = scanner.nextLine();
		if(eis1.isAvail(order)){
			eis1.setName(order);
			String behaelter = scanner.next("Worin möchten Sie Ihr Eis haben?");
//			if(behaelter)
		}
		eis1.toString(eis1);
	}

}
