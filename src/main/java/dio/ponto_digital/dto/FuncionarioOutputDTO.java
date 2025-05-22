package dio.ponto_digital.dto;

import lombok.Data;

@Data
public class FuncionarioOutputDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private JornadaTrabalhoDTO jornadaTrabalho;
}