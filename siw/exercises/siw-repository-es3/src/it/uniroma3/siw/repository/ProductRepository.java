package it.uniroma3.siw.repository;

import it.uniroma3.siw.model.Product;

public class ProductRepository extends SimpleRepositoryImpl<Product> {

	public ProductRepository() {
		super(Product.class);
	}
}
