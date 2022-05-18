package com.company;

public class MenuClassic extends Menu{

    public MenuClassic() {
        this.setNombre("menu classic");
    }

    @Override
    public double calculcarCosto() {
        return getPrecioBase();
    }
}
