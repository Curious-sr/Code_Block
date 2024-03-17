package com.csmtech.service;

import java.util.List;

import com.csmtech.model.Subscription;

public interface SubscriptionService {
	List<Subscription> allSubscriptionList(Integer sId);

	Double getCostByCid(Integer fId);

	List<Subscription> getAllData();

}
