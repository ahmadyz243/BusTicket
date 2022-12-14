package base;

import java.util.List;

public interface BaseService<E> {
    void save(E e);
    E update(E e);
    void delete(E e);
    void deleteById(int id);
    E findById(int id);
    List<E> findAll();
    void beginTransAction();
    void commitTransaction();
}

