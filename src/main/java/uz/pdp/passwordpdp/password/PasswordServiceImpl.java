package uz.pdp.passwordpdp.password;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PasswordServiceImpl implements PasswordService {

    private final PasswordRepository passwordRepository;

    @Override
    public Password get(String site) {
        return passwordRepository.findFirstBySite(site);
    }

    @Override
    public String delete(String site) {
        log.info("Ishladi:::::::::::::::::::::::::::::::");
        if (passwordRepository.findFirstBySite(site) != null) {
            passwordRepository.deleteBySite(site);
            return "Successfully deleted";
        } else {
            return "Not found with site name" + site;
        }
    }

    @Override
    public Password create(Password psw) {
        return passwordRepository.save(psw);
    }

    @Override
    public String update(Password psw) {
        if (passwordRepository.findFirstBySite(psw.getSite()) != null) {
            passwordRepository.save(psw);
            return "Successfully updated";
        } else {
            return "Not found with site name" + psw.getSite();
        }
    }

    @Override
    public List<Password> getAll() {
        return passwordRepository.findAll();
    }
}
