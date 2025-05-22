package dio.ponto_digital.service;

import dio.ponto_digital.dto.JornadaTrabalhoInputDTO;
import dio.ponto_digital.dto.JornadaTrabalhoOutputDTO;
import dio.ponto_digital.model.Funcionario;
import dio.ponto_digital.model.JornadaTrabalho;
import dio.ponto_digital.repository.FuncionarioRepository;
import dio.ponto_digital.repository.JornadaTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JornadaTrabalhoService {

    @Autowired
    private JornadaTrabalhoRepository jornadaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public JornadaTrabalhoOutputDTO salvar(JornadaTrabalhoInputDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(dto.getFuncionarioId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        JornadaTrabalho jornada = new JornadaTrabalho();
        jornada.setFuncionario(funcionario);
        jornada.setHoraEntrada(dto.getHoraEntrada());
        jornada.setHoraSaida(dto.getHoraSaida());
        jornada.setIntervalo(dto.getIntervalo());

        JornadaTrabalho salvo = jornadaRepository.save(jornada);

        JornadaTrabalhoOutputDTO output = new JornadaTrabalhoOutputDTO();
        output.setId(salvo.getId());
        output.setFuncionarioId(funcionario.getId());
        output.setHoraEntrada(salvo.getHoraEntrada());
        output.setHoraSaida(salvo.getHoraSaida());
        output.setIntervalo(salvo.getIntervalo());

        return output;
    }


}
