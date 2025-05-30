import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * 12 - Faça um algoritmo que leia o valor de um produto e determine o valor que
         * deve ser pago,
         * conforme a escolha da forma de pagamento pelo comprador
         * e imprima na tela o valor final do produto a ser pago.
         * Utilize os códigos da tabela de condições de pagamento para efetuar o cálculo
         * adequado.
         * 
         * Tabela de Código de Condições de Pagamento
         * 1 - À Vista em Dinheiro ou Pix, recebe 15% de desconto
         * 2 - À Vista no cartão de crédito, recebe 10% de desconto
         * 3 - Parcelado no cartão em duas vezes, preço normal do produto sem juros
         * 4 - Parcelado no cartão em três vezes ou mais, preço normal do produto mais
         * juros de 10%
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha seu produto: ");
        System.out.println("Produto 1 - 100.00R$");
        System.out.println("Produto 2 - 120.00R$");
        System.out.println("Produto 3 - 150.00R$");
        int input = sc.nextInt();

        Product produto = new Product();
        switch (input) {
            case 1:
                produto = new Product("Produto 1", 100.00);
                break;
            case 2:
                produto = new Product("Produto 2", 120.00);
                break;
            case 3:
                produto = new Product("Produto 3", 150.00);
                break;
            default:
                break;
        }

        System.out.println("Escolha sua forma de pagamento: ");
        System.out.println("1 - À Vista em Dinheiro ou Pix, recebe 15% de desconto");
        System.out.println("2 - À Vista no cartão de crédito, recebe 10% de desconto");
        System.out.println("3 - Parcelado no cartão em duas vezes, preço normal do produto sem juros");
        System.out.println("4 - Parcelado no cartão em três vezes ou mais, preço normal do produto mais juros de 10%");
        int input2 = sc.nextInt();

        Double precoFinal = 0.0;
        switch (input2) {
            case 1:
                precoFinal = produto.getValue() - (produto.getValue() / 100 * 15);
                System.out.printf("\nTotal a ser pago: %.2fR$", precoFinal);
                break;
            case 2:
                precoFinal = produto.getValue() - (produto.getValue() / 100 * 10);
                System.out.printf("\nTotal a ser pago: %.2fR$", precoFinal);
                break;
            case 3:
                precoFinal = produto.getValue() / 2;
                System.out.printf("\nTotal a ser pago: 2x de %.2fR$", precoFinal);
                break;
            case 4:
                precoFinal = produto.getValue() + (produto.getValue() / 100 * 10);
                Double valorParcelas = precoFinal / 3; 
                System.out.printf("\nTotal a ser pago: 3x de %.2fR$", valorParcelas);
                break;
            default:
                break;
        }

        sc.close();
    }
}
