package br.com.rogon.refactoringguru.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5.00);
        RoundPeg rPeg = new RoundPeg(5.00);
        if(hole.fits(rPeg)){
            log.info("Pino Redondo com Raio 5, encaixa num Buraco Redondo com Raio 5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2.00);
        SquarePeg largeSqPeg = new SquarePeg(20.00);

        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);

        if(hole.fits(smallSqPegAdapter)){
            log.info("Pino Quadrado com largura 2, encaixam num Buraco Redondo com Raio 5.");
        }
        if(!hole.fits(largeSqPegAdapter)){
            log.info("Pino Quadrado com Largura 20, NAO encaixa num Buraco Redondo com Raio 5.");
        }
    }
}
