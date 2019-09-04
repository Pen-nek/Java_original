package dao;

import java.util.ArrayList;
import java.sql.*;

import dto.Product;

public class ProductRepository {
	
	private ArrayList<Product> listOfProducts = new ArrayList<Product>();	// 배열 만들기
	private static ProductRepository instance = new ProductRepository();	// 인스턴스 만들기

	public static ProductRepository getInstance(){
		return instance;
	} 

	public ProductRepository() {
		
		// 오라클 드라이버 및 DB 연결
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "madang", "madang");
		} catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
            e.printStackTrace();
		} catch (SQLException e) {
		    System.out.println("DB연결 문제");
		    e.printStackTrace();
		}
		
		// sql구문 실행
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from product";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				String p_id = rs.getString("p_id");
				String p_name = rs.getString("p_name");
				int p_unitprice = rs.getInt("p_unitprice");	
				String p_description = rs.getString("p_description");
				String p_category = rs.getString("p_category");
				String p_publisher = rs.getString("p_publisher");
				int p_unitsInStock = rs.getInt("p_unitsInStock");
				String p_condition = rs.getString("p_condition");
				String p_filename = rs.getString("p_filename");
				
				Product newProduct = new Product(p_id, p_name, p_unitprice);
				newProduct.setDescription(p_description);
				newProduct.setCategory(p_category);
				newProduct.setPublisher(p_publisher);
				newProduct.setUnitsInStock(p_unitsInStock);
				newProduct.setCondition(p_condition);
				newProduct.setFilename(p_filename);
				
				listOfProducts.add(newProduct);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// 배열의 모든 상품 가져오기
	public ArrayList<Product> getAllProducts() {	
		return listOfProducts;
	}
	
	// 제품 id로 특정 상품 1개를 가져오는 메소드
	public Product getProductById(String productId) {
		Product productById = null;	// 제품id로 불러온 상품을 저장할 Product객체 생성

		for (int i = 0; i < listOfProducts.size(); i++) {	// 리스트의 처음부터 끝까지 반복
			Product product = listOfProducts.get(i);	// 리스트에서 현재 차례에 맞는 값을 불러와 Product 객체에 저장
			// 현재 장바구니에 값이 있고, 제품id값이 있고,
			if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
				productById = product;
				break;
			}
		}
		return productById;
	}
	
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}
}
