import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_11047<T> {
	private Object[] nodes;
	private int lastIndex;
	private final int SIZE;
	
	public Main_BJ_11047(int size) {
		SIZE = size;
		nodes = new Object[size+1]; //0인덱스 사용 안함
	}
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	private boolean isFull() {
		return lastIndex == SIZE;
	}
	
	//데이터 추가
	public void add(int i) {
		if(isFull()) {//ArrayIndexOutOfBounds Exception
			System.out.println("포화상태입니다..");
			return;
		}
		nodes[++lastIndex] = i;
	}
	public void bfs() {
		//1.큐(대기열FIFO)생성 Queue : 구현체(LinkedList.ArrayDeque)
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//2. 큐에 루트노드 입력
		queue.offer(1);//'A'가 입력된 배열 인덱스
		
		int current;
		//3. 반복문 : 빈 대기열확인
		while(!queue.isEmpty()) {//종료조건 (데이터가 있다면 반복)
			current = queue.poll();//(기준,부모노드)데이터 뽑기
			
			//데이터에 대한 처리 ==> 데이터 출력
			System.out.println(nodes[current]);
			
			//자식노드 찾기 : 이진트리 => *2(왼쪽자식노드) *2+1(오른쪽자식노드)
			//자식노드 대기열에 추가
			if(current*2 <= lastIndex) queue.offer(current*2);
			if(current*2+1 <= lastIndex) queue.offer(current*2+1);
		}
	}//bfs
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		Main_BJ_11047<Character> tree = new Main_BJ_11047<>(N);
		
		for(int i=0; i<N; i++) {
			tree.add(i);
		}//for문
	
		tree.bfs();//이진트리에 대한 너비우선 탐색
	}
}