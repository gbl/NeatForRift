package vazkii.neat.mixin;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import vazkii.neat.interfaces.IMixinWorldClient;

import java.util.Set;

@Mixin(WorldClient.class)
public class MixinWorldClient implements IMixinWorldClient {
    @Shadow @Final private Set<Entity> entityList;

    @Override
    public Set<Entity> getEntityList() {
        return entityList;
    }
}
