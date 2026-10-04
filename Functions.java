import java.time.LocalDate;
import java.util.List;

public class Functions {

    int anoAtual = LocalDate.now().getYear();

    public void cadastrarVeiculo(List<Veiculo> veiculos) {
        IO.println("CADASTRAR VEICULO ");
        IO.println();

        String marca = IO.readln("Digite a marca do veiculo ou 0 para sair: ");
        if (marca != null && marca.trim().equals("0")) {
            IO.println();
            IO.readln("Pressione ENTER para retornar ao menu.");
            return;
        }

        while (marca == null || marca.isBlank()) {
            IO.println("Erro! A marca não pode estar vazia.");
            marca = IO.readln("Digite uma marca válida: ");
            if (marca != null && marca.trim().equals("0")) {
                return;
            }
        }

        String modelo = IO.readln("Digite o modelo do veiculo: ");
        while (modelo == null || modelo.isBlank()) {
            IO.println("Erro! O modelo não pode ser vazio.");
            modelo = IO.readln("Digite um modelo válido: ");
        }

        int ano = Input.readint("Insira o ano do veículo (entre 1900 e " + anoAtual + "): ");
        while (ano < 1900 || ano > anoAtual) {
            IO.println("Erro! O ano deve ser entre 1900 e " + anoAtual + ".");
            ano = Input.readint("Insira um ano válido: ");
        }

        String placa = "";
        boolean placaValida = false;

        while (!placaValida) {
            placa = IO.readln("Digite a placa do Veiculo: ");

            if (placa == null || placa.isBlank()) {
                IO.println("Erro! A placa não pode ser vazia.");
                continue;
            }

            boolean jaExiste = false;
            for (Veiculo veiculo : veiculos) {
                if (veiculo.getPlaca() != null && veiculo.getPlaca().equalsIgnoreCase(placa)) {
                    jaExiste = true;
                    break;
                }
            }

            if (jaExiste) {
                IO.println("Erro! Já existe um veículo cadastrado com essa placa.");
            } else {
                placaValida = true;
            }
        }

        Veiculo novo = new Veiculo(marca, modelo, ano, placa);
        veiculos.add(novo);
        IO.println();
        IO.println("Veículo cadastrado com sucesso.");
        IO.readln("Pressione ENTER para retornar ao menu.");
    }

    public void listarVeiculos(List<Veiculo> veiculos) {
        IO.println("VEÍCULOS CADASTRADOS");
        IO.println();

        if (veiculos.isEmpty()) {
            IO.println("Nenhum veículo cadastrado.");
            IO.readln("Pressione ENTER para retornar.");
            return;
        }

        for (Veiculo veiculo : veiculos) {
            IO.println();
            IO.println("Veiculo:");
            IO.println("Marca: " + veiculo.getMarca());
            IO.println("Modelo: " + veiculo.getModelo());
            IO.println("Ano: " + veiculo.getAno());
            IO.println("Placa: " + veiculo.getPlaca());
            IO.println();
        }
        IO.readln("Pressione ENTER para retornar ao menu.");
    }

    public void consultarVeiculos(List<Veiculo> veiculos) {
        IO.println("CONSULTAR VEÍCULOS");
        IO.println();

        if (veiculos.isEmpty()) {
            IO.println("Nenhum veículo cadastrado.");
            IO.readln("Pressione ENTER para retornar ao menu.");
            return;
        }

        String placa = IO.readln("Informe a placa do veículo: ");

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca() != null && veiculo.getPlaca().equalsIgnoreCase(placa)) {
                IO.println();
                IO.println("Veículo encontrado!");
                IO.println("Marca: " + veiculo.getMarca());
                IO.println("Modelo: " + veiculo.getModelo());
                IO.println("Ano: " + veiculo.getAno());
                IO.println("Placa: " + veiculo.getPlaca());
                IO.println();
                IO.readln("Pressione ENTER para retornar ao menu.");
                return;
            }
        }

        IO.println();
        IO.println("Placa não cadastrada.");
        IO.readln("Pressione ENTER para retornar ao menu.");
        IO.println();
    }
}