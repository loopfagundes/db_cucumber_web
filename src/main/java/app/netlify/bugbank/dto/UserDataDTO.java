package app.netlify.bugbank.dto;

import com.github.javafaker.Faker;

public class UserDataDTO {
    public static UserModelDTO dto = new UserModelDTO();

    public static UserModelDTO dataUser() {
        dto.setEmail(Faker.instance().internet().emailAddress());
        dto.setName(Faker.instance().name().firstName());
        dto.setPassword("secret");
        return new UserModelDTO(dto.getEmail(), dto.getName(), dto.getPassword());
    }
}