package dio.ponto_digital.dto;

import lombok.Data;
import java.time.LocalTime;

@Data
public class JornadaTrabalhoOutputDTO {
    private Long id;
    private Long funcionarioId;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private LocalTime intervalo;
}

