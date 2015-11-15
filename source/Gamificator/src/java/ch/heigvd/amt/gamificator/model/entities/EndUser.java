/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.model.entities;

import java.util.Date;
import javax.persistence.Entity;


@Entity
public class EndUser extends AbstractGenericEntity
{
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
