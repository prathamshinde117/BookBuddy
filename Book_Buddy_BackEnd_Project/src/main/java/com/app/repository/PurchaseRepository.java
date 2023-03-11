package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Purchase;
import com.app.repository.projection.PurchaseBooks;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

//	@Query("select book.name as name, pur.price as price, pur.purchaseTime as "
//			+ "purchaseTime from Purchase pur left join Book book on book.id=pur.bookid "
//			+ "where pur.userId= :userId")
//	List<PurchaseBooks> findAllPurchaseOfUser(@Param("userId") Long userId);
}

