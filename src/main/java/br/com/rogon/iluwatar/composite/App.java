package br.com.rogon.iluwatar.composite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {
        var messenger = new Messenger();

        log.info("Message from the orcs: ");
        messenger.messageFromOrcs().print();

        log.info("Message from the elves: ");
        messenger.messageFromElves().print();
    }
}
