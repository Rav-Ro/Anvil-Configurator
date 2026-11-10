package com.example.examplemod;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.IntValue MAX_ANVIL_COST = BUILDER
            .comment("Maximum XP cost allowed for anvil operations")
            .defineInRange("maxAnvilCost", 75, 1, Integer.MAX_VALUE);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int maxAnvilCost;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        maxAnvilCost = MAX_ANVIL_COST.get();
    }
}