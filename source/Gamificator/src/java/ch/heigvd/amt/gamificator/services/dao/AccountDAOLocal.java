/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.Account;
import javax.ejb.Local;

@Local
public interface AccountDAOLocal extends IGenericDAO<Account>
{
    Account findByEmail(String email);
    Account verifyLogin(String email, String password);
    void assignPermission(String email, String permission);
    //int countAccounts();
}
