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
        
    private String Name;  
    private String Description;
    
    public Application(){}

    public Application(Account account, ApiKey apiKey, String Name, String Description)
    {
        this.account = account;
        this.apiKey = apiKey;
        this.Name = Name;
        this.Description = Description;
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
        return Name;
    }
        
    public void setName(String Name)
    {
        this.Name = Name;
    }

    public String getDescription()
    {
        return Description;
    }
    
    public void setDescription(String Description)
    {
        this.Description = Description;
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
