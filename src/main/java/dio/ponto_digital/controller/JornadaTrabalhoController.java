package dio.ponto_digital.controller;

import dio.ponto_digital.dto.JornadaTrabalhoInputDTO;
import dio.ponto_digital.dto.JornadaTrabalhoOutputDTO;
import dio.ponto_digital.service.JornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jornadas")
public class JornadaTrabalhoController {

    @Autowired
    private JornadaTrabalhoService jornadaService;

    @PostMapping
    public JornadaTrabalhoOutputDTO criar(@RequestBody JornadaTrabalhoInputDTO dto) {
        return jornadaService.salvar(dto);
    }
}
