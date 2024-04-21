package model;

import java.io.Serializable;
import java.util.Scanner;

public class PessoaFisica extends Pessoa implements Serializable {
    private String cpf;
    private int idade;

    public PessoaFisica() {
    }

    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + cpf + ", Idade: " + idade);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void lerDados(Scanner scanner) {
        System.out.print("Digite o ID: ");
        setId(scanner.nextInt());
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Digite o nome: ");
        setNome(scanner.nextLine());
        System.out.print("Digite o CPF: ");
        setCpf(scanner.nextLine());
        System.out.print("Digite a idade: ");
        setIdade(scanner.nextInt());
        scanner.nextLine(); // Consumir a quebra de linha
    }

    public static void main(String[] args) {
        PessoaFisica pessoa1 = new PessoaFisica(1, "João", "123.456.789-10", 30);
        pessoa1.exibir();

        // Utilizando os getters
        System.out.println("CPF: " + pessoa1.getCpf());
        System.out.println("Idade: " + pessoa1.getIdade());
    }
}
