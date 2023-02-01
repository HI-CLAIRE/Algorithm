package S5;

import java.util.Scanner;

public class 팩토리얼0의개수_1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		int num = sc.nextInt();
		int count = 0;
 
		while (num >= 5) {
			count += num / 5;
			num /= 5;
		}
		System.out.println(count);
		sc.close();
	}
}
