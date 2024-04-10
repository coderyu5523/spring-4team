package shop.mtcoding.blog.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService ;
    private final HttpSession session ;

    @GetMapping("/join-form")
    public String joinForm() {
        return "user/join-form";
    }

    @PostMapping("/join")
    public String join(UserRequest.SaveDTO requestDTO){
        userService.save(requestDTO);
        return "redirect:/login-form";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        return "user/login-form";
    }

    @PostMapping("/login")
    public String login(UserRequest.LoginDTO requestDTO){
       User user = userService.login(requestDTO);
       session.setAttribute("sessionUser",user);
        return "redirect:/";
    }

    @GetMapping("/user/update-form")
    public String updateForm(HttpServletRequest request) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        User user = userService.findById(sessionUser.getId());
        request.setAttribute("user",user);
        return "user/update-form";
    }

    @PostMapping("/user/update")
    public String update(UserRequest.UpdateDTO requestDTO){
        User sessionUser = (User) session.getAttribute("sessionUser");
        userService.update(requestDTO,sessionUser.getId());
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
