package net.voids.utils.particle;

import net.minecraft.client.gui.GuiScreen;
import net.voids.utils.MathUtils;
import net.voids.utils.RenderUtils;

import java.awt.*;

public class Particle {

    private float x, y;

    private float size;

    public Particle(float size) {
        this.x = MathUtils.randomBetween(GuiScreen.width, 0);
        this.y = MathUtils.randomBetween(GuiScreen.height, 0);
        this.size = size;
    }

    public void render(int mouseX, int mouseY) {
        if (isOut()) {
            this.x = MathUtils.randomBetween(GuiScreen.width, 0);
            this.y = MathUtils.randomBetween(GuiScreen.height, 0);
        } else {
            //Rendering
            RenderUtils.drawRect(this.x, this.y, this.x + size, this.y + size, new Color(255, 255, 255));
            this.x += MathUtils.randomBetween(5, 1);
            this.y += MathUtils.randomBetween(5, 1);
        }
    }

    private boolean isOut() {
        return x >= GuiScreen.width || y >= GuiScreen.height;
    }
}
