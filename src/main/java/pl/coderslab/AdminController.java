package pl.coderslab;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.drink.Drink;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @GetMapping("/about")
    @ResponseBody
    public String about() {
        return "Here you can find some details for logged users";
    }



    @ResponseBody
    @GetMapping("/info")
    public String userInfo(@AuthenticationPrincipal CurrentUser customUser) {
        Drink drink = new Drink();
        drink.setName("Super drink");
        drink.setUser(customUser.getUser());
        log.info("customUser getUser {} " , customUser.getUser());
        log.info("customUser class {} " , customUser.getClass());
        return "You are logged as " + customUser;
    }
}
