package DAO;

import DAO.Interfaces.DaoInterface;
import entities.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class ConnectionDao implements DaoInterface<Connection> {
    private Session currentSession;

    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Connection entity) {
        getCurrentSession().save(entity);
    }

    public void update(Connection entity) {
        getCurrentSession().update(entity);
    }

    public Connection findById(int id) {
        return getCurrentSession().get(Connection.class, id);
    }
    public void delete(Connection entity) {
        getCurrentSession().delete(entity);
    }

    public List<Connection> findAll() {
        return (List<Connection>) getCurrentSession().createQuery("from connection").list();
    }
}
