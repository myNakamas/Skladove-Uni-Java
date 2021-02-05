package Services;

import DAO.StokaDao;
import entities.Stoka;

import java.util.List;

public class StokaService {
    private static StokaDao StokaDao;

    public StokaService() {
        StokaDao = new StokaDao();
    }

    public void persist(Stoka entity) {
        StokaDao.openCurrentSessionwithTransaction();
        StokaDao.persist(entity);
        StokaDao.closeCurrentSessionwithTransaction();
    }

    public void update(Stoka entity) {
        StokaDao.openCurrentSessionwithTransaction();
        StokaDao.update(entity);
        StokaDao.closeCurrentSessionwithTransaction();
    }

    public Stoka findById(int id) {
        StokaDao.openCurrentSession();
        Stoka Stoka = StokaDao.findById(id);
        StokaDao.closeCurrentSession();
        return Stoka;
    }

    public void delete(int id) {
        StokaDao.openCurrentSessionwithTransaction();
        Stoka Stoka = StokaDao.findById(id);
        StokaDao.delete(Stoka);
        StokaDao.closeCurrentSessionwithTransaction();
    }

    public List<Stoka> findAll() {
        StokaDao.openCurrentSession();
        List<Stoka> Stoki = StokaDao.findAll();
        StokaDao.closeCurrentSession();
        return Stoki;
    }

    public StokaDao StokaDao() {
        return StokaDao;
    }
}
