package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;

    public AdminController(InstitutionRepository institutionRepository, DonationRepository donationRepository, CategoryRepository categoryRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("")
    public String adminPage(Model model) {
        return "admin";
    }

    @GetMapping("/institutions")
    public String institutionsCrud(Model model) {
        return "institutions";
    }

    @GetMapping("/users")
    public String usersCrud(Model model) {
        return "users";
    }

    @GetMapping("/admins")
    public String adminsCrud(Model model) {
        return "admins";
    }
}
