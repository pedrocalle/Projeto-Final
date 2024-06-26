package br.edu.up.Models;

import java.time.LocalDate;

public class Evento {
  private int id;
  String nome;
  LocalDate data;
  Organizador organizador;
  private static int contadorId = 0;

  public Evento(String nome, LocalDate data, Organizador organizador) {
    this.id = ++contadorId;
    this.nome = nome;
    this.data = data;
    this.organizador = organizador;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getData() {
    return this.data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public Organizador getOrganizador() {
    return this.organizador;
  }

  public void setOrganizador(Organizador organizador) {
    this.organizador = organizador;
  }

  public void exibirInfo() {
    System.out.println("id: " + id);
    System.out.println("nome: " + nome);
    System.out.println("data: " + data);
    System.out.println("organizador: " + organizador);
    System.out.println("-----------------------");
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", nome='" + getNome() + "'" +
        ", data='" + getData() + "'" +
        ", organizador='" + getOrganizador() + "'" +
        "}";
  }

}
