package dio.ponto_digital.controller;

import dio.ponto_digital.dto.JornadaTrabalhoInputDTO;
import dio.ponto_digital.dto.JornadaTrabalhoOutputDTO;
import dio.ponto_digital.service.JornadaTrabalhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jornadas")
@Tag(name = "Jornadas de Trabalho", description = "Endpoints para criação de jornadas de trabalho")
public class JornadaTrabalhoController {

    @Autowired
    private JornadaTrabalhoService jornadaService;

    @Operation(summary = "Criar uma nova jornada de trabalho para um funcionário")
    @PostMapping
    public JornadaTrabalhoOutputDTO criar(@RequestBody JornadaTrabalhoInputDTO dto) {
        return jornadaService.salvar(dto);
    }
}