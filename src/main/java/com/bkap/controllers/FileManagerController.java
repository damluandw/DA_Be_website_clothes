package com.bkap.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bkap.services.FileStorageService;
import com.bkap.util.FileResponse;


@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class FileManagerController {
	@Autowired
	private FileStorageService fileService;
	
	@PostMapping(value = "/user/filemanager/upload")
	public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {
		String fileName = fileService.storeFile(file);
		String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath() // localhost:1111
				.path("/api/user/filemanager/view/") // localhost:1111/api/user/filemanager/view/
				.path(fileName) // localhost:1111/api/user/filemanager/view/anbc.jpg
				.toUriString();
		return new FileResponse(fileName, fileUri, file.getContentType(), file.getSize());
	}
	
	@PostMapping(value = "/user/filemanager/uploads")
	public List<FileResponse> uploadFiles(@RequestParam("files") MultipartFile[] files) {
		return Arrays.asList(files)
				.stream()
				.map(file -> uploadFile(file))
				.collect(Collectors.toList());
	}
	@GetMapping(value = "/user/filemanager/view/{fileName:.+}")
	public ResponseEntity<?> viewFile(@PathVariable String fileName, HttpServletRequest request) {
		Resource resource = fileService.loadFileAsResource(fileName);
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (contentType == null)
			contentType = "application/octet-stream";
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
}
