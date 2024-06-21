package br.edu.up.Models;

public class IngressoVIP extends Ingresso {
  private int id;
  private static int contadorId = 0;

  public IngressoVIP(double preco, Evento evento, Participante participante) {
    super(preco, evento, participante);
    this.id = ++contadorId;
  } 
  
  public int getId() {
    return this.id;
  }
  
  public void setId(int id) {
    this.id = id;
  }

  @Override
  public double calcularAumento() {
    double newPreco = getPreco() * 4;
    setPreco(newPreco);
    return newPreco;
  }


  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      "}";
  }

}
