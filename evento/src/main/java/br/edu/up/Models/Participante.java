package br.edu.up.Models;

public class Participante extends Pessoa {
  String email;
  String telefone;
  private static int contadorId = 0;

  public Participante(String nome, String email, String telefone) {
<<<<<<< HEAD
    super.id = ++contadorId;
    super.nome = nome;
=======
    // Atribui um ID único para o participante
    super.id = ++contadorId;
    super.nome = nome;
    // Inicia o atributo nome da classe pai (Pessoa)
>>>>>>> master
    this.email = email;
    this.telefone = telefone;
  }

  public void exibirInfo() {
    System.out.println("id: " + id);
    System.out.println("nome: " + nome);
    System.out.println("email: " + email);
    System.out.println("telefone: " + telefone);
    System.out.println("-----------------------");
    ;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefone() {
    return this.telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", nome='" + getNome() + "'" +
        ", email='" + getEmail() + "'" +
        ", telefone='" + getTelefone() + "'" +
        "}";
  }

}
