package Services;

import DAO.FormulqrDao;
import entities.Formulqr;

import java.util.List;

public class FormulqrService {
    private static FormulqrDao FormulqrDao;

    public FormulqrService() {
        FormulqrDao = new FormulqrDao();
    }

    public void persist(Formulqr entity) {
        FormulqrDao.openCurrentSessionwithTransaction();
        FormulqrDao.persist(entity);
        FormulqrDao.closeCurrentSessionwithTransaction();
    }

    public void update(Formulqr entity) {
        FormulqrDao.openCurrentSessionwithTransaction();
        FormulqrDao.update(entity);
        FormulqrDao.closeCurrentSessionwithTransaction();
    }

    public Formulqr findById(int id) {
        FormulqrDao.openCurrentSession();
        Formulqr Formulqr = FormulqrDao.findById(id);
        FormulqrDao.closeCurrentSession();
        return Formulqr;
    }

    public void delete(int id) {
        FormulqrDao.openCurrentSessionwithTransaction();
        Formulqr Formulqr = FormulqrDao.findById(id);
        FormulqrDao.delete(Formulqr);
        FormulqrDao.closeCurrentSessionwithTransaction();
    }

    public List<Formulqr> findAll() {
        FormulqrDao.openCurrentSession();
        List<Formulqr> Formulqri = FormulqrDao.findAll();
        FormulqrDao.closeCurrentSession();
        return Formulqri;
    }

    public FormulqrDao FormulqrDao() {
        return FormulqrDao;
    }
}
