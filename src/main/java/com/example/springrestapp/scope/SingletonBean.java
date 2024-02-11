package com.example.springrestapp.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = "singleton") singleton jest defaultowo
public class SingletonBean {

    private final Integer hashCode;

    public SingletonBean() {
        this.hashCode = this.hashCode();
    }

    public Integer showHashCode(){
        return hashCode();
    }

}
