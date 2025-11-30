package com.clickfarma.service;

import com.clickfarma.dto.ProdutoDTO;
import com.clickfarma.model.Produto;
import com.clickfarma.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDTO create(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());
        produto.setEstoque(produtoDTO.getEstoque());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setFabricante(produtoDTO.getFabricante());
        produto.setCategoria(produtoDTO.getCategoria());

        Produto produtoSalvo = produtoRepository.save(produto);
        return mapToDTO(produtoSalvo);
    }

    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ProdutoDTO findById(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));
        return mapToDTO(produto);
    }

    public ProdutoDTO update(Long id, ProdutoDTO produtoDTO) {
        // Verifica se o produto existe
        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));

        // Atualiza os dados
        produtoExistente.setNome(produtoDTO.getNome());
        produtoExistente.setPreco(produtoDTO.getPreco());
        produtoExistente.setEstoque(produtoDTO.getEstoque());
        produtoExistente.setDescricao(produtoDTO.getDescricao());
        produtoExistente.setFabricante(produtoDTO.getFabricante());
        produtoExistente.setCategoria(produtoDTO.getCategoria());

        Produto produtoAtualizado = produtoRepository.save(produtoExistente);
        return mapToDTO(produtoAtualizado);
    }

    public void delete(Long id) {
        // Verifica se o produto existe antes de deletar
        if (!produtoRepository.existsById(id)) {
            throw new EntityNotFoundException("Produto não encontrado com ID: " + id);
        }
        produtoRepository.deleteById(id);
    }

    // Método auxiliar para converter Produto para ProdutoDTO
    private ProdutoDTO mapToDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setPreco(produto.getPreco());
        dto.setEstoque(produto.getEstoque());
        dto.setDescricao(produto.getDescricao());
        dto.setFabricante(produto.getFabricante());
        dto.setCategoria(produto.getCategoria());
        return dto;
    }
}