/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.EndUser;
import javax.ejb.Stateless;

@Stateless
public class EndUserDAO extends GenericDAO<EndUser> implements EndUserDAOLocal
{

}
