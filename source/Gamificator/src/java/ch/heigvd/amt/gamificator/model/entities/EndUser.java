/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class EndUser extends AbstractGenericEntity
{
    @Temporal(TemporalType.TIMESTAMP)
    Date creationDate;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Event> events;
    
    public EndUser()
    {
        this.events = new ArrayList<Event>();
        creationDate = new Date();
    }

    public Date getCreationDate()
    {
        return creationDate;
    }
        
    public List<Event> getEvents()
    {
        return events;
    }

    public void addEvent(Event event)
    {
        events.add(event);
    }
}
