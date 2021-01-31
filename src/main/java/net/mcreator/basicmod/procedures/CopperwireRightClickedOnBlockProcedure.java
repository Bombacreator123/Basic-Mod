package net.mcreator.basicmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.basicmod.block.WireBlock;
import net.mcreator.basicmod.BasicModModElements;
import net.mcreator.basicmod.BasicModMod;

import java.util.Map;

@BasicModModElements.ModElement.Tag
public class CopperwireRightClickedOnBlockProcedure extends BasicModModElements.ModElement {
	public CopperwireRightClickedOnBlockProcedure(BasicModModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BasicModMod.LOGGER.warn("Failed to load dependency x for procedure CopperwireRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BasicModMod.LOGGER.warn("Failed to load dependency y for procedure CopperwireRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BasicModMod.LOGGER.warn("Failed to load dependency z for procedure CopperwireRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BasicModMod.LOGGER.warn("Failed to load dependency world for procedure CopperwireRightClickedOnBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WireBlock.block.getDefaultState(), 3);
	}
}
