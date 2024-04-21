package model;

import java.io.Serializable;
import java.util.Scanner;

public class PessoaJuridica extends Pessoa implements Serializable {
    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CNPJ: " + cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void lerDados(Scanner scanner) {
        System.out.print("Digite o ID: ");
        setId(scanner.nextInt());
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Digite o nome: ");
        setNome(scanner.nextLine());
        System.out.print("Digite o CNPJ: ");
        setCnpj(scanner.nextLine());
    }

    public static void main(String[] args) {
        PessoaJuridica pessoa1 = new PessoaJuridica(1, "Empresa XYZ", "12.345.678/0001-90");
        pessoa1.exibir();

        // Utilizando o getter
        System.out.println("CNPJ: " + pessoa1.getCnpj());
    }
}
