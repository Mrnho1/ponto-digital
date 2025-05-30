package dio.ponto_digital.service;

import dio.ponto_digital.dto.FuncionarioDTO;
import dio.ponto_digital.dto.FuncionarioInputDTO;
import dio.ponto_digital.dto.FuncionarioOutputDTO;
import dio.ponto_digital.dto.JornadaTrabalhoDTO;
import dio.ponto_digital.model.Funcionario;
import dio.ponto_digital.model.JornadaTrabalho;
import dio.ponto_digital.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioOutputDTO salvar(FuncionarioInputDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());
        funcionario.setEmail(dto.getEmail());
        funcionario.setTelefone(dto.getTelefone());

        Funcionario salvo = funcionarioRepository.save(funcionario);

        return toOutputDTO(salvo);
    }

    public FuncionarioOutputDTO buscarPorId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        return toOutputDTO(funcionario);
    }

    private FuncionarioOutputDTO toOutputDTO(Funcionario funcionario) {
        FuncionarioOutputDTO dto = new FuncionarioOutputDTO();
        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setCpf(funcionario.getCpf());
        dto.setEmail(funcionario.getEmail());
        dto.setTelefone(funcionario.getTelefone());

        JornadaTrabalho jornada = funcionario.getJornadaTrabalho();
        if (jornada != null) {
            JornadaTrabalhoDTO jornadaDTO = new JornadaTrabalhoDTO();
            jornadaDTO.setId(jornada.getId());
            jornadaDTO.setHoraEntrada(jornada.getHoraEntrada());
            jornadaDTO.setHoraSaida(jornada.getHoraSaida());
            jornadaDTO.setIntervalo(jornada.getIntervalo());
            dto.setJornadaTrabalho(jornadaDTO);
        }

        return dto;
    }
    public List<FuncionarioDTO> listarTodos() {
        return funcionarioRepository.findAll()
                .stream()
                .map(funcionario -> {
                    FuncionarioDTO dto = new FuncionarioDTO();
                    dto.setId(funcionario.getId());
                    dto.setNome(funcionario.getNome());
                    dto.setCpf(funcionario.getCpf());
                    dto.setEmail(funcionario.getEmail());
                    dto.setTelefone(funcionario.getTelefone());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
