package TestFile.practice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import TestFile.practice.entity.UserEntity;

@Getter
@Setter
@Builder
public class UserResDto {
    private String email;
    private String name;
    private String ageGroup;
    private String profileImage;

    public static UserResDto of(UserEntity userEntity) {
        return UserResDto.builder()
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .ageGroup(userEntity.getAgeGroup())
                .profileImage(userEntity.getProfileImage())
                .build();
    }
}
