package ma.zaatari.controle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import ma.zaatari.controle.dao.IDao;
import ma.zaatari.controle.entities.Servicee;
import org.springframework.stereotype.Service;
import ma.zaatari.controle.repositories.ServiceeRepository;

@Service
public class ServiceeService implements IDao<Servicee> {

    @Autowired
    private ServiceeRepository ServiceeRep;

    @Override
    public Servicee create(Servicee o) {
        return ServiceeRep.save(o);
    }

    @Override
    public boolean delete(Servicee o) {
        try {
            ServiceeRep.delete(o);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Servicee update(Servicee o) {
        return ServiceeRep.save(o);
    }

    @Override
    public Servicee findById(long id) {
        return ServiceeRep.findById((long) id).orElse(null);
    }

    @Override
    public List<Servicee> findAll() {
        return ServiceeRep.findAll();
    }

}
