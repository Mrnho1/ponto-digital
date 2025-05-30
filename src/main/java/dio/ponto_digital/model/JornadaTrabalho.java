package dio.ponto_digital.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
public class JornadaTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private LocalTime intervalo;

    @OneToOne
    @JoinColumn(name = "funcionario_id")
    @JsonBackReference
    private Funcionario funcionario;
}