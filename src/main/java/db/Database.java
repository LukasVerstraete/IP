package db;

import domain.Player;
import java.util.ArrayList;
import util.DatabaseException;

/**
 * Created by Lukas on 8-2-2016.
 */
public interface Database<E> {

    public void add(E object) throws DatabaseException;
    public void update(E object) throws DatabaseException;
    public E get(Object id) throws DatabaseException;
    public ArrayList<E> getAll() throws DatabaseException;
    public void delete(E Object) throws DatabaseException;
    public void closeConnection() throws DatabaseException;

}
