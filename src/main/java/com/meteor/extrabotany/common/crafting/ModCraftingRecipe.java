package com.meteor.extrabotany.common.crafting;

import com.meteor.extrabotany.common.block.ModBlocks;
import com.meteor.extrabotany.common.item.ModItems;
import com.meteor.extrabotany.common.lib.LibMisc;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;
import vazkii.botania.common.lib.LibOreDict;

public class ModCraftingRecipe {
	
	public static IRecipe PEDESTAL;
	public static IRecipe TERRASTEEL_HAMMER;
	public static IRecipe MANASTEEL_HAMMER;
	public static IRecipe ELEMENTIUM_HAMMER;
	public static IRecipe MANAREADER;
	public static IRecipe BINDER;
	public static IRecipe KINGGARDEN;
	public static IRecipe KINGGARDEN2;
	public static IRecipe MANABARREL;
	public static IRecipe FAILNAUGHT;
	public static IRecipe CAMERA;
	public static IRecipe NATUREORB;
	public static IRecipe RELICSHIELD;
	public static IRecipe MASTERMANARING;
	public static IRecipe SHIELDMANASTEEL;
	public static IRecipe SHIELDTERRASTEEL;
	public static IRecipe SHIELDELEMENTIUM;
	public static IRecipe HEROMEDAL;
	public static IRecipe COCOONDESIRE;
	public static IRecipe MANAGENERATOR;
	
	public static IRecipe CMHELM;
	public static IRecipe CMCHEST;
	public static IRecipe CMLEGS;
	public static IRecipe CMBOOTS;
	public static IRecipe COSMHELM;
	public static IRecipe COSMCHEST;
	public static IRecipe COSMLEGS;
	public static IRecipe COSMBOOTS;
	
	public static void init() {
		
		PEDESTAL = new ShapedOreRecipe(getResource("recipe_pedestal"), new ItemStack(ModBlocks.pedestal, 1), "X#X", " X ", "XXX", '#', new ItemStack(Items.GOLD_NUGGET), 'X', LibOreDict.LIVING_ROCK);
		PEDESTAL.setRegistryName(getResource("recipe_pedestal"));
		
		TERRASTEEL_HAMMER = new ShapedOreRecipe(getResource("recipe_terrasteelhammer"), new ItemStack(ModItems.hammerterrasteel, 1), "XXX", "XXX", " Y ", 'X', LibOreDict.TERRA_STEEL, 'Y', LibOreDict.LIVINGWOOD_TWIG);
		TERRASTEEL_HAMMER.setRegistryName(getResource("recipe_terrasteelhammer"));
		
		ELEMENTIUM_HAMMER = new ShapedOreRecipe(getResource("recipe_elementiumhammer"), new ItemStack(ModItems.hammerelementium, 1), "XXX", "XXX", " Y ", 'X', LibOreDict.ELEMENTIUM, 'Y', LibOreDict.LIVINGWOOD_TWIG);
		ELEMENTIUM_HAMMER.setRegistryName(getResource("recipe_elementiumhammer"));
		
		MANASTEEL_HAMMER = new ShapedOreRecipe(getResource("recipe_manasteelhammer"), new ItemStack(ModItems.hammermanasteel, 1), "XXX", "XXX", " Y ", 'X', LibOreDict.MANA_STEEL, 'Y', LibOreDict.LIVINGWOOD_TWIG);
		MANASTEEL_HAMMER.setRegistryName(getResource("recipe_manasteelhammer"));
		
		MANAREADER = new ShapedOreRecipe(getResource("recipe_manareader"), new ItemStack(ModItems.manaReader, 1), " XY", " ZX", "Z  ", 'X', LibOreDict.MANA_POWDER, 'Y', LibOreDict.MANA_DIAMOND, 'Z', LibOreDict.LIVINGWOOD_TWIG);
		MANAREADER.setRegistryName(getResource("recipe_manareader"));
		
		BINDER = new ShapedOreRecipe(getResource("recipe_binder"), new ItemStack(ModItems.binder, 1), " XY", " ZX", "Z  ", 'X', LibOreDict.MANA_POWDER, 'Y', LibOreDict.DRAGONSTONE, 'Z', LibOreDict.LIVINGWOOD_TWIG);
		BINDER.setRegistryName(getResource("recipe_binder"));
	
		KINGGARDEN = new ShapelessOreRecipe(getResource("recipe_kinggarden"), new ItemStack(ModItems.kinggarden, 1), new ItemStack(ModItems.kinggarden));
		KINGGARDEN.setRegistryName(getResource("recipe_kinggarden"));
		
		KINGGARDEN2 = new ShapedOreRecipe(getResource("recipe_kinggarden2"), new ItemStack(ModItems.kinggarden, 1), "XYX", "XZX", "XAX", 'X', new ItemStack(ModItems.material), 'Y', LibOreDict.TERRA_STEEL, 'Z', Blocks.CHEST, 'A', Blocks.WOOL);
		KINGGARDEN2.setRegistryName(getResource("recipe_kinggarden2"));
		
		MANABARREL = new ShapedOreRecipe(getResource("recipe_manabarrel"), new ItemStack(ModBlocks.batterybox), "XYX", "XZX", "XYX", 'X', new ItemStack(vazkii.botania.common.block.ModBlocks.pool, 1, 3), 'Y', new ItemStack(vazkii.botania.common.item.ModItems.lens), 'Z', LibOreDict.GAIA_INGOT);
		MANABARREL.setRegistryName(getResource("recipe_manabarrel"));
		
		FAILNAUGHT = new ShapedOreRecipe(getResource("recipe_failnaught"), new ItemStack(ModItems.failnaught), " #X", "#AX", " #X", '#', LibOreDict.TERRA_STEEL, 'X', LibOreDict.MANA_STRING, 'A', new ItemStack(ModItems.material, 1, 3));
		FAILNAUGHT.setRegistryName(getResource("recipe_failnaught"));
		
		CAMERA = new ShapedOreRecipe(getResource("recipe_camera"), new ItemStack(ModItems.camera), "###", "#A#", "XXX", '#', new ItemStack(vazkii.botania.common.block.ModFluffBlocks.darkQuartz), 'X', LibOreDict.TERRA_STEEL, 'A', new ItemStack(ModItems.material, 1, 3));
		CAMERA.setRegistryName(getResource("recipe_camera"));
		
		NATUREORB = new ShapedOreRecipe(getResource("recipe_natureorb"), new ItemStack(ModItems.orb), "#B#", "BAB", "#B#", '#', LibOreDict.TERRA_STEEL, 'B', LibOreDict.DRAGONSTONE, 'A', LibOreDict.MANA_PEARL);
		NATUREORB.setRegistryName(getResource("recipe_natureorb"));
		
		SHIELDMANASTEEL = new ShapedOreRecipe(getResource("recipe_manasteelshield"), new ItemStack(ModItems.manasteelshield), "A A", "ABA", "A A", 'B', new ItemStack(Items.SHIELD), 'A', LibOreDict.MANA_STEEL);
		SHIELDMANASTEEL.setRegistryName(getResource("recipe_manasteelshield"));
		
		SHIELDTERRASTEEL = new ShapedOreRecipe(getResource("recipe_terrasteelshield"), new ItemStack(ModItems.terrasteelshield), "A A", "ABA", "A A", 'B', new ItemStack(Items.SHIELD), 'A', LibOreDict.TERRA_STEEL);
		SHIELDTERRASTEEL.setRegistryName(getResource("recipe_terrasteelshield"));
		
		SHIELDELEMENTIUM = new ShapedOreRecipe(getResource("recipe_elementiumshield"), new ItemStack(ModItems.elementiumshield), "A A", "ABA", "A A", 'B', new ItemStack(Items.SHIELD), 'A', LibOreDict.ELEMENTIUM);
		SHIELDELEMENTIUM.setRegistryName(getResource("recipe_elementiumshield"));
		
		RELICSHIELD = new ShapedOreRecipe(getResource("recipe_relicshield"), new ItemStack(ModItems.relicshield), "ACA", "ABA", "ABA", 'B', new ItemStack(Items.SHIELD), 'A', LibOreDict.TERRA_STEEL, 'C', new ItemStack(ModItems.material, 1, 3));
		RELICSHIELD.setRegistryName(getResource("recipe_relicshield"));
		
		COCOONDESIRE = new ShapedOreRecipe(getResource("recipe_cocoondesire"), new ItemStack(ModBlocks.cocoondesire), "ABA", "BCB", "ABA", 'B', new ItemStack(ModItems.material, 1, 2), 'A', LibOreDict.TERRA_STEEL, 'C', new ItemStack(ModItems.material, 1, 3));
		COCOONDESIRE.setRegistryName(getResource("recipe_cocoondesire"));
		
		MANAGENERATOR = new ShapedOreRecipe(getResource("recipe_managenerator"), new ItemStack(ModBlocks.managenerator), "ABA", "BCB", "ABA", 'B', new ItemStack(Blocks.LAPIS_BLOCK), 'A', LibOreDict.LIVING_ROCK, 'C', new ItemStack(ModItems.material, 1, 3));
		MANAGENERATOR.setRegistryName(getResource("recipe_managenerator"));
		
		MASTERMANARING = new ShapedOreRecipe(getResource("recipe_mastermanaring"), new ItemStack(ModItems.mastermanaring), "ACA", "BDB", "ABA", 'B', new ItemStack(vazkii.botania.common.item.ModItems.manaTablet), 'A', LibOreDict.TERRA_STEEL, 'C', new ItemStack(ModItems.material, 1, 3), 'D', new ItemStack(vazkii.botania.common.item.ModItems.manaRingGreater));
		MASTERMANARING.setRegistryName(getResource("recipe_mastermanaring"));
		
		HEROMEDAL = new ShapelessOreRecipe(getResource("recipe_heromedal"), new ItemStack(ModItems.rewardbag, 8, 2), new ItemStack(ModItems.material, 1, 3));
		HEROMEDAL.setRegistryName(getResource("recipe_heromedal"));
		
		CMHELM = new ShapedOreRecipe(getResource("recipe_cmhelm"), new ItemStack(ModItems.cmhelm), "AAA", "BCB", 'A', LibOreDict.GAIA_INGOT, 'B', LibOreDict.MANAWEAVE_CLOTH, 'C', new ItemStack(vazkii.botania.common.item.ModItems.terrasteelHelm));
		CMHELM.setRegistryName(getResource("recipe_cmhelm"));
		
		CMCHEST = new ShapedOreRecipe(getResource("recipe_cmchest"), new ItemStack(ModItems.cmchest), "B B", "BCB", "AAA", 'A', LibOreDict.GAIA_INGOT, 'B', LibOreDict.MANAWEAVE_CLOTH, 'C', new ItemStack(vazkii.botania.common.item.ModItems.terrasteelChest));
		CMCHEST.setRegistryName(getResource("recipe_cmchest"));
		
		CMLEGS = new ShapedOreRecipe(getResource("recipe_cmlegs"), new ItemStack(ModItems.cmleg), "AAA", "BCB", "B B", 'A', LibOreDict.GAIA_INGOT, 'B', LibOreDict.MANAWEAVE_CLOTH, 'C', new ItemStack(vazkii.botania.common.item.ModItems.terrasteelLegs));
		CMLEGS.setRegistryName(getResource("recipe_cmlegs"));
		
		CMBOOTS = new ShapedOreRecipe(getResource("recipe_cmboots"), new ItemStack(ModItems.cmboot), "BCB", "AAA", 'A', LibOreDict.GAIA_INGOT, 'B', LibOreDict.MANAWEAVE_CLOTH, 'C', new ItemStack(vazkii.botania.common.item.ModItems.terrasteelBoots));
		CMBOOTS.setRegistryName(getResource("recipe_cmboots"));
		
		COSMHELM = new ShapedOreRecipe(getResource("recipe_cosmhelm"), new ItemStack(ModItems.cosmhelm), "AAA", "ACA", "AAA", 'A', LibOreDict.MANAWEAVE_CLOTH, 'C', new ItemStack(vazkii.botania.common.item.ModItems.manasteelHelm));
		COSMHELM.setRegistryName(getResource("recipe_cosmhelm"));
		
		COSMCHEST = new ShapedOreRecipe(getResource("recipe_cosmchest"), new ItemStack(ModItems.cosmchest), "AAA", "ACA", "AAA", 'A', LibOreDict.MANAWEAVE_CLOTH, 'C', new ItemStack(vazkii.botania.common.item.ModItems.manasteelChest));
		COSMCHEST.setRegistryName(getResource("recipe_cosmchest"));
		
		COSMLEGS = new ShapedOreRecipe(getResource("recipe_cosmlegs"), new ItemStack(ModItems.cosmleg), "AAA", "ACA", "AAA", 'A', LibOreDict.MANAWEAVE_CLOTH, 'C', new ItemStack(vazkii.botania.common.item.ModItems.manasteelLegs));
		COSMLEGS.setRegistryName(getResource("recipe_cosmlegs"));
		
		COSMBOOTS = new ShapedOreRecipe(getResource("recipe_cosmboots"), new ItemStack(ModItems.cosmboot), "AAA", "ACA", "AAA", 'A', LibOreDict.MANAWEAVE_CLOTH, 'C', new ItemStack(vazkii.botania.common.item.ModItems.manasteelBoots));
		COSMBOOTS.setRegistryName(getResource("recipe_cosmboots"));
	}
	
	@Mod.EventBusSubscriber(modid = LibMisc.MOD_ID)
	public static class RegistrationHandlerRecipes {
		@SubscribeEvent
		public static void registerRecipes(final RegistryEvent.Register<IRecipe> event) {
			init();
			final IForgeRegistry<IRecipe> registry = event.getRegistry();
			event.getRegistry().registerAll(
					PEDESTAL,
					TERRASTEEL_HAMMER,
					ELEMENTIUM_HAMMER,
					MANASTEEL_HAMMER,
					MANAREADER,
					KINGGARDEN,
					KINGGARDEN2,
					MANABARREL,
					CAMERA,
					BINDER,
					FAILNAUGHT,
					NATUREORB,
					SHIELDMANASTEEL,
					SHIELDTERRASTEEL,
					SHIELDELEMENTIUM,
					RELICSHIELD,
					MASTERMANARING,
					HEROMEDAL,
					COCOONDESIRE,
					CMHELM,
					CMCHEST,
					CMLEGS,
					CMBOOTS,
					COSMHELM,
					COSMCHEST,
					COSMLEGS,
					COSMBOOTS,
					MANAGENERATOR
			);
		}
	}
	
	private static ResourceLocation getResource(String inName) {
		return new ResourceLocation(LibMisc.MOD_ID, inName);
	}

}
