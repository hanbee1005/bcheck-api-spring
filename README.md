# bCheck API
사내 도서 관리 시스템 api 프로젝트입니다.

## Swagger 3.0 연결
- build.gradle 파일에 라이브러리 추가
```
...

ext {
    swaggerVersion = '3.0.0'
    openApiVersion = '1.5.8'
}

...

dependencies {
    ...
    
    // swagger
    implementation "io.springfox:springfox-swagger2:${swaggerVersion}"
    implementation "io.springfox:springfox-swagger-ui:${swaggerVersion}"
    implementation "org.springdoc:springdoc-openapi-ui:${openApiVersion}"
    
    ...
}
```
- SwaggerConfig.java 파일 추가 (설정 정보 변경)
- 서버 실행 후 http://localhost:9090/app/swagger-ui.html 접속