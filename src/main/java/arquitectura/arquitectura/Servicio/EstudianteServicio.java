// src/main/java/arquitectura/arquitectura/Servicio/EstudianteServicio.java
package arquitectura.arquitectura.Servicio;

import arquitectura.arquitectura.entity.estudiantes;
import java.util.List;

public interface EstudianteServicio {
    List<estudiantes> ListarTodosLosEstudiantes();
    void guardar(estudiantes e);
    void eliminar(Long id);
}
