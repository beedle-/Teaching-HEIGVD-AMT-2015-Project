/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.Event;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class EventDAO extends GenericDAO<Event> implements EventDAOLocal
{
    @EJB
    ApplicationDAOLocal applicationDAO;
    
    public Event findByName(String apiKey, String eventName)
    {
        Event result = null;
        applicationDAO.findByApiKey(apiKey);
        
        try
        {
            result = (Event) em.createNamedQuery("Event.findByName").setParameter("eventName", eventName).setParameter("apiKey", apiKey).getSingleResult();
        } 
        catch (NoResultException e)
        {
            return null;
        }
        return result;     
    }
}
