package king.familyAS.service.iterf;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

   public void init();

   public void store(MultipartFile file);
   
   public void store(MultipartFile file, String path);

   public Stream<Path> loadAll();

   public Path load(String filename);

   public Resource loadAsResource(String filename);

   public void deleteAll();

}
