/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.EndUser;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class EndUserDAO extends GenericDAO<EndUser> implements EndUserDAOLocal
{
    public EndUser findByIdentifier(String apiKey, String userIdentifier)
    {
        EndUser result = null;

        try
        {
            result = (EndUser) em.createNamedQuery("EndUser.findByIdentifier").setParameter("apiKey",apiKey).setParameter("userIdentifier", userIdentifier).getSingleResult();
        } 
        catch (NoResultException e)
        {
            return null;
        }
        return result;  
    }

}
