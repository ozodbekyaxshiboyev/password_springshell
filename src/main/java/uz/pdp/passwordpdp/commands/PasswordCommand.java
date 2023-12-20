package uz.pdp.passwordpdp.commands;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.ParameterValidationException;
import org.springframework.shell.command.CommandHandlingResult;
import org.springframework.shell.command.annotation.ExceptionResolver;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import uz.pdp.passwordpdp.annotation.NonZero;
import uz.pdp.passwordpdp.password.Password;
import uz.pdp.passwordpdp.password.PasswordService;
import uz.pdp.passwordpdp.utils.Util;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

@ShellComponent
@RequiredArgsConstructor
public class PasswordCommand {
    private final PasswordService passwordService;
    private final Util util;
    private boolean loggedIn;

    @ShellMethod(value = "Get password with site name", key = "get")
    public Password get(String site) {
        return passwordService.get(site);
    }

    @ShellMethod(value = "Get all saved passwords", key = "get_all")
    public List<Password> getAll() {
        return passwordService.getAll();
    }

    @ShellMethod(value = "Save new site password")
    public Password create(String site, String name, String psw) {
        return passwordService.create(Password.builder()
                .site(site)
                .username(name)
                .password(psw)
                .build()
        );
    }

    @ShellMethod(value = "Update site information", key = "update")
    public String update(String site, String name, String psw) {
        return passwordService.update(Password.builder()
                .site(site)
                .username(name)
                .password(psw)
                .build()
        );
    }

    @ShellMethod(value = "Delete site information with site name")
    public String delete(String site) {
        return passwordService.delete(site);
    }

    @ShellMethod(value = "Create string password for youself")
    public String getStrongPsw() {
        return util.createStrongPassword();
    }
//
//    @ShellMethod
//    public String logout() {
//        loggedIn = false;
//        return "Successfully signed out";
//    }
//
//    @ShellMethodAvailability({"login"})
//    public Availability availabilityForLogout() {
//        return loggedIn ? Availability.unavailable(" => Logout First") : Availability.available();
//    }
//
//    @ShellMethodAvailability({"get", "getall", "create", "update", "delete", "getStrongPsw"})
//    public Availability availabilityForLogin() {
//        return loggedIn ? Availability.available() : Availability.unavailable(" => Login First");
//    }
//
//    @ExceptionResolver({ParameterValidationException.class})
//    CommandHandlingResult errorHandler(ParameterValidationException e) {
//        Set<ConstraintViolation<Object>> constraintViolations = e.getConstraintViolations();
//        StringJoiner joiner = new StringJoiner("\n", "", "\n");
//        for (ConstraintViolation<Object> violation : constraintViolations) {
//            String arg = violation.getPropertyPath().toString();
//            String message = violation.getMessage();
//            joiner.add(arg + " : " + message);
//        }
//        return CommandHandlingResult.of(joiner.toString(), 400);
//    }

}
