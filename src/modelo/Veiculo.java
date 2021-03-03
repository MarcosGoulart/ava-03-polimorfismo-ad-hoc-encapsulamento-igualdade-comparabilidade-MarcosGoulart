package modelo;

public class Veiculo {
  final String placa, marca, modelo;
  final int    cilindrada;

  public Veiculo(String placa, String marca, String modelo, int cilindrada) {
    this.placa = placa; this.marca = marca; this.modelo = modelo;
    this.cilindrada = cilindrada;
  }

  @Override
  public boolean equals(Object veiculo) {
    if (this == veiculo)
      return true;
    if (veiculo instanceof Veiculo) {
      Veiculo novoVeiculo = (Veiculo) veiculo;
      if (this.marca == novoVeiculo.marca && this.modelo == novoVeiculo.modelo && this.cilindrada == novoVeiculo.cilindrada)
        return true;
    }
    return false;
  }

}
