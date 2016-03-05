/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.account;

import entity.Account;
import entity.Role;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stom2
 */
@Local
public interface AccountFacadeLocal {

    void create(Account account);

    void edit(Account account);

    void remove(Account account);

    Account find(Object id);

    List<Account> findAll();

    List<Account> findRange(int[] range);

    List<Account> findByName(String name, Role role);
    
    List<Account> findByEmail(String email, Role role);
    int count();
    
}
