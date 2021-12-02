import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Day1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printDepthIncreases();
		printSlidingWindowIncreases();
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

}
