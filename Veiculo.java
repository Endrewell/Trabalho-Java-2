import java.time.LocalDate;

public class Veiculo { 
  
    private String marca;
    private String modelo;
    private int ano;
    private String placa;

    public Veiculo() {
        this("Marca desconhecida", "Modelo desconhecido", LocalDate.now().getYear(), "");
    }

    public Veiculo(String marca, String modelo, int ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int calculaTempoUso() {
        int anoAtual = LocalDate.now().getYear();
        return calculaTempoUso(anoAtual);
    }

    public int calculaTempoUso(int anoBase) {
        return anoBase - this.ano;
    }

    public Veiculo cloneMe() {
        Veiculo veiculoDestino = new Veiculo();
        veiculoDestino.marca = this.marca;
        veiculoDestino.modelo = this.modelo;
        veiculoDestino.ano = this.ano;
        veiculoDestino.placa = this.placa;
        return veiculoDestino;
    }

    public Veiculo cloneFromOther(Veiculo veiculoOrigem) {
        Veiculo veiculoDestino = new Veiculo();
        veiculoDestino.marca = veiculoOrigem.marca;
        veiculoDestino.modelo = veiculoOrigem.modelo;
        veiculoDestino.ano = veiculoOrigem.ano;
        veiculoDestino.placa = veiculoOrigem.placa;
        return veiculoDestino;
    }

    public Veiculo cloneFromOtherWrong(Veiculo veiculoOrigem) {
        return veiculoOrigem;
    }

    public void exibirDados() {
        System.out.println("----------------------------------------");
        System.out.println("Marca:        " + this.marca);
        System.out.println("Modelo:       " + this.modelo);
        System.out.println("Ano:          " + this.ano);
        System.out.println("Placa:        " + this.placa);
        System.out.println("Tempo de Uso: " + calculaTempoUso() + " ano(s)");
        System.out.println("----------------------------------------");
    }
}