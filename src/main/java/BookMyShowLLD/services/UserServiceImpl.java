package BookMyShowLLD.services;


import BookMyShowLLD.models.User;
import BookMyShowLLD.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User signupUser(String name, String email, String password) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user != null){
            throw new Exception("User already exists");
        }
        user = new User();
        user.setEmail(email);
        user.setName(name);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        return userRepository.save(user);
    }

    @Override
    public boolean login(String email, String password) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new Exception("User not found");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, user.getPassword());
    }
}
