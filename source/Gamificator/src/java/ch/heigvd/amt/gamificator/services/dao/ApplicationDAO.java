/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.Application;
import javax.ejb.Stateless;

@Stateless
public class ApplicationDAO extends GenericDAO<Application> implements ApplicationDAOLocal
{
 
}
