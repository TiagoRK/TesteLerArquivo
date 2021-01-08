package TesteLerArquivo;

/**
 *
 * @author TIAGO
 */
public class Funcionario implements Comparable<Funcionario> {

    private int ID;
    private String nome;
    private int quantAtendimento;
    private int horasOcupadoEmAtendimento;

    /**
     * Construtor vazio
     */
    public Funcionario() {
    }
    /**
     * Construtor com todos os dados necessários
     * @param ID
     * @param nome
     * @param quantAtendimento
     * @param horasOcupadoEmAtendimento
     */
    public Funcionario(int ID, String nome, int quantAtendimento, int horasOcupadoEmAtendimento) {
        this.ID = ID;
        this.nome = nome;
        this.quantAtendimento = quantAtendimento;
        this.horasOcupadoEmAtendimento = horasOcupadoEmAtendimento;
    }

    /**
     * Método para comparar as horas totais entre os funcionários
     * @param comparaHorasTot
     * @return
     */
    @Override
    public int compareTo(Funcionario comparaHorasTot) {
        int comparaHoras = ((Funcionario) comparaHorasTot).getHorasOcupadoEmAtendimento();
        return comparaHoras - this.horasOcupadoEmAtendimento;
    }

    /**
     *
     * @return
     */
    public int getHorasOcupadoEmAtendimento() {
        return horasOcupadoEmAtendimento;
    }

    /**
     *
     * @param horasOcupadoEmAtendimento
     */
    public void setHorasOcupadoEmAtendimento(int horasOcupadoEmAtendimento) {
        this.horasOcupadoEmAtendimento = horasOcupadoEmAtendimento;
    }

    /**
     *
     * @return
     */
    public int getQuantAtendimento() {
        return quantAtendimento;
    }

    /**
     *
     * @param quantAtendimento
     */
    public void setQuantAtendimento(int quantAtendimento) {
        this.quantAtendimento = quantAtendimento;
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
