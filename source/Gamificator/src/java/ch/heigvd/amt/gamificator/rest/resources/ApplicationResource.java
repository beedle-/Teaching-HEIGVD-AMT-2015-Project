/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.rest.resources;

import ch.heigvd.amt.gamificator.model.entities.Application; 
import ch.heigvd.amt.gamificator.rest.dto.ApplicationCreationDTO;
import ch.heigvd.amt.gamificator.services.dao.ApplicationDAO;
import ch.heigvd.amt.gamificator.services.dao.ApplicationDAOLocal;
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
@Path("/applications")
public class ApplicationResource extends AbstractFacade<Application> 
{
    @EJB 
    ApplicationDAOLocal applicationDAO;
    
    @PersistenceContext(unitName = "Persistence")
    private EntityManager em;

    public ApplicationResource()
    {
        super(Application.class);
    }

    @POST
    @Consumes("application/json")
    public void create(ApplicationCreationDTO dto)
    {
        Application application = new Application();
        
        application.setName(dto.getName());
        application.setDescription(dto.getDescription());
       
        applicationDAO.assignAccount(dto.getEmailAccount(), application);
        applicationDAO.create(application);
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") Long id, Application entity)
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
    public Application find(@PathParam("id") Long id)
    {
        return super.find(id);
    }

    @GET
    @Override
    @Produces("application/json")
    public List<Application> findAll()
    {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces("application/json")
    public List<Application> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to)
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
