package org.kan.kancare.boot.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.kan.kancare.boot.domain.Beneficiario;
import org.kan.kancare.boot.domain.Documento;
import org.kan.kancare.boot.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("beneficiarios")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService service;

    @PostMapping("cadastro")
    public ResponseEntity<Beneficiario> cadastrarBeneficiario(@Valid @RequestBody Beneficiario beneficiario) {
        service.salvar(beneficiario);
        return new ResponseEntity<>(beneficiario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Beneficiario>> listarBeneficiarios() {
        List<Beneficiario> beneficiariosList = service.buscarTodos();
        return new ResponseEntity<>(beneficiariosList, HttpStatus.OK);
    }

    @GetMapping("/documentos/{id}")
    public ResponseEntity<List<Documento>> listarDocumentosPorBeneficiario(@PathVariable Long id) {

        List<Documento> documentos = service.buscarDocumentosPorBeneficiario(id);

        return new ResponseEntity<>(documentos, HttpStatus.OK);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarBeneficiario(@PathVariable Long id,
                                                        @Valid @RequestBody Beneficiario beneficiarioAtualizado) {
        try {
            service.editar(id, beneficiarioAtualizado);
            return new ResponseEntity<>("Beneficiário atualizado com sucesso", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerBeneficiario(@PathVariable Long id) {
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

