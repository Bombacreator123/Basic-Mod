package net.mcreator.basicmod.procedures;

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

		world.setBlockState(new BlockPos((int) x, (int) (new Object() {
			public int getAmount(IWorld world, BlockPos pos, int sltid) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).getCount());
					});
				}
				return _retval.get();
			}
		}.getAmount(world, new BlockPos((int) x, (int) (y - 1), (int) z), (int) ((-1)))), (int) z), WireItem.block.getDefaultState(), 3);

	}

}
