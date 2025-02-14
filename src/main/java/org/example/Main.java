package org.example;

import org.example.Model.ProdutoModel;
import org.example.Service.ProdutoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = "org.example")
@EnableJpaRepositories(basePackages = "org.example.Repository")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        ProdutoService produtoService = context.getBean(ProdutoService.class);
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----- Gerenciamento de Produtos -----");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do produto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    ProdutoModel produto = new ProdutoModel(id, nome, preco);
                    produtoService.cadastrarProduto(produto);
                    System.out.println("Produto cadastrado com sucesso.");
                    break;
                case 2:
                    List<ProdutoModel> produtos = produtoService.obterTodosProdutos();
                    System.out.println("----- Lista de Produtos -----");
                    for (ProdutoModel p : produtos) {
                        System.out.println(p);
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }
}
