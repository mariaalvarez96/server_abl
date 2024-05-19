package com.abl.documents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
public class DocumentController {

	@GetMapping("/{fileName}")
	public ResponseEntity<InputStreamResource> descargarPDF(@PathVariable String fileName) throws IOException {
		String directory = "src/main/java/com/abl/documents/";

		File document = new File(directory + fileName + ".pdf");

		if (!document.exists()) {
			return ResponseEntity.notFound().build();
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=" + fileName + ".pdf");

		FileInputStream inputStream = new FileInputStream(document);
		InputStreamResource inputResource = new InputStreamResource(inputStream);

		long fileSize = document.length();
		headers.setContentLength(fileSize);

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(inputResource);
	}
}
