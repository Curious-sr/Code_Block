package com.csmtech.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import com.csmtech.model.HousingDetails;
import com.csmtech.model.HousingProject;
import com.csmtech.model.HousingProperty;
import com.csmtech.service.HousingDetailsService;
import com.csmtech.service.HousingProjectService;
import com.csmtech.service.HousingPropertyService;

@RequestMapping("/board")
@Controller
public class MyController {

	@Autowired
	private HousingProjectService housingProjectService;
	
	@Autowired
	private HousingPropertyService housingPropertyService;
	
	@Autowired
	private HousingDetailsService housingDetailsService;
	
	@GetMapping("/housing")
	public String getProjects(Model model) {
		model.addAttribute("allProjectList", housingProjectService.getAllProjects());
		model.addAttribute("allBookingList",housingDetailsService.getAllBooking());
	
		return "housingBooking";
	}
	
	
	@GetMapping("/getPropertyByProjectId")
	public void getProperty(@RequestParam("pId") Long pId, Model model, HttpServletResponse resp) throws IOException {
		PrintWriter pw = resp.getWriter();
		System.out.println(pId);
		List<HousingProperty> propertyList = housingPropertyService.allPropertyList(pId);
		System.out.println("++++++++++++++++"+propertyList);
		String t = "";
		t+="<option value='"+0+"'>"+"--select--"+"</option>";
		for (HousingProperty x : propertyList) {
			t += "<option value='" + x.gethId() + "'>" + x.gethName() + "</option>";
		}
		pw.print(t);
		
	}
	@GetMapping("/getCostByPropertyId")
	public void getPropertyCost(@RequestParam("cId") Long cId, Model model, HttpServletResponse resp) throws IOException {
		System.out.println(cId);
		Double housingCost=housingPropertyService.getCostByCid(cId);
		PrintWriter pw = resp.getWriter();
		pw.print(housingCost);
		
	}
	
	@PostMapping("/saveDetails")
	public String saveHousingDetails(@RequestParam(value="hdId" , required = false) Long hdId,
			                    @RequestParam("applicantName") String name,
								@RequestParam("hName") HousingProperty propertyid,
			                  	@RequestParam("email") String email,
			                  	@RequestParam("mobileNo") Long mobileNo,
			                  	@RequestParam("dob") String dateOfBirth,
			                  	@RequestParam("gender") String gender,
									@RequestParam("idProof") MultipartFile userImage) {
										
		File file = new File("E:/MyFile/"+userImage.getOriginalFilename());
		BufferedOutputStream bf= null;
		 
		try {
		
			byte[] bytes = userImage.getBytes();
			bf=new BufferedOutputStream(new FileOutputStream(file));
			bf.write(bytes);
			bf.close();
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		HousingDetails housingDetails= new HousingDetails();
		if(hdId != null)
		housingDetails.setHdId(hdId);
		housingDetails.setApplicantName(name);
		housingDetails.setEmail(email);
		housingDetails.setMobileNo(mobileNo);
		housingDetails.setHousingProperty(propertyid);
		Date date = null;
		try {
			date=new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		Date today=new Date();
		Long age=(long) (today.getYear()-date.getYear());
		if(today.getMonth()<date.getMonth()) {
			age=age-1;
		}
		System.out.println(age);
		housingDetails.setAge(age);
		housingDetails.setDob(date);
		housingDetails.setGender(gender);
		housingDetails.setIdProof("E:/MyFile/"+userImage.getOriginalFilename());
		housingDetails.setHousingProperty(propertyid);
		housingDetails.setIsDelete("No");
		System.out.println(housingDetails);
		
		housingDetailsService.saveAllBookingDetails(housingDetails);
		
		
		return "redirect:./housing";
		
	}
	
	/*
	 * @GetMapping("/showAllBooking") public String allBookingList(Model model) {
	 * model.addAttribute("allBookingList",housingDetailsService.getAllBooking());
	 * return "redirect:./housing"; }
	 */
	
	@GetMapping("/deleteBooking")
	public String deleteHousingBooking(@RequestParam("hdId") Long hdId) {
		housingDetailsService.deleteBookingById(hdId);
		return "redirect:./housing";
	}
}

