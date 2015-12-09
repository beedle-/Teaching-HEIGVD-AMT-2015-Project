/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.rest.resources;

import ch.heigvd.amt.gamificator.model.entities.Role; 
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("/roles")
public class RoleResource extends AbstractFacade<Role> 
{
    @PersistenceContext(unitName = "Persistence")
    private EntityManager em;

    public RoleResource()
    {
        super(Role.class);
    }

    /*
    @POST
    @Consumes("application/json")
    public void create(Role entity)
    {
        super.create(entity);
    }
*/
    
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") Long id, Role entity)
    {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id)
    {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Role find(@PathParam("id") Long id)
    {
        return super.find(id);
    }

    @GET
    @Override
    @Produces("application/json")
    public List<Role> findAll()
    {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces("application/json")
    public List<Role> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to)
    {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST()
    {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

}
