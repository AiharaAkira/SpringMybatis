package com.cmw.smb2;

import java.util.List;
import java.util.Map;

//select(결과가 여러개)
//List

//CUD = int
//U=결과가 여러개 나올수 있는 걸 예상하면 ==1 >=1

//디테일을 보고싶다. 원하는 결과가 단, 하나.
//Menu(javaBean)
//#{menu}어트리뷰트이름을 다른걸로

public interface Mapper {
	List<Product> getAllProduct();

	int deleteProduct(Product product);

	int regProduct(Product product);

	List<Product> searchProductByRange(Price p);

	List<Product> searchProductByName(Product product);

	List<Product> searchProductByLowerPrice(Product product);

	int updateNewPrice(Map<String, String> prices);
}
