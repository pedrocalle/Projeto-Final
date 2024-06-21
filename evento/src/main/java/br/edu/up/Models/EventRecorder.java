package br.edu.up.Models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

interface Resources {
    void gerarRelatorioIngressoVip(IngressoVIP ingressoVIP);
    void gerarRelatorioIngressoRegular(IngressoRegular ingressoRegular);
    void gerarRelatorioEvento(Evento evento);
    void gerarRelatorioParticipante(Participante participante);
}

public class EventRecorder implements Resources {

  @Override
  public void gerarRelatorioIngressoVip(IngressoVIP ingressoVIP) {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("ingressoVip.txt"))) {
          writer.write(ingressoVIP.toString());
          System.out.println("Relatório de Ingresso VIP criado");
      } catch (IOException e) {
          System.err.println("Erro ao criar relatório de Ingresso VIP");
          e.printStackTrace();
      }
  }

  @Override
  public void gerarRelatorioIngressoRegular(IngressoRegular ingressoRegular) {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("ingressoRegular.txt"))) {
          writer.write(ingressoRegular.toString());
          System.out.println("Relatório de Ingresso Regular criado");
      } catch (IOException e) {
          System.err.println("Erro ao criar relatório de Ingresso Regular");
          e.printStackTrace();
      }
  }

  @Override
  public void gerarRelatorioEvento(Evento evento) {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("evento.txt"))) {
          writer.write(evento.toString());
          System.out.println("Relatório de Evento criado");
      } catch (IOException e) {
          System.err.println("Erro ao criar relatório de Evento");
          e.printStackTrace();
      }
  }

  @Override
  public void gerarRelatorioParticipante(Participante participante) {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("participante.txt"))) {
          writer.write(participante.toString());
          System.out.println("Relatório de Participante criado");
      } catch (IOException e) {
          System.err.println("Erro ao criar relatório de Participante");
          e.printStackTrace();
      }
  }
}