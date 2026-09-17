package com.example.teamapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.teamapp.service.KitayamaService;
import com.example.teamapp.service.NakamuraService;

@Controller
public class TeamController {
    @Autowired private KitayamaService kitayamaService; // メンバーのServiceを注入
    @Autowired private NakamuraService nakamuraService; // メンバーのServiceを注入

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("leaderMsg", "リーダーです！");
        model.addAttribute("KitayamaMsg", kitayamaService.getProfile()); // 画面に渡す
        model.addAttribute("NakamuraMsg", nakamuraService.getProfile()); // 画面に渡す
        return "index";
    }
}