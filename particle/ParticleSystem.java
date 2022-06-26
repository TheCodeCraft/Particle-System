package net.voids.design.particle;

import lombok.Getter;
import net.voids.utils.RenderUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ParticleSystem {

    private final List<Particle> particles = new ArrayList<>();

    public void setup() {
        for (int i = 0; i <= 200; i++) {
            particles.add(new Particle(1.5F));
        }
    }

    public void render(int mouseX, int mouseY) {
        for (Particle particle : particles) {
            particle.render(mouseX, mouseY);
            int range = 50;
            final boolean mouseOver = (mouseX >= particle.getX() - range) && (mouseY >= particle.getY() - range) && (mouseX <= particle.getX() + range) && (mouseY <= particle.getY() + range);

            if(mouseOver) {
                particles.stream()
                        .filter(part -> (part.getX() > particle.getX() && part.getX() - particle.getX() < range
                                && particle.getX() - part.getX() < range)
                                && (part.getY() > particle.getY() && part.getY() - particle.getY() < range
                                || particle.getY() > part.getY() && particle.getY() - part.getY() < range))
                        .forEach(connectable -> particle.connectToOther(connectable.getX(), connectable.getY()));
            }
        }
    }

    public void clear() {
        particles.clear();
    }

}