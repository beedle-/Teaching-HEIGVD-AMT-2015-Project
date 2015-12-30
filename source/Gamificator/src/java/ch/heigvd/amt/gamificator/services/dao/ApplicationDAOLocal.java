/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.Application;
import javax.ejb.Local;

@Local
public interface ApplicationDAOLocal extends IGenericDAO<Application>
{
    public void assignAccount(String email, Application application);
}
