package service.impl;

import entity.Token;
import entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.TokenRepository;
import service.ifc.TokenService;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final TokenRepository tokenRepository;

    @Override
    public Token createToken(User user) {
        //todo hash token
        return null;
    }

    @Override
    public void deleteToken(String key) {
        tokenRepository.deleteByKey(key);
    }
}
