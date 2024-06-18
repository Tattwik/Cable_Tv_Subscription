package tech.csm.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.csm.model.RegistrationDetails;
import tech.csm.model.Subscription;
import tech.csm.service.ProviderService;
import tech.csm.service.RegistrationDetailsService;
import tech.csm.util.FileDownloadUtil;
import tech.csm.util.FileUploadUtil;

@Controller
public class CableTvController {

	@Autowired
	private ProviderService providerService;

	@Autowired
	private RegistrationDetailsService registrationDetailsService;

	@GetMapping("/getform")
	public String getForm(Model model) {

		model.addAttribute("providerList", providerService.getAllProviders());
		model.addAttribute("regdList", registrationDetailsService.getAllRegistrationDetails());
		return "cable_regd_form";
	}

	@GetMapping("/getSubscriptionByProviderId")
	public void getSubscriptionByProviderId(@RequestParam("providerId") Integer providerId,
			HttpServletResponse response) {
		List<Subscription> subscriptionList = providerService.getProviderById(providerId).getSubscriptions();
		String res = "<option value='0'>-select-</option>";
		for (Subscription s : subscriptionList) {
			res += "<option value='" + s.getSubscriptionId() + "'>" + s.getSubscriptionType() + "</option>";
		}
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@PostMapping("/register")
	public String saveRegistrion(@ModelAttribute RegistrationDetails registrationDetails) {
		registrationDetails.setIsDelete("NO");
		registrationDetails.setImagePath(FileUploadUtil.uploadFile(registrationDetails.getIPath()));

		registrationDetailsService.saveRegistration(registrationDetails);

		return "redirect:./getform";

	}

	@GetMapping("/downloadFile")
	public void downloadFile(HttpServletRequest req, HttpServletResponse resp)
			throws FileNotFoundException, IOException {

		FileDownloadUtil.downloadFile(req, resp);
	}

	@GetMapping("/providerFilter")
	public String providerFilter(Model model, @RequestParam("filterProvider") Integer pId) {
		model.addAttribute("providerList", providerService.getAllProviders());
		model.addAttribute("regdList", registrationDetailsService.getAllRegistrationByProviderId(pId));
		return "cable_regd_form";
	}

	@GetMapping("/deleteRegistraion")
	public String deleteRegistrion(@RequestParam("regdId") Integer regdId) {

		registrationDetailsService.deleteRegistraion(regdId);

		return "redirect:/getform";
	}

	@GetMapping("/updateRegistraion")
	public String updateRegistration(Model model, @RequestParam("regdId") Integer regdId) {
		model.addAttribute("providerList", providerService.getAllProviders());
		model.addAttribute("regdList", registrationDetailsService.getAllRegistrationDetails());
		model.addAttribute("rege", registrationDetailsService.getRegistraionById(regdId));

		model.addAttribute("selectedSbuList",
				providerService
						.getProviderById(
								registrationDetailsService.getRegistraionById(regdId).getProvider().getProviderId())
						.getSubscriptions());
		return "cable_regd_form";

	}

}
