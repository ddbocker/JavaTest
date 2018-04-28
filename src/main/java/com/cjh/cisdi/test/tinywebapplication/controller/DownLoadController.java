package com.cjh.cisdi.test.tinywebapplication.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjh.cisdi.test.tinywebapplication.service.DataService;

@Controller
public class DownLoadController {
	@Autowired
	DataService dataService;
	
	/**
	 * 文件下载
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping("/download")
	public String downloadFile(@RequestParam("fileId") Integer fileId,HttpServletResponse response) {
		dataService.fileDownLoad(fileId, response);
		return null;
	}

	/**
	 * 断点下载
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/downloadbreak")
	public String downloadFileBreak(@RequestParam("fileId") Integer fileId,HttpServletResponse response) {
		dataService.fileDownLoadBreak(fileId, response);
		return null;
	}
}