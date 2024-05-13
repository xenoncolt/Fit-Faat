package registration;

import java.awt.*;

public interface IRegistration {

    void baseFrame(String title);
    void addLabel(String text, int x, int y, int width, int height, Font font);
    void addFullName(int x, int y, int width, int height);
    void addUsername(int x, int y, int width, int height);
    void addEmail(int x, int y, int width, int height);
    void addPhn(int x, int y, int width, int height);
    void addPassword(int x, int y, int width, int height);
    void addRePassword(int x, int y, int width, int height);
    
}