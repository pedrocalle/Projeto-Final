package br.edu.up.Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.up.Models.Evento;
import br.edu.up.Models.Organizador;

public class EventoController {
  static Scanner scanner = new Scanner(System.in);

  public void criar(Organizador organizador, ArrayList<Evento> eventos) {
    // Cria um objeto com o padrão dd/MM/yyyy para formatar e analisar datas.
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    boolean continuar = true;

    while (continuar) {
      System.out.println("Digite o nome do evento: ");
      String nome = scanner.nextLine();

      System.out.println("Digite a data do evento (dd/mm/yyyy): ");
      String data = scanner.nextLine();

      // Cria um novo objeto Evento com o nome fornecido, a data analisada usando o
      // formatter,
      // e o organizador. Aqui, LocalDate.parse(data, formatter) converte a string
      // data em um
      // objeto LocalDate usando o formato especificado.

      Evento novoEvento = new Evento(nome, LocalDate.parse(data, formatter), organizador);
      eventos.add(novoEvento);

      System.out.println("Deseja criar mais um evento? (s/n): ");
      String resposta = scanner.nextLine();

      if (!resposta.equalsIgnoreCase("s")) {
        continuar = false;
      }

    }
  }

  // Método para exibir todos os eventos cadastrados
  public void ler(ArrayList<Evento> eventos) {
    if (eventos.size() == 0) {
      System.out.println("Lista vazia!");
    } else {
      for (int i = 0; i < eventos.size(); i++) {
        eventos.get(i).exibirInfo();
      }
    }
  }

  // Metodo que modifica alguma informação
  public void atualizar(ArrayList<Evento> eventos) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    this.ler(eventos);
    System.out.println("Digite o ID do evento que deseja atualizar: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    for (int i = 0; i < eventos.size(); i++) {
      Evento evento = eventos.get(i);
      if (evento.getId() == id) {
        System.out.println("Digite o novo nome: ");
        String novoNome = scanner.nextLine();
        evento.setNome(novoNome);
        System.out.println("Digite a nova data: ");
        String novaData = scanner.nextLine();
        evento.setData(LocalDate.parse(novaData, formatter));
      }
    }
  }

  // Metodo que deleta algum evento
  public void deletar(ArrayList<Evento> eventos) {
    System.out.println("Digite o ID do evento que deseja deletar: ");
    int id = scanner.nextInt();
    for (int i = 0; i < eventos.size(); i++) {
      Evento evento = eventos.get(i);
      if (evento.getId() == id) {
        eventos.remove(i);
      } else {
        System.out.println("Evento não encontrado");
      }
    }
  }
}