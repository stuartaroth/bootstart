package org.stuartaroth.bootstart.services.config;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DefaultConfigService implements ConfigService {
    private String serviceAddress;
    private String dataAddress;
    private String dataUsername;
    private String dataPassword;

    public DefaultConfigService() {
        Map<String, String> environmentVariables = System.getenv();

        serviceAddress = environmentVariables.getOrDefault("BOOTSTART_SERVICE_ADDRESS", "localhost");
        dataAddress = environmentVariables.getOrDefault("BOOTSTART_DATA_ADDRESS", "localhost");
        dataUsername = environmentVariables.getOrDefault("BOOTSTART_DATA_USERNAME", "root");
        dataPassword = environmentVariables.getOrDefault("BOOTSTART_DATA_PASSWORD", "");
    }

    @Override
    public String getServiceAddress() {
        return serviceAddress;
    }

    @Override
    public String getDataAddress() {
        return dataAddress;
    }

    @Override
    public String getDataUsername() {
        return dataUsername;
    }

    @Override
    public String getDataPassword() {
        return dataPassword;
    }
}
