package repository;

import base.BaseRepository;
import domain.Company;

public interface CompanyRepository extends BaseRepository<Company> {
    boolean existsByUsername(String username);
    Company findByUsername(String username);
}
