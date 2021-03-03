import java.util.Arrays;

import modelo.*;
class App {
  public static void main(String[] args) {
    Dinheiro d1 = new Dinheiro(2, 30);
    Dinheiro d2 = new Dinheiro(5, 80);
    d1.somar(d2);
    System.out.println(d1.getReais() == 8);
    System.out.println(d1.getCentavos() == 10);

    Dinheiro bufunfa = new Dinheiro(1, 1);
    bufunfa.imprimir(); // R$ 1,01
    Dinheiro d3 = new Dinheiro(3, 45);
    System.out.println(d3.getReais() == 3);
    System.out.println(d3.getCentavos() == 45);
    
    Dinheiro d4 = new Dinheiro(200);
    System.out.println(d4.getReais() == 200);
    System.out.println(d4.getCentavos() == 0);
    
    Dinheiro d5 = new Dinheiro("R$ 345,75");
    System.out.println(d5.getReais() == 345);
    System.out.println(d5.getCentavos() == 75);
    
    Dinheiro d6 = new Dinheiro("R$ 1000000,11");
    System.out.println(d6.getReais() == 1000000);
    System.out.println(d6.getCentavos() == 11);
    
    Dinheiro d7 = new Dinheiro("R$ 2567,89");
    System.out.println(d7.getReais() == 2567);
    System.out.println(d7.getCentavos() == 89);
    
    Dinheiro d8 = new Dinheiro(9.75);
    System.out.println(d8.getReais() == 9);
    System.out.println(d8.getCentavos() == 75);
    
    Dinheiro d9 = new Dinheiro(17.569); // é truncado nas duas casas, não arredondado!
    System.out.println(d9.getReais() == 17);
    System.out.println(d9.getCentavos() == 56);
    
    d3.somar(d4);
    System.out.println(d3.getReais() == 203);
    System.out.println(d3.getCentavos() == 45);
    
    d5.somar(100);
    System.out.println(d5.getReais() == 445);
    System.out.println(d5.getCentavos() == 75);
    
    d6.somar(1.90);
    System.out.println(d6.getReais() == 1000002);
    System.out.println(d6.getCentavos() == 01);
    
    // d7.somar("R$ 998871,86986"); // PATCH
    d7.somar("R$ 998817,86986");
    System.out.println(d7.getReais() == 1001385);
    System.out.println(d7.getCentavos() == 75);

    d8 = new Dinheiro(8, 98);
    d9 = new Dinheiro(8, 99);
    Dinheiro d10 = null;
    Dinheiro d11 = new Dinheiro(8, 98);
    Dinheiro d12 = d8;
    System.out.println(d8);
    System.out.println(d12);
    System.out.println(d8.equals(d9) == false);
    System.out.println(d8.equals(d10) == false);
    System.out.println(d8.equals(d11) == true);
    System.out.println(d8.equals(d12) == true);

    System.out.println(new Dinheiro(3.43).equals(new Dinheiro(3, 43)));
    System.out.println(new Dinheiro("R$ 8,97").equals(new Dinheiro(8, 97)));
    System.out.println(!new Dinheiro("R$ 5,43").equals(null));

    d12 = new Dinheiro(4, 30);
    Dinheiro d13 = new Dinheiro(987, 14);
    Dinheiro d14 = new Dinheiro(0, 1);
    Dinheiro d15 = new Dinheiro(17, 9);
    Dinheiro d16 = new Dinheiro(4, 30);

    // Todas estas assertivas devem imprimir true
    System.out.println(d12.compareTo(d13) < 0);
    System.out.println(d12.compareTo(d14) > 0);
    System.out.println(d12.compareTo(d15) < 0);
    System.out.println(d12.compareTo(d16) == 0);

    Comparable d17 = new Dinheiro(8);
    Comparable d18 = new Dinheiro(9);
    Comparable d19 = new Dinheiro(8);
    System.out.println(d17.compareTo(d18) < 0);
    System.out.println(d17.compareTo(d19) == 0);
    System.out.println(d18.compareTo(d17) > 0);

    Dinheiro[] dindin = { d12, d13, d14, d15, d16 };

    // Classifique em ordem crescente através de java.util.Arrays
    Arrays.sort(dindin);

    System.out.println(dindin[0].equals(d14));
    System.out.println(dindin[1].equals(d12));
    System.out.println(dindin[2].equals(d12));
    System.out.println(dindin[3].equals(d15));
    System.out.println(dindin[4].equals(d13));


    // DATA

    Data data1 = new Data(1, 2, 2010);
    Data data2 = new Data("01/02/2010");
    Data data3 = new Data();
    Data data4 = new Data(4, 2, 2010);
    Data data5 = new Data("5/02/2010");
    Data data6 = new Data("31/01/2010");
    try {
      data3 = new Data("1/2/2010");
    } catch (Exception e) {
      System.err.println("true " + e.getMessage());
    }
    System.out.println(data1.equals(data2) == true);
    System.out.println(data1.equals(data3) == true);
    System.out.println(data2.equals(data3) == true);
    System.out.println(data1.compareTo(data2) == 0);
    System.out.println(data1.compareTo(data3) == 0);
    System.out.println(data2.compareTo(data3) == 0);
    System.out.println(data2.equals(data4) == false);
    System.out.println(data1.compareTo(data5) < 0);
    System.out.println(data1.compareTo(data6) > 0);
    data1.setDia(2);
    System.out.println(data1.equals(data2) == false);


    // VEICULO
    Veiculo carro1 = new Veiculo("placa", "marca", "modelo", 150);
    Veiculo carro2 = new Veiculo("placa2", "marca", "modelo", 150);
    Veiculo carro3 = new Veiculo("plasfsca", "madfdfrca", "msfsodelo", 150);
    Veiculo carro4 = carro1;

    System.out.println(carro1.equals(carro2) == true);
    System.out.println(carro1.equals(carro3) == false);
    System.out.println(carro1.equals(carro4) == true);
  }
}
