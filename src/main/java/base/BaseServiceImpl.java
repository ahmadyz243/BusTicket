package base;

import javax.persistence.NoResultException;
import java.util.List;

public abstract class BaseServiceImpl<E extends BaseEntity, R extends BaseRepository<E>> implements BaseService<E>{
    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    protected final R repository;
    @Override
    public void save(E e) {
        repository.beginTransAction();
        repository.save(e);
        repository.commitTransAction();
    }

    @Override
    public E update(E e) {
        repository.beginTransAction();
        E e1 = repository.update(e);
        repository.commitTransAction();
        return e1;
    }

    @Override
    public void delete(E e) {
        repository.beginTransAction();
        repository.delete(e);
        repository.commitTransAction();
    }

    @Override
    public void deleteById(int id) {
        repository.beginTransAction();
        repository.deleteById(id);
        repository.commitTransAction();
    }

    @Override
    public E findById(int id) {
        try {
            return repository.findById(id);
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public void beginTransAction() {
        repository.beginTransAction();
    }

    @Override
    public void commitTransaction() {
        repository.commitTransAction();
    }
}