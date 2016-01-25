/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.Application;
import ch.heigvd.amt.gamificator.model.entities.Event;
import javax.ejb.Local;

@Local
public interface ApplicationDAOLocal extends IGenericDAO<Application>
{
    public Application findByApiKey(String apiKey);
    public void assignAccount(String email, Application application);
    public void addEvent(Event event, Application application);
}
