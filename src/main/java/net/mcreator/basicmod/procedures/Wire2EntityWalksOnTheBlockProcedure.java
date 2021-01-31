package net.mcreator.basicmod.procedures;

@BasicModModElements.ModElement.Tag
public class Wire2EntityWalksOnTheBlockProcedure extends BasicModModElements.ModElement {

	public Wire2EntityWalksOnTheBlockProcedure(BasicModModElements instance) {
		super(instance, 3);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BasicModMod.LOGGER.warn("Failed to load dependency entity for procedure Wire2EntityWalksOnTheBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		entity.attackEntityFrom(DamageSource.CACTUS, (float) 6);

	}

}
