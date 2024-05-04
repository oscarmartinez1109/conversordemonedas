package com.alura.conversordemonedas.models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ConsultaDeMonedas {
    private final String monedaBase;
    private final String monedaCambio;

    // Constructor que recibe la moneda de cambio
    public ConsultaDeMonedas(String monedaBase, String monedaCambio) {
        this.monedaBase = monedaBase;
        this.monedaCambio = monedaCambio;
    }

    public Monedas obtenerTasasDeCambio() {
        // Aquí deberías realizar la solicitud a la API para obtener las tasas de cambio
        // y devolver un objeto Monedas con las tasas obtenidas
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f7dd6da3627360e6c1d61abd/pair/" + monedaBase + "/" + monedaCambio);


        try {
            HttpResponse<String> response = null;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("ocurrio un error");
            System.out.println(e.getMessage());
        }
        return null;
    }
}
