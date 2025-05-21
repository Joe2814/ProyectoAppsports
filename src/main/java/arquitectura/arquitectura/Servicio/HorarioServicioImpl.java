package arquitectura.arquitectura.Servicio;

import arquitectura.arquitectura.entity.Horario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioServicioImpl implements HorarioServicio {

    @Autowired
    private HorarioRepository repo;

    @Override
    public List<Horario> ListarTodosLosHorarios() {
        return repo.findAll();
    }

    @Override
    public void guardar(Horario h) {
        repo.save(h);
    }
}
