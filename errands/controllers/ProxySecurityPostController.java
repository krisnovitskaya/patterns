package krisnovitskaya.errands.controllers;

import java.util.HashSet;
import java.util.Set;

public class ProxySecurityPostController implements SecurityPostController {
    private SecurityPostController securityPostController;
    private Set<String> cacheErrands; //simple check by FIO

    public ProxySecurityPostController() {
        this.securityPostController = new SecurityPostControllerImpl();
        this.cacheErrands = new HashSet<>();
    }

    @Override
    public boolean errandExist(String fullName) {
        if(cacheErrands.contains(fullName)){
            openTourniquet(fullName);
            return true;
        } else if(securityPostController.errandExist(fullName)){
           cacheErrands.add(fullName);
           openTourniquet(fullName);
           return true;
        } else {
            exitForbidden();
            return false;
        }
    }

    @Override
    public void openTourniquet(String fullName) {
        securityPostController.openTourniquet(fullName);
    }

    @Override
    public void exitForbidden() {
        securityPostController.exitForbidden();
    }


    //for test only
    public void printCache(){
        System.out.println("________");
        for (String cacheErrand : cacheErrands) {
            System.out.println(cacheErrand);
        }
        System.out.println("________");
    }
}
