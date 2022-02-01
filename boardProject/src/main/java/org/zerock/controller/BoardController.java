package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
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
        model.addAttribute("pageMaker", new PageDTO(cri,service.getTotal(cri)));
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
    public void get(Long bno, Criteria cri, Model model) {
        model.addAttribute("vo",service.get(bno));
    }
    
    @PostMapping("/modify")
    public String modify(BoardVO vo, RedirectAttributes rttr, Criteria cri){
        if(service.modify(vo))
            rttr.addFlashAttribute("result", "success");
        
        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());
        
        return "redirect:/board/list";
    }
    
    @PostMapping("/remove")
    public String remove(Long bno, RedirectAttributes rttr, Criteria cri){
        if(service.remove(bno))
            rttr.addFlashAttribute("result", "success");
        
        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());
        
        return "redirect:/board/list";
    }
}
