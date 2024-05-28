package com.chuvblocks.arquic4licenciaservice.controller;

import com.chuvblocks.arquic4licenciaservice.model.Licencia;
import com.chuvblocks.arquic4licenciaservice.service.LicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LicenciaController {
    @Autowired
    private LicenciaService contribuyenteService;

    @GetMapping("/licencia")
    public ResponseEntity<Licencia> getContribuyente(@RequestParam(value = "cedula") String cedula) {
        try {
            String puntosValue = contribuyenteService.getApiResponse(cedula);
            return new ResponseEntity<>(new Licencia(puntosValue), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
