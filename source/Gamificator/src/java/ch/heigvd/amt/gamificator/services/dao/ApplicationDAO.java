/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.Application;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ApplicationDAO extends GenericDAO<Application> implements ApplicationDAOLocal
{
    @EJB
    AccountDAOLocal accountDAO;
    
    public void assignAccount(String email, Application application)
    {
        application.setAccount(accountDAO.findByEmail(email));
    }
}
