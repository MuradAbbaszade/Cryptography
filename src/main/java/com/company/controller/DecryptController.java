package com.company.controller;

import com.company.cipher.AffineCipher;
import com.company.cipher.CaesarCipher;
import com.company.cipher.ViginereCipher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("index")
@RequiredArgsConstructor
public class DecryptController {
    private final AffineCipher affineCipher;
    private final ViginereCipher viginereCipher;
    private final CaesarCipher caesarCipher;
    private List<String> algorithims = Arrays.asList("Caesar", "Affine", "Viginere");

    @GetMapping("decrypt/affine")
    public ModelAndView affine(@RequestParam("ciphertext") String cipherText,
                               @RequestParam("a") Integer a,
                               @RequestParam("b") Integer b) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new RedirectView("/index"));
        String plainText = affineCipher.decrypt(Arrays.asList(a, b), cipherText);
        mv.addObject("plaintext", plainText);
        mv.addObject("algorithims", algorithims);
        return mv;
    }

    @GetMapping("decrypt/viginere")
    public ModelAndView viginere(@RequestParam("ciphertext") String cipherText,
                                 @RequestParam("key") String key) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new RedirectView("/index"));
        String plainText = viginereCipher.decrypt(key, cipherText);
        mv.addObject("plaintext", plainText);
        mv.addObject("algorithims", algorithims);
        return mv;
    }

    @GetMapping("decrypt/caesar")
    public ModelAndView caesar(@RequestParam("ciphertext") String cipherText,
                               @RequestParam("key") Integer key) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new RedirectView("/index"));
        String plainText = caesarCipher.decrypt(key, cipherText);
        mv.addObject("plaintext", plainText);
        mv.addObject("algorithims", algorithims);
        System.out.println(plainText);
        return mv;
    }
}
