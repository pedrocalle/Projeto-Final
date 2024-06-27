package br.edu.up.Controllers;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.up.Models.Participante;

public class ParticipanteController {
  static Scanner scanner = new Scanner(System.in);

  public void criar(ArrayList<Participante> participantes) {
    boolean continuar = true;

    while (continuar) {
      System.out.println("Digite o nome do participante: ");
      String nome = scanner.nextLine();

      System.out.println("Digite o email do participante: ");
      String email = scanner.nextLine();

      System.out.println("Digite o telefone do participante: ");
      String telefone = scanner.nextLine();

      Participante novoParticipante = new Participante(nome, email, telefone);
      participantes.add(novoParticipante);

      System.out.println("Deseja criar mais um participante? (s/n): ");
      String resposta = scanner.nextLine();

      if (!resposta.equalsIgnoreCase("s")) {
        continuar = false;
      }
    }
  }

  public void ler(ArrayList<Participante> participantes) {
    if (participantes.size() == 0) {
      System.out.println("Lista vazia!");
    } else {
      for (int i = 0; i < participantes.size(); i++) {
        participantes.get(i).exibirInfo();
      }
    }
  }

  public void atualizar(ArrayList<Participante> participantes) {
    this.ler(participantes);
    System.out.println("Digite o ID do participante que deseja atualizar: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    for (int i = 0; i < participantes.size(); i++) {
      Participante participante = participantes.get(i);
      if (participante.getId() == id) {
        System.out.println("Digite o novo nome: ");
        String novoNome = scanner.nextLine();
        participante.setNome(novoNome);
        System.out.println("Digite o novo email: ");
        String novoEmail = scanner.nextLine();
        participante.setEmail(novoEmail);
        System.out.println("Digite o novo telefone: ");
        String novoTelefone = scanner.nextLine();
        participante.setTelefone(novoTelefone);
      }
    }
  }

  public void deletar(ArrayList<Participante> participantes) {
    System.out.println("Digite o ID do participante que deseja deletar: ");
    int id = scanner.nextInt();
    for (int i = 0; i < participantes.size(); i++) {
      Participante participante = participantes.get(i);
      if (participante.getId() == id) {
        participantes.remove(i);
      } else {
        System.out.println("Participante não encontrado");
      }
    }
  }
}