package com.api.rest.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.rest.book.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upload-file")
	public String uploadFile(@RequestParam("file") MultipartFile file )
	{
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
		try {
		if(file.isEmpty())
		{
			return "request must contain file";
		}
		
		//
		if(!file.getContentType().equals("image/png"))
		{
			return "only png are allowed";
		}
		
		//file upload code
		boolean f = fileUploadHelper.uploadFile(file);
		if(f) {
			return ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString();
		}
		}catch (Exception e) {
		}
		
		return "serverError" ;
	}
}
