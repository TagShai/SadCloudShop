package org.mannayakasha.controller.web;

import org.mannayakasha.entity.Product;
import org.mannayakasha.entity.Role;
import org.mannayakasha.entity.User;
import org.mannayakasha.service.interfaces.IProductService;
import org.mannayakasha.service.interfaces.IRoleService;
import org.mannayakasha.service.interfaces.IUserService;
import org.mannayakasha.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Home Controller
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017
 */

@Controller
public class HomeController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("products", productService.getAll());

        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model) {

        model.addAttribute("products", productService.getAll());

        return "index";
    }

    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout) {

        if (isCurrentAuthenticationAnonymous()) {
            if (error != null) {
                model.addAttribute("error", "Username or password is incorrect.");
            }

            if (logout != null) {
                model.addAttribute("message", "Logged out successfully.");
            }

            return "login";
        } else {
            return "redirect:/";
        }
    }

    /**
     *
     * @return true if users is already authenticated [logged-in], else false.
     */
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }

    @GetMapping("/userpage")
    public String userPage() { return "user"; }

    @GetMapping("/adminpage")
    public String adminPage() { return "admin"; }

    @GetMapping("/403")
    public String error403() { return "/error/403"; }

    @GetMapping("/registration")
    public String signUp(Model model) {
        User user = new User();

        model.addAttribute("user" , user);

        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/registration";
        }

        userService.create(userForm);

        //securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/login";
    }



/*    @PostMapping("/registration")
    public String signUpPost(@ModelAttribute("user") User user, Model model) {

        if(userService.userExists(user.getUsername(), user.getEmail())) {

            if (userService.checkEmailExists(user.getEmail())) {
                model.addAttribute("emailExists", true);
            }

            if (userService.checkUsernameExists(user.getUsername())) {
                model.addAttribute("usernameExists", true);
            }

            return "signup";
        } else {
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));

            userService.createUser(user, userRoles);

            return "redirect:/";
        }
    }*/

/*    @PostMapping("/registration")
    public String signUpPost(@ModelAttribute("user") User user, Model model) {

        if(userService.userExists(user.getUsername(), user.getEmail())) {

            if (userService.checkEmailExists(user.getEmail())) {
                model.addAttribute("emailExists", true);
            }

            if (userService.checkUsernameExists(user.getUsername())) {
                model.addAttribute("usernameExists", true);
            }

            return "signup";
        } else {
            Set<UserRole> userRoles = new HashSet<>();
            userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));

            userService.createUser(user, userRoles);

            return "redirect:/";
        }
    }*/
}
