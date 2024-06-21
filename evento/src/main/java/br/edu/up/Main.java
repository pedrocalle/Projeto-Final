package br.edu.up;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.Models.EventRecorder;
import br.edu.up.Models.Evento;
import br.edu.up.Models.IngressoRegular;
import br.edu.up.Models.IngressoVIP;
import br.edu.up.Models.Organizador;
import br.edu.up.Models.Participante;

public class Main {
    static List<IngressoVIP> ingressosVIP = new ArrayList<>();
    static List<IngressoRegular> ingressosRegular = new ArrayList<>();
    static List<Evento> eventos = new ArrayList<>();
    static List<Participante> participantes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Organizador organizador = new Organizador( null, null);
    static EventRecorder eventRecorder = new EventRecorder();
    public static void main(String[] args) {
        

        System.out.println("===== Bem vindo ao EventManager =====");

        cadastrarOrganizador(scanner, organizador);
        int opt = scanner.nextInt();
        scanner.nextLine();
        while(opt != 1) {
            cadastrarOrganizador(scanner, organizador);
            opt = scanner.nextInt();
            scanner.nextLine();
        }

        recursos();

    }

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

    private static void recursos() {
        System.out.println("Qual recurso deseja acessar?");
        System.out.println("[1] - Evento");
        System.out.println("[2] - Ingresso");
        System.out.println("[3] - Participantes");
        System.out.println("[4] - Relatório");

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
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private static void evento() {
        System.out.println("[1] - Criar");
        System.out.println("[2] - Ler");
        System.out.println("[3] - Atualizar");
        System.out.println("[4] - Deletar");
        System.out.println("[5] - Voltar");

        int opt = scanner.nextInt();
        scanner.nextLine();
        switch (opt) {
            case 1:
                adicionarEvento();
                evento();
                break;
            case 2:
                lerEvento();
                evento();
                break;
            case 3:
                atualizarEvento();
                evento();
                break;
            case 4:
                deletarEvento();
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

    private static void adicionarEvento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        boolean continuar = true;

        while (continuar) {
            System.out.println("Digite o nome do evento: ");
            String nome = scanner.nextLine();

            System.out.println("Digite a data do evento (dd/mm/yyyy): ");
            String data = scanner.nextLine();

            Evento novoEvento = new Evento(nome, LocalDate.parse(data, formatter), organizador);
            eventos.add(novoEvento);

            System.out.println("Deseja criar mais um evento? (s/n): ");
            String resposta = scanner.nextLine();

            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }

        }
    }

    private static void lerEvento() {
        if (eventos.size() == 0) {
            System.out.println("Lista vazia!");
        } else {
        for (int i = 0; i < eventos.size(); i++) {
            eventos.get(i).exibirInfo();
        }
    }
    }

    private static void atualizarEvento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        lerEvento();
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
    

    private static void deletarEvento() {
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

    private static void ingresso() {
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
                    adicionarVIP();
                    ingresso();
                } else if (tipo == 2) {
                    adicionarRegular();
                    ingresso();
                } else {
                    System.out.println("Inválido");
                    ingresso();
                }
                break;
            case 2:
                 tipo = tipoIngresso();
                if (tipo == 1) {
                    lerVIP();
                    ingresso();
                } else if (tipo == 2) {
                    lerRegular();
                    ingresso();
                } else {
                    System.out.println("Inválido");
                    ingresso();
                }
                break;
            case 3:
            tipo = tipoIngresso();
            if (tipo == 1) {
                atualizarVIP();
                ingresso();
            } else if (tipo == 2) {
                atualizarRegular();
                ingresso();
            } else {
                System.out.println("Inválido");
                ingresso();
            }
                break;
            case 4:
            tipo = tipoIngresso();
            if (tipo == 1) {
                deletarVIP();
                ingresso();
            } else if (tipo == 2) {
                deletarRegular();
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

    private static void adicionarVIP() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Digite o preço do ingresso: ");
            double preco = scanner.nextDouble();

            lerEvento();
            System.out.println("Digite o ID do evento do ingresso: ");
            int idEvento = scanner.nextInt();
            Evento evento = new Evento(null, null, null);
 
            for (int i = 0; i < eventos.size(); i++) {
                if (eventos.get(i).getId() == idEvento) {
                    evento = eventos.get(i);
                }
            }

            lerParticipante();
            System.out.println("Digite o ID do participante do evento: ");
            int idParticipante = scanner.nextInt();
            Participante participante = new Participante(null, null, null);
 
            for (int i = 0; i < participantes.size(); i++) {
                if (participantes.get(i).getId() == idParticipante) {
                    participante = participantes.get(i);
                }
            }

            IngressoVIP novoIngressoVIP = new IngressoVIP(preco, evento, participante);
            novoIngressoVIP.calcularAumento();
            ingressosVIP.add(novoIngressoVIP);

            System.out.println("Deseja criar mais um participante? (s/n): ");
            String resposta = scanner.nextLine();

            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
        }
    }
}
    private static void adicionarRegular() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Digite o preço do ingresso: ");
            double preco = scanner.nextDouble();

            lerEvento();
            System.out.println("Digite o ID do evento do ingresso: ");
            int idEvento = scanner.nextInt();
            Evento evento = new Evento(null, null, null);
 
            for (int i = 0; i < eventos.size(); i++) {
                if (eventos.get(i).getId() == idEvento) {
                    evento = eventos.get(i);
                }
            }

            lerParticipante();
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

private static void lerVIP() {
    if (ingressosVIP.size() == 0) {
        System.out.println("Lista vazia!");
    } else {
    for (int i = 0; i < ingressosVIP.size(); i++) {
        ingressosVIP.get(i).exibirInfo();
    }
}
}

private static void lerRegular() {
    if (ingressosRegular.size() == 0) {
        System.out.println("Lista vazia!");
    } else {
    for (int i = 0; i < ingressosRegular.size(); i++) {
        ingressosRegular.get(i).exibirInfo();
    }
}
}

private static void atualizarVIP() {
    lerVIP();
    System.out.println("Digite o ID do ingresso VIP que deseja atualizar: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    for (int i = 0; i < ingressosVIP.size(); i++) {
        IngressoVIP ingressoVIP = ingressosVIP.get(i);
        if (ingressoVIP.getId() == id) {
            System.out.println("Digite o novo preço do ingresso: ");
            double preco = scanner.nextDouble();
            ingressoVIP.setPreco(preco);
            ingressoVIP.calcularAumento();
            lerEvento();
            System.out.println("Digite o ID do novo evento do ingresso: ");
            int idEvento = scanner.nextInt();
            Evento evento = new Evento(null, null, null);
 
            for (int j = 0; j < eventos.size(); j++) {
                if (eventos.get(i).getId() == idEvento) {
                    evento = eventos.get(i);
                    ingressoVIP.setEvento(evento);
                }
            }

            lerParticipante();
            System.out.println("Digite o ID do novo participante do evento: ");
            int idParticipante = scanner.nextInt();
            Participante participante = new Participante(null, null, null);
 
            for (int j = 0; j < participantes.size(); j++) {
                if (participantes.get(i).getId() == idParticipante) {
                    participante = participantes.get(i);
                    ingressoVIP.setParticipante(participante);
                }
            }
        }   
    } 
}       

private static void atualizarRegular() {
    lerRegular();
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
            lerEvento();
            System.out.println("Digite o ID do novo evento do ingresso: ");
            int idEvento = scanner.nextInt();
            Evento evento = new Evento(null, null, null);
 
            for (int j = 0; j < eventos.size(); j++) {
                if (eventos.get(i).getId() == idEvento) {
                    evento = eventos.get(i);
                    ingressoRegular.setEvento(evento);
                }
            }

            lerParticipante();
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

private static void deletarVIP() {
    lerVIP();
    System.out.println("Digite o ID do ingresso VIP que deseja deletar: ");
    int id = scanner.nextInt();
    for (int i = 0; i < ingressosVIP.size(); i++) {
        IngressoVIP ingressoVIP = ingressosVIP.get(i);
        if (ingressoVIP.getId() == id) {
            ingressosVIP.remove(i);
        } else {
            System.out.println("Ingresso não encontrado");
        }
    } 
}

private static void deletarRegular() {
    lerRegular();
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

    private static void participante() {
        System.out.println("[1] - Criar");
        System.out.println("[2] - Ler");
        System.out.println("[3] - Atualizar");
        System.out.println("[4] - Deletar");
        System.out.println("[5] - Voltar");

        int opt = scanner.nextInt();
        scanner.nextLine();
        switch (opt) {
            case 1:
                adicionarParticipante();
                participante();
                break;
            case 2:
                lerParticipante();
                participante();
                break;
            case 3:
                atualizarParticipante();
                participante();
                break;
            case 4:
                deletarParticipante();
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

    private static void adicionarParticipante() {
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

    private static void lerParticipante() {
        if (participantes.size() == 0) {
            System.out.println("Lista vazia!");
        } else {
        for (int i = 0; i < participantes.size(); i++) {
            participantes.get(i).exibirInfo();
        }
    }
    }

    private static void atualizarParticipante() {
        lerParticipante();
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
    

    private static void deletarParticipante() {
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

    private static void relatorio() {
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
                    eventRecorder.gerarRelatorioEvento(eventos.get(i));
                }
                break;
        
            case 2:
                for (int i = 0; i < ingressosVIP.size(); i++) {
                    eventRecorder.gerarRelatorioIngressoVip(ingressosVIP.get(i));
                }
                break;
        
            case 3:
                for (int i = 0; i < ingressosRegular.size(); i++) {
                    eventRecorder.gerarRelatorioIngressoRegular(ingressosRegular.get(i));
                }
                break;
        
            case 4:
                for (int i = 0; i < participantes.size(); i++) {
                    eventRecorder.gerarRelatorioParticipante(participantes.get(i));
                }
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