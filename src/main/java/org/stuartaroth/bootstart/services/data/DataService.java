package org.stuartaroth.bootstart.services.data;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DataService {
    List<String> getData();
}
