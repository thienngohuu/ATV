/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Account;
import entity.Role;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.account.AccountFacadeLocal;

/**
 *
 * @author stom2
 */
public class AccountStub {
    AccountFacadeLocal accountFacade = lookupAccountFacadeLocal();

    private AccountFacadeLocal lookupAccountFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (AccountFacadeLocal) c.lookup("java:global/Amthucviet/Amthucviet-ejb/AccountFacade!session.account.AccountFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Account account) {
        accountFacade.create(account);
    }

    public void edit(Account account) {
        accountFacade.edit(account);
    }

    public void remove(Account account) {
        accountFacade.remove(account);
    }

    public Account find(Object id) {
        return accountFacade.find(id);
    }

    public List<Account> findAll() {
        return accountFacade.findAll();
    }

    public List<Account> findRange(int[] range) {
        return accountFacade.findRange(range);
    }

    public int count() {
        return accountFacade.count();
    }

    public Account findByName(String name) {
        return accountFacade.findByName(name);
    }

    public List<Account> findByEmail(String email, Role role) {
        return accountFacade.findByEmail(email, role);
    }

    public boolean login(Account account) {
        return accountFacade.login(account);
    }
    
}
