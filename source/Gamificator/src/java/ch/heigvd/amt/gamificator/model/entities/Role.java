/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.model.entities;

import javax.persistence.Entity;


@Entity
public class Role extends AbstractGenericEntity
{
    String role;
    
    public Role(){}

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
}
