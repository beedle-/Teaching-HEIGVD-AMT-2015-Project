/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.model.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class EndUser extends AbstractGenericEntity
{
    @Temporal(javax.persistence.TemporalType.DATE)
    Date creationDate;
    
    public EndUser()
    {
        creationDate = new Date();
    }

    public Date getCreationDate()
    {
        return creationDate;
    }
}
