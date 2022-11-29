package proxy;

import proxy.ISocio;

import java.util.Arrays;
import java.util.List;

public class Socio implements ISocio {

  private Integer cpf;
  private String nome;
  private String cidade;
  private Plano plano;

  public Socio(Integer cpf) {
    this.cpf = cpf;
    Socio obj = BD.getSocio(cpf);
    this.nome = obj.nome;
    this.cidade = obj.cidade;
    this.plano = obj.plano;
  }

  public Socio(Integer cpf, String nome, Plano plano, String cidade) {
    this.cpf = cpf;
    this.nome = nome;
    this.plano = plano;
    this.cidade = cidade;
  }

  public Integer getCpf() {
    return cpf;
  }

  @Override
  public List<Object> getDadosPessoais() {
    return Arrays.asList(this.nome, this.cidade);
  }

  @Override
  public List<Object> getPlanoInfo(Funcionario funcionario) {
    return Arrays.asList(this.plano.nome, this.plano.valor);
  }
}
