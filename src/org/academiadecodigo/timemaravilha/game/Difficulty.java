package org.academiadecodigo.timemaravilha.game;

/**
 * Enum representing the Difficulty
 */
public enum Difficulty {
    EASY(60000, 10000, 12000, 15000, 15000,
            5000, 15000,7500,10000,30000),

    MEDIUM(60000, 7500, 9500, 11000, 15000,
            10000, 15000,12000,10000,35000),

    HARD(50000, 5000, 6500, 8000, 15000,
            12500, 15000,15000,10000,45000),

    CARCRASH(40000, 3000, 4000, 6000, 15000,
            20000, 15000,25000,10000,60000);

    //Despawn times
    private long covidinhoDespawn;
    private long immunityDespawn;
    private long vaccineDespawn;
    private long maskDespawn;

    //Spawn times
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

    /**
     * What's the settings for this difficulty (Covidinho wise)
     * @return - the settings
     */
    public long[] covidinhoSetting(){
        return new long[]{covidinhoDespawn,scovidinhoSpawn,pcovidinhoSpawn,tcovidinhoSpawn};
    }

    /**
     * What's the settings for this difficulty (Mask wise)
     * @return - the settings
     */
    public long[] maskSetting(){
        return  new long[]{maskDespawn,maskSpawn};
    }

    /**
     * What's the settings for this difficulty (Immunity wise)
     * @return - the settings
     */
    public long[] immunitySetting(){
        return new long[]{immunityDespawn,immuntySpawn};
    }

    /**
     * What's the settings for this difficulty (Vaccine wise)
     * @return - the settings
     */
    public long[] vaccineSetting(){
        return new long[]{vaccineDespawn,vaccineSpawn};
    }

}
