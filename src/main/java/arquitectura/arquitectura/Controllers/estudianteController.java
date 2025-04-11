package arquitectura.arquitectura.Controllers;

import arquitectura.arquitectura.Servicio.EstudianteServicio;
import arquitectura.arquitectura.entity.estudiantes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class estudianteController {

    @Autowired
    private EstudianteServicio servicio;

    // Ruta principal para listar estudiantes
    @GetMapping({"/escuela", "/"})
    public String ListarEstudiantes(Model modelo) {
        // Si deseas enviar la lista a la vista, descomenta la siguiente línea:
        // modelo.addAttribute("estudiantes", servicio.ListarTodosLosEstudiantes());
        return "index"; // Busca index.html en src/main/resources/templates
    }

    // Formulario de registro de nuevo estudiante
    @GetMapping("/escuela/registro")
    public String crearEstudianteFormulario(Model modelo) {
        estudiantes estudiante = new estudiantes();
        modelo.addAttribute("estudiante", estudiante);
        return "superegistro"; // Vista de registro
    }

    // Guardar los datos del estudiante
    @PostMapping({"/escuela/guardar"})
    public String guardar(@ModelAttribute("estudiante") estudiantes estudiante) {
        servicio.guardar(estudiante);
        System.out.println("contraseña: " + estudiante.getContrasena());
        return "login"; // Redirige a login
    }

    // Página de inicio de sesión (GET)
    @GetMapping({"/escuela/login"})
    public String Log(Model modelo) {
        return "login";
    }

    // Validar el inicio de sesión (POST)
    @PostMapping({"/escuela/login"})
    public String Login(Model modelo) {
        return "login";
    }

    @GetMapping("/escuela/listar")
    public String listarEstudiantes(Model modelo) {
        modelo.addAttribute("estudiantes", servicio.ListarTodosLosEstudiantes());
        return "listar"; // Esto buscará un archivo listar.html
    }


    // Validar credenciales y listar estudiantes (por ejemplo, para login)
    @PostMapping({"/escuela/validar"})
    public String Listar(@ModelAttribute("estudiante") estudiantes estudiante, Model modelo) {
        List<estudiantes> listaEstudiantes = servicio.ListarTodosLosEstudiantes();
        modelo.addAttribute("estudiantes", listaEstudiantes);
        for (estudiantes estudiante1 : listaEstudiantes) {
            if (estudiante.getCorreo().equals(estudiante1.getCorreo()) &&
                    estudiante.getContrasena().equals(estudiante1.getContrasena())) {
                modelo.addAttribute("idusuario", estudiante1.getId());
                return "dentro"; // Vista después de un login exitoso
            }
        }
        return "login"; // Vuelve a login si no se validó correctamente
    }

    // Eliminar estudiante por ID
    @GetMapping({"/escuela/{id}"})
    public String Eliminar(@PathVariable String id) {
        servicio.Eliminar(Long.parseLong(id));
        return "index";
    }
}
