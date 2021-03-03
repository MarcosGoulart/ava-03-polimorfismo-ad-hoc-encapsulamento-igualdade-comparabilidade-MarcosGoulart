package modelo;

public class Dinheiro implements Comparable {

  private int centavos;

  public Dinheiro(int reais, int centavos) {
    while(centavos > 99){
      centavos /= 10;
    }
    this.centavos = reais * 100 + centavos;
  }

  public Dinheiro(int reais) {
    this.centavos = reais * 100;
  }

  public Dinheiro(String dinheiro) { // O ERRO TA AQUI SEU ZÉ RUELA DO FUTURO
    String[] split1 = dinheiro.split(" ");
    String[] split2 = split1[1].split(",");
    int reais = Integer.parseInt(split2[0]);
    String centavosString = String.valueOf(split2[1].charAt(0)) + String.valueOf(split2[1].charAt(1));
    int centavosInt = Integer.parseInt(centavosString);
    this.centavos = reais * 100 + centavosInt;
  }

  public Dinheiro(double dinheiro) {
    this.centavos = (int)(dinheiro * 100);
  }

public int getReais() {
    return this.centavos / 100;
  }

  public int getCentavos() {
    return this.centavos % 100;
  }

  public void somar(Dinheiro dinheiro) {
    this.centavos += dinheiro.centavos;
  }

  public void imprimir() { // Não é ilegal imprimir Dinheiro?
    System.out.println(
      String.format("R$ %d,%02d", this.getReais(), this.getCentavos())
    );
  }

  public void somar(int reais) {
    this.centavos += reais * 100;
  }

  public void somar(double dinheiro) {
    this.centavos += (int)(dinheiro * 100);
  }

  public void somar(String dinheiro) {
    String[] split1 = dinheiro.split(" ");
    String[] split2 = split1[1].split(",");
    int reais = Integer.parseInt(split2[0]);
    String centavosString = String.valueOf(split2[1].charAt(0)) + String.valueOf(split2[1].charAt(1));
    int centavosInt = Integer.parseInt(centavosString);
    this.centavos = reais * 100 + centavosInt;
  }

  @Override
  public boolean equals(Object dinheiro) {
    if (this == dinheiro) return true;
    if(dinheiro instanceof Dinheiro){
      Dinheiro novoDinheiro = (Dinheiro) dinheiro;
      if(this.centavos == novoDinheiro.centavos) return true;
    }
    return false;

  }

  @Override
  public int compareTo(Object dinheiro) {
    // TODO Auto-generated method stub
    Dinheiro novoDinheiro = (Dinheiro) dinheiro;
    return this.centavos - novoDinheiro.centavos;
  }
}
