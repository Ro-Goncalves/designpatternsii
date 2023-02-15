package br.com.rogon.iluwatar.composite;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Letter extends LetterComposite {
    private final char character;

    @Override
    protected void printThisBefore(){
        System.out.print(character);
    }
    
}
