package dio.ponto_digital.dto;

import lombok.Data;

@Data
public class FuncionarioInputDTO {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
}