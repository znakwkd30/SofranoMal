package kr.hs.dgsw.webclass01.controller;

import kr.hs.dgsw.webclass01.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    private CalculatorService cs;

    @GetMapping("/cal1")
    public int cal1(@RequestParam int num1, @RequestParam int num2, @RequestParam String oper) {
        int res = 0;
        switch (oper) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
        }

        return res;
    }

    @GetMapping("/cal2/{n1}/{oper}/{n2}")
    public String cal2(@PathVariable String n1, @PathVariable String n2, @PathVariable String oper) {
        String res = cs.valid(n1, n2, oper);
        System.out.println(res);
        if(res == "OK") { return "결과값: " + cs.calculator(n1, n2, oper); }
        else { return res; }
    }
}
