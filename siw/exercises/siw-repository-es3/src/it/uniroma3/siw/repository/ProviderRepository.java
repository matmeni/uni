package it.uniroma3.siw.repository;

import it.uniroma3.siw.model.Provider;

public class ProviderRepository extends SimpleRepositoryImpl<Provider> {

	public ProviderRepository() {
		super(Provider.class);
	}
}