package com.cmw.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MMain {

	public static void main(String[] args) {

		try {
			
			SqlSession ss = DBManager_new.connect();
			
			HttpsURLConnection huc = null;
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("city:");
			String str = sc.next();
			
			String url = "https://api.openweathermap.org/data/2.5/weather?q="+str+"&units=metric&appid=aa7b9386aea6402f6b5f06d2db012668";
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			//json 데이터 받은거 파싱 jsonparser
			
			JSONParser jp = new JSONParser();
			
			//만든 그 객체로 isr 넣어서 파싱준비
			JSONObject weatherData = (JSONObject) jp.parse(isr);
			
			System.out.println(weatherData);
			
			//원하는 데이터 추출
			
			//온도
			JSONObject main = (JSONObject) weatherData.get("main");
			System.out.println("현재온도:"+main.get("temp"));
			//국가
			JSONObject sys = (JSONObject) weatherData.get("sys");
			System.out.println("현재국가:"+sys.get("country"));
			//도시
			 
			System.out.println("현재국가:"+weatherData.get("name"));
			
			
			//설명
			JSONArray weather = (JSONArray) weatherData.get("weather");
			JSONObject wObj= (JSONObject) weather.get(0);
			String description = (String) wObj.get("description");
			
			System.out.println("날씨정보:"+description);
			
			//mybatis작업
			
			ss.insert("mzqqq.regCurWeather");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
