package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.Subscription;
import com.csmtech.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	 
	@Override
	public List<Subscription> allSubscriptionList(Integer sId) {
		
		return subscriptionRepository.allSubscriptionList(sId);
	}

	@Override
	public Double getCostByCid(Integer fId) {
		
		return subscriptionRepository.getCostByCid(fId);
	}

	@Override
	public List<Subscription> getAllData() {
		
		return (List<Subscription>) subscriptionRepository.findAll();
	}

}
