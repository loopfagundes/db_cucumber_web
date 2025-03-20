package app.netlify.bugbank.managers;

import app.netlify.bugbank.dto.UserDataDTO;
import app.netlify.bugbank.dto.UserModelDTO;
import app.netlify.bugbank.widgets.Element;

public class UserFieldManager {
    public static void fillUserField(String locator, String fieldType) throws Exception {
        UserModelDTO userData = UserDataDTO.dataUser();
        String data;
        switch (fieldType) {
            case "email":
                data = userData.getEmail();
                break;
            case "nome":
                data = userData.getName();
                break;
            case "senha":
            case "confirmar_senha":
                data = userData.getPassword();
                break;
            default:
                throw new IllegalArgumentException("Campo inválido: " + fieldType);
        }
        new Element(locator).getData(data);
    }
}