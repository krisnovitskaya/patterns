package krisnovitskaya.errands.controllers;

import krisnovitskaya.errands.database.DummyDataBase;

public class SecurityPostControllerImpl implements SecurityPostController {
    private DummyDataBase database;

    public SecurityPostControllerImpl() {
        this.database = DummyDataBase.getInstance();
    }

    @Override
    public boolean errandExist(String fullName) {
        return database.findByFullName(fullName);
    }

    @Override
    public void exitForbidden() {
        System.out.println("Exit forbidden!");
    }

    @Override
    public void openTourniquet(String fullName) {
        System.out.println("Проходите " + fullName);
    }
}
