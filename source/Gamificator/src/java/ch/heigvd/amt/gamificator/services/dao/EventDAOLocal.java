/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.Event;
import javax.ejb.Local;

@Local
public interface EventDAOLocal extends IGenericDAO<Event>
{
}
