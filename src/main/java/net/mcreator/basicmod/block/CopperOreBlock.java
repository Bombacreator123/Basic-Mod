
package net.mcreator.basicmod.block;

import net.minecraft.block.material.Material;

@BasicModModElements.ModElement.Tag
public class CopperOreBlock extends BasicModModElements.ModElement {

	@ObjectHolder("basic_mod:copper_ore")
	public static final Block block = null;

	public CopperOreBlock(BasicModModElements instance) {
		super(instance, 10);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3f, 10f).setLightLevel(s -> 0).harvestLevel(2)
							.harvestTool(ToolType.PICKAXE));

			setRegistryName("copper_ore");
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
