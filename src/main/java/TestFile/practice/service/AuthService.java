package TestFile.practice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import TestFile.practice.repository.UserRepository;
import TestFile.practice.entity.UserEntity;
import TestFile.practice.dto.UserResDto;
import TestFile.practice.dto.UserReqDTO;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final UserRepository userRepository;

    // user 이메일 중복 확인
    public Boolean checkUnique(int type, String info) {
        switch (type) {
            case 0:
                return userRepository.existsByEmail(info);
            case 1:
                return !userRepository.existsByEmail(info);
            default:
                return true;
        }
    }

    // user 회원 가입
    public UserResDto join(UserReqDTO userReqDto) {
        if (userRepository.existsByEmail(userReqDto.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }
        
        UserEntity user = new UserEntity();
        user.setEmail(userReqDto.getEmail());
        user.setPassword(userReqDto.getPassword());
        user.setName(userReqDto.getName());
        user.setAgeGroup(userReqDto.getAge_Group());
        user.setProfileImage(userReqDto.getProfileImage());
      
        
        return UserResDto.of(userRepository.save(user));
    }
}

