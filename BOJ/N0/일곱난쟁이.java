package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 일곱난쟁이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> arr = new ArrayList<>();
		for(int i=0; i<9; i++)
			arr.add(sc.nextInt());
		
		Collections.sort(arr);                         //미리 sort 
		
		int sum = 0;
		for(int i=0; i<9; i++)
			sum += arr.get(i);                         //9명 모두 더한 값
		
		int tmp = 0;
		for(int i=0; i<arr.size(); i++) {              //9명에서 2명을 빼간다 
			for(int j=i+1; j<arr.size(); j++) {        //j를 늘려가며 비교 
				tmp = sum - arr.get(i) - arr.get(j);   //sum에서 직접적으로 빼면 값이 변하므로
				if(tmp == 100) {
					arr.remove(j);                     // j 먼저 지우면 오류가 나지 않음 
					arr.remove(i);                     // j가 i보다 크기 때문에 다른곳에 접근 할 일이 없어
					for(int k : arr)
						System.out.println(k);
					return;
				}
			}
		}
	}

}
