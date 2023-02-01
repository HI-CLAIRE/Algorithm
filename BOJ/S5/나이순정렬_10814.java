package S5;

import java.util.Scanner;

class student {
	
	int age;
	String name;
	
	student(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

public class 나이순정렬_10814 {
	
	private static int minFinder(student[] arr) {
		
		int min = Integer.MAX_VALUE;
		
		for(student tmp : arr)
			min = Math.min(min, tmp.getAge());
		
		return min;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		student[] arr = new student[T];
		for(int n=0; n<T; n++) {
			arr[n] = new student(sc.nextInt(), sc.next());
		}
		
		
		while(T > 0) {
			int min = minFinder(arr);
	 		for(student tmp : arr) {
	 			if(min == tmp.getAge()) {
	 				System.out.println(tmp.getAge() + " " + tmp.getName());
	 				tmp.setAge(Integer.MAX_VALUE);
	 				T--;
	 			}
	 		}
			
		}
	}

}
