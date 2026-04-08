package org.example.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseController;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/child")
public class MdcLoggingExampleController extends BaseController {

    @GetMapping("/test1")
    public String test() {
        System.out.println("Map :: " + MDC.getCopyOfContextMap());
        log.info("log1");
        log.info("log2");
        log.info("log3");
        log.info("log4");
        return "working";
    }
}
