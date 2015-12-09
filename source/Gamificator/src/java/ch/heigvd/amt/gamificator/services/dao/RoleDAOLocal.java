/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.Account;
import ch.heigvd.amt.gamificator.model.entities.Role;
import javax.ejb.Local;

@Local
public interface RoleDAOLocal extends IGenericDAO<Role>
{
    Role findByName(String name);
    public Role findByNameOrCreateIfNotFound(String name);
}
