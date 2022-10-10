package com.company.controller;

import com.company.cipher.AffineCipher;
import com.company.cipher.CaesarCipher;
import com.company.cipher.ViginereCipher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("index")
@RequiredArgsConstructor
public class EncryptController {
    private final AffineCipher affineCipher;
    private final ViginereCipher viginereCipher;
    private final CaesarCipher caesarCipher;
    private List<String> algorithims = Arrays.asList("Caesar","Affine","Viginere");
    @GetMapping
    public String showEncryptPage(Model model,
                                  @RequestParam(value="cipherText",required = false) String cipherText,
                                  @RequestParam(value="plaintext",required = false) String plainText){
        model.addAttribute("algorithims",algorithims);
        model.addAttribute("cipherText",cipherText);
        model.addAttribute("plaintext",plainText);
        return "index";
    }
    @GetMapping("encrypt/affine")
    public ModelAndView affine(@RequestParam("plaintext")String plainText,
                               @RequestParam("a")Integer a,
                               @RequestParam("b")Integer b){
        ModelAndView mv = new ModelAndView();
        mv.setView(new RedirectView("/index"));
        String cipherText = affineCipher.encrypt(Arrays.asList(a,b),plainText);
        mv.addObject("cipherText",cipherText);
        mv.addObject("algorithims",algorithims);
        return mv;
    }
    @GetMapping("encrypt/viginere")
    public ModelAndView viginere(@RequestParam("plaintext")String plainText,
                        @RequestParam("key")String key){
        ModelAndView mv = new ModelAndView();
        mv.setView(new RedirectView("/index"));
        String cipherText = viginereCipher.encrypt(key,plainText);
        mv.addObject("cipherText",cipherText);
        mv.addObject("algorithims",algorithims);
        return mv;
    }
    @GetMapping("encrypt/caesar")
    public ModelAndView caesar(@RequestParam("plaintext")String plainText,
                         @RequestParam("key")Integer key) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new RedirectView("/index"));
        String cipherText = caesarCipher.encrypt(key,plainText);
        mv.addObject("cipherText",cipherText);
        mv.addObject("algorithims",algorithims);
        return mv;
    }
}
