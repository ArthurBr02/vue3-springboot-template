package fr.arthurbr02.vue3templateback.backend.app.file;

import fr.arthurbr02.vue3templateback.backend.app.file.constant.FicType;
import fr.arthurbr02.vue3templateback.backend.app.user.User;
import fr.arthurbr02.vue3templateback.backend.app.user.UserService;
import fr.arthurbr02.vue3templateback.backend.core.base.BaseWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/rest/v1/fic")
public class FicWS extends BaseWS {
    @Autowired
    private FicService ficService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/profile-picture/{userId}")
    public ResponseEntity<Resource> getProfilePicture(@PathVariable Long userId) throws IOException {
        File file = ficService.findByUserIdAndTypeToFile(userId, FicType.PROFILE_PICTURE);
        Resource resource = new UrlResource(file.toURI());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }

    @PostMapping("/upload-profile-picture")
    public ResponseEntity<Object> uploadProfilePicture(@RequestParam("file") MultipartFile file) throws IOException {
        User user = getCurrentUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        ficService.uploadProfilePicture(file);
        return ResponseEntity.ok().build();
    }
}
