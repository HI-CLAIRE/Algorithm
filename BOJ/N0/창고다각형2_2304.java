package BOJ;

import java.util.Scanner;

public class 창고다각형2_2304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 기둥의 개수
        
        int[] input = new int[1001]; // 입력값(높이)을 저장하는 배열.
        int gMax = -1; // global max 높이의 최대값
        int gMaxIdx = -1; // global max의 위치 index
        int leftIdx = 1001; // 가장 왼쪽에 있는 기둥의 idx(최소값)
        int rightIdx = -1; // 가장 오른쪽에 있는 기둥의 indx(최대값)
        
        for(int i=0; i<N; i++) {
            int L = sc.nextInt(); // 기둥의 위치
            int H = sc.nextInt(); // 기둥의 높이
            input[L] = H; // 입력값을 저장
            
            if(H > gMax) { // 가장 높은 기둥의 높이와 위치를 찾기
                gMax = H;
                gMaxIdx = L;
            }
            if(L > rightIdx) rightIdx = L; // 가장 오른쪽 index
            if(L < leftIdx) leftIdx = L; // 가장 왼족 기둥의 index
        }
        int[] heights = new int[rightIdx+1]; // 창고 다각형의 높이를 저장할 배열
        // 1. 왼쪽 -> gMaxIdx
        int localMax = -1;
        for(int i=leftIdx ; i < gMaxIdx; i++) {
            int currHeight = input[i];
            if(currHeight > localMax) localMax = currHeight;
            heights[i] = localMax;
        }
        
        // 2. global Max
        heights[gMaxIdx] = gMax;
        
        // 3. 오른쪽 -> gMaxIdx
        localMax = -1;
        for(int i=rightIdx; i > gMaxIdx; i--) {
            int currHeight = input[i];
            if(currHeight > localMax) localMax = currHeight;
            heights[i] = localMax;
        }
        
        // 4. 넓이 계산
        int area = 0;
        for(int i=leftIdx; i <= rightIdx; i++) {
            area += heights[i];
        }
        
        System.out.println(area);
    }
}
