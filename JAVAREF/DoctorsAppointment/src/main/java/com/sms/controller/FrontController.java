package com.sms.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.styledxmlparser.css.media.MediaDeviceDescription;
import com.sms.entity.DiseaseMaster;
import com.sms.entity.Doctor_Appointment;
import com.sms.entity.MedicineMaster;
import com.sms.entity.Prescription;
import com.sms.entity.PrescriptionDto;
import com.sms.repository.DiseaseMasterRepository;
import com.sms.repository.DoctorMasterRepository;
import com.sms.repository.Doctor_AppointmentRepository;
import com.sms.repository.MedicineMasterRepository;
import com.sms.repository.PrescriptionRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FrontController {
	@Autowired
	private final DoctorMasterRepository doctorMasterRepository;
	@Autowired
	private final DiseaseMasterRepository diseaseMasterRepository;
	@Autowired
	private final Doctor_AppointmentRepository doctor_AppointmentRepository;
	@Autowired
	private final MedicineMasterRepository medicineMasterRepository;
	@Autowired
	private final PrescriptionRepository prescriptionRepository;
	String data;
	Boolean flag;

	@RequestMapping("/view")
	public String viewPage(Model model) {
		System.out.println(doctorMasterRepository.findAll());
		System.out.println(diseaseMasterRepository.findAll());
		model.addAttribute("doctorList", doctorMasterRepository.findAll());
	
		return "doctor_pen";
	}

	@GetMapping("/getPatientDetails")
	public void getPatientDetails(Model model, @RequestParam("doctorId") Integer doctorId, HttpServletResponse resp)
			throws IOException {
		// Integer doctorIdd=1;
		System.out.println("helloooooooooooooooooooooo");
		PrintWriter pw = resp.getWriter();
		List<Doctor_Appointment> Doctor_AppointmentList = doctor_AppointmentRepository.findPatientDetailsById(doctorId);
		System.out.println(Doctor_AppointmentList);
		data += "<option value='" + 0 + "'>" + "--SELECT--" + "</option>";

		for (Doctor_Appointment bh : Doctor_AppointmentList) {
			data += "<option value='" + bh.getDoctor_Appointment_id() + "'>" + bh.getPatient_Name() + "</option>";

		}

		pw.print(data);
		data = null;

	}

	@GetMapping("/getMedicines")
	public void getMedicines(@RequestParam("diseaseId") Integer diseaseId, HttpServletResponse resp)
			throws IOException {
		// Integer diseaseId=1;
		PrintWriter pw = resp.getWriter();
		List<MedicineMaster> medicineMastersList = medicineMasterRepository.getAllMedicinesByDiseaseId(diseaseId);
		System.out.println(medicineMastersList);
		data += "<option value='" + 0 + "'>" + "--SELECT--" + "</option>";

		for (MedicineMaster bh : medicineMastersList) {
			data += "<option value='" + bh.getMedicine_id() + "'>" + bh.getMedicine_Name() + "</option>";
//			data += "<option value=" + bh.getMedicine_id() + "<c:if test='${prescriptionDto.medicineId eq "+bh.getMedicine_id()+"} selected='selected'</c:if>>" + bh.getMedicine_Name() + "</option>";

		}
		pw.print(data);
		data = null;

	}

	@GetMapping("/getPatientInformation")
	public void getPatientInformation(Model model, @RequestParam("doctorsAppointmentId") Integer doctorsAppointmentId,
			HttpServletResponse resp) throws IOException {
		// Integer doctorsAppointmentId=1;
		PrintWriter pw = resp.getWriter();
		Doctor_Appointment doctorAppointmentDetails = doctor_AppointmentRepository
				.getPatientDetailsByPatientId(doctorsAppointmentId);
		System.out.println(doctorAppointmentDetails);
		if (doctorAppointmentDetails.getPatient_Status() != 'P') {
			data = "\r\n" + "						<tr>\r\n" + "							<td>"
					+ doctorAppointmentDetails.getPatient_Name() + "</td>\r\n" + "							<td>"
					+ doctorAppointmentDetails.getPatient_Phone() + "</td>\r\n" + "							<td>"
					+ doctorAppointmentDetails.getDate_Of_appointment() + "</td>\r\n"

					+ "\r\n";
		} else {
			data = "<center><span>No Data Available for Prescribe<span></center>";
		}
		pw.print(data);
		System.out.println(data);
		data = null;

	}
//	@PostMapping("/save")
//	public String saveData(Model model,@RequestParam("diseaseId") Integer disease_id,@RequestParam("patientId") Integer Doctor_Appointment_id,@RequestParam("doctorId") Integer Doctor_id,@RequestParam("medicineId") Integer medicine_id,@RequestParam("prescriptionDetails") String prescriptionDetails ) {
//		//List<Prescription> prescriptionList= prescriptionRepository.findAll();
//		Prescription prescription2=null;
//		Prescription prescription=new Prescription();
//		DiseaseMaster diseaseMaster=diseaseMasterRepository.findById(disease_id).get();
//		Doctor_Appointment doctor_Appointment=doctor_AppointmentRepository.findById(Doctor_Appointment_id).get();
//		MedicineMaster medicineMaster=medicineMasterRepository.findById(medicine_id).get();
//		prescription.setDiseaseMaster(diseaseMaster);
//		prescription.setDoctor_Appointment(doctor_Appointment);
//		prescription.setMedicineMaster(medicineMaster);
//		prescription.setPrescription(prescriptionDetails);
//		
//		doctor_AppointmentRepository.save(doctor_Appointment);
//		
//		if(doctor_Appointment.getPatient_Status()!='P') {
//			doctor_Appointment.setPatient_Status('P');
//			prescription2= prescriptionRepository.save(prescription);
//			flag=true;
//		
//		//System.out.println(prescriptionList+"---------------");
//		model.addAttribute("msg", flag);
//		model.addAttribute("doctorList", doctorMasterRepository.findAll());
//		model.addAttribute("diseaseList", diseaseMasterRepository.findAll());
//		model.addAttribute("AllDetails", prescriptionRepository.findAll());
//		}else {
//			flag=false;
//			model.addAttribute("AllDetails", prescriptionRepository.findAll());
//			model.addAttribute("msg", flag);
//			model.addAttribute("doctorList", doctorMasterRepository.findAll());
//			model.addAttribute("diseaseList", diseaseMasterRepository.findAll());
//			
//		}
//		
//		return "doctor_pen";
//	}

	@RequestMapping("pdfExporter")
	public void downloadPdf(HttpServletResponse response, @RequestParam("pId") Integer pId, Model model) {
		System.out.println("patientId is " + pId);
		Prescription prescription = prescriptionRepository.findByDoctorAppointmentId(pId);

		try {
			StringBuilder builder = new StringBuilder("");
			builder.append("<div style=\"width:700px ; border:5px solid black;\">\r\n"
					+ "                <div style=\"width:100%; margin-top: 30px; height: 900px;\">\r\n"
					+ "                    <div style=\"float:left; width:20%; margin-left: 20px;\">\r\n"
					+ "                        <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrEmHEW9bS7CkrUbzw6bfWlCXHcQy9nfVmkHGxbF5ys1BU8oLi71rBE42LCtfZctAHFbo&usqp=CAU\"\r\n"
					+ "                            alt=\"imgae\" height=\"110px\">\r\n"
					+ "                    </div>\r\n"
					+ "                    <div style=\"float:left; width:65%;\">\r\n"
					+ "                        <div style=\"font-size: 30px;\"><b>Patient's Medical History</b></div>\r\n"
					+ "                        <div style=\"margin-top: 20px;\">Patient NAME - <i> "
					+ prescription.getDoctor_Appointment().getPatient_Name() + "</i></div>\r\n"
					+ "                        <div style=\"margin-top: 10px;\">Disease Name - <i>"
					+ prescription.getDiseaseMaster().getDisease_Name() + "</i></div>"
					+ "				   		   <div style=\"margin-top: 10px;\"> Medicine Name - <i> "
					+ prescription.getMedicineMaster().getMedicine_Name() + "</i></div>\r\n"
					+ "                         <div style=\"margin-top: 20px;\">Pescription - <i>"
					+ prescription.getPrescription() + "</i></div>\r\n" + "                    </div>\r\n"
					+ "                </div>\r\n" + "\r\n"
					+ "                <div style=\"text-align: center;\" ><p>/**/  END OF REPORT /**/</p></div>\r\n"
					+ "            </div>");
			File f = null;
			f = new File("D:\\my file/upload/");
			if (!f.exists()) {
				f.mkdirs();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(f + "/" + "test" + ".html"));
			bw.write(builder.toString());
			bw.close();

			ConverterProperties properties = new ConverterProperties();

			MediaDeviceDescription description = MediaDeviceDescription.createDefault();

			HtmlConverter.convertToPdf(new File("D:/my file/upload/" + "test" + ".html"),
					new File("D:/my file/upload/" + "test" + ".pdf"), properties);
			// pdf genrated process from html file end
			// here delete the html file from given folder.
			File delFile = new File(f + "/" + "test" + ".html");
			delFile.delete();

			// pdf download process start
			File file = new File("D:/my file/upload/" + File.separator + "test.pdf");
			FileInputStream is = new FileInputStream(file);
			response.setContentType("appplication/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
			OutputStream os = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
			os.flush();
			os.close();
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(encodelValue);
	}

	@PostMapping("/save")
	public String saveData(Model model, @ModelAttribute PrescriptionDto prescriptionDto) {
		System.out.println(prescriptionDto);
		List<Prescription> prescriptionsList= prescriptionRepository.getPresicriptionByDoctorId(prescriptionDto.getDoctorId());
		List<Doctor_Appointment> getPatientDetailsByDoctorId=doctor_AppointmentRepository.getPatientDetailsByDoctorId(prescriptionDto.getDoctorId());
		if (prescriptionDto.getPatientId() == 0) {
			model.addAttribute("prescriptionDetails",
					prescriptionRepository.getPresicriptionByDoctorId(prescriptionDto.getDoctorId()));
			
			model.addAttribute("patientDetails",
					doctor_AppointmentRepository.getPatientDetailsByDoctorId(prescriptionDto.getDoctorId()));
			model.addAttribute("prescriptionDto", prescriptionDto);
			model.addAttribute("diseaseList", diseaseMasterRepository.findAll());
			System.out.println(doctor_AppointmentRepository.getPatientDetailsByDoctorId(prescriptionDto.getDoctorId()));
			return "forward:/view";
		} else {
			Prescription prescription = new Prescription();
			Doctor_Appointment doctor_Appointment = doctor_AppointmentRepository
					.findById(prescriptionDto.getPatientId()).get();
			if (doctor_Appointment.getPatient_Status() != 'P') {
				
				doctor_Appointment.setPatient_Status('P');
				prescription.setDoctor_Appointment(doctor_Appointment);
				prescription
						.setMedicineMaster(medicineMasterRepository.findById(prescriptionDto.getMedicineId()).get());
				prescription.setPrescription(prescriptionDto.getPrescription());
				prescription.setDiseaseMaster(diseaseMasterRepository.findById(prescriptionDto.getDiseaseId()).get());
				
				Prescription save = prescriptionRepository.save(prescription);
				if (save != null) {
					model.addAttribute("msg", 200);
					model.addAttribute("prescriptionDto", new PrescriptionDto());
					model.addAttribute("prescriptionDetails",
							prescriptionRepository.getPresicriptionByDoctorId(prescriptionDto.getDoctorId()));
				}
			} else {
				model.addAttribute("msg", 201);

			}
		}
		return "forward:/view";

	}

}
