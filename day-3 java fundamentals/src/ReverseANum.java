import java.util.Scanner;

public class ReverseANum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a num");
		int n = sc.nextInt();
		int rev = 0;
		while (n!=0) {
			 int rem = n % 10;
	         rev = rev * 10 + rem;
	         n = n / 10;
		}
		System.out.println("Reversed num :" + rev);
		sc.close();
	}

}
