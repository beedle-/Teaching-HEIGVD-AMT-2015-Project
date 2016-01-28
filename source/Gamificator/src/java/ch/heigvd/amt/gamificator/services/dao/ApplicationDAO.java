/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.Application;
import ch.heigvd.amt.gamificator.model.entities.Event;
import ch.heigvd.amt.gamificator.model.entities.Trophy;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class ApplicationDAO extends GenericDAO<Application> implements ApplicationDAOLocal
{
    @EJB
    AccountDAOLocal accountDAO;
    
    public void assignAccount(String email, Application application)
    {
        application.setAccount(accountDAO.findByEmail(email));
    }
    
    public Application findByApiKey(String apiKey)
    {
        Application result = null;

        try
        {
            result = (Application) em.createNamedQuery("Application.findByApiKey").setParameter("apiKey", apiKey).getSingleResult();
        } 
        catch (NoResultException e)
        {
            return null;
        }
        return result;  
    }

    @Override
    public void addEvent(Event event, Application application)
    {
       application.addEvent(event);
    }

    @Override
    public List<Trophy> getTrophiesList(String apiKey)
    {
        List<Trophy> trophies = new ArrayList<Trophy>();
        for(Event e : findByApiKey(apiKey).getEvents())
        {
            for(Trophy t : e.getTrophies())
            {
                if(!trophies.contains(t))
                {
                    trophies.add(t);
                }
            }
        }
        return trophies;
    }
}
