#### 1. Tomcat 서버를 시작할 때 웹 애플리케이션이 초기화하는 과정을 설명하라.

* ContextLoaderListener 에서 DB초기화 및 서블릿 컨테이너 초기화 작업을 한다.
* DispatcherServlet에서 init()을 호출하고  RequestMapping을 생성하고 초기화 한다. 
* (아는 부분까지만 적어보았습니다.)

#### 2. Tomcat 서버를 시작한 후 http://localhost:8080으로 접근시 호출 순서 및 흐름을 설명하라.
* DispatcherServlet이 RequestMapping을 호출해서 url패턴과 맞는 Controller를 찾아 매핑 해준후 다시 DispatcherServlet 요청을 넘긴다.
*DispatcherServlet이 요청을 전달할 Controller를 결정 한후 해당 Controller에게 요청을 넘긴다.(HomeController)
*HomeController에서   맞는 비지니스 모델(questionDao)에서 필요한 로직(findAll())을 호출한 후 ModelAndView개체에 저장한 후  DispatcherServlet 로 넘긴다.
*  DispatcherServlet가 요청한 사용자에게 view를 전달한다.

#### 7. next.web.qna package의 ShowController는 멀티 쓰레드 상황에서 문제가 발생하는 이유에 대해 설명하라.
* 
