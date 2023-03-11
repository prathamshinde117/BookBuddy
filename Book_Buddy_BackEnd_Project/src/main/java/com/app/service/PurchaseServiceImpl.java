package com.app.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Purchase;
import com.app.repository.PurchaseRepository;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	public PurchaseRepository purchaseRepository;
	
	@Override
	public Purchase savePurchase(Purchase purchase) {
		purchase.setPurchaseTime(LocalDate.now());
		return purchaseRepository.save(purchase);
	}
	
//	@Override
//	public List<PurchaseBooks> findPurchaseBookOfUser(Long userId){
//		return purchaseRepository.findAllPurchaseOfUser(userId);
//	}
}
