package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitiees.Funcionario;

public class SistemaDeFuncionarios {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos funcionários você deseja cadastrar? ");
        int quantidade = sc.nextInt();

        List<Funcionario> funcionarios = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Funcionário #" + (i + 1) + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consumir quebra de linha

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Salário: ");
            double salario = sc.nextDouble();

            funcionarios.add(new Funcionario(id, nome, salario));
        }

        System.out.print("\nDigite o ID do funcionário que deseja aumentar o salário: ");
        int idAumentar = sc.nextInt();

        Funcionario funcionario = funcionarios.stream()
                .filter(f -> f.getId() == idAumentar)
                .findFirst()
                .orElse(null);

        if (funcionario == null) {
            System.out.println("\nNão existe funcionário com o ID informado.");
        } else {
            System.out.print("Digite a porcentagem de aumento: ");
            double porcentagem = sc.nextDouble();
            funcionario.aumentarSalario(porcentagem);
        }

        System.out.println("\nLista de funcionários atualizada:");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }

        sc.close();
    }
}