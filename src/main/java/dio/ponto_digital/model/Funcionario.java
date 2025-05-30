package dio.ponto_digital.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.ALL)
    @JsonManagedReference
    private JornadaTrabalho jornadaTrabalho;

}