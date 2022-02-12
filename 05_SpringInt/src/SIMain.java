
public class SIMain {

	public static void main(String[] args) {

		//phone
		
		
		//1.버전 출시후 수정 원하면 싹다 갈아야됨
		Iphone i = new Iphone();
		
		Galaxy g = new Galaxy();
		
		System.out.println("--------------");
		
		//2.다형성(상위타입에 하위타입 넣는거)
		//객체만 바꿔주면 되는데 다시 수정 다시 배포
		//여기까지가 java 한계, 다음이 Spring
		//Spring은 객체를 밖에 (xml)
		
		
		Phone p = new Galaxy();
		p.logo();
		
		p = new Iphone();
		p.logo();
		
		
		
	}

}
