import java.util.Scanner;

/**
 * Testing class for BoundedQueue problem.
 * @author aditya29
 *
 */
public class Tester {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int size = 0;
		int flag = 0;
		String inst;
		int rm;

		System.out
				.println("Please enter an integer that will represent the size of your BoundedQueue: \n");
		size = sc.nextInt();
		BoundedQueue bq = new BoundedQueue(size);
		System.out.println("\nA BoundedQueue of size " + size
				+ " has been created. It is currently empty.\n");

		System.out.println("Instructions: ");
		System.out
				.println("1. To enter a number into queue, just type in an integer.");
		System.out.println("2. To dequeue, please enter 'dq'.");
		System.out.println("3. To see status, please enter 'status'");
		System.out.println("4. To quit, please enter 'quit'.\n");

		while (flag >= 0) {
			System.out.println("Please enter an instruction: \n");

			inst = sc.next();

			if (isInteger(inst)) {
				int x = Integer.parseInt(inst);
				bq.enqueue(x);
				System.out.println(x + " was inserted.\n");
			} else if (inst.equalsIgnoreCase("dq")) {
				rm = bq.dequeue();
				System.out.println(rm + " was removed.\n");
			} else if (inst.equalsIgnoreCase("quit")) {
				System.out.println("Quitting.");
				flag = -1;
			}
			else if (inst.equalsIgnoreCase("status"))
			{
				System.out.println("There are currently " + bq.getCount() + " elements in the BoundedQueue.\n");
				String s = "The elements of the BoundedQueue are: ";
				for(int e = 0; e < bq.getCount(); e++)
				{
					s += bq.getElem(e) + " ";
				}
				System.out.println(s + "\n");
			}
		}
	}

	/**
	 * Returns true if a string is an integer.
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		if (str == null)
			return false;

		int length = str.length();
		
		//no entry, obv false
		if (length == 0) {
			return false;
		}
		
		int i = 0;
		
		//check if it's negative; if only a negative sign, then false.
		if (str.charAt(0) == '-') 
		{
			if (length == 1)
				return false;
			i = 1;
		}
		
		//check the rest of the string for only numbers
		for (; i < length; i++)
		{
			char c = str.charAt(i);
			if (c <= '/' || c >= ':')
				return false;
		}
		return true;
	}
}
