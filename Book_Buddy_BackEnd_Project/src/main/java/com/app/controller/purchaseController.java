package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Purchase;
import com.app.security.UserPrinciple;
import com.app.service.PurchaseService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/purchase")
public class purchaseController {

	@Autowired
	public PurchaseService purchaseService;
	
	@PostMapping
	public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase){
		return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
	}
	
//	@GetMapping
//	public ResponseEntity<?> getAllPurchases(@AuthenticationPrincipal UserPrinciple userPrinciple){
//		return ResponseEntity.ok(purchaseService.findPurchaseBookOfUser(userPrinciple.getId()));
//	}
//	
}
