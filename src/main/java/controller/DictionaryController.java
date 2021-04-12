package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class DictionaryController {
    @PostMapping("/dictionary")
    public String Dictionary(@RequestParam String english, ModelMap modelMap){
        modelMap.put("hello","xin chào");
        modelMap.put("goodbye","tạm biệt");
        modelMap.put("love is the sea of trouble","yêu là biển khổ");
        modelMap.put("LOVEAND", "yêu và được yêu");
        english = english.toLowerCase();
        String vietnamese = (String) modelMap.get(english);
        if(vietnamese==null){
            vietnamese = "not found";
            modelMap.addAttribute("english", english);
            modelMap.addAttribute("vietnamese",vietnamese);
        } else {
            modelMap.addAttribute("english",english);
            modelMap.addAttribute("vietnamese",vietnamese);

        }
        return "/dictionary";
    }
}
