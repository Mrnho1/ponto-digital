package dio.ponto_digital.controller;

import dio.ponto_digital.dto.FuncionarioDTO;
import dio.ponto_digital.dto.FuncionarioInputDTO;
import dio.ponto_digital.dto.FuncionarioOutputDTO;
import dio.ponto_digital.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@Tag(name = "Funcionários", description = "Endpoints para gerenciamento de funcionários")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Operation(summary = "Criar novo funcionário.")
    @PostMapping
    public FuncionarioOutputDTO criar(@RequestBody FuncionarioInputDTO dto) {
        return funcionarioService.salvar(dto);
    }
    @Operation(summary = "Listar todos os funcionários.")
    @GetMapping
    public List<FuncionarioDTO> listarFuncionarios() {
        return funcionarioService.listarTodos();
    }
    @Operation(summary = "Buscar funcionário por ID.")
    @GetMapping("/{id}")
    public FuncionarioOutputDTO buscarPorId(@PathVariable Long id) {
        return funcionarioService.buscarPorId(id);
    }
}
