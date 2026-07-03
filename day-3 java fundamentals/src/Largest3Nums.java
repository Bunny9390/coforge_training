import java.util.Scanner;

public class Largest3Nums {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 3 nums:");
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(a>=b&&a>=c)
			System.out.print("Largets :"+a);
		else if(b>=a && b>=c)
			System.out.print("Largest :"+b);
		else
			System.out.print("Largest :"+c);
		
		sc.close();
		
		
	}

}
