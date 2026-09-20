import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Veiculo> listaVeiculos = new ArrayList<>();

        Veiculo uno = new Veiculo();
        uno.setMarca("Fiat");
        uno.setModelo("Uno Mille");
        uno.setAno(1998);
        uno.setPlaca("ABC-1234");

        Veiculo fusca = new Veiculo("Volkswagen", "Fusca - Série Ouro", 1995, "DEF-5678");
        Veiculo outroFusca = fusca.cloneMe();

        listaVeiculos.add(uno);
        listaVeiculos.add(fusca);
        listaVeiculos.add(outroFusca);

        int anoBase = LocalDate.now().getYear();
        System.out.println("Tempo de uso do Uno: " + uno.calculaTempoUso(anoBase) + " anos.");
        System.out.println("Tempo de uso do Fusca em 2030: " + fusca.calculaTempoUso(2030) + " anos.");

        int opcao = -1;
        do {
            exibirMenu();
            try {
                opcao = Integer.parseInt(IO.readln("Escolha uma opção: "));
            } catch (Exception e) {
                System.out.println("Opção inválida! Digite um número do menu.");
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarVeiculo(listaVeiculos);
                    break;
                case 2:
                    listarVeiculos(listaVeiculos);
                    break;
                case 3:
                    consultarVeiculo(listaVeiculos);
                    break;
                case 0:
                    System.out.println("\nEncerrando o sistema...");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n======= CADASTRO DE VEÍCULOS =======");
        System.out.println("1 - Cadastrar Veículo");
        System.out.println("2 - Listar Veículos");
        System.out.println("3 - Consultar Veículo por Placa");
        System.out.println("0 - Sair");
    }

    private static void cadastrarVeiculo(List<Veiculo> listaVeiculos) {
        System.out.println("\n--- Novo Cadastro ---");
        String placa = IO.readln("Informe a placa: ").trim().toUpperCase();

        if (buscarPorPlaca(listaVeiculos, placa) != null) {
            System.out.println("Erro: Já existe um veículo cadastrado com a placa '" + placa + "'.");
            return;
        }

        String marca = IO.readln("Informe a marca: ");
        String modelo = IO.readln("Informe o modelo: ");

        int ano = 0;
        int anoAtual = LocalDate.now().getYear();
        int anoMaximo = anoAtual + 1;

        try {
            ano = Integer.parseInt(IO.readln("Informe o ano de fabricação: "));
        } catch (Exception e) {
            System.out.println("Erro: O ano deve ser um número inteiro válido.");
            return;
        }

        if (ano < 1900 || ano > anoMaximo) {
            System.out.println("Erro: Ano inválido! O ano deve ser entre 1900 e " + anoMaximo + ".");
            return;
        }

        Veiculo novo = new Veiculo(marca, modelo, ano, placa);
        listaVeiculos.add(novo);
        System.out.println("Sucesso: Veículo cadastrado com sucesso!");
    }

    private static void listarVeiculos(List<Veiculo> listaVeiculos) {
        System.out.println("\n--- Lista de Veículos ---");
        if (listaVeiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        for (Veiculo v : listaVeiculos) {
            v.exibirDados();
        }
    }

    private static void consultarVeiculo(List<Veiculo> listaVeiculos) {
        System.out.println("\n--- Consulta de Veículo ---");
        if (listaVeiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado no sistema.");
            return;
        }

        String placaBusca = IO.readln("Informe a placa para busca: ").trim().toUpperCase();
        Veiculo encontrado = buscarPorPlaca(listaVeiculos, placaBusca);

        if (encontrado != null) {
            System.out.println("\nVeículo encontrado:");
            encontrado.exibirDados();
        } else {
            System.out.println("Nenhum veículo encontrado com a placa '" + placaBusca + "'.");
        }
    }

    private static Veiculo buscarPorPlaca(List<Veiculo> listaVeiculos, String placa) {
        for (Veiculo v : listaVeiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }
}