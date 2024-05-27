package converter;

import api.ConexaoApi;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
public class ConversorMoedas {
    private ConexaoApi conexaoApi;
    private JsonObject taxaDeCambio;

    public ConversorMoedas() {
        this.conexaoApi = new ConexaoApi();
        try {
            String dadosApi = null;
            try {
                dadosApi = conexaoApi.buscaDadosApi();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.taxaDeCambio = JsonParser.parseString(dadosApi).getAsJsonObject()
                    .getAsJsonObject("conversion_rates");
        } catch (IOException e) {
            System.err.println("Erro ao obter dados da API de taxas de câmbio dessa moeda. Isso pode acontecer com algumas moedas.");

        }
    }

    public double converterMoeda(double valor, String moedaConverter, String moedaConversora) {
        JsonElement taxaMoedaConverter = taxaDeCambio.get(moedaConverter);
        JsonElement taxaMoedaConversora = taxaDeCambio.get(moedaConversora);

        if (taxaMoedaConverter == null) {
            System.err.println("Moeda de origem não encontrada: " + moedaConverter);
            return 0.0;
        }
        if (taxaMoedaConversora == null) {
            System.err.println("Moeda de destino não encontrada: " + moedaConversora);
            return 0.0;
        }

        double valorTaxaConverter = taxaMoedaConverter.getAsDouble();
        double valorTaxaConversora = taxaMoedaConversora.getAsDouble();

        return (valor / valorTaxaConverter) * valorTaxaConversora;
    }
}
