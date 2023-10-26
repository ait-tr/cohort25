## 01. Загрузка файлов

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/back_end/lesson_23/img/1.png)
* 
* Если загружать все файлы пользователей, то сильно возрастает нагрузка на сервер
    * Потому что все запросы на получение файлов будут проходить через нас
    * Также, файлы будут занимать очень много места и вам скоро его не хватит
* Поэтому выбирают сторонние решения, по типу - `Dropbox`, `AWS S3`, `Digital Ocean Spaces` (аналогичен `AWS`)
* Это облачные хранилища с возможностями быстрой доставки контента (безграничная память и высокая скорость)
* Преимущество стороннего решения в очень высокой скорости доставки контента без нагрузки вашего сервера

## 02. Примитивная загрузка файлов

```
    @PostMapping("/api/files")
    public StandardResponseDto upload(@RequestParam("file") MultipartFile file) {
        String originalFileName = file.getOriginalFilename(); // получаем имя файла оригинальное

        String extension;

        if (originalFileName != null) {
            extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1); // забираем расширение файла
        } else {
            throw new IllegalArgumentException("null original file name");
        }

        String uuid = UUID.randomUUID().toString(); // генерируем случайную строку в формате UUID
        String newFileName = uuid + "." + extension; // создаем новое имя файла, которое состоит из случайной строки и расширения

        try (InputStream inputStream = file.getInputStream()) { // открываем у загружаемого файла поток для чтения
            Files.copy(inputStream, Path.of("C:\\Users\\marse\\Desktop\\OnlineShop\\static\\" + newFileName)); // перекидываем данные из потока для чтения
            // к нам на диск
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        return StandardResponseDto.builder()
                .message(newFileName)
                .build();
    }
```
## 03. Подключение S3/DigitalOcean

```xml
<dependency>
  <groupId>com.amazonaws</groupId>
  <artifactId>aws-java-sdk-s3</artifactId>
  <version>1.12.572</version>
</dependency>
```

* `sdk3-s3` - значительно упрощает работу с сервисом

## Дополнительно

`@SneakyThrows` - аннотация lombok, которая позволяет обработать проверяемое исключения через `try-catch`
