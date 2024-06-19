import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main_BJ_12891_DNA비밀번호 {
	
	static int[] minOccurs;
	
	public static void main(String[] args) throws Exception {
		//DNA문자열 ==> 'A', 'C', 'G', 'T' 문자로만 구성된 문자열

//		System.setIn(InputStream in);
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int strLength = sc.nextInt(); //DNA문자열 길이
		int	subStrLength = sc.nextInt(); //비밀번호롤 사용할 부분문자열 길이
		int answer = 0;
		
		String DNAStr = sc.next(); //"CCTGGATTG" DNA문자열
		minOccurs = new int[4]; //'A', 'C', 'G', 'T'의 최소 출현횟수 저장
		
//		for(int i=0; i<minOccurs.length; i++) {
		for(int i=0 ; i<4; i++){
				minOccurs[i] = sc.nextInt();
		}
		
//		System.out.println(Arrays.toString(minOccurs));
		
		//각 문자가 0번 이상 발생할 수 있으므로 각 문자 키값에 기본값 0을 입력
		//Key(유일한값)-A/C/G/T Value - 윈도우 너비 내의 출현 카운트
		Map<Character, Integer> map = new HashMap<>();
			map.put('A', 0);
			map.put('C', 0);
			map.put('G', 0);
			map.put('T', 0);
			
		//가장 처음 윈도우 창 달기
		for(int i=0; i<subStrLength; i++) {
			map.put(DNAStr.charAt(i), map.get(DNAStr.charAt(i))+1);
		}
		
		//우측으로 한칸씩 (같은 너비를 유지한 채) 윈도우 이동
		if(check(map))
			answer++;
		//첫번째 너비를 검사
		
		//=> 왼쪽 첫번째는 빼기, 오른쪽 새로 들어오는 정보는 더하기
		//=> 슬라이딩 위도우는 너비가 클수록 연산의 횟수를 많이 줄여 줄 수 있음
		
		for(int i=1; i+subStrLength <= strLength; i++) {
			char delKey = DNAStr.charAt(i-1); //제거(빼기)할 인덱스 찾기
			char addKey = DNAStr.charAt(i-1 + subStrLength); //추가(더하기)할 인덱스 찾기
			
			map.put(delKey, map.get(delKey)-1); //제거할 문자 카운트 1감소후 수정
			map.put(addKey, map.get(addKey)+1); //추가할 문자 카운트 1증가후 수정
			
//			if(check(map) == true)
			if(check(map))
				answer++;
			
		}
		
		
		System.out.println(answer);
		
		sc.close();
		
	}//main
	
	
	//윈도우 너비내에 각 문자의 출현 횟수가 주어진 최소 출현횟수보다 많은지 체크
	static boolean check(Map<Character, Integer> map) {
		
		for(Character key : map.keySet()) {
			if(key == 'A') {
				if(map.get(key) < minOccurs[0]) return false;
			} else if(key == 'C') {
				if(map.get(key) < minOccurs[1]) return false;
			} else if(key == 'G') {
				if(map.get(key) < minOccurs[2]) return false;
			} else if(key == 'T') {
				if(map.get(key) < minOccurs[3]) return false;
			}
		}
		return true;
	}
}//end class
