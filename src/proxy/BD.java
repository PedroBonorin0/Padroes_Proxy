package proxy;

import java.util.HashMap;
import java.util.Map;

public class BD {
  private static Map<Integer, Socio> socios = new HashMap<>();
  private static Map<String, Plano> planos = new HashMap<>();

  public static Socio getSocio(Integer cpf) {
    return socios.get(cpf);
  }

  public static void addSocio(Socio socio) {
    socios.put(socio.getCpf(), socio);
  }

  public static Plano getPlano(String nome) {
    return planos.get(nome);
  }

  public static void addPlano(Plano plano) {
    planos.put(plano.getNome(), plano);
  }
}
