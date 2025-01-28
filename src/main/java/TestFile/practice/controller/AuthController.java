package TestFile.practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import TestFile.practice.dto.UserReqDTO;
import TestFile.practice.dto.UserResDto;
import TestFile.practice.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    //user 이메일 중복 확인
    @PostMapping("/isunique")
    public ResponseEntity<Boolean> isUnique(@RequestBody Map<String, String> dataMap) {
        int type = Integer.parseInt(dataMap.get("type"));
        return ResponseEntity.ok(authService.checkUnique(type,dataMap.get("data")));
    }


    //user 회원 가입
    @PostMapping("/join")
    public ResponseEntity<UserResDto> join(@RequestBody UserReqDTO userReqDto) {
        return ResponseEntity.ok(authService.join(userReqDto));
    }
}