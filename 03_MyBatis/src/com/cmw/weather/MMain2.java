package com.cmw.weather;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MMain2 {

	public static void main(String[] args) {

		try {
			SqlSession ss = DBManager_new.connect();
			
			List<Weather> weathers = ss.selectList("cmwqqq.getAllWeather");
			for (Weather weather : weathers) {
				System.out.println(weather.getW_city());
				System.out.println(weather.getW_country());
				System.out.println(weather.getW_temp());
				System.out.println(weather.getW_date());
				System.out.println(weather.getW_description());
			}
			
			FileOutputStream fos = new FileOutputStream("D:\\sts3.9\\eGovFrameDev-3.9.0-64bit\\workspace\\r.csv",true);
			//fos보다 두꺼운
			OutputStreamWriter osw = new OutputStreamWriter(fos, "euc-kr");
			
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write("city"+",");
			bw.write("country"+",");
			bw.write("date"+",");
			bw.write("temp"+",");
			bw.write("descpiption"+"\r\n");
			for (Weather w : weathers) {
				bw.write(w.getW_city() + ",");
				bw.write(w.getW_country() + ",");
				bw.write(w.getW_temp() + ",");
				bw.write(w.getW_date() + ",");
				bw.write(w.getW_description()+"\r\n");
			}
			
			System.out.println("성공");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
