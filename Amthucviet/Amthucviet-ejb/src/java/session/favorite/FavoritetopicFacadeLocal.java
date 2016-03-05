/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.favorite;

import entity.Favoritetopic;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stom2
 */
@Local
public interface FavoritetopicFacadeLocal {

    void create(Favoritetopic favoritetopic);

    void edit(Favoritetopic favoritetopic);

    void remove(Favoritetopic favoritetopic);

    Favoritetopic find(Object id);

    List<Favoritetopic> findAll();

    List<Favoritetopic> findRange(int[] range);

    int count();
    
}
