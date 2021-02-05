package DAO;

import DAO.Interfaces.DaoInterface;
import entities.Formulqr;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class FormulqrDao implements DaoInterface<Formulqr> {
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

    public void persist(Formulqr entity) {
        getCurrentSession().save(entity);
    }

    public void update(Formulqr entity) {
        getCurrentSession().update(entity);
    }

    public Formulqr findById(int id) {
        return getCurrentSession().get(Formulqr.class, id);
    }
    public void delete(Formulqr entity) {
        getCurrentSession().delete(entity);
    }

    public List<Formulqr> findAll() {
        return (List<Formulqr>) getCurrentSession().createQuery("from formulqr").list();
    }
}
