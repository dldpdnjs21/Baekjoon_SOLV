import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//import java.util.Scanner;

public class Main_BJ_1000 {
	public static void main(String[] args) throws Exception {
		//입력도구 : Scanner, BufferedReader
		//A a = new A(); ==> A클래스의 멤버를 사용할 준비
//		Scanner sc = new Scanner(System.in); //==> Scanner 클래스의 멤버를 사용할 준비
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//==> BufferedReader 클래스의 멤버를 사용할 준비
		
		//입력 데이터 => 1 2
//		int su1 = sc.nextInt();
//		int su2 = sc.nextInt();
//		System.out.println(su1+su2);
//		System.out.println(sc.nextInt()+sc.nextInt()); //Scanner
		
		String str = br.readLine(); //str="1 2"
		StringTokenizer tokens = new StringTokenizer(str, " ");
		int su1 = Integer.parseInt(tokens.nextToken()); //Integer.parseInt("1") => 1
		int su2 = Integer.parseInt(tokens.nextToken()); // Integer.parseInt("2") => 2
		System.out.println(su1+su2);
		
//		sc.close(); //Scanner 입출력 객체 자원 반환
	}//main
}
