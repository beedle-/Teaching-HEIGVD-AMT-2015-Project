/*
 *
 * @author Bastien Rouiller
 */
package ch.heigvd.amt.gamificator.rest.dto;

public class AccountCreationDTO
{
    //private String[] roles;

    private String email;
    private String firstName;
    private String lastName;
    private String password;
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
