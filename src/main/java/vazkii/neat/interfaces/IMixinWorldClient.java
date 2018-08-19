package vazkii.neat.interfaces;

import net.minecraft.entity.Entity;

import java.util.Set;

public interface IMixinWorldClient {
    Set<Entity> getEntityList();
}
