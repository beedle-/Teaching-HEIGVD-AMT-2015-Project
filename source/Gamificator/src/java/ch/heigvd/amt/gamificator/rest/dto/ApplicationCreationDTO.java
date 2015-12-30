/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.rest.dto;

public class ApplicationCreationDTO 
{
    String emailAccount;
    String name;
    String description;

    public String getEmailAccount()
    {
        return emailAccount;
    }
    
    public void setEmailAccount(String emailAccount)
    {
        this.emailAccount = emailAccount;
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
    
    
}
