package it.uniroma3.siw.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.siw.repository.ProductRepository;

class ProductTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	private static ProductRepository pr;
	
	private String select = "SELECT p FROM Product p";
	private String delete = "DELETE FROM Product p";
	
	@BeforeAll
	public static void initEntityManager() throws Exception {
		emf = Persistence.createEntityManagerFactory("products-unit-test");
		em = emf.createEntityManager();
		pr = new ProductRepository();
		pr.setEntityManager(em);
	}
	
	@AfterAll
	public static void closeEntityManager() throws SQLException {
		if (em != null) em.close();
		if (emf != null) emf.close();
	}

	@BeforeEach
	public void setUp() {
		Product product1;
		Product product2;
		
		product1 = new Product();
		product1.setName("SLANGAN");
		product1.setCode("4321423131-AA");
		
		product2 = new Product();
		product2.setName("ORSOY");
		product2.setCode("5322341131-AA");
		
		Query deleteQuery = em.createQuery(delete);
		
		tx = em.getTransaction();		
		tx.begin();
		
		deleteQuery.executeUpdate();
		em.persist(product1);
		em.persist(product2);
		
		tx.commit();
	}

	@Test
	void testDeleteAll() {
		tx.begin();
		pr.deleteAll();
		tx.commit();
		
		assertEquals(0, em.createQuery(select).getResultList().size());
	}
	
	@Test
	void testSave() {
		Product product = createProd();
		
		tx.begin();
		pr.save(product);
		tx.commit();
		
		assertEquals(3, em.createQuery(select).getResultList().size());
	}
	
	@Test
	void testFind() {
		Product product = createProd();
		
		tx.begin();
		pr.save(product);
		tx.commit();
		
		Product found = pr.findById((long) 3);
		
		assertNotNull(found);
		assertEquals(product,found);
	}
	
	private Product createProd() {
		Product product = new Product();
		product.setName("ELPAS");
		product.setCode("43542341-AB");
		return product;
	}
}
