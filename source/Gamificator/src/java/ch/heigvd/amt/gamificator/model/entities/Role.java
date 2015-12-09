/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.model.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@NamedQueries
({
    @NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.role = :role")
 })
@XmlRootElement
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
