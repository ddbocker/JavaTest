package com.cjh.cisdi.test.tinywebapplication.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjh.cisdi.test.tinywebapplication.dao.DataAnalyze;
import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.interceptor.PageInterceptor.Page;
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
	public String defaultPage() {
	    return "redirect:/index";
	}
	
	/**
	 * 文件列表
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String index(Model model) {
		List<DataFile> dataFiles = dataService.getDataFiles();
		if(CollectionUtils.isNotEmpty(dataFiles)) {
			model.addAttribute("fileList", dataFiles);
		}
	    return "index";
	}
	
	/**
	 * 删除服务器源文件
	 * @param fileId
	 * @return
	 */
	@GetMapping("/deletefile")
	public String deleteFile(@RequestParam("fileId") Integer fileId) {
		dataService.deleteFile(fileId);
		return "redirect:/index";
	}
	
	/**
	 * 文件分析结果
	 * @param fileId
	 * @param model
	 * @return
	 */
	@GetMapping("/analyzedata")
	public String fileAnalyzeData(@RequestParam("fileId") Integer fileId, Model model) {
		List<DataAnalyze> dataAnalyzes = dataService.getDataAnalyzes(fileId);
		if(CollectionUtils.isNotEmpty(dataAnalyzes)) {
			model.addAttribute("dataAnalyzes", dataAnalyzes);
		}
		return "analyzeData";
	}
	
	/**
	 * 文件数据详情
	 * @param fileId
	 * @param model
	 * @return
	 */
	@GetMapping("/datalist")
	public String fileDataList(@RequestParam("fileId") Integer fileId, @RequestParam("pageNo") Integer pageNo, Model model) {
		Page<DataRecord> pageResult = dataService.getDataRecordPageResult(fileId, pageNo);
		if(pageResult != null) {
			model.addAttribute("pageNo", pageResult.getPageNum());
			model.addAttribute("pages", pageResult.getPages());
			model.addAttribute("totalSize", pageResult.getTotal());
			model.addAttribute("fileId", fileId);
			if(CollectionUtils.isNotEmpty(pageResult.getResult())) {
				model.addAttribute("dataList", pageResult.getResult());
			}
		}
		return "dataList";
	}
	
}
