package clinica.service;


import clinica.dao.IDao;
import clinica.model.Domicilio;

import java.util.List;

public class DomicilioService {
    private IDao<Domicilio> domicilioDao;

    public DomicilioService(IDao<Domicilio> domicilioDao) {
        this.domicilioDao = domicilioDao;
    }
    public Domicilio guardar(Domicilio d){
        domicilioDao.guardar(d);
        return d;
    }
    public Domicilio buscar(Integer id){
        return domicilioDao.buscar(id);
    }
    public List<Domicilio> buscarTodos(){
        return domicilioDao.buscarTodos();
    }
    public void eliminar(Integer id){
        domicilioDao.eliminar(id);
    }

}
