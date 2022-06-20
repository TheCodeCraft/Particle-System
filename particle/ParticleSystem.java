package net.voids.utils.particle;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ParticleSystem {

    private final List<Particle> particles = new ArrayList<>();

    public void setup() {
        for (int i = 0; i <= 50; i++) {
            particles.add(new Particle(1.5F));
        }
    }

    public void render(int mouseX, int mouseY) {
        particles.forEach(particle -> particle.render(mouseX, mouseY));
    }

    public void clear() {
        particles.clear();
    }

}
