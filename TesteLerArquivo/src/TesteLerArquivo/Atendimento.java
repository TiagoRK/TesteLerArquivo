package TesteLerArquivo;

/**
 *
 * @author TIAGO
 */
public class Atendimento {

    private int ID;
    private Funcionario funcionario;
    private Cliente cliente;
    private int horasAtendimento;

    /**
     * Construtor vazio
     */
    public Atendimento() {
    }

    /**
     * Construtor com dados somente da classe atendimento
     * @param ID
     * @param horasAtendimento
     */
    public Atendimento(int ID, int horasAtendimento) {
        this.ID = ID;
        this.horasAtendimento = horasAtendimento;
    }

    /**
     * Construtor dependente da criação de outras classes antes
     * @param ID
     * @param funcionario
     * @param cliente
     * @param horasAtendimento
     */
    public Atendimento(int ID, Funcionario funcionario, Cliente cliente, int horasAtendimento) {
        this.ID = ID;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.horasAtendimento = horasAtendimento;
    }

    /**
     *
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     *
     * @return
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     *
     * @param funcionario
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     *
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @return
     */
    public int getHorasAtendimento() {
        return horasAtendimento;
    }

    /**
     *
     * @param horasAtendimento
     */
    public void setHorasAtendimento(int horasAtendimento) {
        this.horasAtendimento = horasAtendimento;
    }

}
