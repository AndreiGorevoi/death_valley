/*
@author Andrei Gorevoi
*/
package deathvalley.controller;

import deathvalley.model.Account;
import deathvalley.service.AccountService;
import deathvalley.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.OptionalInt;

@Controller
public class MyController {

    private final UserService userService;
    private final AccountService accountService;

    @Autowired
    public MyController(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @GetMapping(value = "/")
    public String getMain(){
        return "rich";
    }

    @GetMapping(value = "rich")
    public String getRichPage(Model model){
        return "rich";
    }

    @GetMapping(value = "richest")
    public String getMostRichest(Model model){
        List<Account> allAccounts = accountService.getAllAccounts();
        int maxValue=0;
        Long idOfRichest=0L;
        for (Account account : allAccounts) {
            if(account.getAccount()>maxValue){
                maxValue=account.getAccount();
                idOfRichest=account.getUser().getId();
            }
        }
        model.addAttribute("richest",userService.getUserById(idOfRichest).getName());
        return "richest";
    }

    @GetMapping(value = "sum")
    public String getSum(Model model){
        List<Account> allAccounts = accountService.getAllAccounts();
        int sum = allAccounts.stream().mapToInt((it) -> it.getAccount()).sum();
        model.addAttribute("sum",sum);
        return "sum";
    }
}
