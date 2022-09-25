package services;

import entities.Funcionario;

public class SalarioService {

    private ImpostoService impostoService;
    private PrevidenciaService previdenciaService;

    public SalarioService(ImpostoService impostoService, PrevidenciaService previdenciaService) {
        this.impostoService = impostoService;
        this.previdenciaService = previdenciaService;
    }

    public double calcularSalario(Funcionario funcionario) {

        double previdencia = previdenciaService.calcularPrevidencia(funcionario.getSalario());
        double imposto = impostoService.calcularImposto(funcionario.getSalario());

        return funcionario.getSalario() - previdencia - imposto;
    }

}
