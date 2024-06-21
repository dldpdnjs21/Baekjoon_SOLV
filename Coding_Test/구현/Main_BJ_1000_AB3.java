import java.util.Scanner;

public class Main_BJ_1000_AB3 {

	public static void main(String[] args) {
      //입력도구 : Scanner, BufferedReader
	  //A  a  = new A (); ==> A클래스의 멤버를 사용할 준비
	  Scanner  scan  = new Scanner(System.in); //==> Scanner클래스의 멤버를 사용할 준비
	  
	  //입력 데이터 => 1 2
	  
//	  int su1 = scan.nextInt();
//	  int su2 = scan.nextInt();
//	  
//	  System.out.println(su1+su2);

	  
	  System.out.println(scan.nextInt() +scan.nextInt());
	  
      scan.close();//입출력 객체 자원 반환
	}//main

}
