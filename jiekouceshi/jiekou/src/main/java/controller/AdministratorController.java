package controller;

import com.wzh.controller.pogo.Administrator;
import com.wzh.controller.pogo.AdministratorGet;
import com.wzh.controller.pogo.AdministratorUpdate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @GetMapping("/login")
    public String login(Administrator administratorLoginInDTO){
        return null;
    }

    @GetMapping("/getProfile")
    public AdministratorGet getProfile(Integer adminstratorId){
        return null;
    }

    @PostMapping("/updateProdfile")
    public void updateProdfile(@RequestBody AdministratorUpdate administratorUpdateProfileInDTO){

    }
}
