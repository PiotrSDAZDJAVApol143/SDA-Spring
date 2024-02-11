package com.example.springrestapp.controller.scope;

import com.example.springrestapp.scope.PrototypeBean;
import com.example.springrestapp.scope.RequestBean;
import com.example.springrestapp.scope.SingletonBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beans/v2")
public class BeanControllerV2 {
    private final SingletonBean singletonBean;
    private final PrototypeBean prototypeBean;
    private final RequestBean requestBean;

    public BeanControllerV2(SingletonBean singletonBean, PrototypeBean prototypeBean, RequestBean requestBean) {
        this.singletonBean = singletonBean;
        this.prototypeBean = prototypeBean;
        this.requestBean = requestBean;
    }
    @GetMapping("/singleton")
    public ResponseEntity<Integer> showSingleton(){
        return ResponseEntity.ok(singletonBean.showHashCode());
    }
    @GetMapping("/prototype")
    public ResponseEntity<Integer> showPrototype(){
        return ResponseEntity.ok(prototypeBean.showHashCode());
    }
    @GetMapping("/request")
    public ResponseEntity<Integer> showRequest(){
        return ResponseEntity.ok(requestBean.showHashCode());
    }





}
