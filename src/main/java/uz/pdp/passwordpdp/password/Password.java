package uz.pdp.passwordpdp.password;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Builder
@Entity
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String site;
    @NonNull
    private String username;
    @NonNull
    private String password;

    @Override
    public String toString() {
        return  "\n ===== \nsite => " + site + '\n' +
                "username => " + username + '\n' +
                "password => " + password;
    }
}
