package com.example.examplemod;

import net.minecraft.world.inventory.AnvilMenu;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = ExampleMod.MODID,
        bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class AnvilCostHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (event.phase != TickEvent.Phase.END)
            return;

        if (!(event.player.containerMenu instanceof AnvilMenu anvilMenu))
            return;

        int cost = anvilMenu.getCost();

        if (cost > Config.maxAnvilCost) {
            anvilMenu.setMaximumCost(Config.maxAnvilCost);
        }
    }

}