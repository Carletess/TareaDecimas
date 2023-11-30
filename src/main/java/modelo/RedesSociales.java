package modelo;

public enum RedesSociales {
    FACEBOOK("FaceBook"),
    INSTAGRAM("Instagram"),
    TWITTER("Twitter");

    private String redesSociales;

    private RedesSociales(String redesSociales) {
        this.redesSociales = redesSociales;
    }

    public String getEspecialidad() {
        return redesSociales;
    }
}
