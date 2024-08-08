package org.kan.kancare.boot.controller;

import org.kan.kancare.boot.domain.Documento;
import org.kan.kancare.boot.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService service;

    @GetMapping("/{id}")
    public ResponseEntity<List<Documento>> listarDocumentosPorBeneficiario(@PathVariable Long id) {
        List<Documento> documentos = service.buscarDocumentosPorIdBeneficiario(id);
        if (documentos == null || documentos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(documentos, HttpStatus.OK);
    }
}
