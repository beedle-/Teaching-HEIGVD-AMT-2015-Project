/*
 *
 * @author Bastien Rouiller
 */
package ch.heigvd.amt.gamificator.rest.resources;

import ch.heigvd.amt.gamificator.model.entities.Account;
import ch.heigvd.amt.gamificator.rest.dto.AccountCreationDTO;
import ch.heigvd.amt.gamificator.services.dao.AccountDAOLocal;
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
@Path("/accounts")
public class AccountResource extends AbstractFacade<Account>
{

    @PersistenceContext(unitName = "Persistence")
    private EntityManager em;

    @EJB
    AccountDAOLocal accountDAO;

    public AccountResource()
    {
        super(Account.class);
    }

    @POST
    @Consumes("application/json")
    public void create(AccountCreationDTO dto)
    {

        Account account = new Account();

        account.setEmail(dto.getEmail());
        account.setFirstName(dto.getFirstName());
        account.setLastName(dto.getLastName());
        account.setPassword(dto.getPassword());

        accountDAO.create(account);

        String[] permissions = dto.getPermissions();
        if (permissions != null)
        {
            for (String permission : permissions)
            {
                accountDAO.assignPermission(account.getEmail(), permission);
            }
        }

        //   super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") Long id, Account entity)
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
    public Account find(@PathParam("id") Long id)
    {
        return super.find(id);
    }

    @GET
    @Override
    @Produces("application/json")
    public List<Account> findAll()
    {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces("application/json")
    public List<Account> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to)
    {
        return super.findRange(new int[]
        {
            from, to
        });
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
