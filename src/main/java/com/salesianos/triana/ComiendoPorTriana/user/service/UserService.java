package com.salesianos.triana.ComiendoPorTriana.user.service;


import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import com.salesianos.triana.ComiendoPorTriana.exception.NotOwnerException;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
import com.salesianos.triana.ComiendoPorTriana.user.model.UserRole;
import com.salesianos.triana.ComiendoPorTriana.user.model.dto.CreateUserRequest;
import com.salesianos.triana.ComiendoPorTriana.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public User createUser(CreateUserRequest createUserRequest, EnumSet<UserRole> roles) {
        User user =  User.builder()
                .username(createUserRequest.getUsername())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .fullName(createUserRequest.getFullName())
                .roles(roles)
                .build();

        return userRepository.save(user);
    }

    public User createUserWithUserRole(CreateUserRequest createUserRequest) {
        return createUser(createUserRequest, EnumSet.of(UserRole.CLIENT));
    }

    public User createUserWithAdminRole(CreateUserRequest createUserRequest) {
        return createUser(createUserRequest, EnumSet.of(UserRole.BARMAN));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findFirstByUsername(username);
    }

    public Optional<User> edit(User user) {

        return userRepository.findById(user.getId())
                .map(u -> {
                    u.setFullName(user.getFullName());
                    return userRepository.save(u);
                }).or(() -> Optional.empty());
    }

    public Optional<User> editPassword(UUID userId, String newPassword) {
        return userRepository.findById(userId)
                .map(u -> {
                    u.setPassword(passwordEncoder.encode(newPassword));
                    return userRepository.save(u);
                }).or(() -> Optional.empty());
    }

    public void delete(User user) {
        deleteById(user.getId());
    }

    public void deleteById(UUID id) {
        if (userRepository.existsById(id))
            userRepository.deleteById(id);
    }

    public boolean passwordMatch(User user, String clearPassword) {
        return passwordEncoder.matches(clearPassword, user.getPassword());
    }


//    public boolean checkOwner(Bar bar, UUID id){
//        return userRepository.findFirstById(id)
//                .map(user -> {
//                    boolean isAdmin = user.getOwnership().stream().anyMatch(b -> b.equals(bar));
//                    if (!isAdmin)
//                        throw new NotOwnerException("El usuario no es administrador");
//                    return isAdmin;
//                }).orElseThrow(() -> new NotOwnerException("Usuario sin acceso"));
//    }


    public boolean checkCommentOwner(Comment comment, UUID id){
        return userRepository.findFirstById(id)
                .map(user -> {
                   boolean isAuthor = user.getComments().stream().anyMatch(c -> c.equals(comment));
                   if (!isAuthor)
                       throw new NotOwnerException("El usuario no es el autor.");
                   return isAuthor;
                }).orElseThrow(() -> new NotOwnerException("usuario sin acceso."));
    }


}
