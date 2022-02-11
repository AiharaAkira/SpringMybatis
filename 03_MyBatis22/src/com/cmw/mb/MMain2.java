package com.cmw.mb;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MMain2 {

	public static void main(String[] args) {

		// 콘솔에 db에 있는거 다나오게
		
		try {
			SqlSession ss = DBManager_new.connect();
			
			List<Weather> weathers = ss.selectList("cmwqqq.getAllweather");
			
//			for (Weather w : weathers) {
//				System.out.println(w.getW_city());
//			}
			
			FileOutputStream fos = new FileOutputStream("D:\\sts3.9\\eGovFrameDev-3.9.0-64bit\\workspace\\r.csv", true);
			
			// fos 보다는 두꺼운
			OutputStreamWriter osw = new OutputStreamWriter(fos, "euc-kr");
			
			BufferedWriter bw = new BufferedWriter(osw);
			
			for (Weather w : weathers) {
				bw.write(w.getW_city()+",");
				bw.write(w.getW_country()+",");
				bw.write(w.getW_temp()+",");
				bw.write(w.getW_description()+"\r\n");
			}
			
			System.out.println("성공");
			bw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
