/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.rest.resources;

import ch.heigvd.amt.gamificator.model.entities.Event; 
import ch.heigvd.amt.gamificator.rest.dto.EventCreationDTO;
import ch.heigvd.amt.gamificator.services.dao.ApplicationDAOLocal;
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
@Path("/application/{apiKey}/events")
public class EventResource extends AbstractFacade<Event> 
{
    @EJB
    EventDAOLocal eventDAO;
    
    @EJB 
    ApplicationDAOLocal applicationDAO;
    
    @PersistenceContext(unitName = "Persistence")
    private EntityManager em;

    public EventResource()
    {
        super(Event.class);
    }

    @POST
    @Consumes("application/json")
    public void create(@PathParam("apiKey") String apiKey, EventCreationDTO dto)
    {
        Event event = new Event();
        
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        event.setScore(dto.getScore());
       
        applicationDAO.addEvent(event,applicationDAO.findByApiKey(apiKey));
        eventDAO.create(event);        
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") Long id, Event entity)
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
    public Event find(@PathParam("id") Long id)
    {
        return super.find(id);
    }

    @GET
    @Override
    @Produces("application/json")
    public List<Event> findAll()
    {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces("application/json")
    public List<Event> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to)
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
