package repository.impl;

import base.BaseRepositoryImpl;
import domain.Company;
import repository.CompanyRepository;

public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company> implements CompanyRepository {
    @Override
    public Class<Company> getEntityClass() {
        return Company.class;
    }

    @Override
    public boolean existsByUsername(String username) {
        return em.createQuery("select (count (c) > 0) from Company c where c.username =: username", Boolean.class)
                .setParameter("username", username).getSingleResult();
    }

    @Override
    public Company findByUsername(String username) {
        return em.createQuery("select c from Company c where c.username =: username", Company.class)
                .setParameter("username", username).getSingleResult();
    }
}
