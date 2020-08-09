package springmvcsearch;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping("/fileForm")
	public String showUploadForm() {
		String str = null;
		System.out.println(str.charAt(0));
		return "fileForm";
	}
	
	@RequestMapping(value = "/uploadimage", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("profile") CommonsMultipartFile file,HttpSession s, Model m) {
		System.out.println("upload file");
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getStorageDescription());
		System.out.println(file.getOriginalFilename());
		try {
			String path = s.getServletContext().getRealPath("/")+"resources"+File.separator+"images"+File.separator+file.getOriginalFilename();
			System.out.println(path);
			byte[] data = file.getBytes();
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
			m.addAttribute("msg", "uploaded succesfully");
			m.addAttribute("filename", file.getOriginalFilename());
		}
		catch(IOException e) {
			e.printStackTrace();
			m.addAttribute("msg", "something went wrong");
		}
		return "fileSuccess";
	}
	

}
