package br.edu.up;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.up.Controllers.EventoController;
import br.edu.up.Controllers.IngressoRegularController;
import br.edu.up.Controllers.IngressoVIPController;
import br.edu.up.Controllers.ParticipanteController;
import br.edu.up.Models.EventRecorder;
import br.edu.up.Models.Evento;
import br.edu.up.Models.IngressoRegular;
import br.edu.up.Models.IngressoVIP;
import br.edu.up.Models.Organizador;
import br.edu.up.Models.Participante;

public class Main {
<<<<<<< HEAD
=======
    // Lista que armazenara os eventos, ingressos, particiantes, organizadot e event recorder
>>>>>>> master
    static ArrayList<IngressoVIP> ingressosVIP = new ArrayList<>();
    static ArrayList<IngressoRegular> ingressosRegular = new ArrayList<>();
    static ArrayList<Evento> eventos = new ArrayList<>();
    static ArrayList<Participante> participantes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Organizador organizador = new Organizador(null, null);
    static EventRecorder eventRecorder = new EventRecorder();
    static EventoController eventoController = new EventoController();
    static IngressoVIPController ingressoVIPController = new IngressoVIPController();
    static IngressoRegularController ingressoRegularController = new IngressoRegularController();
    static ParticipanteController participanteController = new ParticipanteController();

    public static void main(String[] args) {
<<<<<<< HEAD

        System.out.println("===== Bem vindo ao EventManager =====");
=======
        System.out.println("===== Bem vindo ao EventManager =====");
        //puxa o metódo que solicita ao usuário as informações
>>>>>>> master

        cadastrarOrganizador(scanner, organizador);
        int opt = scanner.nextInt();
        scanner.nextLine();
        while (opt != 1) {
            cadastrarOrganizador(scanner, organizador);
            opt = scanner.nextInt();
            scanner.nextLine();
        }

        recursos();

    }
<<<<<<< HEAD

=======
    //Método de solicita ao usuário as informações de cadastro
>>>>>>> master
    private static void cadastrarOrganizador(Scanner scanner, Organizador organizador) {
        System.out.println("Qual é o seu nome?");
        String nome = scanner.nextLine();
        organizador.setNome(nome);
        System.out.println("Qual é o seu email?");
        String email = scanner.nextLine();
        organizador.setEmail(email);
        System.out.println("As informações confirmam?");
        organizador.exibirInfo();
        System.out.println("[1] - Sim");
        System.out.println("[2] - Não");
    }
<<<<<<< HEAD

    private static void recursos() {
=======
    // Menu com as opções principais do gerenciador
    private static void recursos() {
        System.out.println("===== MENU PRINCIPAL =====");
>>>>>>> master
        System.out.println("Qual recurso deseja acessar?");
        System.out.println("[1] - Evento");
        System.out.println("[2] - Ingresso");
        System.out.println("[3] - Participantes");
        System.out.println("[4] - Relatório");
        System.out.println("[0] - Sair");

        int opt = scanner.nextInt();
        scanner.nextLine();
        switch (opt) {
            case 1:
                evento();
                break;
            case 2:
                ingresso();
                break;
            case 3:
                participante();
                break;
            case 4:
                relatorio();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
<<<<<<< HEAD

    private static void evento() {
=======
    //CRUD de evento
    private static void evento() {
        System.out.println("===== MENU EVENTO =====");
>>>>>>> master
        System.out.println("[1] - Criar");
        System.out.println("[2] - Ler");
        System.out.println("[3] - Atualizar");
        System.out.println("[4] - Deletar");
        System.out.println("[5] - Voltar");

        int opt = scanner.nextInt();
        scanner.nextLine();
        switch (opt) {
            case 1:
                eventoController.criar(organizador, eventos);
                evento();
                break;
            case 2:
                eventoController.ler(eventos);
                evento();
                break;
            case 3:
                eventoController.atualizar(eventos);
                evento();
                break;
            case 4:
                eventoController.deletar(eventos);
                evento();
                break;
            case 5:
                recursos();
                break;
            default:
                System.out.println("Opção inválida");
                evento();
                break;
        }
    }
<<<<<<< HEAD

    private static void ingresso() {
=======
    // Método CRUD para ingresso
    private static void ingresso() {
        System.out.println("===== MENU INGRESSO =====");
>>>>>>> master
        System.out.println("[1] - Criar");
        System.out.println("[2] - Ler");
        System.out.println("[3] - Atualizar");
        System.out.println("[4] - Deletar");
        System.out.println("[5] - Voltar");

        int opt = scanner.nextInt();
        scanner.nextLine();
        int tipo;
        switch (opt) {
            case 1:
                tipo = tipoIngresso();
                if (tipo == 1) {
                    ingressoVIPController.criar(eventos, participantes, ingressosVIP);
                    ingresso();
                } else if (tipo == 2) {
                    ingressoRegularController.criar(eventos, participantes, ingressosRegular);
                    ingresso();
                } else {
                    System.out.println("Inválido");
                    ingresso();
                }
                break;
            case 2:
                tipo = tipoIngresso();
                if (tipo == 1) {
                    ingressoVIPController.ler(ingressosVIP);
                    ingresso();
                } else if (tipo == 2) {
                    ingressoRegularController.ler(ingressosRegular);
                    ingresso();
                } else {
                    System.out.println("Inválido");
                    ingresso();
                }
                break;
            case 3:
                tipo = tipoIngresso();
                if (tipo == 1) {
                    ingressoVIPController.atualizar(eventos, participantes, ingressosVIP);
                    ingresso();
                } else if (tipo == 2) {
                    ingressoRegularController.atualizar(eventos, participantes, ingressosRegular);
                    ingresso();
                } else {
                    System.out.println("Inválido");
                    ingresso();
                }
                break;
            case 4:
                tipo = tipoIngresso();
                if (tipo == 1) {
                    ingressoVIPController.deletarVIP(ingressosVIP);
                    ingresso();
                } else if (tipo == 2) {
                    ingressoRegularController.deletarRegular(ingressosRegular);
                    ingresso();
                } else {
                    System.out.println("Inválido");
                    ingresso();
                }
                break;
            case 5:
                recursos();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private static int tipoIngresso() {
        System.out.println("Qual tipo de ingresso deseja manipular");
        System.out.println("[1] - VIP");
        System.out.println("[2] - Regular");
        int opt = scanner.nextInt();
        scanner.nextLine();
        if (opt == 1) {
            return 1;
        } else if (opt == 2) {
            return 2;
        } else {
            System.out.println("Tipo não é valido");
            return 0;
        }
    }
<<<<<<< HEAD

    private static void participante() {
=======
    // Metodo CRUD para participante
    private static void participante() {
        System.out.println("===== MENU PARTICIPANTES =====");
>>>>>>> master
        System.out.println("[1] - Criar");
        System.out.println("[2] - Ler");
        System.out.println("[3] - Atualizar");
        System.out.println("[4] - Deletar");
        System.out.println("[5] - Voltar");

        int opt = scanner.nextInt();
        scanner.nextLine();
        switch (opt) {
            case 1:
                participanteController.criar(participantes);
                participante();
                break;
            case 2:
                participanteController.ler(participantes);
                participante();
                break;
            case 3:
                participanteController.atualizar(participantes);
                participante();
                break;
            case 4:
                participanteController.deletar(participantes);
                participante();
                break;
            case 5:
                recursos();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
<<<<<<< HEAD

    private static void relatorio() {
=======
    // Metodo que possibilita a geração de relatorios em TXT
    private static void relatorio() {
        System.out.println("===== MENU RELATORIO =====");
>>>>>>> master
        System.out.println("Qual relatório deseja gerar?");
        System.out.println("[1] - Evento");
        System.out.println("[2] - Ingresso VIP");
        System.out.println("[3] - Ingresso Regular");
        System.out.println("[4] - Participante");
        System.out.println("[5] - Voltar");
        int opt = scanner.nextInt();
        scanner.nextLine();
        switch (opt) {
            case 1:
                for (int i = 0; i < eventos.size(); i++) {
                    eventRecorder.gerarRelatorioEvento(eventos.get(i), i);
                }
                relatorio();
                break;

            case 2:
                for (int i = 0; i < ingressosVIP.size(); i++) {
                    eventRecorder.gerarRelatorioIngressoVip(ingressosVIP.get(i), i);
                }
                relatorio();
                break;

            case 3:
                for (int i = 0; i < ingressosRegular.size(); i++) {
                    eventRecorder.gerarRelatorioIngressoRegular(ingressosRegular.get(i), i);
                }
                relatorio();
                break;

            case 4:
                for (int i = 0; i < participantes.size(); i++) {
                    eventRecorder.gerarRelatorioParticipante(participantes.get(i), i);
                }
                relatorio();
                break;
            case 5:
                recursos();
                break;
            default:
                System.out.println("Escolha inválida");
                relatorio();
                break;
        }

    }
}