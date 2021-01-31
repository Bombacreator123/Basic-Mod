
package net.mcreator.basicmod.block;

import net.minecraft.block.material.Material;

@BasicModModElements.ModElement.Tag
public class WireBlock extends BasicModModElements.ModElement {

	@ObjectHolder("basic_mod:wire")
	public static final Block block = null;

	public WireBlock(BasicModModElements instance) {
		super(instance, 10);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends PaneBlock {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.REDSTONE_LIGHT).sound(SoundType.CLOTH).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0)
							.notSolid().setOpaque((bs, br, bp) -> false));

			setRegistryName("wire");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public boolean canConnectRedstone(BlockState state, IBlockReader world, BlockPos pos, Direction side) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
