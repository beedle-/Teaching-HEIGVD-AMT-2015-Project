package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.AbstractGenericEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 * adapted by Bastien Rouiller
 */
@Local
public interface IGenericDAO<T extends AbstractGenericEntity> {

  public long create(T t);

  public T createAndReturnManagedEntity(T t);

  public void update(T t);

  public void delete(T t);

  public long count();
  
  public T findById(long id);

  public List<T> findAll();
  
  public List<T> findAllByPage(int pageSize, int pageIndex);

}
