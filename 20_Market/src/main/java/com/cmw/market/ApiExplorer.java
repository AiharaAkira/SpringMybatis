package com.cmw.market;

import java.io.BufferedReader;
import java.io.IOException;

/* Java 샘플 코드 */
//공공데이터 포털 - OPEN-API Java 샘플코드 참고

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiExplorer {

	public static void main(String[] args) throws IOException {

		// 1. URL을 만들기 위한 StringBuilder.
		StringBuilder urlBuilder = new StringBuilder(
				"https://api.odcloud.kr/api/15035771/v1/uddi:993923fe-3270-4fc6-89e6-e4c1b3ff511c_201909041431?page=1&perPage=10&serviceKey=TLtv07DU2VazaRI0IKuZqa3hBupDXvsL1ubnjOsj1FNtxjM5X%2Ftba%2B4Q75lipY7oTFyyKmbzYeYy13JEvVlkNg%3D%3D"); /*
																																																												 * URL
																																																												 */
		// 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
		urlBuilder.append("?" + URLEncoder.encode("	\r\n"
				+ "TLtv07DU2VazaRI0IKuZqa3hBupDXvsL1ubnjOsj1FNtxjM5X%2Ftba%2B4Q75lipY7oTFyyKmbzYeYy13JEvVlkNg%3D%3D",
				"UTF-8") + "=인코딩된 서비스키"); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "="
				+ URLEncoder.encode("JSON", "UTF-8")); /* XML 또는 JSON */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("10", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append(
				"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지 번호 */
		urlBuilder.append("&" + URLEncoder.encode("cond[country_nm::EQ]", "UTF-8") + "="
				+ URLEncoder.encode("가나", "UTF-8")); /* 한글 국가명 */
		urlBuilder.append("&" + URLEncoder.encode("cond[country_iso_alp2::EQ]", "UTF-8") + "="
				+ URLEncoder.encode("GH", "UTF-8")); /* ISO 2자리코드 */
		// 3. URL 객체 생성.
		URL url = new URL(urlBuilder.toString());
		// 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 5. 통신을 위한 메소드 SET.
		conn.setRequestMethod("GET");
		// 6. 통신을 위한 Content-type SET.
		conn.setRequestProperty("Content-type", "application/json");
		// 7. 통신 응답 코드 확인.
		System.out.println("Response code: " + conn.getResponseCode());
		// 8. 전달받은 데이터를 BufferedReader 객체로 저장.
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		// 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		// 10. 객체 해제.
		rd.close();
		conn.disconnect();
		// 11. 전달받은 데이터 확인.
		System.out.println(sb.toString());
	}
}
