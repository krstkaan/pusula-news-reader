package com.example.newsreaderdemo.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class XMLcontroller {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final XmlMapper xmlMapper;

    @Autowired
    public XMLcontroller(RestTemplate restTemplate, ObjectMapper objectMapper, XmlMapper xmlMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.xmlMapper = xmlMapper;
    }


    @GetMapping("/jsonToXml")
    public String convertJsonToXml() {
        String jsonUrl = "https://www.ntv.com.tr/gundem.rss";
        String xmlUrl = null;

        // Get JSON response from the API
        String jsonResponse = restTemplate.getForObject(jsonUrl, String.class);

        try {
            // Parse JSON response
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);

            // Extract XML URL from JSON
            if (jsonNode.has("xmlUrl")) {
                xmlUrl = jsonNode.get("xmlUrl").asText();
            }

            if (xmlUrl != null) {
                // Fetch XML data
                String xmlResponse = restTemplate.getForObject(xmlUrl, String.class);

                // Convert XML to JSON
                JsonNode xmlNode = xmlMapper.readTree(xmlResponse);

                // Convert JSON to XML string
                return xmlMapper.writeValueAsString(xmlNode);
            } else {
                return "XML URL not found in JSON response.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }
}
