package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusServiceTest {

	@Test()
	void bonusDeveriaSerZeroParaFuncionarioSalarioMuitoAlto() {
		BonusService service = new BonusService();

		// assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Fulano", LocalDate.now(), new BigDecimal("25000"))));

		try {
			service.calcularBonus(new Funcionario("Fulano", LocalDate.now(), new BigDecimal("25000")));
			fail("Não deu uma exception");
		}catch (Exception e) {
			assertEquals("Funcionário com salario maior que 10 mil reais não poderá receber bônus", e.getMessage());
			System.out.println(e.getMessage());
		}

	}

	@Test()
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Fulano", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test()
	void bonusDeveriaSer10PorCentoParaSalalarioDeExatamente10Mil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Fulano", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
