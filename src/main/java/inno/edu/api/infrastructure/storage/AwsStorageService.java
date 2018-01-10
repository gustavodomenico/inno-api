package inno.edu.api.infrastructure.storage;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@ConditionalOnProperty(name = "application.storage.mode", havingValue = "aws")
public class AwsStorageService implements StorageService {
    @Override
    public void save(UUID keyId, MultipartFile file) {

    }
}
