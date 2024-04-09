package shop.mtcoding.blog.controller.reply;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ReplyController {

    private final ReplyService replyService ;
    private final HttpSession session;
}
