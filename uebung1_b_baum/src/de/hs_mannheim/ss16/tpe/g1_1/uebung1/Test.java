package de.hs_mannheim.ss16.tpe.g1_1.uebung1;
import static gdi.MakeItSimple.*;

public class Test {

	public static void main(String[] args) {
		BTree treeFriend = new BTree(1);
		int[] a={5,13,27,9,7,3,10,50,11};
		for(int i = 0; i < a.length; i++ ){
		treeFriend.insert(a[i]);
		}
//		treeFriend.insert(51);
//		treeFriend.insert(52);
//		treeFriend.insert(53);
//		treeFriend.insert(23);
//		treeFriend.insert(24);
//		treeFriend.insert(25);
//		treeFriend.insert(6);
//		treeFriend.insert(7);
//		treeFriend.insert(8);
//		treeFriend.insert(65);
//		treeFriend.insert(66);
//		treeFriend.insert(67);
//		treeFriend.insert(68);
		String filename="C:\\Users\\Simon.Simon-PC\\Desktop\\test.txt";
//		if (isFileReadable(filename)) {
//            Object file = openOutputFile(filename);
//            for( int i = 0; i < 1500; i++){
//            	print(file,((int)(Math.random()*500))+" ");
//            }
//            closeOutputFile(file);
//		}
//            
            
//		treeFriend.insert(filename);
//		treeFriend.printInorder();
	
		println("Stier");
	

	}

}
