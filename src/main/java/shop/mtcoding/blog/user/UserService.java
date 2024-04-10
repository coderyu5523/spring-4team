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
}
