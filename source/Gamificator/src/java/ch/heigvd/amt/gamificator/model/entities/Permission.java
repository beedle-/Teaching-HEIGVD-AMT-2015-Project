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
    @NamedQuery(name = "Permission.findByName", query = "SELECT p FROM Permission p WHERE p.permission = :permission")
 })
@XmlRootElement
public class Permission extends AbstractGenericEntity
{
    String permission;
    
    public Permission(){}

    public String getPermission()
    {
        return permission;
    }

    public void setPermission(String permission)
    {
        this.permission = permission;
    }
}
