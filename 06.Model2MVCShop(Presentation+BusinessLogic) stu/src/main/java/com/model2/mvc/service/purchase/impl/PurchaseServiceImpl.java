package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDao;
import com.model2.mvc.service.purchase.PurchaseService;

//import com.model2.mvc.service.purchase.PurchaseService;

@Service("purchaseServiceImpl")
public class PurchaseServiceImpl implements PurchaseService{
	 
	//private ProductDAO productDAO;
	@Autowired
	@Qualifier("purchaseDaoImpl")
	private PurchaseDao  purchaseDao;
	public void setPurchaseDao(PurchaseDao purchaseDao) {
			this.purchaseDao =  purchaseDao;
	}
	
	public PurchaseServiceImpl() {
		//productDAO = new ProductDAO();
		System.out.println(this.getClass());
	}
	
	//public PurchaseVO addPurchase(PurchaseVO purchaseVO) throws Exception {
		
		
		//return 
	//}
	public Purchase getPurchase(int tranNo) throws Exception {
		//System.out.println(purchaseDAO.findPurchase(prodNo).getPurchaseProd());
		
		return purchaseDao.getPurchase(tranNo);
	}

	
	public void addPurchase(Purchase purchase) throws Exception{
		// TODO Auto-generated method stub
		 purchaseDao.addPurchase(purchase);
	}
	
	
	
	public Map<String, Object> getPurchaseList(Search search) throws Exception {
		List<Purchase> list = purchaseDao.getPurchaseList(search);
		int totalCount = purchaseDao.getTotalCount(search);
		//System.out.println("dao total ¸î°Ô"+totalCount);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		
		
		return map;
	}

	/*
	public Map<String, Object> getSaleList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}*/

	
	public void updatePurchase(Purchase purchase) throws Exception {
		// TODO Auto-generated method stub
		 purchaseDao.updatePurchase(purchase);
	}

	
	public void updateTranCode(Purchase purchase) throws Exception {
		// TODO Auto-generated method stub
		purchaseDao.updateTranCode(purchase);
		
	}

}
