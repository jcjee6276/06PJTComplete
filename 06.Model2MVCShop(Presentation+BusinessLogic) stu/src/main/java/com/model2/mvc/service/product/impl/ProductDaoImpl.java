package com.model2.mvc.service.product.impl;

import java.util.Map;
import java.util.List;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::"+getClass()+".setSqlSession()  Call.....");
		this.sqlSession = sqlSession;
	}
	public ProductDaoImpl() {
		System.out.println(this.getClass());
	}
	
	public void addProduct(Product product) throws Exception{
		sqlSession.insert("ProductMapper.addProduct", product);
	}
	
	public Product findProduct(int productNo) throws Exception {
		return sqlSession.selectOne("ProductMapper.findProduct", productNo);
	}
	
	public List<Product> getProductList(Search search) throws Exception{
		return sqlSession.selectList("ProductMapper.getProductList", search);
	}
	
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("ProductMapper.getTotalCount", search);
	}
	
	public void updateProduct(Product product) throws Exception {
		sqlSession.update("ProductMapper.updateProduct", product);
	}
}
