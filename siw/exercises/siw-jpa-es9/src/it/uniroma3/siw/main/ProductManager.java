package it.uniroma3.siw.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import it.uniroma3.siw.model.Product;

public class ProductManager {
	
	private List<Product> createProducts() {
		
		List<Product> prods = new ArrayList<Product>();
		
		Product product1 = new Product("A", 2.3F, "a", "1234");
		Product product2 = new Product("B", 1.15F, "b", "1234");
		Product product3 = new Product("C", 3.10F, "c", "1234");
		Product product4 = new Product("D", 5.0F, "d", "1234");
		Product product5 = new Product("E", 0.55F, "e", "1234");
		Product product6 = new Product("F", 3.10F, "f", "1234");
		Product product7 = new Product("G", 1.15F, "g", "1234");
		Product product8 = new Product("H", 5.0F, "h", "1234");
		Product product9 = new Product("I", 0.55F, "i", "1234");
		Product product10 = new Product("L", 20.0F, "l", "1234");
		
		prods.add(product1);
		prods.add(product2);
		prods.add(product3);
		prods.add(product4);
		prods.add(product5);
		prods.add(product6);
		prods.add(product7);
		prods.add(product8);
		prods.add(product9);
		prods.add(product10);
		
		return prods;
	}
	
	protected void initializeProducts(EntityManager em) {
		EntityTransaction tx = em.getTransaction();
		
		List<Product> prods = createProducts();
		
		tx.begin();
		for(Product prod: prods)
			em.persist(prod);
		tx.commit();
	}
	
	protected List<Product> findProductByLowerPrice(Float price, EntityManager em) {
		
		TypedQuery<Product> query = 
				em.createQuery("SELECT p FROM Product p WHERE p.price <= :price", Product.class);
		query.setParameter("price", price);
		List<Product> resultList = query.getResultList();
		return resultList;
	}
	
	protected List<Product> findProductByUpperPrice(Float price, EntityManager em) {
		
		TypedQuery<Product> query = 
				em.createQuery("SELECT p FROM Product p WHERE p.price >= :price", Product.class);
		query.setParameter("price", price);
		List<Product> resultList = query.getResultList();
		return resultList;
	}
	
	protected Map<Float,Long> findPriceToNumberOfProducts(EntityManager em) {
		Map<Float,Long> price2count = new HashMap<>();
		TypedQuery<Object[]> query = em.createQuery("SELECT p.price, count(p) FROM Product p GROUP BY p.price", Object[].class);
		
		for (Object[] o : query.getResultList())
			price2count.put((Float)o[0], (Long)o[1]);
		
		return price2count;
	}
	
	protected List<Product> findProductsWithMaxPrice(EntityManager em) {
		TypedQuery<Product> query = 
				em.createQuery("SELECT p FROM Product p WHERE p.price = (SELECT MAX(p.price) FROM Product p)", 
						Product.class);
		List<Product> resultList = query.getResultList();
		return resultList;
	}

	public List<Product> findProductsWithMinPrice(EntityManager em) {
		TypedQuery<Product> query = 
				em.createQuery("SELECT p FROM Product p WHERE p.price = (SELECT MIN(p.price) FROM Product p)", 
						Product.class);
		List<Product> resultList = query.getResultList();
		return resultList;
	}
	
	protected void printListOfProducts(List<Product> prods) {
		for(Product prod: prods)
			System.out.print(prod);
	}
}
