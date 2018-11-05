package org.stuartaroth.bootstart.services.config;

import org.springframework.stereotype.Service;

@Service
public interface ConfigService {
    String getServiceAddress();
    String getDataAddress();
    String getDataUsername();
    String getDataPassword();
}
