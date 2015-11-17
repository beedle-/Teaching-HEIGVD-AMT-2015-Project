/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.services.dao;

import ch.heigvd.amt.gamificator.model.entities.Account;
import javax.ejb.Stateless;

@Stateless
public class AccountDAO extends GenericDAO<Account> implements AccountDAOLocal
{
}
