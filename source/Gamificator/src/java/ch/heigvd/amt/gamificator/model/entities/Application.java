/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.model.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Application extends AbstractGenericEntity
{
    @ManyToOne
    private Account account;
    
    @OneToOne
    private ApiKey apiKey;
    
    @OneToMany
    private List<EndUser> endUsers;
        
    private String name;  
    private String description;
    private boolean active;
    
    public Application(){}

    public Application(Account account, ApiKey apiKey, String name, String description, boolean active)
    {
        this.account = account;
        this.apiKey = apiKey;
        this.name = name;
        this.description = description;
        this.active = active;
    }
    
    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }

    public ApiKey getapiKey()
    {
        return apiKey;
    }
    
    public void setApiKey(ApiKey apiKey)
    {
        this.apiKey = apiKey;
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

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    public List<EndUser> getEndUsers() 
    {
        return endUsers;
    }
    
    public void addEndUser(EndUser eu) 
    {
        endUsers.add(eu);
    }
}