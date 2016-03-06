/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.account;

import entity.Account;
import entity.Profile;
import entity.Role;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import session.AbstractFacade;

/**
 *
 * @author stom2
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {

    @PersistenceContext(unitName = "Amthucviet-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }

    /**
     * @author hien 4/3/2016
     * @param name username
     * @param role type of account
     * @return list<Account>
     */
    @Override
    public Account findByName(String name) {
        return (Account)em.createNamedQuery("Acount.findByUsername").setParameter("username", "%" + name + "%").getSingleResult();
    }

    @Override
    public List<Account> findByEmail(String email, Role role) {
        return em.createNamedQuery("Acount.findByEmail").setParameter("email", "%" + email + "%")
                .setParameter("idrole", role.getIdrole()).getResultList();
    }

    @Override
    public boolean login(Account user) {
        Account checkUser = find(user.getUsername());
        return checkUser != null && checkUser.getPassword().equals(user.getPassword()); 
    }
}
