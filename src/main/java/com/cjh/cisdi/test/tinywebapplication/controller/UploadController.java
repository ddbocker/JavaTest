package com.cjh.cisdi.test.tinywebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cjh.cisdi.test.tinywebapplication.service.DataService;

/**
 * 上传控制器
 * @author cjh
 *
 */
@Controller
public class UploadController {
	@Autowired
	DataService dataService;
	
	@GetMapping("/pageupload")
	public String pageUpload() {
		return "upload";
	}
	
	@PostMapping("/upload") 
	public String fileUpload(@RequestParam("file") MultipartFile file,
	                               RedirectAttributes redirectAttributes) {
	    // 判断上传文件是否为空
		if (file.isEmpty()) {
	        redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	        return "redirect:uploadStatus";
	    }
		
		if(dataService.fileUpload(file)) {
			 redirectAttributes.addFlashAttribute("message",
		                "You successfully uploaded '" + file.getOriginalFilename() + "'");
		}
		 
		return "redirect:/index";
	}
	
	@GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadResult";
    }
}
