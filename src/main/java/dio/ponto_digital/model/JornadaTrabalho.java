package dio.ponto_digital.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
public class JornadaTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "funcionario_id", nullable = false, unique = true)
    private Funcionario funcionario;

    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private LocalTime intervalo;
}