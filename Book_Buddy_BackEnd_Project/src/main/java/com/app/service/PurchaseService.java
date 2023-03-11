package com.app.service;

import java.util.List;

import com.app.entities.Purchase;
import com.app.repository.projection.PurchaseBooks;

public interface PurchaseService {

	Purchase savePurchase(Purchase purchase);

//	List<PurchaseBooks> findPurchaseBookOfUser(Long userId);
}
