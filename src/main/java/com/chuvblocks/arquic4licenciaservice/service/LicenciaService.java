package com.chuvblocks.arquic4licenciaservice.service;

import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@Service
public class LicenciaService {
    private static final Logger log = LoggerFactory.getLogger(LicenciaService.class);
    @Autowired
    private RestTemplate restTemplate;

    public String getApiResponse(String cedula) {
        String url = "https://consultaweb.ant.gob.ec/PortalWEB/paginas/clientes/clp_grid_citaciones.jsp?ps_tipo_identificacion=CED&ps_identificacion=" + cedula;
        String htmlResponse = restTemplate.getForObject(url, String.class);

        // Parse the HTML response
        Document document = Jsoup.parse(htmlResponse);

        // Extract relevant data
        // Example: Extract data from a table with id "list10"
        Element table = document.select("td.titulo1 a").first();
        String extractedData = table.text();

        // Process the extracted data as needed
        return extractedData;
    }
}
