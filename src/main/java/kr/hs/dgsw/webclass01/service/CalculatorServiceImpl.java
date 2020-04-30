package kr.hs.dgsw.webclass01.service;

import kr.hs.dgsw.webclass01.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String valid(String n1, String n2, String oper) {
        if(n1 == null || n2 == null) { return "첫번째 값 혹은 두번째 값이 없음"; }
        else if(n1 == null && n2 == null) { return "첫번째, 두번째 두가지값 모두 없음"; }
        else if(oper.equals("나누기")) {
            System.out.println(2);
            if(Integer.parseInt(n1) / Integer.parseInt(n2) == 0) {
                return "나눈 값이 0임";
            }
        }

        return "OK";
    }

    @Override
    public int calculator(String n1, String n2, String oper) {
        int res = 0;

        switch (oper) {
            case "+":
                res = Integer.parseInt(n1) + Integer.parseInt(n2);
                break;
            case "-":
                res = Integer.parseInt(n1) - Integer.parseInt(n2);
                break;
            case "*":
                res = Integer.parseInt(n1) * Integer.parseInt(n2);
                break;
            case "나누기":
                res = Integer.parseInt(n1) / Integer.parseInt(n2);
                break;
        }

        return res;
    }
}
