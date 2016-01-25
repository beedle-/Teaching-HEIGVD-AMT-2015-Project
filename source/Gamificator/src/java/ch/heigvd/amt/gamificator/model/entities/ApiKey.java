/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.model.entities;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class ApiKey extends AbstractGenericEntity
{    
    private String apiKey;
    
    public ApiKey()
    {
        apiKey = Long.toHexString(Double.doubleToLongBits(Math.random()));
    }

    public ApiKey(String apiKey)
    {
        this.apiKey = apiKey;
    }

    public String getApiKey()
    {
        return apiKey;
    }

    public void setApiKey(String apiKey)
    {
        this.apiKey = apiKey;
    }
}
