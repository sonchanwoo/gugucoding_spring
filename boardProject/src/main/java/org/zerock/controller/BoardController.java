package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    private BoardService service;
    
    @GetMapping("/list")
    public void list(Model model) {
        model.addAttribute("list",service.getList());
    }
    
    @GetMapping("/register")
    public void register() {        
    }
    
    @PostMapping("/register")
    public String register(BoardVO vo) {
        service.register(vo);
        return "redirect:/board/list";
    }
    
    @GetMapping({"/get","/modify"})
    public void get(Long bno, Model model) {
        model.addAttribute("vo",service.get(bno));
    }
    
    @PostMapping("/modify")
    public String modify(BoardVO vo){
        service.modify(vo);
        return "redirect:/board/list";
    }
    
    @PostMapping("/remove")
    public String remove(Long bno){
        service.remove(bno);
        return "redirect:/board/list";
    }
}
