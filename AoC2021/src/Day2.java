import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("input_day2");
		List<Integer> values = new ArrayList<>();
		List<String> commands = new ArrayList<>();
		try (Scanner scan = new Scanner(file)) {
			while (scan.hasNext()) {
				commands.add(scan.next());
				values.add(scan.nextInt());
			}
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		int q1 = multipliedHozDepth(commands, values);
		
		System.out.println(q1);
		
		int q2 = multipliedHozDepth2(commands, values);
		System.out.println(q2);
	}
	
	public static int multipliedHozDepth(List<String> commands, List<Integer> values) {
		int hoz = 0;
		int depth = 0;
		for (int i=0; i<commands.size(); i++) {
			String command = commands.get(i);
			int val = values.get(i);
			if (command.equals("forward"))
				hoz += val;
			else if (command.equals("down"))
				depth += val;
			else if (command.equals("up"))
				depth -= val;
			else
				System.out.println("Unknown command: " + command);
		}
		return hoz * depth;
	}
	

	
	public static int multipliedHozDepth2(List<String> commands, List<Integer> values) {
		int hoz = 0;
		int depth = 0;
		int aim = 0;
		for (int i=0; i<commands.size(); i++) {
			String command = commands.get(i);
			int val = values.get(i);
			if (command.equals("forward")) {
				hoz += val;
				depth += val * aim;
			}
			else if (command.equals("down"))
				aim += val;
			else if (command.equals("up"))
				aim -= val;
			else
				System.out.println("Unknown command: " + command);
		}
		return hoz * depth;
	}


}
