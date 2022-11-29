package proxy;

import java.util.List;

public class SocioProxy implements ISocio {

  private Socio socio;

  private Integer cpf;

  public SocioProxy(Integer cpf) {
    this.cpf = cpf;
  }

  @Override
  public List<Object> getDadosPessoais() {
    if (this.socio == null) {
      this.socio = new Socio(this.cpf);
    }
    return this.socio.getDadosPessoais();
  }

  @Override
  public List<Object> getPlanoInfo(Funcionario funcionario) {
    if (!funcionario.isFinanceiroOrAdmin()) {
      throw new IllegalArgumentException("Funcionário não autorizado");
    }
    if (this.socio == null) {
      this.socio = new Socio(this.cpf);
    }
    return this.socio.getPlanoInfo(funcionario);
  }
}
