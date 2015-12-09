/* 
 *
 * @author Bastien Rouiller
 */
package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.Role;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class RoleDAO extends GenericDAO<Role> implements RoleDAOLocal
{    
    public Role findByName(String name)
    {
        Role result = null;

        try
        {
            result = (Role) em.createNamedQuery("role.findByName").setParameter("role", name).getSingleResult();
        } 
        catch (NoResultException e)
        {
            return null;
        }
        return result;       
    }

    public Role findByNameOrCreateIfNotFound(String name)
    {
        Role r = findByName(name);
        if(r == null)
        {
            r = new Role();
            r.setRole(name);
            create(r);
        }
        return r;            
    }
}
