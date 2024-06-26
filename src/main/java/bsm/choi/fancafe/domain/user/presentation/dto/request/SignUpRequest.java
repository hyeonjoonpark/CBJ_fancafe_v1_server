package bsm.choi.fancafe.domain.user.presentation.dto.request;

import bsm.choi.fancafe.domain.user.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public record SignUpRequest(
  String id,
  String email,
  String password
) {

    public User toEntity(BCryptPasswordEncoder bCryptPasswordEncoder) {
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        return User.builder()
                .id(id)
                .email(email)
                .password(encodedPassword)
                .build();
    }
}
