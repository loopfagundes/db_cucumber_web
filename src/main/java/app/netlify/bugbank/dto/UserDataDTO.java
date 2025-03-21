package app.netlify.bugbank.dto;

import com.github.javafaker.Faker;

public class UserDataDTO {
        public static UserModelDTO dataUser() {
        return new UserModelDTO(
                Faker.instance().internet().emailAddress(),
                Faker.instance().name().fullName(),
                "secret"
        );
    }
}