/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.model.entities;

import javax.persistence.Entity;


@Entity
public class ApiKey extends AbstractGenericEntity
{    
    private String apiKey;
    
    public ApiKey(){}

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
