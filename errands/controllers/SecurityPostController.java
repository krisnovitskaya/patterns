package krisnovitskaya.errands.controllers;

public interface SecurityPostController {
    boolean errandExist(String fullName);
    void openTourniquet(String fullName);
    void exitForbidden();
}
