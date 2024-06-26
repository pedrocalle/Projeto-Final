package br.edu.up.Models;

public class IngressoRegular extends Ingresso {
  private int id;
  private static int contadorId = 0;

  public IngressoRegular(double preco, Evento evento, Participante participante) {
    super(preco, evento, participante);
    this.id = ++contadorId;
<<<<<<< HEAD
=======
    //incrementador de ID

>>>>>>> master
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
<<<<<<< HEAD
=======
  // Método para calcular o aumento do preço (atualmente retorna 0.0)
  // Ingresso relugar *2
>>>>>>> master
  public double calcularAumento() {
    double newPreco = getPreco() * 2;
    setPreco(newPreco);
    return newPreco;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", preco='" + getPreco() + "'" +
        ", evento='" + getEvento() + "'" +
        ", participante='" + getParticipante() + "'" +
        "}";
  }

}
