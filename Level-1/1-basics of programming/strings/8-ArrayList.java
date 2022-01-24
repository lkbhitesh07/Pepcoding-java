import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		
		System.out.println(list + " -> " + list.size());
		
		list.add(1, 1000);
		System.out.println(list + " -> " + list.size());
		
		int val = list.get(1);
		System.out.println(val);
		
		list.set(1, 2000);
		System.out.println(list + " -> " + list.size());
		
		list.remove(1);
		System.out.println(list + " -> " + list.size());
		
		
		ArrayList<String> l2 = new ArrayList<>();
		l2.add("Hello");
		l2.add("World");
		l2.add("suck it");
		
		System.out.println(l2 + " -> " + l2.size());
		
		for(int val1: list) {
			System.out.println(val1);
		}
	}
}
