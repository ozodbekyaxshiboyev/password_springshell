package uz.pdp.passwordpdp.password;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Integer> {
    public Password findFirstBySite(String site);

    @Transactional
    public void deleteBySite(String site);
}
