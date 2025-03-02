package BookMyShowLLD.services;


import BookMyShowLLD.models.User;

public interface UserService {

    User signupUser(String name, String email, String password) throws Exception;

    boolean login(String email, String password) throws Exception;
}
