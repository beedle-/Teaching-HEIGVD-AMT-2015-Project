/* 
 * Inspired by MVCDemo
 * Generic class in order to factorate some code amonst entity 
 * 
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.model.entities;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractGenericEntity implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  public Long getId()
  {
      return id;
  }

  public void setId(Long id)
  {
      this.id = id;
  }
}
