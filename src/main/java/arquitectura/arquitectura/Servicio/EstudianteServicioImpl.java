// src/main/java/arquitectura/arquitectura/Servicio/EstudianteServicioImpl.java
package arquitectura.arquitectura.Servicio;

import arquitectura.arquitectura.Repository.EstudianteRepositorio;
import arquitectura.arquitectura.entity.estudiantes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServicioImpl implements EstudianteServicio {

    @Autowired
    private EstudianteRepositorio repo;

    @Override
    public List<estudiantes> ListarTodosLosEstudiantes() {
        return repo.findAll();
    }

    @Override
    public void guardar(estudiantes e) {
        repo.save(e);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
