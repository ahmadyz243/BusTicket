package service;

import base.BaseService;
import domain.Company;

public interface CompanyService extends BaseService<Company> {
    boolean existsByUsername(String username);
    Company findByUsername(String username);
    Company signup(String companyName, String username, String password);
    Company login(String username, String password);
}
