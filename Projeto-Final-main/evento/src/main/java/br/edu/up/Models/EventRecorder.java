package br.edu.up.Models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

interface Resources {
    void gerarRelatorioIngressoVip(IngressoVIP ingressoVIP, int i);

    void gerarRelatorioIngressoRegular(IngressoRegular ingressoRegular, int i);

    void gerarRelatorioEvento(Evento evento, int i);

    void gerarRelatorioParticipante(Participante participante, int i);
}

public class EventRecorder implements Resources {

    @Override
    public void gerarRelatorioIngressoVip(IngressoVIP ingressoVIP, int i) {
        String formattedString = String.format("ingressoVIP%d.txt", i);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(formattedString))) {
            writer.write(ingressoVIP.toString());
            System.out.println("Relatório de Ingresso VIP criado");
        } catch (IOException e) {
            System.err.println("Erro ao criar relatório de Ingresso VIP");
            e.printStackTrace();
        }
    }

    @Override
    public void gerarRelatorioIngressoRegular(IngressoRegular ingressoRegular, int i) {
        String formattedString = String.format("ingressoRegular%d.txt", i);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(formattedString))) {
            writer.write(ingressoRegular.toString());
            System.out.println("Relatório de Ingresso Regular criado");
        } catch (IOException e) {
            System.err.println("Erro ao criar relatório de Ingresso Regular");
            e.printStackTrace();
        }
    }

    @Override
    public void gerarRelatorioEvento(Evento evento, int i) {
        String formattedString = String.format("evento%d.txt", i);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(formattedString))) {
            writer.write(evento.toString());
            System.out.println("Relatório de Evento criado");
        } catch (IOException e) {
            System.err.println("Erro ao criar relatório de Evento");
            e.printStackTrace();
        }
    }

    @Override
    public void gerarRelatorioParticipante(Participante participante, int i) {
        String formattedString = String.format("participante%d.txt", i);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(formattedString))) {
            writer.write(participante.toString());
            System.out.println("Relatório de Participante criado");
        } catch (IOException e) {
            System.err.println("Erro ao criar relatório de Participante");
            e.printStackTrace();
        }
    }
}