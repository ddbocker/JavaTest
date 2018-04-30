package com.cjh.cisdi.test.tinywebapplication.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.service.DataService;

/**
 * 数据控制器
 * @author cjh
 *
 */
@Controller
public class DataController {
	@Autowired
	DataService dataService;
	
	@GetMapping("/")
	public String defaultPage(Model model) {
	    return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		List<DataFile> dataFiles = dataService.getDataFiles();
		if(CollectionUtils.isNotEmpty(dataFiles)) {
			model.addAttribute("fileList", dataFiles);
		}
	    return "index";
	}
	
	@GetMapping("/deletefile")
	public String deleteFile(@RequestParam("fileId") Integer fileId) {
		dataService.deleteFile(fileId);
		return "redirect:/index";
	}
	
}
