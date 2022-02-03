package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        System.out.println("Inicializar");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Fulano", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @AfterEach()
    public void finalizar() {
        System.out.println("Fim");
    }

    @Test()
    public void reajusteDeveriaSerDe3PorcentoQuandoDesempenhoForRazoavel() {
        service.concederReajuste(funcionario, Desempenho.RAZOAVEL);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test()
    public void reajusteDeveriaSerDe15PorcentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test()
    public void reajusteDeveriaSerDe20PorcentoQuandoDesempenhoForOTIMO() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
