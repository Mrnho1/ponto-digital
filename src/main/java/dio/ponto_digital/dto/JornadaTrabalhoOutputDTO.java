package dio.ponto_digital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JornadaTrabalhoOutputDTO {
    private Long id;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private LocalTime intervalo;
    private FuncionarioDTO funcionario;
}
