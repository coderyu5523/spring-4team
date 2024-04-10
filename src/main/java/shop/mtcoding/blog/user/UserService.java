package shop.mtcoding.blog.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserJPARepository userJPARepository ;

    @Transactional
    public void save(UserRequest.SaveDTO requestDTO) {
        userJPARepository.save(requestDTO.toEntity());

    }

    public User login(UserRequest.LoginDTO requestDTO) {
       User user = userJPARepository.findByUsernameAndPassword(requestDTO.getUsername(),requestDTO.getPassword()) ;
        return user;
    }

    public User findById(Integer sessionUserId) {
        User user = userJPARepository.findById(sessionUserId).get();
        return user ;
    }

    @Transactional
    public void update(UserRequest.UpdateDTO requestDTO,int sessionUserId) {
       User user = userJPARepository.findById(sessionUserId).get();
       user.update(requestDTO.getPassword(),requestDTO.getEmail());
    }
}
