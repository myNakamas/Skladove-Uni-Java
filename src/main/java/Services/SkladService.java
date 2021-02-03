package Services;

import DAO.SkladDao;
import entities.Sklad;

import java.util.List;

public class SkladService {
    private static SkladDao SkladDao;

    public SkladService() {
        SkladDao = new SkladDao();
    }

    public void persist(Sklad entity) {
        SkladDao.openCurrentSessionwithTransaction();
        SkladDao.persist(entity);
        SkladDao.closeCurrentSessionwithTransaction();
    }

    public void update(Sklad entity) {
        SkladDao.openCurrentSessionwithTransaction();
        SkladDao.update(entity);
        SkladDao.closeCurrentSessionwithTransaction();
    }

    public Sklad findById(int id) {
        SkladDao.openCurrentSession();
        Sklad Sklad = SkladDao.findById(id);
        SkladDao.closeCurrentSession();
        return Sklad;
    }

    public void delete(int id) {
        SkladDao.openCurrentSessionwithTransaction();
        Sklad Sklad = SkladDao.findById(id);
        SkladDao.delete(Sklad);
        SkladDao.closeCurrentSessionwithTransaction();
    }

    public List<Sklad> findAll() {
        SkladDao.openCurrentSession();
        List<Sklad> Skladove = SkladDao.findAll();
        SkladDao.closeCurrentSession();
        return Skladove;
    }

    public SkladDao SkladDao() {
        return SkladDao;
    }
}
