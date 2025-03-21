import java.util.ArrayList;
import java.util.Scanner;


class Livro {
    String titulo;
    String autor;
    int ano;

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    
    public String toString() {
        return titulo + " - " + autor + " (" + ano + ")";
    }
}


public class Biblioteca {
    static ArrayList<Livro> livros = new ArrayList<>(); 
    static Scanner scanner = new Scanner(System.in); 

    public static void main(String[] args) {
        int opcao;

        do {
            
            System.out.println("\n=== Biblioteca ===");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Buscar Livro");
            System.out.println("4. Remover Livro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 


            if (opcao == 1) {
                adicionarLivro();
            } else if (opcao == 2) {
                listarLivros();
            } else if (opcao == 3) {
                buscarLivro();
            } else if (opcao == 4) {
                removerLivro();
            } else if (opcao == 0) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    
    static void adicionarLivro() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de publicação: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); 

        livros.add(new Livro(titulo, autor, ano));
        System.out.println("Livro adicionado com sucesso!");
    }

    
    static void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("\nLista de Livros:");
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    
    static void buscarLivro() {
        System.out.print("Digite o título do livro: ");
        String tituloBusca = scanner.nextLine();

        for (Livro livro : livros) {
            if (livro.titulo.equalsIgnoreCase(tituloBusca)) {
                System.out.println("Livro encontrado: " + livro);
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    
    static void removerLivro() {
        System.out.print("Digite o título do livro a ser removido: ");
        String tituloRemover = scanner.nextLine();

        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).titulo.equalsIgnoreCase(tituloRemover)) {
                livros.remove(i);
                System.out.println("Livro removido com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }
}
