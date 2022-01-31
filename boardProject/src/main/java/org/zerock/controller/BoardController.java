package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    private BoardService service;
    
    @GetMapping("/list")
    public void list(Criteria cri, Model model) {
        model.addAttribute("list",service.getListWithPage(cri));
    }
    
    @GetMapping("/register")
    public void register() {        
    }
    
    @PostMapping("/register")
    public String register(BoardVO vo, RedirectAttributes rttr) {
        if(service.register(vo))
            rttr.addFlashAttribute("result", vo.getBno());
        return "redirect:/board/list";
    }
    
    @GetMapping({"/get","/modify"})
    public void get(Long bno, Model model) {
        model.addAttribute("vo",service.get(bno));
    }
    
    @PostMapping("/modify")
    public String modify(BoardVO vo, RedirectAttributes rttr){
        if(service.modify(vo))
            rttr.addFlashAttribute("result", "success");
        return "redirect:/board/list";
    }
    
    @PostMapping("/remove")
    public String remove(Long bno, RedirectAttributes rttr){
        if(service.remove(bno))
            rttr.addFlashAttribute("result", "success");
        return "redirect:/board/list";
    }
}
