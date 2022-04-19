package it.uniroma3.siw.main;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.siw.model.Product;

public class ProductMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		
		ProductManager pi = new ProductManager();
		pi.initializeProducts(em);
		
		Map<Float,Long> price2count = pi.findPriceToNumberOfProducts(em);
		System.out.print(price2count);
		
		System.out.print("\n\n");
		
		List<Product> prods;
		prods = pi.findProductsWithMaxPrice(em);
		pi.printListOfProducts(prods);
		
		prods = pi.findProductsWithMinPrice(em);
		pi.printListOfProducts(prods);
		
		em.close();
		emf.close();
	}	
}