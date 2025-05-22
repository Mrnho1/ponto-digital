package dio.ponto_digital.service;

import dio.ponto_digital.dto.FuncionarioInputDTO;
import dio.ponto_digital.dto.FuncionarioOutputDTO;
import dio.ponto_digital.model.Funcionario;
import dio.ponto_digital.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public FuncionarioOutputDTO salvar(FuncionarioInputDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());
        funcionario.setEmail(dto.getEmail());
        funcionario.setTelefone(dto.getTelefone());

        funcionario = repository.save(funcionario);

        return toOutputDTO(funcionario);
    }

    public List<FuncionarioOutputDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toOutputDTO)
                .collect(Collectors.toList());
    }

    private FuncionarioOutputDTO toOutputDTO(Funcionario funcionario) {
        FuncionarioOutputDTO dto = new FuncionarioOutputDTO();
        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setCpf(funcionario.getCpf());
        dto.setEmail(funcionario.getEmail());
        dto.setTelefone(funcionario.getTelefone());
        return dto;
    }
}