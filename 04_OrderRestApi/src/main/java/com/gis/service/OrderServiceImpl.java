package com.gis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gis.entity.OrderEntity;
import com.gis.repo.OrderRepo;

public abstract class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepo  orderRepo;

	@Override
	public boolean upsert(OrderEntity orderEntity) 
	{
		orderRepo.save(orderEntity);
		 return true;
	}

	public OrderEntity getByOrderId(Integer id) {
		Optional<OrderEntity> findById = orderRepo.findById(id);
		if(findById.isPresent()) {
			
			return findById.get();
		}
		return null;
	}

	@Override
	public List<OrderEntity> getAllOrders() {
		
		return null;
	}

	@Override
	public boolean deleteOrderById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}





}
