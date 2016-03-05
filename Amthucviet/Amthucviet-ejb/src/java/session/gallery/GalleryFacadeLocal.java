/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.gallery;

import entity.Gallery;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stom2
 */
@Local
public interface GalleryFacadeLocal {

    void create(Gallery gallery);

    void edit(Gallery gallery);

    void remove(Gallery gallery);

    Gallery find(Object id);

    List<Gallery> findAll();

    List<Gallery> findRange(int[] range);

    int count();
    
}
