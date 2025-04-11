package arquitectura.arquitectura.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;



@Entity
@Table(name = "Pago")

public class pago {

    @Id
    private String nombre;

    private String correo;
    private float valor;
    private Date fecha;
}
