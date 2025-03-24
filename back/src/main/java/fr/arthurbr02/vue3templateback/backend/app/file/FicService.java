package fr.arthurbr02.vue3templateback.backend.app.file;

import fr.arthurbr02.vue3templateback.backend.app.file.constant.FicType;
import fr.arthurbr02.vue3templateback.backend.app.user.User;
import fr.arthurbr02.vue3templateback.backend.core.base.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Service("ficService")
public class FicService extends BaseService {
    @Autowired
    private FicRepository ficRepository;

    @Value("${data-dir}")
    private String dataDir;

    public Fic findById(Long id) {
        return ficRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteByUserIdAndType(Long userId, FicType type) {
        ficRepository.deleteByUserIdAndType(userId, type.getName());
    }

    public void deleteById(Long id) {
        ficRepository.deleteById(id);
    }

    @Transactional
    public void save(Fic fic) {
        ficRepository.save(fic);
    }

    public Fic findByUserIdAndType(Long userId, FicType ficType) {
        return ficRepository.findByUserIdAndType(userId, ficType.getName()).orElseThrow();
    }

    public File findByUserIdAndTypeToFile(Long userId, FicType ficType) {
        Fic fic = findByUserIdAndType(userId, ficType);
        return new File(dataDir + File.separator + ficType.getName() + File.separator + fic.getUuid());
    }

    @Transactional
    public void uploadProfilePicture(MultipartFile file) throws IOException {
        User user = getCurrentUser();

        deleteByUserIdAndType(user.getId(), FicType.PROFILE_PICTURE);

        Fic fic = new Fic();
        fic.setUserId(user.getId());
        fic.setType(FicType.PROFILE_PICTURE.getName());
        fic.setCreatedAt(new Date());
        fic.setMimetype(file.getContentType());
        fic.setSize(file.getSize());
        fic.setName(file.getOriginalFilename());
        fic.setUuid(UUID.randomUUID().toString());
        save(fic);

        // Transfer file to data directory
        File dataDir = new File(this.dataDir + File.separator + FicType.PROFILE_PICTURE.getName());
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
        file.transferTo(new File(dataDir + File.separator + fic.getUuid()));
    }
}
