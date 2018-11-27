spring 3.2.13-RELEASE 버전을 사용한 프로젝트로, jetty, tomcat 메이븐 플러그인을 사용하여 로컬 환경에서 개발 기능들을 확인할 수 있다.
그리고 기본적인 type 별(modelAndView, json-response, json-post, form)에 대한 end point 예제를 포함하고 있다. 

[jetty](https://www.eclipse.org/jetty/)을 servlet container로 애플리케이션을 실행하려면 아래의 명령어를 실행하면 된다.

```
./mvnw clean jetty:run
```

[tomcat](http://tomcat.apache.org/)을 servlet container로 애플리케이션을 실행하려면 아래의 명령어를 실행하면 된다.

```
./mvnw clean tomcat7:run
```

위의 명령어들을 통해 실행한 애플리케이션은 `ctrl + c`를 입력하면 실행이 종료된다.