package br.edu.up.Models;

public abstract class Pessoa {
  public int id;
  public String nome;

  public void exibirInfo() {
    System.out.println(id);
    System.out.println(nome);
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

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", nome='" + getNome() + "'" +
        "}";
  }

}