package uz.pdp.passwordpdp.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Util {
    public String createStrongPassword(){
        String strongPsw = "";
        Random random = new Random();
        String uppers = "QWERTYUIOPLKJHGFDSAZXCVBNM";
        String lowers = "qwertyuioplkjhgfdsazxcvbnm";
        String signs = "$@&*><";
        for (int i = 0; i < 2; i++) {
            strongPsw += lowers.charAt(random.nextInt(0,lowers.length()+1));
        }
        for (int i = 0; i < 2; i++) {
            strongPsw += uppers.charAt(random.nextInt(0,uppers.length()+1));
        }
        for (int i = 0; i < 2; i++) {
            strongPsw += signs.charAt(random.nextInt(0,signs.length()+1));
        }
        for (int i = 0; i < 2; i++) {
            strongPsw += random.nextInt(0,10);
        }

        return strongPsw;
    }


}
