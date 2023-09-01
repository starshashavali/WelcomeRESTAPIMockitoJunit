package com.gis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gis.entity.OrderEntity;

public interface OrderRepo  extends JpaRepository<OrderEntity, Integer>{

}
