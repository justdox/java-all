package xlab.java.lang.serializable;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

/**
 * @author CodeKing
 */
public class SerializableDemo {
  public static void main(String[] args) throws IOException {
    final DayOfWeek dayOfWeek = DayOfWeek.from(LocalDate.now());

    final SerializableEntity entity = new SerializableEntity((byte) 1,
      (short) 2, 3, 4L, 5F, 6D,
      'a', true, "Original entity",
      dayOfWeek, List.of("One", "Two", "Three"), new String[]{"A", "B", "C"},
      "Self field", "Transient " + "field");

    final Path filePath = Paths.get("", "test.txt").toAbsolutePath();
    final File file = filePath.toFile();
    if (!file.exists()) {
      if (!file.createNewFile()) {
        System.out.printf("创建文件 “%s” 失败！%n", file.getAbsolutePath());
        return;
      }
    }

    System.out.printf("文件路径：%s%n", file.getCanonicalPath());

    try (final FileOutputStream fos = new FileOutputStream(file);
         final ObjectOutputStream objectOutputStream =
           new ObjectOutputStream(fos);
         final FileInputStream fis = new FileInputStream(file);
         final ObjectInputStream objectInputStream = new ObjectInputStream(fis)) {
      objectOutputStream.writeObject(entity);

      final SerializableEntity deserializedEntity =
        (SerializableEntity) objectInputStream.readObject();

      System.out.printf("序列化：%n\t%s", entity);
      System.out.println();
      System.out.printf("反序列化：%n\t%s", deserializedEntity);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

  }
}
