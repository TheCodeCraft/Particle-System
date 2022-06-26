package net.voids.design.particle;

import lombok.Getter;
import net.minecraft.client.gui.GuiScreen;
import net.voids.utils.GlRender;
import net.voids.utils.MathUtils;

import static org.lwjgl.opengl.GL11.*;

@Getter
public class Particle {

    private float x, y;

    private final float size;

    public Particle(float size) {
        this.x = MathUtils.randomBetween(GuiScreen.width, 0);
        this.y = MathUtils.randomBetween(GuiScreen.height, 0);
        this.size = size;
    }

    public void render(int mouseX, int mouseY) {
        if (isOut()) {
            this.x = MathUtils.randomBetween(GuiScreen.width, 0) - x;
            this.y = MathUtils.randomBetween(GuiScreen.height, 0) - y;
        } else {
            //Rendering
            GlRender.drawRoundedRect(this.x, this.y, this.x + size, this.y + size, size, Integer.MAX_VALUE);
            this.x += MathUtils.randomBetween(5, 1);
            this.y += MathUtils.randomBetween(5, 1);
        }
    }

    public void connectToOther(float x, float y) {
        connectPoints(getX(), getY(), x, y);
    }


    private void connectPoints(float xOne, float yOne, float xTwo, float yTwo) {
        glPushMatrix();
        glEnable(GL_LINE_SMOOTH);
        glColor4f(1.0F, 1.0F, 1.0F, 0.8F);
        glDisable(GL_TEXTURE_2D);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_BLEND);
        glLineWidth(0.5F);
        glBegin(GL_LINES);
        glVertex2f(xOne, yOne);
        glVertex2f(xTwo, yTwo);
        glEnd();
        glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        glDisable(GL_LINE_SMOOTH);
        glEnable(GL_TEXTURE_2D);
        glPopMatrix();
    }

    private boolean isOut() {
        return x >= GuiScreen.width || y >= GuiScreen.height;
    }
}
