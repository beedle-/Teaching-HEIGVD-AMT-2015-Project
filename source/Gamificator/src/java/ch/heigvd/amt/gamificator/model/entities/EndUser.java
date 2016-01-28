/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.model.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
@NamedQueries
({
    @NamedQuery(name = "EndUser.findByIdentifier", query = "SELECT e FROM Application a INNER JOIN a.apiKey ak INNER JOIN a.endUsers e WHERE ak.apiKey = :apiKey AND e.userIdentifier = :userIdentifier")
 })
public class EndUser extends AbstractGenericEntity
{
    @Temporal(TemporalType.TIMESTAMP)
    Date creationDate;
       
    String userIdentifier;
    
    @OneToMany
    private List<Action> actions;
    
    public EndUser()
    {
        creationDate = new Date();
        userIdentifier = Long.toHexString(Double.doubleToLongBits(Math.random()));
    }

    public Date getCreationDate()
    {
        return creationDate;
    }
        
    public List<Action> getActions()
    {
        return actions;
    }

    public void addAction(Action action)
    {
        actions.add(action);
    }
    
    public String getUserIdentifier()
    {
        return userIdentifier;
    }
    
    public void setUserIdentifier(String identifier)
    {
        this.userIdentifier = identifier;
    }
}
