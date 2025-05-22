package dio.ponto_digital.controller;

import dio.ponto_digital.dto.FuncionarioInputDTO;
import dio.ponto_digital.dto.FuncionarioOutputDTO;
import dio.ponto_digital.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioOutputDTO criar(@RequestBody FuncionarioInputDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<FuncionarioOutputDTO> listar() {
        return service.listarTodos();
    }
}
