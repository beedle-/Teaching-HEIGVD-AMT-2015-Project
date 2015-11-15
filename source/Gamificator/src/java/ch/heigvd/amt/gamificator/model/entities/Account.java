/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.model.entities;


import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
public class Account extends AbstractGenericEntity
{
    @ManyToMany(fetch = FetchType.EAGER)   
    private List<Role> roles;

    private String email;
    private String firstName;
    private String lastName;
    private String password;

    public Account(){}   
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public List<Role> getRoles()
    {
        return roles;
    }
    
    public void addRole(Role role)
    {
        roles.add(role);
    }  
}
