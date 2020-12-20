package com.ust.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ust.cart.entities.Product;
import com.ust.cart.repo.CartRepository;


@SpringBootTest
class EcartApplicationTests {
	
	@Autowired
	private CartRepository cartRepository;

	
	public void CreateProduct() {
		Product product = new Product();
		
		product.setTitle("Brief History of time");
		product.setPrice(570.85f);
		product.setDescription("Study of Black Holes");
		product.setCategory("Book");
		product.setImage("www.books.science/bhwt.jpg");
		
		cartRepository.save(product);
		System.out.println(product.getTitle() + " has been added");
	}
	
	
	public void updateProductById()
	{
		Product product = cartRepository.findById(1).get();
		product.setDescription("Features 855");
		cartRepository.save(product);
		System.out.println(product.getTitle() + " has been Updated");
	}
	
	
	public void deleteProductById()
	{
		Product product = cartRepository.findById(4).get();
		cartRepository.delete(product);
		System.out.println(product.getTitle() + " has been deleted");
	}
	
	@Test
	public void findAllProducts()
	{
		Iterable<Product> itr = cartRepository.findAll();
		for (Product product : itr) {
			System.out.println(product);
		}
	}
	

}
