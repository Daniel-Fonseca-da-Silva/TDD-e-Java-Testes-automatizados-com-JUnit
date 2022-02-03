package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    @Test()
    public void reajusteDeveriaSerDe3PorcentoQuandoDesempenhoForRazoavel() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Fulano", LocalDate.now(), new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.RAZOAVEL);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test()
    public void reajusteDeveriaSerDe15PorcentoQuandoDesempenhoForBom() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Fulano", LocalDate.now(), new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

}
