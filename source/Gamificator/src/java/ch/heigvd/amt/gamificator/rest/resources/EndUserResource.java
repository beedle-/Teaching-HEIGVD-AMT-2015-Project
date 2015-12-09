/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.rest.resources;

import ch.heigvd.amt.gamificator.model.entities.Application;
import ch.heigvd.amt.gamificator.model.entities.EndUser; 
import ch.heigvd.amt.gamificator.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.gamificator.services.dao.EndUserDAOLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
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
@Path("/application/{applicationId}/endUsers)")
public class EndUserResource extends AbstractFacade<EndUser> 
{
    @EJB
    EndUserDAOLocal endUserDAO;   
    
    @EJB
    ApplicationDAOLocal applicationDAO;
    
    @PersistenceContext(unitName = "Persistence")
    private EntityManager em;

    public EndUserResource()
    {
        super(EndUser.class);
    }

    @POST
    @Consumes("application/json")
    public void create(EndUser entity, @PathParam("applicationId") long applicationId)
    {
        Application app = applicationDAO.findById(applicationId);
        app.addEndUser(entity);
        //super.create(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id)
    {
        super.remove(super.find(id));
    }

    /*
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") Long id, EndUser entity)
    {
        super.edit(entity);
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public EndUser find(@PathParam("id") Long id)
    {
        return super.find(id);
    }
*/
    @GET
    @Override
    @Produces("application/json")
    public List<EndUser> findAll()
    {
        //return super.findAll();
        return endUserDAO.findAll();
    }
/*
    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST()
    {
        return String.valueOf(super.count());
    }
    */
    
    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

}
