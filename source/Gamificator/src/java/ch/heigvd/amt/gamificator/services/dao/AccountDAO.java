/* 
 *
 * @author Bastien Rouiller
 */
package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.Account;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class AccountDAO extends GenericDAO<Account> implements AccountDAOLocal
{

    public Account findByEmail(String email)
    {
        Account result = null;

        try
        {
            result = (Account) em.createNamedQuery("Account.findByEmail").setParameter("email", email).getSingleResult();
        } 
        catch (NoResultException e)
        {
            return null;
        }
        return result;       
    }
}
