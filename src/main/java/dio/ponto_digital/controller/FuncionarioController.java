package dio.ponto_digital.controller;

import dio.ponto_digital.dto.FuncionarioInputDTO;
import dio.ponto_digital.dto.FuncionarioOutputDTO;
import dio.ponto_digital.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public FuncionarioOutputDTO criar(@RequestBody FuncionarioInputDTO dto) {
        return funcionarioService.salvar(dto);
    }

    @GetMapping("/{id}")
    public FuncionarioOutputDTO buscarPorId(@PathVariable Long id) {
        return funcionarioService.buscarPorId(id);
    }
}
