/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.model.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class Action extends AbstractGenericEntity
{
    @Temporal(TemporalType.TIMESTAMP)
    Date timeStamp;
    
    @ManyToOne
    private Event event;
    
    public Action()
    {
        timeStamp = new Date();
    }

    public Date getTimeStamp()
    {
        return timeStamp;
    }
    
    public void setTimeStamp(Date timeStamp)
    {
        this.timeStamp = timeStamp;
    }
    
    public Event getEvent()
    {
        return event;
    }
    
    public void setEvent(Event event)
    {
        this.event = event;
    }
}