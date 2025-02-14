package org.example.Service;

import org.example.Model.ProdutoModel;
import org.example.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void cadastrarProduto(ProdutoModel produto) {
        produtoRepository.save(produto);
    }
    public List<ProdutoModel> obterTodosProdutos() {
        return produtoRepository.findAll();
    }
    public Optional<ProdutoModel> obterProdutoPorId(Integer id) {
        return produtoRepository.findById(id);
    }

}