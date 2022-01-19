import java.util.Scanner;

//Bad Maintenance

//jar 


//프로젝트 열어서(새로 작성해서) -> 소스코드 수정 -> 테스트 -> 재배포(jar) -> 다시건내주기
public class BMain {

	public static void main(String[] args) {

		// 물건을 샀는데 포인트 적립

		// 구매가격:1000
		// 적립포인트:100(10프로)

		Scanner sc = new Scanner(System.in);

		System.out.println("구매가격: ");
		int price = sc.nextInt();

		double pointRate = 0.1;
		
		double point = price * pointRate;

		System.out.printf("적립포인트:%.1f점", point);

	}

}
