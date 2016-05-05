package de.hsmannheim.tpe.ss16.gruppe13.uebung1_b_baum_final;

import java.util.Scanner;

public class BTreeMenu {

	static BTreeImpl[] BTree = new BTreeImpl[3];  // array with 3 Elements

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < BTree.length; i++){
			BTree[i] = new BTreeImpl(3);
		}

		int decition = 0;

		while (true) {

			System.out.println("---- Menü ----");
			System.out.println("1: Print Inorder");  
			System.out.println("2: Print Postorder");
			System.out.println("3: Print Preorder");
			System.out.println("4: Print Levelorder");
			System.out.println("5: insert (Integer)");
			System.out.println("6: insert from file");
			System.out.println("7: Size");
			System.out.println("8: Height");
			System.out.println("9: Contains?");
			System.out.println("10: get Min");
			System.out.println("11: get Max");
			System.out.println("12: is empty?");
			System.out.println("13: set order and create new empty tree");
			System.out.println("66: terminate");


			int selection = scanner.nextInt();

			switch (selection) {
			case 1:
				BTree[decition].printInorder();
				break;
			case 2:
				BTree[decition].printPostorder();
				break;
			case 3:
				BTree[decition].printPreorder();
				break;
			case 4:
				BTree[decition].printLevelorder();
				break;
			case 5:
				System.out.println("Input: ");
				int z = scanner.nextInt();
				boolean inserted;
				inserted = BTree[decition].insert((Integer) z);
				if(inserted){
					System.out.println("inserted " + z);
				}
				else{
					System.out.println(z + "is already in the tree");
				}
				break;
			case 6:
				String filename = "InsertFile.txt";
				BTree[decition].insert(filename);
				break;
			case 7:
				System.out.println("Size: " + BTree[decition].size());
				break;
			case 8:
				System.out.println("Height: " + BTree[decition].height());
				break;
			case 9:
				System.out.println("search for: ");
				int contains = scanner.nextInt();
				if(BTree[decition].contains((Integer) contains)){
					System.out.println(contains +" was found");
				}
				else{
					System.out.println("value not found");
				}
				break;
			case 10:
				System.out.println("Minimum: " + BTree[decition].getMin());
				break;
			case 11:
				System.out.println("Maximum: " + BTree[decition].getMax());
				break;
			case 12:
				if(BTree[decition].isEmpty()){
					System.out.println("BTree is empty");
				}
				else{
					System.out.println("BTree is not empty");
				}
				break;		
			case 13:
				System.out.println("choose order");
				int order = scanner.nextInt();
				if(order >= 1){
					BTree[decition] = new BTreeImpl(order);
					System.out.println("BTree with order " + order + " created");
				}
				else{
					System.out.println("Wrong order");
				}
				break;
			case 66:
				System.out.println("terminate...");
				return;
			default:
				break;
			}
			;

			String s = scanner.next(); 

		}

	}
}