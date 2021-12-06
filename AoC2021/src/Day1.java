import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Day1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printDepthIncreases();
		printSlidingWindowIncreases();
		printSlidingWindowIncreases2();
	}
	
	static void printDepthIncreases() {

		File file = new File("input");
		int count = 0;
		try (Scanner scan = new Scanner(file);) {
			int prev = scan.nextInt();
			while (scan.hasNext()) {
				int curr = scan.nextInt();
				if (prev < curr)
					count++;
				prev = curr;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
	}
	
	static void printSlidingWindowIncreases() {
		File file = new File("input");
		int count = 0;
		try (Scanner scan = new Scanner(file);) {
			LinkedList<Integer> ll = new LinkedList<>();
			while (scan.hasNext()) {
				ll.addLast(scan.nextInt());
				if (ll.size() == 4) {
					Integer a = ll.get(0) + ll.get(1) + ll.get(2);
					Integer b = ll.get(1) + ll.get(2) + ll.get(3);
					if (a < b)
						count++;
					ll.pollFirst();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
	}

	
	static void printSlidingWindowIncreases2() {
		File file = new File("input");
		int count = 0;
		List<Integer> list = new ArrayList<>();
		try (Scanner scan = new Scanner(file);) {
			while (scan.hasNext()) {
				list.add(scan.nextInt());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i=1; i<list.size()-2; i++) {
			int a = list.get(i-1) + list.get(i) + list.get(i+1);
			int b = list.get(i) + list.get(i+1) + list.get(i+2);
			if (a < b)
				count++;
		}
		System.out.println(count);
	}

}
