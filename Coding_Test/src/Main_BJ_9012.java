import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_9012 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //입력데이터의 수
		for(int i=0; i<T; i++) {
			
			String str = br.readLine(); //괄호 문자열 ()
			char arr[] = str.toCharArray();
			Stack<Character> stack = new Stack<>();
			
			for(int j=0; j<arr.length; j++) {

				if(arr[j]=='(') {
					//괄호가 열려있는 경우
					//바로 스택에 저장
						stack.push(arr[j]);
					} else { //괄호가 ')'인 경우
						if(stack.empty()) { //비어있으면 저장
							stack.push(arr[j]);
						}else { //비어있지않다면
							if(stack.peek()=='(') { //앞에 저장된 스택이 '('이면 날리기
							stack.pop();
							}
						}
					}
				}
			if(stack.empty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	
}