package org.kan.kancare.boot.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.kan.kancare.boot.domain.Beneficiario;
import org.kan.kancare.boot.dto.ApiResponse;
import org.kan.kancare.boot.dto.BeneficiarioResposta;
import org.kan.kancare.boot.dto.DocumentoResposta;
import org.kan.kancare.boot.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("beneficiarios")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService service;

    @PostMapping
    public ResponseEntity<ApiResponse<Beneficiario>> cadastrarBeneficiario(@Valid @RequestBody Beneficiario beneficiario) {
        service.salvar(beneficiario);
        ApiResponse<Beneficiario> response = ApiResponse.<Beneficiario>builder()
                .status(HttpStatus.CREATED.value())
                .message("Beneficiário cadastrado com sucesso.")
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<BeneficiarioResposta>>> listarBeneficiarios() {
        List<BeneficiarioResposta> beneficiariosList = service.buscarTodos();
        ApiResponse<List<BeneficiarioResposta>> response = ApiResponse.<List<BeneficiarioResposta>>builder()
                .status(HttpStatus.OK.value())
                .message("Lista de beneficiários obtida com sucesso.")
                .data(beneficiariosList)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/documentos/{id}")
    public ResponseEntity<ApiResponse<List<DocumentoResposta>>> listarDocumentosPorBeneficiario(@PathVariable Long id) {
        try {
            List<DocumentoResposta> listaDocumentos = service.buscarDocumentosPorBeneficiario(id);

            ApiResponse<List<DocumentoResposta>> response = ApiResponse.<List<DocumentoResposta>>builder()
                    .status(HttpStatus.OK.value())
                    .message("Lista de documentos obtida com sucesso.")
                    .data(listaDocumentos)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            ApiResponse<List<DocumentoResposta>> response = ApiResponse.<List<DocumentoResposta>>builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .message(e.getMessage())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> atualizarBeneficiario(@PathVariable Long id,
                                                        @Valid @RequestBody Beneficiario beneficiarioAtualizado) {
        try {
            service.editar(id, beneficiarioAtualizado);
            ApiResponse<String> response = ApiResponse.<String>builder()
                    .status(HttpStatus.OK.value())
                    .message("Beneficiário atualizado com sucesso.")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            ApiResponse<String> response = ApiResponse.<String>builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .message(e.getMessage())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> removerBeneficiario(@PathVariable Long id) {
        service.excluir(id);
        ApiResponse<String> response = ApiResponse.<String>builder()
                .status(HttpStatus.OK.value())
                .message("Beneficiário removido com sucesso.")
                .build();
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}

