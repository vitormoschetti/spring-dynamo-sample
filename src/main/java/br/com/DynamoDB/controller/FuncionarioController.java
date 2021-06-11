package br.com.DynamoDB.controller;

import br.com.DynamoDB.entity.Funcionario;
import br.com.DynamoDB.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioRepository funcionarioRepository;

    @PostMapping
    public Funcionario save(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @GetMapping("/{id}")
    public Funcionario getFuncionarioById(@PathVariable("id") String funcionarioId) {
        return funcionarioRepository.getFuncionarioById(funcionarioId);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String funcionarioId) {
        return funcionarioRepository.delete(funcionarioId);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") String funcionarioId, @RequestBody Funcionario funcionario) {
        return funcionarioRepository.update(funcionarioId, funcionario);
    }


}
