package DAO;

import DAO.Interfaces.DaoInterface;
import entities.Stoka;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class StokaDao implements DaoInterface<Stoka> {
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

    public void persist(Stoka entity) {
        getCurrentSession().save(entity);
    }

    public void update(Stoka entity) {
        getCurrentSession().update(entity);
    }

    public Stoka findById(int id) {
        return getCurrentSession().get(Stoka.class, id);
    }
    public void delete(Stoka entity) {
        getCurrentSession().delete(entity);
    }

    public List<Stoka> findAll() {
        return (List<Stoka>) getCurrentSession().createQuery("from Stoka").list();
    }
}
