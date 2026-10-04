import java.util.ArrayList;
import java.util.List;

void main() {

    List<Veiculo> veiculos = new ArrayList<>();
    Functions functions = new Functions();

    String menu = """
                Controle Veiculos

            Selecione uma opção:

            [1] - Cadastrar Veículo
            [2] - Listar Veículos
            [3] - Consultar Veículo
            [0] - Sair
            """;

    int opcao;

    do {
        IO.println(menu);

        opcao = Input.readint("Digite uma opção: ");

        switch (opcao) {

            case 1:
                functions.cadastrarVeiculo(veiculos);
                break;
            case 2:
                functions.listarVeiculos(veiculos);
                break;
            case 3:
                functions.consultarVeiculos(veiculos);
                break;
            case 0:
                IO.readln("Pressione ENTER para sair do sistema.");
                break;
            default:
                IO.println("Opção inválida!");
                break;
        }

    } while (opcao != 0);
}