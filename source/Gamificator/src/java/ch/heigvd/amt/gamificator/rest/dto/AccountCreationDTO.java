/*
 *
 * @author Bastien Rouiller
 */
package ch.heigvd.amt.gamificator.rest.dto;

import ch.heigvd.amt.gamificator.model.entities.Role;
import java.io.Serializable;
import java.util.List;

public class AccountCreationDTO implements Serializable
{
    //private String[] roles;
    private List<Role> roles;
    public String email;
    public String firstName;
    public String lastName;
    public String password;

/*
   public String[] getRoles()
   {
        return roles;
   }
*/
    public String getEmail()
    {
        return email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPassword()
    {
        return password;
    }
}
