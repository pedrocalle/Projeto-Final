package br.edu.up.Models;

public class Ingresso {
  private double preco;
  private Evento evento;
  private Participante participante;

  public void exibirInfo() {
    System.out.println(preco);
    System.out.println(evento);
    System.out.println(participante);
  }

  public Ingresso(double preco, Evento evento, Participante participante) {
    this.preco = preco;
    this.evento = evento;
    this.participante = participante;
  }

  public double getPreco() {
    return this.preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public Evento getEvento() {
    return this.evento;
  }

  public void setEvento(Evento evento) {
    this.evento = evento;
  }

  public Participante getParticipante() {
    return this.participante;
  }

  public void setParticipante(Participante participante) {
    this.participante = participante;
  }

  public double calcularAumento() {
    return 0.0;
  }

  @Override
  public String toString() {
    return "{" +
        ", preco='" + preco + "'" +
        ", evento='" + evento + "'" +
        ", participante='" + participante + "'" +
        "}";
  }

}