package Services;

import DAO.ConnectionDao;
import entities.Connection;

import java.util.List;

public class ConnectionService {
    private static ConnectionDao ConnectionDao;

    public ConnectionService() {
        ConnectionDao = new ConnectionDao();
    }

    public void persist(Connection entity) {
        ConnectionDao.openCurrentSessionwithTransaction();
        ConnectionDao.persist(entity);
        ConnectionDao.closeCurrentSessionwithTransaction();
    }

    public void update(Connection entity) {
        ConnectionDao.openCurrentSessionwithTransaction();
        ConnectionDao.update(entity);
        ConnectionDao.closeCurrentSessionwithTransaction();
    }

    public Connection findById(int id) {
        ConnectionDao.openCurrentSession();
        Connection Connection = ConnectionDao.findById(id);
        ConnectionDao.closeCurrentSession();
        return Connection;
    }

    public void delete(int id) {
        ConnectionDao.openCurrentSessionwithTransaction();
        Connection Connection = ConnectionDao.findById(id);
        ConnectionDao.delete(Connection);
        ConnectionDao.closeCurrentSessionwithTransaction();
    }

    public List<Connection> findAll() {
        ConnectionDao.openCurrentSession();
        List<Connection> Connections = ConnectionDao.findAll();
        ConnectionDao.closeCurrentSession();
        return Connections;
    }

    public ConnectionDao ConnectionDao() {
        return ConnectionDao;
    }
}
