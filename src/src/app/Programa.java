package app;

import entities.Funcionario;
import services.ImpostoService;
import services.PrevidenciaService;
import services.SalarioService;

import java.util.Locale;
import java.util.Scanner;

public class Programa {



    public static void main(String[] args) {



        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Funcionario f1 = new Funcionario();

        System.out.println("Nome: ");
        f1.setName(sc.nextLine());
        System.out.println("Salario: ");
        f1.setSalario(sc.nextDouble());

        ImpostoService impostoService = new ImpostoService();
        PrevidenciaService previdenciaService = new PrevidenciaService();
        SalarioService salarioService = new SalarioService(impostoService, previdenciaService);

        double salarioLiquido = salarioService.calcularSalario(f1);

        System.out.println("Salario de " + f1.getName() + " e de " + salarioLiquido);

        sc.close();

    }

}
