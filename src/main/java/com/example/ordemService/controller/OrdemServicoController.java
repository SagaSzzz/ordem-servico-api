package com.example.ordemService.controller;


import com.example.ordemService.model.OrdemServicoModel;
import com.example.ordemService.service.OrdemServicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordemServico")
public class OrdemServicoController {

    private OrdemServicoService ordemServicoService;

    public OrdemServicoController(OrdemServicoService ordemServicoService) {
        this.ordemServicoService = ordemServicoService;
    }

    @PostMapping
    public OrdemServicoModel adcItem(@RequestBody OrdemServicoModel ordem){
        return ordemServicoService.adcItem(ordem);
    }

    @GetMapping
    public List<OrdemServicoModel> listarItem(){
        return ordemServicoService.listarItem();
    }

    @GetMapping("/{id}")
    public OrdemServicoModel procurarId(@PathVariable Long id){
        return ordemServicoService.procurarId(id);
    }

    @PutMapping("/{id}")
    public OrdemServicoModel attItem(@PathVariable Long id, @RequestBody OrdemServicoModel ordem){
        return ordemServicoService.attItem(id, ordem);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        ordemServicoService.deletar(id);
    }

    @GetMapping("/status/{status}")
    public List <OrdemServicoModel> buscarPorStatus(@PathVariable String status){
        return  ordemServicoService.buscarPorStatus(status);
    }














}
