package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.assembler.EntregaMapper;
import com.algaworks.algalog.api.model.DestinatarioModel;
import com.algaworks.algalog.api.model.EntregaModel;
import com.algaworks.algalog.api.model.input.EntregaInput;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.FinalizacaoEntregaService;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController
{
    private EntregaMapper entregaMapper;
    private EntregaRepository entregaRepository;
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private FinalizacaoEntregaService finalizacaoEntregaService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput)
    {
        Entrega novaEntrega = entregaMapper.toEntity(entregaInput);
        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
        return entregaMapper.toModel(entregaSolicitada);
    }

    @GetMapping
    public List<EntregaModel> listar() {
        return entregaMapper.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaMapper.toModel(entrega)))
                        .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId){
        finalizacaoEntregaService.finalizar(entregaId);
    }
}
