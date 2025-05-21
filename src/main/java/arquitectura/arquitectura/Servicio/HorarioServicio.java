package arquitectura.arquitectura.Servicio;


import arquitectura.arquitectura.entity.Horario;
import java.util.List;

public interface HorarioServicio {
    List<Horario> ListarTodosLosHorarios();
    void guardar(Horario h);
}
