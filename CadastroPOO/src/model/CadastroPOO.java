import java.io.IOException;
import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class CadastroPOO {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
            PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
            
            int opcao = -1;
            while (opcao != 0) {
                System.out.println("===== Menu =====");
                System.out.println("1. Incluir");
                System.out.println("2. Alterar");
                System.out.println("3. Excluir");
                System.out.println("4. Exibir pelo ID");
                System.out.println("5. Exibir todos");
                System.out.println("6. Salvar dados");
                System.out.println("7. Recuperar dados");
                System.out.println("0. Finalizar");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha
                
                switch (opcao) {
                    case 1 ->  {
                        System.out.println("Selecionada a opção Incluir.");
                        System.out.println("Escolha o tipo (1 para Física, 2 para Jurídica): ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha
                        switch (tipo) {
                            case 1 ->  {
                                System.out.println("Incluir Pessoa Física:");
                                PessoaFisica pessoaFisica = new PessoaFisica();
                                pessoaFisica.lerDados(scanner);
                                repoFisica.inserir(pessoaFisica);
                            }
                            case 2 ->  {
                                System.out.println("Incluir Pessoa Jurídica:");
                                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                                pessoaJuridica.lerDados(scanner);
                                repoJuridica.inserir(pessoaJuridica);
                            }
                            default -> System.out.println("Opção inválida.");
                        }
                    }
                    case 2 ->  {
                        System.out.println("Selecionada a opção Alterar.");
                        System.out.println("Escolha o tipo (1 para Física, 2 para Jurídica): ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha
                        System.out.println("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha
                        switch (tipo) {
                            case 1 -> {
                                PessoaFisica pessoaFisica = repoFisica.obter(id);
                                if (pessoaFisica != null) {
                                    System.out.println("Dados atuais:");
                                    pessoaFisica.exibir();
                                    System.out.println("Digite os novos dados:");
                                    pessoaFisica.lerDados(scanner);
                                    repoFisica.alterar(pessoaFisica);
                                } else {
                                    System.out.println("Pessoa física não encontrada.");
                                }
                            }
                            case 2 -> {
                                PessoaJuridica pessoaJuridica = repoJuridica.obter(id);
                                if (pessoaJuridica != null) {
                                    System.out.println("Dados atuais:");
                                    pessoaJuridica.exibir();
                                    System.out.println("Digite os novos dados:");
                                    pessoaJuridica.lerDados(scanner);
                                    repoJuridica.alterar(pessoaJuridica);
                                } else {
                                    System.out.println("Pessoa jurídica não encontrada.");
                                }
                            }
                            default -> System.out.println("Opção inválida.");
                        }
                    }
                    case 3 ->  {
                        System.out.println("Selecionada a opção Excluir.");
                        System.out.println("Escolha o tipo (1 para Física, 2 para Jurídica): ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha
                        System.out.println("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha
                        switch (tipo) {
                            case 1 -> {
                                repoFisica.excluir(id);
                                System.out.println("Pessoa física excluída com sucesso.");
                            }
                            case 2 -> {
                                repoJuridica.excluir(id);
                                System.out.println("Pessoa jurídica excluída com sucesso.");
                            }
                            default -> System.out.println("Opção inválida.");
                        }
                    }
                    case 4 ->  {
                        System.out.println("Selecionada a opção Exibir pelo ID.");
                        System.out.println("Escolha o tipo (1 para Física, 2 para Jurídica): ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha
                        System.out.println("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha
                        switch (tipo) {
                            case 1 -> {
                                PessoaFisica pessoaFisica = repoFisica.obter(id);
                                if (pessoaFisica != null) {
                                    System.out.println("Dados da pessoa física:");
                                    pessoaFisica.exibir();
                                } else {
                                    System.out.println("Pessoa física não encontrada.");
                                }
                            }
                            case 2 -> {
                                PessoaJuridica pessoaJuridica = repoJuridica.obter(id);
                                if (pessoaJuridica != null) {
                                    System.out.println("Dados da pessoa jurídica:");
                                    pessoaJuridica.exibir();
                                } else {
                                    System.out.println("Pessoa jurídica não encontrada.");
                                }
                            }
                            default -> System.out.println("Opção inválida.");
                        }
                    }
                    case 5 ->  {
                        System.out.println("Selecionada a opção Exibir todos.");
                        System.out.println("Escolha o tipo (1 para Física, 2 para Jurídica): ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha
                        switch (tipo) {
                            case 1 -> {
                                System.out.println("Pessoas físicas:");
                                for (PessoaFisica pessoa : repoFisica.obterTodos()) {
                                    pessoa.exibir();
                                }
                            }
                            case 2 -> {
                                System.out.println("Pessoas jurídicas:");
                                for (PessoaJuridica pessoa : repoJuridica.obterTodos()) {
                                    pessoa.exibir();
                                }
                            }
                            default -> System.out.println("Opção inválida.");
                        }
                    }
                    case 6 ->  {
                        try {
                            System.out.println("Selecionada a opção Salvar dados.");
                            System.out.print("Digite o prefixo dos arquivos: ");
                            String prefixo = scanner.nextLine();
                            repoFisica.persistir(prefixo + ".fisica.bin");
                            repoJuridica.persistir(prefixo + ".juridica.bin");
                            System.out.println("Dados salvos com sucesso.");
                        } catch (IOException e) {
                            System.err.println("Erro ao salvar os dados: " + e.getMessage());
                        }
                    }
                    case 7 ->  {
                        try {
                            System.out.println("Selecionada a opção Recuperar dados.");
                            System.out.print("Digite o prefixo dos arquivos: ");
                            String prefixo = scanner.nextLine();
                            repoFisica.recuperar(prefixo + ".fisica.bin");
                            repoJuridica.recuperar(prefixo + ".juridica.bin");
                            System.out.println("Dados recuperados com sucesso.");
                        } catch (IOException | ClassNotFoundException e) {
                            System.err.println("Erro ao recuperar os dados: " + e.getMessage());
                        }
                    }
                    case 0 -> System.out.println("Finalizando...");
                    default -> System.out.println("Opção inválida.");
                }
            }
        }
    }
}
