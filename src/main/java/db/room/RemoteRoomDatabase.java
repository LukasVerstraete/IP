package db.room;

import db.Database;
import domain.Room;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import util.DatabaseException;

public class RemoteRoomDatabase implements Database<Room> {

    private EntityManagerFactory factory;
    private EntityManager entityManager;
    
    public RemoteRoomDatabase(String pu) throws DatabaseException
    {
        factory = Persistence.createEntityManagerFactory(pu);
        entityManager = factory.createEntityManager();
    }
    
    public void add(Room room) throws DatabaseException {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.persist(room);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public void update(Room room) throws DatabaseException {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.merge(room);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public Room get(Object id) throws DatabaseException {
        try
        {
            return entityManager.find(Room.class, (String)id);
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public List<Room> getAll() throws DatabaseException {
        try
        {
            Query query = entityManager.createQuery("select room from Room room");
            return new ArrayList<Room>(query.getResultList());
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public void delete(Room room) throws DatabaseException {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.remove(room);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public void closeConnection() throws DatabaseException {
        try
        {
            entityManager.close();
            factory.close();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }
    
}
