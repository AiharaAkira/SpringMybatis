import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Easy Maintenance

//수정이 일어날만한 부분 : 외부파일에 (D:\mmm)
//java에서는 그 파일을 불러다가 사용
public class Emain {

	public static void main(String[] args) throws IOException {

		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("구매가격: ");
			int price = sc.nextInt();
			
			FileReader fr = new FileReader("D:\\mmm/pointRate.txt");
			BufferedReader br = new BufferedReader(fr);
			String pr = br.readLine();
			
			double pointRate = Double.parseDouble(pr);

			
			double point = price * pointRate;

			System.out.printf("적립포인트:%.1f점", point);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}

	}

}
