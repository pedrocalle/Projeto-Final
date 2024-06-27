package br.edu.up.Controllers;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.up.Models.Evento;
import br.edu.up.Models.IngressoRegular;
import br.edu.up.Models.Participante;

public class IngressoRegularController {
  static Scanner scanner = new Scanner(System.in);
  static EventoController eventoController = new EventoController();
  static ParticipanteController participanteController = new ParticipanteController();

  // Criamos um ingresso reguar dentro de um objeto participante e evento
  public void criar(ArrayList<Evento> eventos, ArrayList<Participante> participantes,
      ArrayList<IngressoRegular> ingressosRegular) {
    boolean continuar = true;

    while (continuar) {
      System.out.println("Digite o preço do ingresso: ");
      double preco = scanner.nextDouble();

      eventoController.ler(eventos);
      System.out.println("Digite o ID do evento do ingresso: ");
      int idEvento = scanner.nextInt();
      Evento evento = new Evento(null, null, null);

      for (int i = 0; i < eventos.size(); i++) {
        if (eventos.get(i).getId() == idEvento) {
          evento = eventos.get(i);
        }
      }

      participanteController.ler(participantes);
      System.out.println("Digite o ID do participante do evento: ");
      int idParticipante = scanner.nextInt();
      Participante participante = new Participante(null, null, null);

      for (int i = 0; i < participantes.size(); i++) {
        if (participantes.get(i).getId() == idParticipante) {
          participante = participantes.get(i);
        }
      }

      IngressoRegular novoIngressoRegular = new IngressoRegular(preco, evento, participante);
      novoIngressoRegular.calcularAumento();
      ingressosRegular.add(novoIngressoRegular);

      System.out.println("Deseja criar mais um participante? (s/n): ");
      String resposta = scanner.nextLine();

      if (!resposta.equalsIgnoreCase("s")) {
        continuar = false;
      }
    }
  }

  public void ler(ArrayList<IngressoRegular> ingressosRegular) {
    if (ingressosRegular.size() == 0) {
      System.out.println("Lista vazia!");
    } else {
      for (int i = 0; i < ingressosRegular.size(); i++) {
        ingressosRegular.get(i).exibirInfo();
      }
    }
  }

  public void atualizar(ArrayList<Evento> eventos, ArrayList<Participante> participantes,
      ArrayList<IngressoRegular> ingressosRegular) {
    this.ler(ingressosRegular);
    System.out.println("Digite o ID do ingresso Regular que deseja atualizar: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    for (int i = 0; i < ingressosRegular.size(); i++) {
      IngressoRegular ingressoRegular = ingressosRegular.get(i);
      if (ingressoRegular.getId() == id) {
        System.out.println("Digite o novo preço do ingresso: ");
        double preco = scanner.nextDouble();
        ingressoRegular.setPreco(preco);
        ingressoRegular.calcularAumento();
        eventoController.ler(eventos);
        System.out.println("Digite o ID do novo evento do ingresso: ");
        int idEvento = scanner.nextInt();
        Evento evento = new Evento(null, null, null);

        for (int j = 0; j < eventos.size(); j++) {
          if (eventos.get(i).getId() == idEvento) {
            evento = eventos.get(i);
            ingressoRegular.setEvento(evento);
          }
        }

        participanteController.ler(participantes);
        System.out.println("Digite o ID do novo participante do evento: ");
        int idParticipante = scanner.nextInt();
        Participante participante = new Participante(null, null, null);

        for (int j = 0; j < participantes.size(); j++) {
          if (participantes.get(i).getId() == idParticipante) {
            participante = participantes.get(i);
            ingressoRegular.setParticipante(participante);
          }
        }
      }
    }
  }

  public void deletarRegular(ArrayList<IngressoRegular> ingressosRegular) {
    this.ler(ingressosRegular);
    System.out.println("Digite o ID do ingresso Regular que deseja deletar: ");
    int id = scanner.nextInt();
    for (int i = 0; i < ingressosRegular.size(); i++) {
      IngressoRegular ingressoRegular = ingressosRegular.get(i);
      if (ingressoRegular.getId() == id) {
        ingressosRegular.remove(i);
      } else {
        System.out.println("Ingresso não encontrado");
      }
    }
  }
}