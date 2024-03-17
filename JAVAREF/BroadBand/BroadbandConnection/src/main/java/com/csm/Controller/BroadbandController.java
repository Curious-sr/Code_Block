package com.csm.Controller;

import com.csm.Model.ConnectionMaster;
import com.csm.Model.ProviderMaster;
import com.csm.Model.RegistrationDetails;
import com.csm.Repository.ConnectionMasterRepository;
import com.csm.Repository.RegistrationDetailsRepository;
import com.csm.Repository.providerMasterRepository;
import com.csm.Utils.AgeCalculator;
import com.csm.Utils.CommonFileUpload;
import com.csm.Utils.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
public class BroadbandController {

	@Autowired
	private providerMasterRepository providerMasterRepository;
	@Autowired
	private ConnectionMasterRepository connectionMasterRepository;
	@Autowired
	private RegistrationDetailsRepository registrationDetailsRepository;


	@GetMapping(value = "/addBroadbandRegistration")
	public String addBroadbandRegistration(Model model) {
		System.out.println("Inside Add Broadband Registration--------->>");
		List<ProviderMaster> providerMasterList = providerMasterRepository.findAll();
		List<RegistrationDetails> registrationDetailsList = registrationDetailsRepository.findAll();
		model.addAttribute("providerMasterList", providerMasterList);
		model.addAttribute("registrationDetailsList", registrationDetailsList);
		return "addBroadbandRegistration";
	}

	@PostMapping(value = "/addBroadbandRegistration")
	public String saveBroadbandRegistration(RegistrationDetails registrationDetails,
	                                        @RequestParam(value = "providerId", required = false)Integer providerId,
	                                        @RequestParam(value = "connectionSpeed", required = false)String connectionSpeed,
									@RequestParam(value = "idProof", required = false) MultipartFile idProof,
	                                        @RequestParam(value = "regId", required = false)Integer regId) {
		try {
			if (regId == null || regId == 0){
				System.out.println("Inside Save Broadband Registration--------->>");
				System.out.println("Registration Details--------->>"+registrationDetails);
				System.out.println("Provider Id--------->>"+providerId);
				System.out.println("Connection Speed--------->>"+connectionSpeed);

				System.out.println("Registration Id--------->>"+regId);
				ProviderMaster providerMaster = providerMasterRepository.getProviderMasterByProviderId(providerId);
				System.out.println("Provider Master--------->>"+providerMaster);
				ConnectionMaster connectionMaster = new ConnectionMaster();
				connectionMaster.setConnectionSpeed(connectionSpeed);
				connectionMaster.setProviderMaster(providerMaster);
				connectionMaster.setFee((double) (Integer.parseInt(connectionSpeed) * 2));
				connectionMasterRepository.save(connectionMaster);
				registrationDetails.setConnectionMaster(connectionMaster);
				registrationDetails.setProviderMaster(providerMaster);
				registrationDetails.setImageName(idProof.getOriginalFilename());
				String path = CommonFileUpload.singleFileUplaod(idProof, "idProof");
				System.out.println("Path--------->>"+path);

				LocalDate dob = registrationDetails.getDateOfBirth().toLocalDate();
				int age = AgeCalculator.calculateAge(dob, LocalDate.now());

				System.out.println("Age--------->>"+age);
				registrationDetails.setImagePath(path);
				registrationDetails.setAge(age);
				System.out.println("Registration Details Before Save--------->>"+registrationDetails);

				registrationDetailsRepository.save(registrationDetails);
				Mail.sendEmailGmailTLS(registrationDetails.getMailId());
			}else {
				System.out.println("Inside Update Broadband Registration--------->>");
				System.out.println("Registration Details--------->>"+registrationDetails);
				System.out.println("Provider Id--------->>"+providerId);
				System.out.println("Connection Speed--------->>"+connectionSpeed);
				int age = AgeCalculator.calculateAge(registrationDetails.getDateOfBirth().toLocalDate(), LocalDate.now());
				registrationDetails.setAge(age);
				String imagePath = CommonFileUpload.singleFileUplaod(idProof, "idProof");
				registrationDetails.setImagePath(imagePath);
				registrationDetails.setImageName(idProof.getOriginalFilename());

				ProviderMaster providerMaster = providerMasterRepository.getProviderMasterByProviderId(providerId);
				System.out.println("Provider Master--------->>"+providerMaster);
				ConnectionMaster connectionMaster = new ConnectionMaster();
				connectionMaster.setConnectionSpeed(connectionSpeed);
				connectionMaster.setProviderMaster(providerMaster);
				connectionMaster.setFee((double) (Integer.parseInt(connectionSpeed) * 2));
				connectionMasterRepository.save(connectionMaster);

				registrationDetails.setProviderMaster(providerMaster);
				registrationDetails.setConnectionMaster(connectionMaster);

				registrationDetails.setRegistrationId(regId);

				registrationDetailsRepository.save(registrationDetails);
				System.out.println("Registration Details--------->>"+registrationDetails);
				System.out.println("Data Updated Successfully--------->>");
				Mail.sendEmailGmailTLS(registrationDetails.getMailId());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return "redirect:/addBroadbandRegistration";
	}

	@GetMapping(value = "/downloadFile/{registrationId}")
	public void downloadFile(@PathVariable("registrationId") Integer registrationId, HttpServletResponse response) throws IOException {
		System.out.println("Inside Download File--------->>");
		RegistrationDetails registrationDetails = registrationDetailsRepository.getRegistrationDetailsByRegistrationId(registrationId);
		CommonFileUpload.downloadFile(response, registrationDetails.getImagePath());
	}

	@GetMapping(value = "/editBroadbandRegistration/{registrationId}")
	public String editBroadbandRegistration(@PathVariable("registrationId") Integer registrationId, Model model) {
		System.out.println("Inside Edit Broadband Registration--------->>");
		RegistrationDetails registrationDetails = registrationDetailsRepository.getRegistrationDetailsByRegistrationId(registrationId);
		List<ProviderMaster> providerMasterList = providerMasterRepository.findAll();
		List<RegistrationDetails> registrationDetailsList = registrationDetailsRepository.findAll();
		model.addAttribute("providerMasterList", providerMasterList);
		model.addAttribute("registrationDetailsList", registrationDetailsList);
		model.addAttribute("registrationDetails", registrationDetails);
		return "addBroadbandRegistration";
	}

//	@GetMapping(value = "/insertData")
//	public String insertData(){
//		ProviderMaster providerMaster = providerMasterRepository.getProviderMasterByProviderId(1);
//		List<ConnectionMaster> connectionMasterList = new ArrayList<>();
//		ConnectionMaster connectionMaster = new ConnectionMaster();
//		connectionMaster.setConnectionSpeed("10");
//		connectionMaster.setFee(20.0);
//		connectionMaster.setProviderMaster(providerMaster);
//
//		ConnectionMaster connectionMaster1 = new ConnectionMaster();
//		connectionMaster1.setConnectionSpeed("20");
//		connectionMaster1.setFee(40.0);
//		connectionMaster1.setProviderMaster(providerMaster);
//
//		ConnectionMaster connectionMaster2 = new ConnectionMaster();
//		connectionMaster2.setConnectionSpeed("30");
//		connectionMaster2.setFee(60.0);
//		connectionMaster2.setProviderMaster(providerMaster);
//
//		connectionMasterList.add(connectionMaster);
//		connectionMasterList.add(connectionMaster1);
//		connectionMasterList.add(connectionMaster2);
//
//		connectionMasterRepository.saveAll(connectionMasterList);
//
//		providerMaster.setConnectionMasterList(connectionMasterList);
//		providerMasterRepository.save(providerMaster);
//
//
//		ProviderMaster providerMaster1 = providerMasterRepository.getProviderMasterByProviderId(2);
//		List<ConnectionMaster> connectionMasterList1 = new ArrayList<>();
//		ConnectionMaster connectionMaster3 = new ConnectionMaster();
//		connectionMaster3.setConnectionSpeed("50");
//		connectionMaster3.setFee(100.0);
//		connectionMaster3.setProviderMaster(providerMaster1);
//
//
//		ConnectionMaster connectionMaster4 = new ConnectionMaster();
//		connectionMaster4.setConnectionSpeed("100");
//		connectionMaster4.setFee(200.0);
//		connectionMaster4.setProviderMaster(providerMaster1);
//
//		connectionMasterList1.add(connectionMaster3);
//		connectionMasterList1.add(connectionMaster4);
//
//		connectionMasterRepository.saveAll(connectionMasterList1);
//
//		providerMaster1.setConnectionMasterList(connectionMasterList1);
//
//		providerMasterRepository.save(providerMaster1);
//
//
//
//		return null;
//	}
}
