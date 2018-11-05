package org.stuartaroth.bootstart.services.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stuartaroth.bootstart.services.config.ConfigService;

import java.util.Arrays;
import java.util.List;

@Service
public class DefaultDataService implements DataService {

    @Autowired
    private ConfigService configService;

    @Override
    public List<String> getData() {
        return Arrays.asList(
                configService.getServiceAddress(),
                configService.getDataAddress(),
                configService.getDataUsername(),
                configService.getDataPassword()
        );
    }
}
