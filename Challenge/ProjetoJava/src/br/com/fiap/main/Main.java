package br.com.fiap.main;

import br.com.fiap.bean.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        String auxiliar, status, nome, cpf, dataEUA, mensagem, indicacoes, especialidade, nomePlano, endereco, telefone;
        int opcao, idAtendente, idConfirmacao, idConsulta, idPagamento, idLog, idMediacamento, idMedico, idPaciente, idPlano, idUnidade, atualizar, atendimento, crm, numero;
        LocalDate dataNascimento, dataConsulta, dataConfirmacao, dataInicio, dataTermino;
        LocalTime horario;
        do {
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog("*-- Menu --* \nSelecione a opção desejada: \n (1) Atendente \n (2) Confirmação \n (3) Consulta \n (4) Forma de pagamento \n (5) Log de mensagens \n (6) Medicamento \n (7) Médico \n (8) Paciente \n (9) Pesssoa \n (10) Plano de Saúde \n (11) Unidade"));
                switch (opcao){
                    case 1:
                        nome = JOptionPane.showInputDialog("Informe o nome do atendente: ");
                        cpf = JOptionPane.showInputDialog("Informe o CPF do atendente: ");
                        idAtendente = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do atendente: "));
                        auxiliar = JOptionPane.showInputDialog("Digite a data de nascimento do atendente:(dd/MM/yyyy)");

                        String anoAtendente = auxiliar.substring(6, 10);
                        String mesAtendente = auxiliar.substring(3, 5);
                        String diaAtendente = auxiliar.substring(0, 2);

                        dataEUA = anoAtendente + "-" + mesAtendente + "-" + diaAtendente;
                        dataNascimento = LocalDate.parse(dataEUA);

                        Atendente atendente = new Atendente(idAtendente, nome, cpf, dataNascimento);
                        atendente.setDataNascimento(dataNascimento);

                        atendente.formatarData();

                        JOptionPane.showMessageDialog(null, String.format("Atendente: %s \nCPF: %s \nID: %d \nIdade: %d", nome, cpf, idAtendente, atendente.verificarIdade()), "Atendente", JOptionPane.INFORMATION_MESSAGE);


                        atendimento = JOptionPane.showConfirmDialog(null, "Deseja iniciar atendimento?", "Atendimento", JOptionPane.YES_NO_OPTION);
                        if (atendimento == 0){
                            atendente.iniciarAtendimento();
                            atendimento = JOptionPane.showConfirmDialog(null, "Deseja encerrar atendimento?", "Atendimento", JOptionPane.YES_NO_OPTION);
                            if (atendimento == 0){
                                atendente.encerrarAtendimento();
                            }
                        }
                        break;
                    case 2:
                        idConfirmacao = Integer.parseInt(JOptionPane.showInputDialog("Informe o id de confirmação: "));
                        auxiliar = JOptionPane.showInputDialog("Digite a data de confirmação: (dd/MM/yyyy): ");

                        String anoConfirmacao = auxiliar.substring(6, 10);
                        String mesConfirmacao = auxiliar.substring(3, 5);
                        String diaConfirmacao = auxiliar.substring(0, 2);

                        dataEUA = anoConfirmacao + "-" + mesConfirmacao + "-" + diaConfirmacao;
                        dataConfirmacao = LocalDate.parse(dataEUA);

                        status = JOptionPane.showInputDialog("Digite o status da confirmação: (Pendente, confirmado ou ausente): ");

                        Confirmacao confirmacao = new Confirmacao(idConfirmacao, dataConfirmacao, status);
                        JOptionPane.showMessageDialog(null, String.format("Id confrimação: %d \nData confirmação: %s \nStatus: %s", idConfirmacao, dataConfirmacao, status), "Confirmação", JOptionPane.INFORMATION_MESSAGE);

                        int verificar = JOptionPane.showConfirmDialog(null, "Deseja verificar o status da corfimação?", "Confirmação", JOptionPane.YES_NO_OPTION);
                        if (verificar == 0){
                            confirmacao.verificarConfirmacao();
                        }

                        atualizar = JOptionPane.showConfirmDialog(null, "Deseja atualizar o status da corfimação?", "Confirmação", JOptionPane.YES_NO_OPTION);
                        if (atualizar == 0){
                            confirmacao.atualizarStatus();
                        }
                        break;
                    case 3:
                        idConsulta = Integer.parseInt(JOptionPane.showInputDialog("Informe o id de confirmação: "));
                        auxiliar = JOptionPane.showInputDialog("Digite a data da consulta: (dd/MM/yyyy): ");

                        String anoConsulta = auxiliar.substring(6, 10);
                        String mesConsulta = auxiliar.substring(3, 5);
                        String diaConsulta = auxiliar.substring(0, 2);

                        dataEUA = anoConsulta + "-" + mesConsulta + "-" + diaConsulta;
                        dataConsulta = LocalDate.parse(dataEUA);

                        auxiliar = JOptionPane.showInputDialog("Digite a hora da consulta: (Horários dás 08:00 ás 16:00): ");
                        horario = LocalTime.parse(auxiliar);

                        Consulta consulta = new Consulta(idConsulta, horario, dataConsulta);

                        JOptionPane.showMessageDialog(null, String.format("Id consulta: %d \nData: %s \nHorário: %s \nFaltam %s dias para a consulta \nConsulta futura: %s", idConsulta, dataConsulta, horario, consulta.diasParaConsulta(), consulta.consultaFutura()), "Consulta", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 4:
                        idPagamento = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do pagamento: "));
                        status = JOptionPane.showInputDialog("Digite o status do Pagamento: (Pendente ou Pago): ");
                        nome = JOptionPane.showInputDialog("Digite a forma de pagamento (Pix, Dinheiro, Débito ou Crédito): ");

                        FormaDePagamento pagamento = new FormaDePagamento(idPagamento, status, nome);
                        pagamento.exibirPagamento();

                        atualizar = JOptionPane.showConfirmDialog(null, "Deseja atualizar o status do pagamento?", "Pagamento", JOptionPane.YES_NO_OPTION);
                        if (atualizar == 0){
                            pagamento.atualizarStatus();
                        }
                        break;
                    case 5:
                        idLog = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do log: "));
                        mensagem = JOptionPane.showInputDialog("Digite a mensagem: ");
                        status = JOptionPane.showInputDialog("Digite o status da mensagem: (Entrege, Lido, Enviado ou Respondido): ");

                        LogMensagem log = new LogMensagem(idLog, mensagem, status);
                        log.exibirLog();
                        atualizar = JOptionPane.showConfirmDialog(null, "Deseja atualizar o status do Log?", "Log", JOptionPane.YES_NO_OPTION);
                        if (atualizar == 0){
                            log.atualizarStatus();
                        }
                        break;
                    case 6:
                        idMediacamento = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do medicamento: "));
                        nome = JOptionPane.showInputDialog("Digite o nome do medicamento: ");
                        indicacoes = JOptionPane.showInputDialog("Digite as indicações necessárias para tomar esse medicamento: ");

                        Medicamento medicamento = new Medicamento(idMediacamento, nome, indicacoes);
                        medicamento.exibirMedicamento();
                        atualizar = JOptionPane.showConfirmDialog(null, "Deseja atualizar as indicações do medicamento?", "Medicamento", JOptionPane.YES_NO_OPTION);
                        if (atualizar == 0){
                            medicamento.atualizarindicacoes();
                        }
                        break;
                    case 7:
                        idMedico = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do medicamento: "));
                        nome = JOptionPane.showInputDialog("Informe o nome do atendente: ");
                        crm = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do medicamento: "));
                        especialidade = JOptionPane.showInputDialog("Informe a especialidade do médico: ");

                        Medico medico = new Medico(idMedico, nome, crm, especialidade);
                        medico.exibirMedico();
                        atualizar = JOptionPane.showConfirmDialog(null, "Deseja atualizar a especialidade do médico?", "Médico", JOptionPane.YES_NO_OPTION);
                        if (atualizar == 0){
                            medico.atualizarEspecialidade();
                        }
                        break;
                    case 8:
                        nome = JOptionPane.showInputDialog("Informe o nome do Paciente: ");
                        cpf = JOptionPane.showInputDialog("Informe o CPF do Paciente: ");
                        idPaciente = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do Paciente: "));
                        auxiliar = JOptionPane.showInputDialog("Digite a data de nascimento do Paciente:(dd/MM/yyyy)");

                        String anoPaciente = auxiliar.substring(6, 10);
                        String mesPaciente = auxiliar.substring(3, 5);
                        String diaPaciente = auxiliar.substring(0, 2);

                        dataEUA = anoPaciente + "-" + mesPaciente + "-" + diaPaciente;
                        dataNascimento = LocalDate.parse(dataEUA);

                        Paciente paciente = new Paciente(idPaciente, nome, cpf, dataNascimento);
                        paciente.setDataNascimento(dataNascimento);

                        paciente.formatarData();

                        paciente.exibirPaciente();
                        atualizar = JOptionPane.showConfirmDialog(null, "Deseja atualizar as informações do paciente?", "Paciente", JOptionPane.YES_NO_OPTION);
                        if (atualizar == 0){
                            paciente.atualizarCadastro();
                        }
                        break;
                    case 9:
                        nome = JOptionPane.showInputDialog("Informe o nome da pessoa: ");
                        cpf = JOptionPane.showInputDialog("Informe o CPF do pessoa: ");
                        auxiliar = JOptionPane.showInputDialog("Digite a data de nascimento do pessoa:(dd/MM/yyyy)");

                        String anoPessoa = auxiliar.substring(6, 10);
                        String mesPessoa = auxiliar.substring(3, 5);
                        String diaPessoa = auxiliar.substring(0, 2);

                        dataEUA = anoPessoa + "-" + mesPessoa + "-" + diaPessoa;
                        dataNascimento = LocalDate.parse(dataEUA);

                        Pessoa pessoa = new Pessoa(nome, cpf, dataNascimento);
                        pessoa.setDataNascimento(dataNascimento);

                        pessoa.formatarData();

                        JOptionPane.showMessageDialog(null, String.format("Nome: %s \nCPF: %s \nIdade: %s", nome, cpf, pessoa.verificarIdade()), "Pessoa", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 10:
                        idPlano = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do plano: "));
                        auxiliar = JOptionPane.showInputDialog("Digite a data de inicio do plano de saúde:(dd/MM/yyyy)");

                        String anoInicio = auxiliar.substring(6, 10);
                        String mesInicio = auxiliar.substring(3, 5);
                        String diaInicio = auxiliar.substring(0, 2);
                        dataEUA = anoInicio + "-" + mesInicio + "-" + diaInicio;
                        dataInicio = LocalDate.parse(dataEUA);

                        auxiliar = JOptionPane.showInputDialog("Digite a data de término do plano de saúde:(dd/MM/yyyy)");
                        String anoTermino = auxiliar.substring(6, 10);
                        String mesTermino= auxiliar.substring(3, 5);
                        String diaTermino= auxiliar.substring(0, 2);
                        dataEUA = anoTermino + "-" + mesTermino + "-" + diaTermino;
                        dataTermino = LocalDate.parse(dataEUA);

                        nomePlano = JOptionPane.showInputDialog("Informe o nome do plano de saúde: ");

                        PlanoDeSaude plano = new PlanoDeSaude();
                        plano.setDataInicio(dataInicio);
                        plano.setDataTermino(dataTermino);

                        JOptionPane.showMessageDialog(null, String.format("Id Plano: %d \nNome Plano: %s \nDias restante para o fim do plano: %s", idPlano, nomePlano, plano.diasRestantes()), "Plano", JOptionPane.INFORMATION_MESSAGE);
                        plano.verificarPlanoAtivo();
                    case 11:
                        idUnidade = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do enderreço: "));
                        endereco = JOptionPane.showInputDialog("Digite o endereço (sem o número): ");
                        numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do endereço: "));
                        telefone = JOptionPane.showInputDialog("Informe o telefone: ");

                        Unidade unidade = new Unidade(idUnidade, telefone, numero, endereco);
                        JOptionPane.showMessageDialog(null, String.format("Id Unidade: %d \nEndereço: %s\nTelefone: %s", idUnidade, unidade.formatarEndereco(), unidade.formatarTelefone()), "Unidade", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        throw new Exception("Escolha incorreta! Selecione um número entre (1 e 11)");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        } while (JOptionPane.showConfirmDialog(null, "Voltar ao menu?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
            JOptionPane.showMessageDialog(null, "Fim de programa, Volte sempre!", "Adeus!", JOptionPane.WARNING_MESSAGE);
    }
}