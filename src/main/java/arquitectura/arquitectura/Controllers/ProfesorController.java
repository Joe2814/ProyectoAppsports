package arquitectura.arquitectura.Controllers;


import arquitectura.arquitectura.Servicio.EstudianteServicio;
import arquitectura.arquitectura.Servicio.HorarioServicio;
import arquitectura.arquitectura.entity.Horario;
import arquitectura.arquitectura.entity.estudiantes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/escuela/profesor")
public class ProfesorController {

    @Autowired
    private EstudianteServicio estudianteServicio;

    @Autowired
    private HorarioServicio horarioServicio;

    // Panel principal: muestra profesor.html
    @GetMapping
    public String panelProfesor() {
        return "profesor";
    }

    // Listar usuarios existentes
    @GetMapping("/listar-usuarios")
    public String listarUsuarios(Model modelo) {
        List<estudiantes> lista = estudianteServicio.ListarTodosLosEstudiantes();
        modelo.addAttribute("estudiantes", lista);
        return "listar-usuarios";
    }

    // Mostrar y agregar/editar horarios
    @GetMapping("/organizar-horarios")
    public String mostrarHorarios(Model modelo) {
        modelo.addAttribute("horarios", horarioServicio.ListarTodosLosHorarios());
        modelo.addAttribute("nuevoHorario", new Horario());
        return "organizar-horarios";
    }

    @PostMapping("/organizar-horarios")
    public String guardarHorario(@ModelAttribute("nuevoHorario") Horario horario) {
        horarioServicio.guardar(horario);
        return "redirect:/escuela/profesor/organizar-horarios";
    }
}
