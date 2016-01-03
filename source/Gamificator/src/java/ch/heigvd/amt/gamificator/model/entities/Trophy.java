/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.model.entities;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class Trophy extends AbstractGenericEntity
{
    String name;
    String description;
    int occurenceEvent;
        
    public Trophy(){}

    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }

    public long getOccurenceEvent()
    {
        return occurenceEvent;
    }

    public void setOccurenceEvent(int occurenceEvent)
    {
        this.occurenceEvent = occurenceEvent;
    }  
}
