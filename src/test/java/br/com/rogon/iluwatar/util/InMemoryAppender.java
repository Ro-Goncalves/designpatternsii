package br.com.rogon.iluwatar.util;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class InMemoryAppender extends AppenderBase<ILoggingEvent>{

    private final List<ILoggingEvent> log = new LinkedList<>();

    public InMemoryAppender(Class clazz){
        ((Logger) LoggerFactory.getLogger(clazz)).addAppender(this);
        start();
    }

    public InMemoryAppender(){
        ((Logger) LoggerFactory.getLogger("root")).addAppender(this);
        start();
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
        log.add(eventObject);
    }

    public String getLastMessage(){
        return log.get(log.size() - 1).getMessage();
    }

    public Integer getLogSize(){
        return log.size();
    }

    public boolean logContains(String message){
        return log.stream()
                  .map(ILoggingEvent::getFormattedMessage)
                  .anyMatch(message::equals);
    }
}
