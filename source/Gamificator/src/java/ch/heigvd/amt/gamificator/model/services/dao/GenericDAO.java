package ch.heigvd.amt.gamificator.model.services.dao;

import ch.heigvd.amt.gamificator.model.entities.AbstractGenericEntity;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olivier Liechti
 * adapted by Bastien Rouiller
 */
public class GenericDAO<T extends AbstractGenericEntity> implements IGenericDAO<T> {

  @PersistenceContext
  EntityManager em;

  private final Class<T> jpaEntityClass;

  public GenericDAO() {
    this.jpaEntityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }

  @Override
  public long create(T t) {
    T managedEntity = createAndReturnManagedEntity(t);
    long id = managedEntity.getId();
    return id;
  }

  @Override
  public T createAndReturnManagedEntity(T t) {
    em.persist(t);
    em.flush();
    return t;
  }

  @Override
  public void update(T t) {
    em.merge(t);
  }

  @Override
  public void delete(T t) {
    em.remove(t);
  }

  @Override
  public long count() {
    return (long)em.createQuery("Select count(t) from " + jpaEntityClass.getSimpleName() + " t").getSingleResult();
  }

  @Override
  public T findById(long id) {
    return em.find(jpaEntityClass, id);
  }

  @Override
  public List<T> findAll() {
    return em.createQuery("Select t from " + jpaEntityClass.getSimpleName() + " t").getResultList();
  }

  @Override
  public List<T> findAllByPage(int pageSize, int pageIndex) {
    return em.createQuery("Select t from " + jpaEntityClass.getSimpleName() + " t").setMaxResults(pageSize).setFirstResult(pageIndex*pageSize).getResultList();
  }
  
  

}
