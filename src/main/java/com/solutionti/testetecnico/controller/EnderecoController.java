package com.solutionti.testetecnico.controller;

import com.solutionti.testetecnico.dto.EnderecoDTO;
import com.solutionti.testetecnico.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService){

        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> getAllEnderecos(){

        return ResponseEntity.ok(enderecoService.getAllEnderecos());
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<EnderecoDTO>> getEnderecosByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(enderecoService.getEnderecosByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> createEndereco(@RequestBody EnderecoDTO enderecoDTO) {

        return ResponseEntity.ok(enderecoService.createEndereco(enderecoDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id){
        enderecoService.deleteEndereco(id);
        return ResponseEntity.noContent().build();

    }

}
