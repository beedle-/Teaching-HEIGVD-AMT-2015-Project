/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.Event;
import javax.ejb.Stateless;

@Stateless
public class EventDAO extends GenericDAO<Event> implements EventDAOLocal
{

}
