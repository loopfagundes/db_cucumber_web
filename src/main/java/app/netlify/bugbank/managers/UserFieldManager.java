package app.netlify.bugbank.managers;

import app.netlify.bugbank.dto.UserDataDTO;
import app.netlify.bugbank.dto.UserModelDTO;
import app.netlify.bugbank.utils.FilesOperation;
import app.netlify.bugbank.widgets.Element;

public class UserFieldManager {
    public static void fillUserField(String locator, String fieldType, String nameProp) throws Exception {
        UserModelDTO userData = UserDataDTO.dataUser();
        String data;
        switch (fieldType) {
            case "email":
                data = userData.getEmail();
                FilesOperation.setProperty("properties", nameProp, "email", userData.getEmail());
                break;
            case "nome":
                data = userData.getName();
                FilesOperation.setProperty("properties", nameProp, "nome", userData.getName());
                break;
            case "senha":
            case "confirmar senha":
                data = userData.getPassword();
                FilesOperation.setProperty("properties", nameProp, "senha", userData.getPassword());
                break;
            default:
                throw new IllegalArgumentException("Campo inválido: " + fieldType);
        }
        new Element(locator).getDataUser(data);
    }
}