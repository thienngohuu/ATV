/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.favorite;

import entity.Favoritetopic;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import session.AbstractFacade;

/**
 *
 * @author stom2
 */
@Stateless
public class FavoritetopicFacade extends AbstractFacade<Favoritetopic> implements FavoritetopicFacadeLocal {
    @PersistenceContext(unitName = "Amthucviet-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FavoritetopicFacade() {
        super(Favoritetopic.class);
    }
    
}
