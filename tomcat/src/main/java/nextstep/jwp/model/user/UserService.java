package nextstep.jwp.model.user;

import java.util.Optional;
import nextstep.jwp.db.InMemoryUserRepository;
import nextstep.jwp.model.user.exception.UserNotFoundException;
import org.apache.coyote.http11.Http11Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {

    private static final Logger log = LoggerFactory.getLogger(Http11Processor.class);

    public boolean login(String account, String password) {
        Optional<User> user = InMemoryUserRepository.findByAccount(account);
        if (user.isEmpty() || !user.get().checkPassword(password)) {
            return false;
        }
        log.info(String.valueOf(user.get()));
        return true;
    }

    public User findUser(String account) {
        return InMemoryUserRepository.findByAccount(account)
                .orElseThrow(UserNotFoundException::new);
    }

    public boolean addNewUser(String account, String email, String password) {
        if (InMemoryUserRepository.findByAccount(account).isPresent()) {
            return false;
        }
        InMemoryUserRepository.save(new User(account, password, email));
        return true;
    }
}
