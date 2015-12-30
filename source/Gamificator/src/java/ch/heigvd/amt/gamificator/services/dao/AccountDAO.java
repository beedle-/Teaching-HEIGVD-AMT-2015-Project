/* 
 *
 * @author Bastien Rouiller
 */
package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.Account;
import ch.heigvd.amt.gamificator.model.entities.Permission;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class AccountDAO extends GenericDAO<Account> implements AccountDAOLocal
{
    @EJB
    PermissionDAOLocal permissionDAO;
    
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

    public Account verifyLogin(String email, String password)
    {
        Account result = null;

        try
        {
            result = (Account) em.createNamedQuery("Account.verifyLogin").setParameter("email", email).setParameter("password", password).getSingleResult();
        } 
        catch (NoResultException e)
        {
            return null;
        }
        return result;     
    }
    
    /*
    public int countAccounts()
    {
        return((Number)em.createNamedQuery("Account.countAccounts").getSingleResult()).intValue();
    }
    */

    @Override
    public void assignPermission(String email, String permission)
    {
        Account account = findByEmail(email);
        Permission p = permissionDAO.findByNameOrCreateIfNotFound(permission);
        account.addPermission(p);
    }
}
