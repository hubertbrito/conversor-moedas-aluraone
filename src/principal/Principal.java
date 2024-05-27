package principal;

import converter.ConversorMoedas;

import java.util.Scanner;

class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoedas conversor = new ConversorMoedas();

        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println(" ");
        System.out.println("Abaixo algumas das 161 siglas suportadas:");
        System.out.println("USD (Dólar Americano), BRL (Real), EUR (Euro)," +
                           " ARS (Argentino), CHF (Suíço)," +
                           "VES (Venezuela), GBP (Reino Unido) etc.");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        boolean converter = true;
        while (converter) {
            try {
                System.out.print("Digite a sigla da moeda atual que quer converter (USD, BRL, EUR etc.): ");
                String moedaConverter = scanner.next().toUpperCase();

                System.out.print("Digite a sigla da moeda para qual pretende equivalência (USD, BRL, EUR etc.): ");
                String moedaEquivalente = scanner.next().toUpperCase();

                System.out.print("Digite o valor a ser convertido (Melhor sem ponto, vírgula nem espaços!): ");
                double valor;
                try {
                    String input = scanner.next().replace(",", "").replace(".", "");
                    valor = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    System.err.println("Erro: Digite um valor numérico válido.");
                    System.out.println(" ***");
                    scanner.nextLine();
                    continue;
                }

                double valorConvertido = conversor.converterMoeda(valor, moedaConverter, moedaEquivalente);
                System.out.printf("%.2f %s equivalem a %.2f %s%n", valor, moedaConverter, valorConvertido, moedaEquivalente);

                System.out.print("Deseja fazer outra conversão? (S/N): ");
                String resposta = scanner.next().toUpperCase();
                converter = resposta.equals("S");
            } catch (Exception e) {
                System.err.println("Erro inesperado: " + e.getMessage());
            }
            System.out.println("-------------------------------------------------------------------");
        }

        System.out.println("Programa encerrado. Obrigado por usar o Conversor de Moedas!");
    }
}
