package SWEA;

import java.util.Scanner;

class Node {
	int data;
	Node left;
	Node right;
	Node(int data) {
		this.data = data;
	}
}

public class 중위순회_개념 {

	public Node root;
	
	public void creatNode(int data, int leftData, int rightData) {
		if(root == null) {         // 초기값 
			root = new Node(data);
			
			if(leftData != -1) {   // 좌우 값이 있는 경우
				root.left = new Node(leftData);   // 왼쪽 자식 노드
			}
			if(rightData != -1) {
				root.right = new Node(rightData); // 오른쪽 자식 노드
			}
			// 초기 상태가 아니라면, 루트 노드 생성 이후 만들어진 노드 중 어떤 것인지 찾기
			else searchNode(root, data, leftData, rightData);
		}
	}
	
	// 매개변수로 들어온 node를 시작으로 data와 같은 값을 가지는 노드 찾기
	// 찾을 때까지 root노드에서부터 왼쪽, 오른쪽으로 내려간다. 
	public void searchNode(Node node, int data, int leftData, int rightData) {
		if(node == null) return; // 재귀 탈출
		else if(node.data == data) {
			if(leftData != -1) node.left = new Node(leftData);
			if(rightData != -1) node.left = new Node(rightData);
			else {
				searchNode(node.left, data, leftData, rightData);
				searchNode(node.right, data, leftData, rightData);
			}
		}
	}
	
	public void inOrder(Node node) {
		if(node != null) {
			if(node.left != null) inOrder(node.left);
			System.out.println(node.data + " ");
			if(node.right != null) inOrder(node.right);
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int tc=1; tc<=10; tc++) {
			for(int i=0; i<N; i++) {
				int a = sc.nextInt();
				

			}
			
		}

	}

}
