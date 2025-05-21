// src/main/java/arquitectura/arquitectura/entity/estudiantes.java
package arquitectura.arquitectura.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Estudiantes")
public class estudiantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "correo", nullable = false, length = 50, unique = true)
    private String correo;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "contrasena")
    private String contrasena;

    @ElementCollection
    @CollectionTable(
            name = "estudiante_dias",
            joinColumns = @JoinColumn(name = "estudiante_id")
    )
    @Column(name = "dia")
    private List<String> dias;

    public estudiantes() { }

    public estudiantes(Long id, String nombre, String apellido, String correo, int edad, String contrasena, List<String> dias) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.edad = edad;
        this.contrasena = contrasena;
        this.dias = dias;
    }

    // getters & setters...

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public List<String> getDias() { return dias; }
    public void setDias(List<String> dias) { this.dias = dias; }
}
