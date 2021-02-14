package org.academiadecodigo.timemaravilha.game;

public enum Difficulty {
    EASY(60000, 10000, 12000, 15000, 15000,
            5000, 15000,7500,10000,30000),

    MEDIUM(60000, 7500, 9500, 11000, 15000,
            10000, 15000,12000,10000,35000),

    HARD(90000, 7500, 7500, 8000, 15000,
            12500, 15000,15000,10000,45000),

    CARCRASH(120000, 7500, 5000, 6000, 15000,
            15000, 15000,20000,10000,60000);

    private long covidinhoDespawn;
    private long immunityDespawn;
    private long vaccineDespawn;
    private long maskDespawn;

    private long scovidinhoSpawn;
    private long pcovidinhoSpawn;
    private long tcovidinhoSpawn;
    private long maskSpawn;
    private long vaccineSpawn;
    private long immuntySpawn;

    Difficulty(long covidinhoDespawn, long scovidinhoSpawn, long pcovidinhoSpawn, long tcovidinhoSpawn,
               long maskDespawn, long maskSpawn, long immunityDespawn, long immunitySpawn, long vaccineDespawn,
               long vaccineSpawn){
        this.covidinhoDespawn = covidinhoDespawn;
        this.scovidinhoSpawn = scovidinhoSpawn;
        this.pcovidinhoSpawn = pcovidinhoSpawn;
        this.tcovidinhoSpawn = tcovidinhoSpawn;

        this.maskDespawn = maskDespawn;
        this.maskSpawn = maskSpawn;

        this.immunityDespawn = immunityDespawn;
        this.immuntySpawn = immunitySpawn;

        this.vaccineDespawn = vaccineDespawn;
        this.vaccineSpawn = vaccineSpawn;
    }

    public long[] covidinhoSetting(){
        return new long[]{covidinhoDespawn,scovidinhoSpawn,pcovidinhoSpawn,tcovidinhoSpawn};
    }

    public long[] maskSetting(){
        return  new long[]{maskDespawn,maskSpawn};
    }

    public long[] immunitySetting(){
        return new long[]{immunityDespawn,immuntySpawn};
    }

    public long[] vaccineSetting(){
        return new long[]{vaccineDespawn,vaccineSpawn};
    }

}
