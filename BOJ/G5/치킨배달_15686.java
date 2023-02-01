package G5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 치킨배달_15686 {
	
	static List<int[]> houseList = new ArrayList<>();
	static List<int[]> chickenList = new ArrayList<>();
	static List<int[]> survivedList = new ArrayList<>();
	static int M;
	static int min = Integer.MAX_VALUE; // 가장 최소의 값(정답)
	
//	private static void sListPrinter() {
//		
//		System.out.print("survivedList is : ");
//		for(int[] arr : survivedList) {
//			System.out.printf("[%d, %d] ", arr[0], arr[1]);
//		}
//		System.out.println();
//	}
	
	//1. M개의 치킨집 뽑아 survivedList에 저장, 반환값은 없음
	private static void survivedM(int M, int cnt, int idx) {
		if(cnt == M) return;
		
		for(int i=idx; i<chickenList.size(); i++) {
			
			survivedList.add(chickenList.get(i));
			survivedM(M, cnt+1, i+1);
			
			int tmp = sumChicken();
			min = Math.min(min, tmp);
			
			// 재귀돌 때 마지막 요소를 지워주기 
			survivedList.remove(survivedList.size()-1);
		}
//		sListPrinter();
	}
	
	//2. 모든 집들의 치킨거리의 합, 반환값은 그 합(int)
	private static int sumChicken() {
		int sum = 0;
		for(int[] house : houseList) {
			sum += houseToChicken(house);
		}
		return sum;
	}
	
	//3. 한 집에서 가장 가까운 치킨집까지의 거리(int[] house), 반환값은 그 거리 int
	private static int houseToChicken(int[] house) {
		int distance = Integer.MAX_VALUE;
		for(int[] chicken : survivedList) {
			int tmp = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
			distance = Math.min(distance, tmp);
		}
		return distance;
	}	
	
	//main 함수 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt();
			
		// 가정집의 좌표와 치킨집의 좌표만 arraylist에 저장한다.
		for(int j=0; j<N; j++) {
			for(int i=0; i<N; i++) {
				int num = sc.nextInt();
				int[] arr = {j, i};
				
				if(num == 1) houseList.add(arr);
				else if(num == 2) chickenList.add(arr);
			}
		}
		survivedM(M, 0, 0);
		System.out.println(min);
		sc.close();
	}
}