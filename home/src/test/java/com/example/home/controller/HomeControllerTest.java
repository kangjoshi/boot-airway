package com.example.home.controller;

import com.example.home.service.HomeService;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    @MockBean
    private HomeService homeService;

    public void init() {
        HomeController homeController = new HomeController(homeService);
    }

}
