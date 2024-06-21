package br.edu.up.Models;

public class Organizador extends Pessoa {
  private String email;

  public Organizador(String nome, String email) {
    super.nome = nome;
    email = this.email;
  }

  public void exibirInfo() {
    System.out.println(id);
    System.out.println(nome);
    System.out.println(email);
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "{" +
      " email='" + getEmail() + "'" +
      "}";
  }



}
