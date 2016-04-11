package services;

import domain.Player;
import java.util.ArrayList;
import util.ServiceException;

/**
 * Created by Lukas on 9-2-2016.
 */
public interface Service<E> {

    public void add(E object) throws ServiceException;
    public E get(Object id) throws ServiceException;
    public ArrayList<E> getAll() throws ServiceException;
    public void update(E object) throws ServiceException;
    public void delete(E object) throws ServiceException;
    public void closeConnection() throws ServiceException;

}
