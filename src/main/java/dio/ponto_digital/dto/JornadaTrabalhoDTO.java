package dio.ponto_digital.dto;

import lombok.Data;

import java.time.Duration;
import java.time.LocalTime;

@Data
public class JornadaTrabalhoDTO {
    private Long id;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private LocalTime intervalo;
}