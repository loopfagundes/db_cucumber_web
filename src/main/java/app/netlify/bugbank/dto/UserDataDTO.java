package app.netlify.bugbank.dto;

import com.github.javafaker.Faker;

public class UserDataDTO {
    private static final Faker faker = new Faker();

    public static UserModelDTO dataUser() {
        return new UserModelDTO(
                faker.internet().emailAddress(),
                faker.name().fullName(),
                "secret"
        );
    }
}