/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.model.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@XmlRootElement
@NamedQueries
({
    @NamedQuery(name = "Event.findByName", query = "SELECT e FROM Application a INNER JOIN a.apiKey ak INNER JOIN a.events e WHERE ak.apiKey = :apiKey AND e.name = :eventName")
 })
public class Event extends AbstractGenericEntity
{
    String name;
    String description;
    long score;
    
    @OneToMany
    private List<Trophy> trophies;
    
    public Event()
    {
        this.trophies = new ArrayList<Trophy>();
    }

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

    public long getScore()
    {
        return score;
    }

    public void setScore(long score)
    {
        this.score = score;
    }  
    
    @XmlTransient
    public List<Trophy> getTrophies()
    {
        return trophies;
    }

    public void addTrophy(Trophy trophy)
    {
        trophies.add(trophy);
    }
}