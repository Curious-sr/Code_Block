package com.csmtech.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.csmtech.model.Club;
import com.csmtech.model.Registration;
import com.csmtech.model.Sports;
import com.csmtech.service.ClubService;
import com.csmtech.service.RegistrationService;
import com.csmtech.service.SportsService;

@Controller
public class MyController {

	@Autowired
	private ClubService clubService;
	
	@Autowired
	private SportsService sportsService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("/getRegistration")
	public String getClub(Model model) {
		model.addAttribute("ListClub",clubService.getAllClubs());
		model.addAttribute("allRegistrationList", registrationService.getAllRegistration());
		return "sportsRegistration";
	}
	
	@GetMapping("/getSportsByClubId")
	public void getBranch(@RequestParam("clubId") Integer clubId, Model model, HttpServletResponse resp) throws IOException {
		PrintWriter pw = resp.getWriter();
		System.out.println(clubId);
		List<Sports> sportsList = sportsService.allSportsList(clubId);
		System.out.println("++++++++++++++++"+sportsList);
		String t = "";
		t+="<option value='"+0+"'>"+"--select--"+"</option>";
		for (Sports x : sportsList) {
			t += "<option value='" + x.getSportsId() + "'>"+x.getSportsName() + "</option>";
		}
		pw.print(t);
		//'<c:if test=\"${branch.branchId eq regdd.branch.branchId}\">selected='selected'</c:if>
	}
	
	@GetMapping("/search")
	public String getFilter(@RequestParam("cName") Integer id, Model model) {
		System.out.println("////////////////////"+id);
		model.addAttribute("ListClub", clubService.getAllClubs());

		model.addAttribute("allRegistrationList", registrationService.getAllCollegeByName(id));

		return "sportsRegistration";
	}
	
	@PostMapping("/saveRegistrationDetails")
	public String saveHousingDetails(@RequestParam(value="registrationId" , required = false) Integer registrationId,
								@RequestParam("applicantName") String name,
								@RequestParam("sportsName") Sports sportsId,
								@RequestParam("clubName") Club clubId,
			                  	@RequestParam("emailId") String email,
			                  	@RequestParam("mobileNo") String mobileNo,
			                  	@RequestParam("dob") String dateOfBirth,
			                  	@RequestParam("gender") String gender,
									@RequestParam("imagePath") MultipartFile userImage) {
										
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
		
		Registration registration = new Registration();
		if(registrationId != null)
			registration.setRegistrationId(registrationId);
		registration.setApplicantName(name);
		registration.setSports(sportsId);
		registration.setClub(clubId);
		registration.setEmailId(email);
		registration.setMobileNo(mobileNo);
		try {
			registration.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		registration.setGender(gender);
		registration.setIsDelete("No");
		registration.setImagePath("E:/MyFile/"+userImage.getOriginalFilename());
		
		System.out.println(registration);
		registrationService.saveAllRegistrationDetails(registration);
		
		return "redirect:./getRegistration";
      }
	
	@GetMapping("/deleteRegistration")
    public String deleteRegistrationApplicant(@RequestParam("registrationId") Integer registrationId) {
	registrationService.deleteRegistrationById(registrationId);
	return "redirect:./getRegistration";
     }
	
	@GetMapping(path="/updateRegistration")
	public String updateStudentForm(Model model,@RequestParam("registrationId") Integer registrationId) {
		//model.addAttribute("allStudents", studentService.getAllStudents());
		System.out.println(registrationId);
		model.addAttribute("allRegistrationList", registrationService.getAllRegistration());
		model.addAttribute("regdd",registrationService.updateRegistrationById(registrationId));
		return "forward:/getRegistration";
	}
}
