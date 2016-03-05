/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.picture;

import entity.Picture;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stom2
 */
@Local
public interface PictureFacadeLocal {

    void create(Picture picture);

    void edit(Picture picture);

    void remove(Picture picture);

    Picture find(Object id);

    List<Picture> findAll();

    List<Picture> findRange(int[] range);

    int count();
    
}
