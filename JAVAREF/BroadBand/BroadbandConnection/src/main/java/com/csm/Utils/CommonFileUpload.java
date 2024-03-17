package com.csm.Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CommonFileUpload {
	public static final String windowsRootFolder = "C:/RegisterFiber/";
	public static final String linuxRootFolder = "/opt/RegisterFiber/";
	public static String operatingSystem = System.getProperty("os.name").toLowerCase().trim();

	//    Check For Folder Is Exists or Not
	public static String fileExistsOrNot(String folderName){
		String filePath = "";
		String result= null;
		if (operatingSystem.contains("windows")){
			filePath = windowsRootFolder + folderName;
		}
		else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.contains("aix")){
			filePath = linuxRootFolder + folderName;
		}

		//Checking Root Directory is Present or Not
		File file = new File("C:/RegisterFiber");
		if (!file.exists()){
			Scanner scanner = new Scanner(System.in);
			System.out.println("Root Directory is not Present. Please Create Root Directory\n" +
				   "Press Y to Create Root Directory\n");

			char response = scanner.next().charAt(0);
			if (Character.toUpperCase(response) == 'Y'){
				boolean checkCreated = file.mkdir();
				if (checkCreated){
					File file1 = new File(filePath);
					if (!file1.exists()){
						boolean checkCreated1 = file1.mkdir();
						if (checkCreated1){
							result = "Success";
							return filePath + "/";
						}
						else {
							result = "Failed";
							return filePath + "/";
						}
					}
				}
			}
			else{
				result = "Failed";
			}
		}
		else{
			File file1 = new File(filePath);
			if (!file1.exists()){
				boolean checkCreated2 = file1.mkdir();
				if (checkCreated2){
					result = "Success";
					return filePath + "/";
				}
				else {
					result = "Failed";
					return filePath + "/";
				}
			}
		}
		return filePath;
	}

	//    Upload Single File into Local Folder
	public static String singleFileUplaod(MultipartFile file, String fileName) throws IOException {
		String fileFlag = "";
		if (file.isEmpty()){
			fileFlag = "FileEmpty";
		}
		else {
			String folderPath = fileExistsOrNot(fileName);
			byte[] bytes =file.getBytes();
			Path path =Paths.get(folderPath + "/" + file.getOriginalFilename());
			Files.write(path, bytes);
			fileFlag = folderPath +"/"+ file.getOriginalFilename();
		}
		return fileFlag.replace(windowsRootFolder, "");
	}



	public static String getDocumentPath(String filePath){
		String docPath = "";
		if (operatingSystem.indexOf("win") >= 0) {
			docPath = windowsRootFolder+filePath;
			System.out.println("Document Path : " + docPath);
		}
		else if (operatingSystem.indexOf("nix") >= 0 || operatingSystem.indexOf("nux") >= 0 || operatingSystem.indexOf("aix") > 0 ) {
			docPath = linuxRootFolder+filePath;
			System.out.println("Document Path : " + docPath);
		}
		return docPath;
	}



	public static void downloadFile(HttpServletResponse response, String filePath) throws IOException {

		File file= new File(CommonFileUpload.getDocumentPath(filePath));
		if(!file.exists()){
			String errorMessage = "Sorry. The File You Are Looking For Doesn't Exists!";
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}
		String mimeType= URLConnection.guessContentTypeFromName(file.getName());
		if(mimeType==null){
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() +"\""));//For Downloading
//        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));//For Opeing in Chrome
		response.setContentLength((int)file.length());
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
}
