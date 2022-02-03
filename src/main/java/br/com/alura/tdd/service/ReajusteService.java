package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        if(desempenho == Desempenho.RAZOAVEL) {
           BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
           funcionario.reajustarSalario(reajuste);
        }
    }
}
