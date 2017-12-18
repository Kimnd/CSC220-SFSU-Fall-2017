//If you want to see what's 'really' going on, uncomment the print statements, or add some yourself!
public class stupid{
//This method just lets me print stuff without writing "System.out.println();" five million times
	public static void print(String text) {
		System.out.print(text);
	}

//A method that figures out the 'n'th fibonacci number via self-reference
	public static void stu(int n){
//		print(" [n:" + n + "] ");
		if(n <= 1) {
			return;
		}
//		print("\nstu(n - 1): ");
		stu(n - 1);
//		print("\n    stu(n - 2): ");
		stu(n - 2);
//		print("\n        stu(n - 3): ");
		stu(n - 3);
	}

//This method returns the 'n'th fibonacci number too, but doesn't reference itself to do so
	public static int fib(int n){
		print(" [n at start:" + n + "] ");
		if(n <= 2) {
			print(" (n <= 2, returns 1) ");
			return 1;
		}
		int first = 1;
		int second = 1;
		int next = 0;
		for(int i = 3; i <= n; i++) {//this for loop is what does the heavy lifting for our non-recursive method
//			print(" (i:" + i + ") FIRST: " + first + " SECOND: " + second);
			next = first+second;
			first = second;
			second = next;
//			print(" NEXT: " + next + " --> ");
		}
		print(" Final return: " + next + "\n");
		return next;
	}

//This method calls itself and eventually returns the nth fibonacci number
	public static int fibrec(int n){
		print("\n    [n at start:" + n + "] ");
		if(n <= 2) {
			print(" (n <= 2, return 1) ");
			return 1;
		}
		print(" Final return: " + fibrec(n - 1) + fibrec(n - 2) + "\n");
		return fibrec(n-1)+fibrec(n-2);
	}

	public static void main(String[] args){
		stu(6);
		print("\nNo recursion:   " + fib(6));
		print("\n\nWith recursion: " + fibrec(6));
	}
}
