package com.csmtech.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

import com.csmtech.model.RegistrationDetails;
import com.csmtech.model.SubscriptionMaster;
import com.csmtech.service.LibraryService;
import com.csmtech.service.RegistrationService;
import com.csmtech.service.SubscriptionService;

@Controller
@RequestMapping("/form")
public class FrontController {
	@Autowired
	private LibraryService libraryService;
	@Autowired
	private SubscriptionService subscriptionService;
	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("/getForm")
	public String getForm(Model model) {
		model.addAttribute("AllLibrary", libraryService.getAllLibrary());
		model.addAttribute("AllData",registrationService.getAllData());
		return "index";
	}
	@PostMapping("/save")
	public String saveData(@RequestParam("imagePath") MultipartFile imagePath,
							@RequestParam("libraryId") Integer libraryId,
							@RequestParam("subscriptionId")Integer subscriptionId,
							@RequestParam("applicantName")String applicantName,
							@RequestParam("emailId")String emailId,
							@RequestParam("mobileNo")String mobileNo,
							@RequestParam("dob")Date dob,
							@RequestParam("gender")String gender,
							@RequestParam(value="registrationId",defaultValue= "-1")Integer registrationId) throws ParseException {
		File file=new File("D:/MyFiles/"+imagePath.getOriginalFilename());
		BufferedOutputStream bf=null;
		try {
			byte[] bytes=imagePath.getBytes();
			bf=new BufferedOutputStream(new FileOutputStream(file));
			bf.write(bytes);
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		RegistrationDetails registrationDetails=new RegistrationDetails();
		registrationDetails.setLibrary(libraryService.getById(libraryId));
		registrationDetails.setSubscription(subscriptionService.getById(subscriptionId));
		registrationDetails.setApplicantName(applicantName);
		registrationDetails.setEmailId(emailId);
		registrationDetails.setMobileNo(mobileNo);
		SimpleDateFormat sm=new SimpleDateFormat("yyyy/MM/dd");
		registrationDetails.setDob(sm.format(dob));
		registrationDetails.setGender(gender);
		registrationDetails.setImagePath("D:/MyFiles/"+imagePath.getOriginalFilename());
		registrationService.saveData(registrationDetails);
		
		return "redirect:./getForm";
	}
	@GetMapping("/getSubscriptionByLibraryId")
	public void getSubscriptionByLibraryId(@RequestParam("libraryId")Integer libraryId,HttpServletResponse resp) {
		PrintWriter pw=null;
		try {
			pw = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<SubscriptionMaster> getAllSubsList=subscriptionService.getAllSubscription(libraryId);
		String subscription="";
		for(SubscriptionMaster submaster:getAllSubsList) {
			subscription+="<option value='"+submaster.getSubscriptionId()+"'>"+submaster.getSubscriptionType()+"</option>";
		}
		pw.println(subscription);
	}
	@GetMapping("/get")
	public String getByLibrary(@RequestParam("library")Integer libraryId,Model model) {
		System.out.println(libraryId);
		List<RegistrationDetails> getAllData=registrationService.getAllData();
		List<RegistrationDetails> regDetails=new ArrayList<RegistrationDetails>();
		for(RegistrationDetails rg:getAllData) {
			if(rg.getLibrary().getLibraryId().equals(libraryId))
				regDetails.add(rg);
		}
		model.addAttribute("AllData",regDetails);
		return "index";
	}
}
