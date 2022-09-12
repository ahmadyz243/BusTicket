package base;

import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class BaseRepositoryImpl<E extends BaseEntity> implements BaseRepository<E> {
    public BaseRepositoryImpl(){
        em = HibernateUtil.getEmf().createEntityManager();
    }
    protected final EntityManager em;

    @Override
    public void save(E e) {
        em.persist(e);
    }

    @Override
    public E update(E e) {
        return em.merge(e);
    }

    @Override
    public void delete(E e) {
        em.remove(e);
    }

    @Override
    public void deleteById(int id) {
        em.createQuery("delete from " + getEntityClass().getSimpleName() + " e where e.id =: id", getEntityClass())
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public E findById(int id) {
        return em.find(getEntityClass(), id);
    }

    @Override
    public List<E> findAll() {
        return em.createQuery("from " + getEntityClass().getSimpleName(), getEntityClass()).getResultList();
    }

    @Override
    public void beginTransAction() {
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
    }

    @Override
    public void commitTransAction() {
        if(em.getTransaction().isActive()){
            em.getTransaction().commit();
        }
    }
}
