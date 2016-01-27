/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.rest.resources;


import ch.heigvd.amt.gamificator.model.entities.Event;
import ch.heigvd.amt.gamificator.model.entities.Trophy; 
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
@Path("/application/{apiKey}/event/{eventName}/trophies")
public class TrophyResource extends AbstractFacade<Trophy> 
{    
    @EJB
    EventDAOLocal eventDAO;
    
    @PersistenceContext(unitName = "Persistence")
    private EntityManager em;

    public TrophyResource()
    {
        super(Trophy.class);
    }

    @POST
    @Consumes("application/json")
    public void create(@PathParam("apiKey") String apiKey, @PathParam("eventName") String eventName, Trophy entity)
    {
        em.persist(entity);
        Event event = eventDAO.findByName(apiKey, eventName);    
        event.addTrophy(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") Long id, Trophy entity)
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
    public Trophy find(@PathParam("id") Long id)
    {
        return super.find(id);
    }

    @GET
    @Override
    @Produces("application/json")
    public List<Trophy> findAll()
    {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces("application/json")
    public List<Trophy> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to)
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
