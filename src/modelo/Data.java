package modelo;

public class Data implements Comparable{
  private int dia, mes, ano;

  public Data(){}

  public Data(int dia, int mes, int ano){
    this.validar(dia, mes, ano);
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }
  
  public Data(String data) {
    if(!(data.matches("([0-9]{1,2})/([0-9]{1,2})/([0-9]{1,4})")))throw new IllegalStateException("Data em formato de texto inválida.");
    String[] dataSplit = data.split("/");
    int dia = Integer.parseInt(dataSplit[0]), mes = Integer.parseInt(dataSplit[1]), ano = Integer.parseInt(dataSplit[2]);
    this.validar(dia, mes, ano);
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }

  public void validar(int dia, int mes, int ano){
    boolean bissexto = false;
    if (ano % 4 == 0 && ano % 100 != 0) bissexto = true;
    else if (ano % 400 == 0) bissexto = true;
    if (mes < 1 || mes > 12) throw new IllegalStateException("Mês é inválido.");
    if ((mes == 1 && (dia < 1 || dia > 31)) || (mes == 3 && (dia < 1 || dia > 31)) || (mes == 4 && (dia < 1 || dia > 30))
      || (mes == 5 && (dia < 1 || dia > 31)) || (mes == 6 && (dia < 1 || dia > 30)) || (mes == 7 && (dia < 1 || dia > 31))
      || (mes == 8 && (dia < 1 || dia > 31)) || (mes == 9 && (dia < 1 || dia > 30)) || (mes == 10 && (dia < 1 || dia > 31))
      || (mes == 11 && (dia < 1 || dia > 30)) || (mes == 12 && (dia < 1 || dia > 31)))throw new IllegalStateException("Dia é inválido.");
    if (bissexto) if (mes == 2 && dia < 1 || dia > 29) throw new IllegalStateException("Dia é inválido.");
    else if (mes == 2 && dia < 1 || dia > 28) throw new IllegalStateException("Dia é inválido.");
  }

  @Override
  public boolean equals(Object data) {
    if (this == data)
      return true;
    if (data instanceof Data) {
      Data novaData = (Data) data;
      if (this.dia == novaData.dia && this.mes == novaData.mes && this.ano == novaData.ano)
        return true;
    }
    return false;
  }

  @Override
  public int compareTo(Object data) {
    Data novaData = (Data) data;
    if(this.ano - novaData.ano != 0) return this.ano - novaData.ano;
    if (this.mes - novaData.mes != 0) return this.mes - novaData.mes;
    if (this.dia - novaData.dia != 0) return this.dia - novaData.dia;
    return 0;
  }
}
