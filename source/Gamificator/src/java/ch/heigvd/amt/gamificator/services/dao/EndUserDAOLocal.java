/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.EndUser;
import javax.ejb.Local;

@Local
public interface EndUserDAOLocal extends IGenericDAO<EndUser>
{
}
