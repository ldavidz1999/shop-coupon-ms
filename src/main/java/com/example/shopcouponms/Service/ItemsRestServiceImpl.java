package com.example.shopcouponms.Service;

import com.example.shopcouponms.Model.Response.ItemsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ItemsRestServiceImpl implements ItemRestService {

    private final ObjectMapper objectMapper;

    public ItemsRestServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Double getItemPrice(String itemId) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("https://api.mercadolibre.com/items/" + itemId);
            request.addHeader("accept", "application/json");

            // Ejecutar solicitud HTTP
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    String responseBody = EntityUtils.toString(response.getEntity());
                    ItemsResponse itemsResponse = objectMapper.readValue(responseBody, ItemsResponse.class);
                    return itemsResponse.getPrice();
                } else {
                    // Manejar caso de respuesta no exitosa
                    return null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}