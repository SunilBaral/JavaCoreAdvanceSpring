package com.smart.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smart.dao.ContactRepository;
import com.smart.dao.UserRepository;
import com.smart.entities.Contact;
import com.smart.entities.User;
import com.smart.helper.Message;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ContactRepository contactRepository;
	
	

	@ModelAttribute // har bar chal jayega
	public void addCommonData(Model model, Principal principal) {

		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		model.addAttribute("user", user);
	}

	@RequestMapping("/index")
	public String dashboard(Model model, Principal principal) {
		model.addAttribute("title", "User dashboard");

		return "normal/user_dashboard";
	}

	@GetMapping("/add-contact")
	public String OpenAddContactForm(Model model) {
		model.addAttribute("title", "Add Contact");
		model.addAttribute("contact", new Contact());
		return "normal/add_contact_form";
	}

	// processing add contact form
	@PostMapping("/process-contact")
	public String processContact(@ModelAttribute Contact contact, @RequestParam("profileImage") MultipartFile file,
			Principal principal, HttpSession session) {

		try {

			String name = principal.getName();
			User user = this.userRepository.getUserByUserName(name);

			// processing and uploading file..

			if (file.isEmpty()) {
				// if the file is empty then try our message
				System.out.println("File is empty");
				contact.setImage("contact.png");

			} else {
				// file the file to folder and update the name to contact
				contact.setImage(file.getOriginalFilename());

				File saveFile = new ClassPathResource("static/img/").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				System.out.println("Image is uploaded");

			}

			user.getContacts().add(contact);

			contact.setUser(user);

			this.userRepository.save(user);

			System.out.println("DATA " + contact);

			System.out.println("Added to data base");

			// message success.......
			session.setAttribute("message", new Message("Your contact is added !! Add more..", "success"));

		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
			e.printStackTrace();
			// message error
			session.setAttribute("message", new Message("Some went wrong !! Try again..", "danger"));

		}

		return "normal/add_contact_form";
	}

	@GetMapping("/show-contacts/{page}")
	public String showContacts(@PathVariable("page") Integer page, Model m, Principal principal) {
		m.addAttribute("title", "Show user Contacts");

		String userName = principal.getName();
		User user = this.userRepository.getUserByUserName(userName);

		Pageable pageable = PageRequest.of(page, 5);
		Page<Contact> contacts = this.contactRepository.findContactsByUser(user.getId(), pageable);

		m.addAttribute("contacts", contacts);
		m.addAttribute("currentPage", page);
		m.addAttribute("totalPages", contacts.getTotalPages());

		return "normal/show_contacts";
	}

	@GetMapping("/{cId}/contact")
	public String showContactDetails(@PathVariable("cId") Integer cId, Model model, Principal principal) {

		Optional<Contact> contactOptional = this.contactRepository.findById(cId);
		Contact contact = contactOptional.get();

		String userName = principal.getName();
		User user = this.userRepository.getUserByUserName(userName);

		if (user.getId() == contact.getUser().getId())
			model.addAttribute("contact", contact);

		return "normal/contact_detail";
	}

	@GetMapping("/delete/{cid}")
	public String deleteContact(@PathVariable("cid") Integer cId, HttpSession session) {
		Optional<Contact> findById = this.contactRepository.findById(cId);
		Contact contact = findById.get();
		this.contactRepository.delete(contact);

		session.setAttribute("message", new Message("Contact Deleted sucessfully", "success"));

		return "redirect:/user/show-contacts/0";
	}

	@PostMapping("/update-contact/{cid}")
	public String updateForm(@PathVariable("cid") Integer cid, Model m) {
		m.addAttribute("title", "Update Contact");

		Contact contact = this.contactRepository.findById(cid).get();
		m.addAttribute("contact", contact);
		return "normal/update_form";
	}

	@PostMapping("/process-update")
	public String updateHandler(@ModelAttribute Contact contact, @RequestParam("profileImage") MultipartFile file,
			Model m, HttpSession session, Principal principal) {
		// oldcontact detail
		Contact contact2 = this.contactRepository.findById(contact.getcId()).get();
		try {
			if (!file.isEmpty()) {
				// delete old photo
				File deleteFile = new ClassPathResource("static/img/").getFile();
				File file1 = new File(deleteFile, contact2.getImage());
				file1.delete();

				// update new photo
				contact.setImage(file.getOriginalFilename());

				File saveFile = new ClassPathResource("static/img/").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			} else {
				contact.setImage(contact2.getImage());
			}

			User user = this.userRepository.getUserByUserName(principal.getName());
			contact.setUser(user);
			this.contactRepository.save(contact);
			session.setAttribute("message", new Message("Your Contact is updated", "success"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(contact.getName());
		System.out.println(contact.getcId());
		return "redirect:/user/" + contact.getcId() + "/contact";
	}

	// your profile
	@GetMapping("/profile")
	public String YourProfile(Model model) {

		model.addAttribute("title", "Profile Page");
		return "normal/profile";
	}
	
	// open settings handler
		@GetMapping("/settings")
		public String openSettings() {
			return "normal/settings";
		}

	// change password..handler
	@PostMapping("/change-password")
	public String changePassword(@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword, Principal principal, HttpSession session) {
		System.out.println("OLD PASSWORD " + oldPassword);
		System.out.println("NEW PASSWORD " + newPassword);

		String userName = principal.getName();
		User currentUser = this.userRepository.getUserByUserName(userName);
		System.out.println(currentUser.getPassword());

		if (this.bCryptPasswordEncoder.matches(oldPassword, currentUser.getPassword())) {
			// change the password

			currentUser.setPassword(this.bCryptPasswordEncoder.encode(newPassword));
			this.userRepository.save(currentUser);
			session.setAttribute("message", new Message("Your password is successfully changed..", "success"));

		} else {
			// error...
			session.setAttribute("message", new Message("Please Enter correct old password !!", "danger"));
			return "redirect:/user/settings";
		}

		return "redirect:/user/index";
	}

}
