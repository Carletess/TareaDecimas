package modelo;

public enum TamañoCafe {
    GRANDE("Grande"),
    MEDIANO("Mediano"),
    PEQUEÑO("Pequeño");

    private String tamañoCafe;

    private TamañoCafe(String tamañoCafe) {
        this.tamañoCafe = tamañoCafe;
    }

    public String getTamañoCafe() {
        return tamañoCafe;
    }
}
