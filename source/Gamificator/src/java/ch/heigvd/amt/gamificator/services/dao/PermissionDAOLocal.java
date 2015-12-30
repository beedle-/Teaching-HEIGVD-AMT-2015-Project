/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.services.dao;


import ch.heigvd.amt.gamificator.model.entities.Permission;
import javax.ejb.Local;

@Local
public interface PermissionDAOLocal extends IGenericDAO<Permission>
{
    Permission findByName(String name);
    public Permission findByNameOrCreateIfNotFound(String name);
}
