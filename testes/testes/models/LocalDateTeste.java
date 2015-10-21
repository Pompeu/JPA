package testes.models;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class LocalDateTeste {

	@Test
	public void data_formater_dia_mes_ano() {

		Funcionario fun = new Funcionario(LocalDate.of(2015, 8, 2));
		DateTimeFormatter ofPattern = DateTimeFormatter
				.ofPattern("dd/MMMM/yyyy");
		System.out.println(fun.getAdmissao().format(ofPattern));

		ofPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(fun.getAdmissao().format(ofPattern));

		ofPattern = DateTimeFormatter.ofPattern("dd/MM/yy");
		System.out.println(fun.getAdmissao().format(ofPattern));

		ofPattern = DateTimeFormatter.ofPattern("dd/MM");
		System.out.println(fun.getAdmissao().format(ofPattern));

		ofPattern = DateTimeFormatter.ofPattern("dd");
		System.out.println(fun.getAdmissao().format(ofPattern));

	}

	
}

interface Id {
	Integer getId();
}

class Funcionario implements Id {
	private Integer id;
	private LocalDate admissao;

	public Funcionario(LocalDate admissao) {
		this.admissao = admissao;

	}

	public Funcionario(int id, LocalDate of) {
		this.id = id;
		admissao = of;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public LocalDate getAdmissao() {
		return admissao;
	}

}