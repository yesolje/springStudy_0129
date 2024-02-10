package hello.hellospring.web.frontcontroller.v5;

import hello.hellospring.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.hellospring.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.hellospring.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.hellospring.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlertMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5(){
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerMappingMap() {
        handlertMappingMap.put("/front-controller/v3/members/new-form" , new MemberFormControllerV3());
        handlertMappingMap.put("/front-controller/v3/members/save" , new MemberSaveControllerV3());
        handlertMappingMap.put("/front-controller/v3/members" , new MemberListControllerV3());
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
