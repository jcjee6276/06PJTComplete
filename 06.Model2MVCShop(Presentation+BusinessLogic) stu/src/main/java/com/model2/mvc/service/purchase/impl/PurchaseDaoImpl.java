package com.model2.mvc.service.purchase.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDao;

@Repository("purchaseDaoImpl")
public class PurchaseDaoImpl implements PurchaseDao{

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public PurchaseDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void addPurchase(Purchase purchase) throws Exception {
		sqlSession.insert("PurchaseMapper.insertPurchase", purchase);
	}
	
	public Purchase getPurchase(int tranNo) throws Exception {
		//System.out.println("dao tranNo РќДо "+tranNo);
		return sqlSession.selectOne("PurchaseMapper.getPurchase", tranNo);
	}
	
	public List<Purchase> getPurchaseList(Search search) throws Exception{
			return sqlSession.selectList("PurchaseMapper.getPurchaseList", search);
	}
	
	//public Map<String, Object> getSaleList(Search searchvo) throws Exception;
	
	public void updatePurchase(Purchase purchase) throws Exception{
		 sqlSession.update("PurchaseMapper.updatePurchase", purchase);
	}
	
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("PurchaseMapper.getTotalCount", search);
	}
	
	public void updateTranCode(Purchase purchase) throws Exception{
		sqlSession.update("PurchaseMapper.yeopdateTranCode", purchase);
	}
	
}
