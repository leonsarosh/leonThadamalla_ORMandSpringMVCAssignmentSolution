package leon.spring.ormandmvc.customermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import leon.spring.ormandmvc.customermanagement.model.Customer;
import leon.spring.ormandmvc.customermanagement.service.CustomerServiceImpl;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;

	@RequestMapping("/list")
	public String showCustomerList(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "customer-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		model.addAttribute("mode", "Add");
		return "customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(Model model, @RequestParam("customerId") long customerId) {
		Customer customer = customerService.findById(customerId);
		model.addAttribute("customer", customer);
		model.addAttribute("mode", "Update");
		return "customer-form";
	}

	@PostMapping("/save")
	public String save(@RequestParam("customerId") long customerId, @RequestParam("custFirstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("emailAdd") String emailAdd) {
		Customer customer = null;
		if (customerId == 0) {
			if (firstName == "" || lastName == "" || emailAdd == "" || customerService.isLetters(firstName) == false
					|| customerService.isLetters(lastName) == false) {
				return "redirect:showFormForAdd";
			} else {
				customer = new Customer(firstName, lastName, emailAdd);
				customerService.save(customer);
				return "redirect:list";
			}

		} else {
			if (firstName == "" || lastName == "" || emailAdd == "" || customerService.isLetters(firstName) == false
					|| customerService.isLetters(lastName) == false) {
				return "redirect:list";
			} else {
				customer = customerService.findById(customerId);
				customer.setCustFirstName(firstName);
				customer.setLastName(lastName);
				customer.setEmailAdd(emailAdd);
				customerService.save(customer);
				return "redirect:list";
			}
		}
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") long customerId) {
		customerService.delete(customerId);
		return "redirect:list";
	}

}
