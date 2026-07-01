package com.example.ordemService.service;

import com.example.ordemService.dto.OrdemServicoRequestDTO;
import com.example.ordemService.dto.OrdemServicoResponseDTO;
import com.example.ordemService.enums.StatusOrdem;
import com.example.ordemService.model.ClienteModel;
import com.example.ordemService.model.EquipamentoModel;
import com.example.ordemService.model.OrdemServicoModel;
import com.example.ordemService.repository.ClienteRepository;
import com.example.ordemService.repository.EquipamentoRepository;
import com.example.ordemService.repository.OrdemServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final ClienteRepository clienteRepository;
    private final EquipamentoRepository equipamentoRepository;

    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository,
                               ClienteRepository clienteRepository,
                               EquipamentoRepository equipamentoRepository)
    {
        this.ordemServicoRepository = ordemServicoRepository;
        this.clienteRepository = clienteRepository;
        this.equipamentoRepository = equipamentoRepository;
    }


    private OrdemServicoResponseDTO converterDTO(OrdemServicoModel ordem) {
        return new OrdemServicoResponseDTO(ordem.getId(), ordem.getDescProblema(),
                ordem.getStatus(), ordem.getValor(), ordem.getComeco(),
                ordem.getFim(), ordem.getCliente(), ordem.getEquipamento());
    }

    private ClienteModel buscarClientePorId(Long clienteId) {
        return clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("CLIENTE NAO ENCONTADO"));
    }

    private EquipamentoModel buscarEquipamentoPorId(Long equipamentoId) {
        return equipamentoRepository.findById(equipamentoId)
                .orElseThrow(() -> new RuntimeException("EQUIPAMENTO NAO ENCONTRADO"));
    }


    public OrdemServicoResponseDTO adicionarItemDto(OrdemServicoRequestDTO dto) {
        ClienteModel cliente = buscarClientePorId(dto.getClienteId());
        EquipamentoModel equipamento = buscarEquipamentoPorId(dto.getEquipamentoId());


        OrdemServicoModel ordem = new OrdemServicoModel();
        ordem.setDescProblema(dto.getDescProblema());
        ordem.setStatus(dto.getStatus());
        ordem.setValor(dto.getValor());
        ordem.setComeco(dto.getComeco());
        ordem.setFim(dto.getFim());
        ordem.setCliente(cliente);
        ordem.setEquipamento(equipamento);

        OrdemServicoModel ordemSalva = ordemServicoRepository.save(ordem);

        return converterDTO(ordemSalva);
    }

    public List<OrdemServicoResponseDTO> listarItemDto() {
        return ordemServicoRepository.findAll()
                .stream()
                .map(ordem -> converterDTO(ordem))
                .toList();
    }


    public OrdemServicoResponseDTO procurarIdDto(Long id) {
        OrdemServicoModel ordem = ordemServicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NAO ENCONTRADO"));
        return converterDTO(ordem);
    }


    public OrdemServicoResponseDTO atualizarItemDto(Long id, OrdemServicoRequestDTO dto) {
        ClienteModel cliente = buscarClientePorId(dto.getClienteId());
        EquipamentoModel equipamento = buscarEquipamentoPorId(dto.getEquipamentoId());

        OrdemServicoModel atualizado = ordemServicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NAO ENCONNTRADO"));

        atualizado.setValor(dto.getValor());
        atualizado.setComeco(dto.getComeco());
        atualizado.setFim(dto.getFim());
        atualizado.setStatus(dto.getStatus());
        atualizado.setDescProblema(dto.getDescProblema());
        atualizado.setCliente(cliente);
        atualizado.setEquipamento(equipamento);

        OrdemServicoModel ordem = ordemServicoRepository.save(atualizado);

        return converterDTO(ordem);
    }


    public void deletar(Long id) {
        OrdemServicoModel busca = ordemServicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NAO ENCONNTRADO"));
        ordemServicoRepository.delete(busca);
    }

    public List<OrdemServicoResponseDTO> buscarPorStatusDto(StatusOrdem status) {
        return ordemServicoRepository.findByStatus(status)
                .stream()
                .map(ordemStatus -> converterDTO(ordemStatus))
                .toList();
    }

    public List<OrdemServicoResponseDTO> buscarClienteIdDto(Long clienteId) {
        return ordemServicoRepository.findByClienteId(clienteId)
                .stream()
                .map(ordemId -> converterDTO(ordemId))
                .toList();
    }


    public List<OrdemServicoResponseDTO> buscarEquipamentoIdDto(Long equipamentoId) {
        return ordemServicoRepository.findByEquipamentoId(equipamentoId)
                .stream()
                .map(ordemEquipamento -> converterDTO(ordemEquipamento))
                .toList();
    }


}
