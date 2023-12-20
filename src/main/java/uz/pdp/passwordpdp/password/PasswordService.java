package uz.pdp.passwordpdp.password;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PasswordService {
    public Password get(String site);

    public String delete(String site);

    public Password create(Password psw);

    public String update(Password psw);

    public List<Password> getAll();

}
