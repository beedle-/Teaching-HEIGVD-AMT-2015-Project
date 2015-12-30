/* 
 *
 * @author Bastien Rouiller
 */
package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.Permission;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class PermissionDAO extends GenericDAO<Permission> implements PermissionDAOLocal
{    
    public Permission findByName(String name)
    {
        Permission result = null;

        try
        {
            result = (Permission) em.createNamedQuery("Permission.findByName").setParameter("permission", name).getSingleResult();
        } 
        catch (NoResultException e)
        {
            return null;
        }
        return result;       
    }

    public Permission findByNameOrCreateIfNotFound(String name)
    {
        Permission p = findByName(name);
        if(p == null)
        {
            p = new Permission();
            p.setPermission(name);
            create(p);
        }
        return p;            
    }
}
