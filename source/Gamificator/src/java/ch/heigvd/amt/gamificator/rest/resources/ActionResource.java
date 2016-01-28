/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.rest.resources;

import ch.heigvd.amt.gamificator.model.entities.Action; 
import ch.heigvd.amt.gamificator.model.entities.EndUser;
import ch.heigvd.amt.gamificator.model.entities.Event;
import ch.heigvd.amt.gamificator.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.gamificator.services.dao.EndUserDAOLocal;
import ch.heigvd.amt.gamificator.services.dao.EventDAOLocal;
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
@Path("/application/{apiKey}/endUser/{userIdentifier}/action/{eventName}")
public class ActionResource extends AbstractFacade<Action> 
{
    @EJB
    EndUserDAOLocal endUserDAO;   
    
    @EJB
    EventDAOLocal eventDAO;
    
    @PersistenceContext(unitName = "Persistence")
    private EntityManager em;

    public ActionResource()
    {
        super(Action.class);
    }

    @POST
    @Consumes("application/json")
    public void create(@PathParam("apiKey") String apiKey, @PathParam("userIdentifier") String userIdentifier, @PathParam("eventName") String eventName)
    {
        EndUser endUser = endUserDAO.findByIdentifier(apiKey, userIdentifier);
        Event event = eventDAO.findByName(apiKey, eventName);
        
        Action action = new Action();
        em.persist(action);
        action.setEvent(event);
        endUser.addAction(action);
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") Long id, Action entity)
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
    public Action find(@PathParam("id") Long id)
    {
        return super.find(id);
    }

    @GET
    @Override
    @Produces("application/json")
    public List<Action> findAll()
    {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces("application/json")
    public List<Action> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to)
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
