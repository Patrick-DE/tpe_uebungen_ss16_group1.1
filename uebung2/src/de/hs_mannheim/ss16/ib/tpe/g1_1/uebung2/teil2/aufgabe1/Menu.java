package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe1;
import static gdi.MakeItSimple.*;

public class Menu {
	static int wl=0;	// Sets the default working list
	static BTree happyTreeFriends[] = new BTree[3];	// Creates three trees
	public static void main(String[] args) {
		println("Enter degree of all 3 trees(degree has to be greater than 0. Otherwise an exceptions will be thrown):");
		int degree=readInt();

		for (int i = 0; i < happyTreeFriends.length; i++)
			happyTreeFriends[i] = new BTree(degree);

		while (true){
			makeMenu();
		}
	}
	

	public static void makeMenu() {

		println("------------------- Men� -------------------");
		println("1: Insert value");
		println("2: Input file");
		println("3: Contains value");
		println("4: Size");
		println("5: Height");
		println("6: getMin");
		println("7: getMax");
		println("8: isEmpty");
		println("9: addAll (otherTree)");
		println("10: Print: Inorder");
		println("11: Print: Preorder");
		println("12: Print: Postorder");
		println("13: Print: Levelorder");
		println("14: Clone");
		println("15: change working tree");  // sets another tree as working tree

		int selection = readInt();

		switch (selection){
		case 1:		// Insert value
			println("Enter the integer");
			int integer=readInt();
			println(happyTreeFriends[wl].insert(integer));
			break;
		case 2:
			println("Enter path to input file: ");
			readLine();
			String path = readLine();
			println(happyTreeFriends[wl].insert(path));
			break;
		case 3:
			println("Enter value: ");
			int checkValue=readInt();
			println(happyTreeFriends[wl].contains(checkValue));
			break;
		case 4:
			println(happyTreeFriends[wl].size());
			break;
		case 5:
			println(happyTreeFriends[wl].height());
			break;
		case 6:
			println(happyTreeFriends[wl].getMin());
			break;
		case 7:
			println(happyTreeFriends[wl].getMax());
			break;
		case 8:
			println(happyTreeFriends[wl].isEmpty());
			break;
		case 9:
			println("Current working tree: ");
			print(wl);
			println();
			println("Append tree no.: ");
			happyTreeFriends[wl].addAll(happyTreeFriends[readInt()]);	
			break;
		case 10:
			happyTreeFriends[wl].printInorder();
			break;
		case 11:
			happyTreeFriends[wl].printPreorder();
			break;
		case 12:
			happyTreeFriends[wl].printPostorder();
			break;
		case 13:
			happyTreeFriends[wl].printLevelorder();
			break;
		case 14:
			happyTreeFriends[wl].cloneDeep();
			break;
		case 15:
			println("Please enter 0,1 or 2:");
			wl=readInt();
			break;
		}
		readLine();
	}

}