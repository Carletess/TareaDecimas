package modelo;

public enum IngredientesOpcionales {
    CREMA("Crema"),
    LECHE("Leche"),
    CHOCOLATE("Chocolate");

    private String ingredientesOpcionales;

    private IngredientesOpcionales(String ingredientesOpcionales) {
        this.ingredientesOpcionales = ingredientesOpcionales;
    }

    public String getIngredientesOpcionales() {
        return ingredientesOpcionales;
    }
}
