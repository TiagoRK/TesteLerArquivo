package TesteLerArquivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author TIAGO
 */
public class TesteLeituraDeArquivo {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Funcionario> listaFuncionarios = new ArrayList();
        List<Cliente> listaClientes = new ArrayList();
        List<Atendimento> listaAtendimentos;
        listaAtendimentos = new ArrayList();
        int horasTotaisAtendimento = 0;
        int horasTotaisAtendimento1;
        int totalFuncionarios = 0;
        int totalClientes = 0;
        int totalAtendimentos = 0;
        try {
            /**
             * Abre o arquivo
             * Altera aqui a localização do arquivo de acordo com sua maquina.
             */
            FileReader fr = new FileReader("G:/dados.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp;
            /**
             * A cada interação, lê uma linha do arquivo e atribui-a a temp
             */
            while ((temp = br.readLine()) != null) {
                /**
                 * Aqui salva cada string separada por | no vetor primeiraLetra,
                 * depois verifica a primeira letra e age de acordo, em caso de
                 * 0 cadastra um funcionario, 1 para cadastrar cliente e 2 para
                 * criar um atendimento
                 */
                String[] primeiraLetra = temp.split("|");
                if (primeiraLetra[0].equalsIgnoreCase("0")) {
                    Funcionario funcionario = new Funcionario();
                    int um;
                    int dois;
                    int tres;
                    int ultimo = temp.lastIndexOf("");
                    um = temp.indexOf("|");
                    dois = temp.indexOf("|", um + 1);
                    tres = temp.indexOf("|", dois);
                    funcionario.setID(Integer.parseInt(temp.substring(um + 1, dois)));
                    funcionario.setNome(temp.substring(tres + 1, ultimo));
                    totalFuncionarios = totalFuncionarios + 1;
                    listaFuncionarios.add(funcionario);
                } else if (primeiraLetra[0].equalsIgnoreCase("1")) {
                    Cliente cliente = new Cliente();
                    int um;
                    int dois;
                    int tres;
                    int ultimo = temp.lastIndexOf("");
                    um = temp.indexOf("|");
                    dois = temp.indexOf("|", um + 1);
                    tres = temp.indexOf("|", dois);
                    cliente.setID(Integer.parseInt(temp.substring(um + 1, dois)));
                    cliente.setNome(temp.substring(tres + 1, ultimo));
                    totalClientes = totalClientes + 1;
                    listaClientes.add(cliente);
                } else if (primeiraLetra[0].equalsIgnoreCase("2")) {
                    Atendimento atendimento = new Atendimento();
                    int um;
                    int dois;
                    int tres;
                    int quatro;
                    int cinco;
                    int ultimo = temp.lastIndexOf("");
                    um = temp.indexOf("|");
                    dois = temp.indexOf("|", um + 1);
                    tres = temp.indexOf("|", dois);
                    quatro = temp.indexOf("|", tres + 1);
                    cinco = temp.indexOf("|", quatro + 1);
                    atendimento.setID(Integer.parseInt(temp.substring(um + 1, dois)));
                    totalAtendimentos = totalAtendimentos + 1;
                    for (int i = 0; i < listaFuncionarios.size(); i++) {
                        if (listaFuncionarios.get(i).getID() == (Integer.parseInt(temp.substring(tres + 1, quatro)))) {
                            atendimento.setFuncionario(listaFuncionarios.get(i));
                            atendimento.getFuncionario().setQuantAtendimento(atendimento.getFuncionario().getQuantAtendimento() + 1);
                        }
                    }
                    for (int i = 0; i < listaClientes.size(); i++) {
                        if (listaClientes.get(i).getID() == (Integer.parseInt(temp.substring(quatro + 1, cinco)))) {
                            int horasDeAtendimentoOcupadas;
                            int horasDeAtendimentoAnterior;
                            int horasTotaisAtendimentoProFuncionario;
                            atendimento.setCliente(listaClientes.get(i));
                            horasDeAtendimentoOcupadas = (Integer.parseInt(temp.substring(cinco + 1, ultimo)));
                            horasDeAtendimentoAnterior = atendimento.getCliente().getHorasAtendimento();
                            atendimento.getCliente().setHorasAtendimento(horasDeAtendimentoAnterior + horasDeAtendimentoOcupadas);
                            horasTotaisAtendimento1 = (Integer.parseInt(temp.substring(cinco + 1, ultimo)));
                            horasTotaisAtendimento = horasTotaisAtendimento + horasTotaisAtendimento1;
                            horasTotaisAtendimentoProFuncionario = (Integer.parseInt(temp.substring(cinco + 1, ultimo)));
                            atendimento.getFuncionario().setHorasOcupadoEmAtendimento(horasTotaisAtendimentoProFuncionario);
                            listaClientes.get(i).getHorasAtendimento();
                        }
                    }
                    listaAtendimentos.add(atendimento);
                } else {
                    System.out.println("LINHA COM CÓDIGO INVÁLIDO!\nFechando programa...");
                    System.exit(0);
                }
            }
        } catch (FileNotFoundException el) {
            System.out.println("Arquivo não Encontrado!");
        } catch (IOException e) {
        }
        /**
         * Imprime os dados retirados do arquivo de forma formatada e conforme
         * solicitado
         */
        System.out.println("DADOS GERAIS");
        System.out.println("Horas de atendimento totais: " + horasTotaisAtendimento);
        System.out.println("Total de atendimentos: " + totalAtendimentos);
        System.out.println("Total de funcionarios: " + totalFuncionarios);
        System.out.println("Total de clientes: " + totalClientes);
        mostrarTotalHorasAtendPorCliente(listaClientes);
        mostrarTotalHorasAtendPorFuncionario(listaFuncionarios);
        funcionarioMaisHorasAtendimento(listaFuncionarios);
        clienteMaisHorasAtendimento(listaClientes);
        comparaHoras(listaFuncionarios);
    }

    /**
     * Mostra o total de horas ocupadas em atendimento por cliente
     *
     * @param listaClientes
     */
    public static void mostrarTotalHorasAtendPorCliente(List<Cliente> listaClientes) {
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println("O cliente " + listaClientes.get(i).getNome() + " realizou o total de " + listaClientes.get(i).getHorasAtendimento() + " horas totais de atendimento");
        }
    }

    /**
     * Mostra o total de horas atendidas por funcionario
     *
     * @param listaFuncionarios
     */
    public static void mostrarTotalHorasAtendPorFuncionario(List<Funcionario> listaFuncionarios) {
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            System.out.println("O funcionario " + listaFuncionarios.get(i).getNome() + " realizou o total de " + listaFuncionarios.get(i).getHorasOcupadoEmAtendimento() + " horas totais em atendimento");
        }
    }

    /**
     * Imprime o funcionário da lista que atendeu mais horas
     *
     * @param listaFuncionarios
     */
    public static void funcionarioMaisHorasAtendimento(List<Funcionario> listaFuncionarios) {
        int tempo = 0;

        for (int i = 0; i < listaFuncionarios.size(); i++) {
            int a = listaFuncionarios.get(i).getHorasOcupadoEmAtendimento();
            if (a > tempo) {
                tempo = a;
            }
        }
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            if (listaFuncionarios.get(i).getHorasOcupadoEmAtendimento() == tempo) {
                System.out.println("O ID do funcionario com mais horas em atendimento é: " + listaFuncionarios.get(i).getID() + ", de nome: " + listaFuncionarios.get(i).getNome());
            }
        }
    }

    /**
     * Imprime o cliente que ocupou mais horas em antedimento
     *
     * @param listaClientes
     */
    public static void clienteMaisHorasAtendimento(List<Cliente> listaClientes) {
        int tempo = 0;

        for (int i = 0; i < listaClientes.size(); i++) {
            int a = listaClientes.get(i).getHorasAtendimento();
            if (a > tempo) {
                tempo = a;
            }
        }
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getHorasAtendimento() == tempo) {
                System.out.println("O nome do cliente com mais horas em atendimento é: " + listaClientes.get(i).getNome());
            }
        }
    }

    /**
     * Compara as horas entre os funcionários da lista e imprime em ordem
     * decrescente os funcionarios que atenderam mais horas
     *
     * @param listaFuncionarios
     */
    public static void comparaHoras(List<Funcionario> listaFuncionarios) {
        Collections.sort(listaFuncionarios);
        listaFuncionarios.forEach((str) -> {
            System.out.println("Nome do funcionario: " + str.getNome() + " ,atendeu " + str.getHorasOcupadoEmAtendimento() + " horas");
        });
    }
}
