package br.edu.up.Models;

public class Organizador extends Pessoa {
  private String email;

  public Organizador(String nome, String email) {
    super.nome = nome;
    email = this.email;
  }
  // Método para ixibir as informações do Organizador
  public void exibirInfo() {
    System.out.println(nome); // Cria um nome
    System.out.println(email);// Cria um email
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
        ", nome='" + getNome() + "'" +
        ", email='" + getEmail() + "'" +
        "}";
  }

}
