/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.topic;

import entity.Topic;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import session.AbstractFacade;

/**
 *
 * @author stom2
 */
@Stateless
public class TopicFacade extends AbstractFacade<Topic> implements TopicFacadeLocal {
    @PersistenceContext(unitName = "Amthucviet-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TopicFacade() {
        super(Topic.class);
    }
    
}
