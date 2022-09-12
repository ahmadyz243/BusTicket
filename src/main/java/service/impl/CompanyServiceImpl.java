package service.impl;

import base.BaseServiceImpl;
import domain.ComService;
import domain.Company;
import repository.CompanyRepository;
import service.CompanyService;
import util.Menu;

import java.util.ArrayList;
import java.util.Objects;

public class CompanyServiceImpl extends BaseServiceImpl<Company, CompanyRepository> implements CompanyService {
    public CompanyServiceImpl(CompanyRepository repository) {
        super(repository);
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public Company findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Company signup(String companyName, String username, String password) {
        if(existsByUsername(username)){
            return null;
        }
        Company company = new Company();
        company.setServices(new ArrayList<>());
        company.setName(companyName);
        company.setUsername(username);
        company.setPassword(password);
        save(company);
        return company;
    }

    @Override
    public Company login(String username, String password) {
        Company company;
        if(existsByUsername(username)){
            company = findByUsername(username);
        }else {
            System.out.println("company not exists!");
            return null;
        }
        if (Objects.equals(company.getPassword(), password)){
            System.out.println("login success...");
            return company;
        }else {
            System.out.println("wrong password");
            return null;
        }
    }
}
