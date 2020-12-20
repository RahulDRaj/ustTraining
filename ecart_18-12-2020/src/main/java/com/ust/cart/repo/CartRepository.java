package com.ust.cart.repo;

import org.springframework.data.repository.CrudRepository;

import com.ust.cart.entities.Product;

public interface CartRepository extends CrudRepository<Product, Integer> {

}
