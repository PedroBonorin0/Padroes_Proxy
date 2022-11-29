package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import proxy.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SocioProxyTest {

  @BeforeEach
  void setUp() {
    BD.addPlano(new Plano("Básico", 20f));
    BD.addPlano(new Plano("Premium", 50f));
    BD.addSocio(new Socio(123, "Pedro", BD.getPlano("Básico"), "Teresópolis"));
    BD.addSocio(new Socio(999, "Gilberto", BD.getPlano("Premium"), "Rio de Janeiro"));
  }

  @Test
  void deveRetornarDadosPessoaisSocio() {
    SocioProxy socio = new SocioProxy(123);

    assertEquals(Arrays.asList("Pedro", "Teresópolis"), socio.getDadosPessoais());
  }

  @Test
  void deveRetonarPlanoFinanceiro() {
    Funcionario funcionario = new Funcionario("Maria", "Financeiro");
    SocioProxy socio = new SocioProxy(123);

    assertEquals(Arrays.asList("Básico", 20f), socio.getPlanoInfo(funcionario));
  }

  @Test
  void deveRetonarPlanoAdmin() {
    Funcionario funcionario = new Funcionario("Maria", "Admin");
    SocioProxy socio = new SocioProxy(999);

    assertEquals(Arrays.asList("Premium", 50f), socio.getPlanoInfo(funcionario));
  }

  @Test
  void deveGerarExcecaoParaNaoAutorizado() {
    try {
      Funcionario funcionario = new Funcionario("Maria", "Marketing");
      SocioProxy socio = new SocioProxy(123);

      socio.getPlanoInfo(funcionario);
      fail();
    }
    catch (IllegalArgumentException e) {
      assertEquals("Funcionário não autorizado", e.getMessage());
    }
  }
}