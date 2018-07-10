package linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class LinkedList_Explicacao {
	public static void main(String[] args) {
		LinkedList al = new LinkedList();
		al.add(3);
		al.add(2);
		al.add(1);
		al.add(4);
		al.add(5);
		al.add(6);
		al.add(6);

		Iterator iter1 = al.iterator();

		while (iter1.hasNext()) {
			System.out.println(iter1.next());
		}
		
		System.out.println(al.get(1));

	}
}
