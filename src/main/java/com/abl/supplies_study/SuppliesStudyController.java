package com.abl.supplies_study;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplies")
public class SuppliesStudyController {

	@GetMapping("/{fileName}")
    public ResponseEntity<InputStreamResource> descargarPDFs(@PathVariable String fileName) throws IOException {
		String directory = "src/main/java/com/abl/supplies_study/";

		
		File document = new File(directory + fileName + ".pdf");
		
		if (!document.exists()) {
            return ResponseEntity.notFound().build();
        }
		
		// Configurar el encabezado de la respuesta
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + fileName + ".pdf");
        
        // Crear el flujo de entrada para el archivo PDF
        FileInputStream inputStream = new FileInputStream(document);
        InputStreamResource inputResource = new InputStreamResource(inputStream);
        
     // Retornar la respuesta con el archivo PDF y el encabezado configurado
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(inputResource);
    }
}
