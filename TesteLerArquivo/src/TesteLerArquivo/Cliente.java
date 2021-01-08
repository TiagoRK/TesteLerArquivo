package TesteLerArquivo;

/**
 *
 * @author TIAGO
 */
public class Cliente {

    private int ID;
    private String nome;
    private int horasAtendimento;

    /**
     * Construtor vazio
     */
    public Cliente() {
    }
    /**
     * Construtor com todos os dados da classe
     * @param ID
     * @param nome
     * @param horasAtendimento
     */
    public Cliente(int ID, String nome, int horasAtendimento) {
        this.ID = ID;
        this.nome = nome;
        this.horasAtendimento = horasAtendimento;
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
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}
