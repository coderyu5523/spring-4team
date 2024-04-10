package shop.mtcoding.blog.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
