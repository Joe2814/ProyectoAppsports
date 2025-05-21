// src/main/java/arquitectura/arquitectura/Controllers/estudianteController.java
package arquitectura.arquitectura.Controllers;

import arquitectura.arquitectura.Servicio.EstudianteServicio;
import arquitectura.arquitectura.Servicio.HorarioServicio;
import arquitectura.arquitectura.entity.estudiantes;
import arquitectura.arquitectura.entity.Horario;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/escuela/estudiante")
public class estudianteController {

    @Autowired
    private EstudianteServicio servicio;

    @Autowired
    private HorarioServicio horarioServicio;

    /** Panel inicial de estudiante (ya existente) */
    @GetMapping
    public String panelEstudiante() {
        return "estudiante";
    }

    /** Registro (sin cambios) */
    @GetMapping("/registro")
    public String mostrarRegistro(Model modelo) {
        modelo.addAttribute("estudiante", new estudiantes());
        return "superegistro";
    }
    @PostMapping("/registro/guardar")
    public String guardarRegistro(@ModelAttribute("estudiante") estudiantes est) {
        servicio.guardar(est);
        return "redirect:/escuela/estudiante/bienvenida";
    }
    @GetMapping("/bienvenida")
    public String bienvenidaRegistro() {
        return "bienvenida-estudiante";
    }

    @GetMapping("/programar")
    public String mostrarAsistencia(Model modelo) {
        modelo.addAttribute("horarios", horarioServicio.ListarTodosLosHorarios());
        return "programar-asistencia";
    }

    @PostMapping("/programar")
    public String filtrarAsistencia(@RequestParam(value = "dias", required = false) List<String> dias,
                                    Model modelo) {
        List<Horario> todos = horarioServicio.ListarTodosLosHorarios();
        if (dias != null) {
            List<Horario> filtrados = todos.stream()
                    .filter(h -> dias.contains(h.getDia()))
                    .collect(Collectors.toList());
            modelo.addAttribute("filtrados", filtrados);
        }
        modelo.addAttribute("horarios", todos);
        return "programar-asistencia";
    }

}
