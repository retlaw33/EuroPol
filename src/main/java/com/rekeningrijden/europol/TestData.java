package com.rekeningrijden.europol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestData implements ApplicationRunner {
    @Autowired
    private StolenVehicleRepository repo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repo.save(new StolenVehicle("22640d1e16868faa8b6c380d8f5a3392", "123", "NL"));
        repo.save(new StolenVehicle("7d05e8ad5f102197ccb6ce5e94cf6b24", "124", "NL"));
    }
}
