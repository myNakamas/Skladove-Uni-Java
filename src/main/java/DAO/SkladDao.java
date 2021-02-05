package DAO;

import DAO.Interfaces.DaoInterface;
import entities.Sklad;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class SkladDao implements DaoInterface<Sklad> {
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

    public void persist(Sklad entity) {
        getCurrentSession().save(entity);
    }

    public void update(Sklad entity) {
        getCurrentSession().update(entity);
    }

    public Sklad findById(int id) {
        return getCurrentSession().get(Sklad.class, id);
    }
    public void delete(Sklad entity) {
        getCurrentSession().delete(entity);
    }

    public List<Sklad> findAll() {
        return (List<Sklad>) getCurrentSession().createQuery("from sklad").list();
    }
}
