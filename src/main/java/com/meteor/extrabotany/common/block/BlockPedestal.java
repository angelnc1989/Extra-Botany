package com.meteor.extrabotany.common.block;

import java.util.Random;

import javax.annotation.Nonnull;

import com.meteor.extrabotany.api.ExtraBotanyAPI;
import com.meteor.extrabotany.api.IHammer;
import com.meteor.extrabotany.api.PedestalVariant;
import com.meteor.extrabotany.client.core.handler.ModelHandler;
import com.meteor.extrabotany.common.block.tile.TilePedestal;
import com.meteor.extrabotany.common.item.ItemGildedMashedPotato;
import com.meteor.extrabotany.common.item.ItemSpiritFuel;
import com.meteor.extrabotany.common.item.tool.ItemHammerUltimate;
import com.meteor.extrabotany.common.lib.LibBlocksName;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vazkii.botania.common.item.ItemLexicon;
import vazkii.botania.common.item.ModItems;

public class BlockPedestal extends BlockMod{
	
	private static final AxisAlignedBB AABB = new AxisAlignedBB(0.125, 0.125, 0.125, 0.875, 20.0/16, 0.875);

	public BlockPedestal() {
		super(Material.ROCK, LibBlocksName.TILE_PEDESTAL);
		setHardness(3.5F);
		setSoundType(SoundType.STONE);
		setDefaultState(blockState.getBaseState()
				.withProperty(ExtraBotanyAPI.PEDESTAL_VARIANT, PedestalVariant.DEFAULT));
	}
	
	@Nonnull
	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, ExtraBotanyAPI.PEDESTAL_VARIANT);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(ExtraBotanyAPI.PEDESTAL_VARIANT).ordinal();
	}

	@Nonnull
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if (meta < 0 || meta >= PedestalVariant.values().length ) {
			meta = 0;
		}
		return getDefaultState().withProperty(ExtraBotanyAPI.PEDESTAL_VARIANT, PedestalVariant.values()[meta]);
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state){
		Random rand = new Random();
		TilePedestal pedestal = (TilePedestal) world.getTileEntity(pos);

		if(pedestal != null)
			if(!pedestal.getItem().isEmpty()){
				float f = rand.nextFloat() * 0.8F + 0.1F;
				float f1 = rand.nextFloat() * 0.8F + 0.1F;
				float f2 = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem item = new EntityItem(world, pos.getX() + f, pos.getY() + f1, pos.getZ() + f2, pedestal.getItem());
				float f3 = 0.05F;
				item.motionX = (float)rand.nextGaussian() * f3;
				item.motionY = (float)rand.nextGaussian() * f3 + 0.2F;
				item.motionZ = (float)rand.nextGaussian() * f3;
				world.spawnEntity(item);
			}

		super.breakBlock(world, pos, state);
	}
	
	public static boolean handleBlockActivation(World world, BlockPos pos, EntityPlayer player, ItemStack heldItem){
		TileEntity tile = world.getTileEntity(pos);
		if(tile != null && tile instanceof TilePedestal){
			TilePedestal te = (TilePedestal) tile;
			if(!heldItem.isEmpty() && te.getItem().isEmpty()){
				te.setStrikes(0);
				te.markForUpdate();
				ItemStack newItem = heldItem.copy();
				newItem.setCount(1);
				te.setItem(newItem);
				heldItem.shrink(1);
				world.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.5F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1, false);
				return true;
			}
			if(!te.getItem().isEmpty()){
				if(heldItem.isEmpty()){
					if(player.inventory.addItemStackToInventory(((TilePedestal)tile).getItem())){
						te.setStrikes(0);
						te.markForUpdate();
						te.setItem(ItemStack.EMPTY);
						world.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.5F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1, false);
						return true;
					}
				}else{
					if(heldItem.getItem() instanceof IHammer && !(te.getItem().getItem() instanceof ItemHammerUltimate)){
						te.setStrikes(te.getStrikes() + 1);
						heldItem.damageItem(1, player);
						te.markForUpdate();
						return true;
					}else if(te.getItem().getItem() instanceof ItemHammerUltimate){
						ItemHammerUltimate stack = (ItemHammerUltimate) te.getItem().getItem();
						if(heldItem.getItem() instanceof ItemGildedMashedPotato && stack.getRepair(te.getItem()) < 3 && heldItem.getCount() >=5){
							if(!world.isRemote)
								stack.setRepair(te.getItem(), stack.getRepair(te.getItem()) + 1);
							heldItem.shrink(5);
							return true;
						}else if(heldItem.getItem() == ModItems.elementiumSword && stack.getAttack(te.getItem()) < 10){
							if(!world.isRemote)
								stack.setAttack(te.getItem(), stack.getAttack(te.getItem()) + 1);
							heldItem.shrink(1);
							return true;
						}else if(heldItem.getItem() == com.meteor.extrabotany.common.item.ModItems.hammerterrasteel && !stack.hasRange(te.getItem())){
							if(!world.isRemote)
								stack.setRange(te.getItem(), true);
							heldItem.shrink(1);
							return true;
						}
					}else if(te.getItem().getItem() instanceof ItemSpiritFuel && heldItem.getItem() == ModItems.lexicon){
						ItemLexicon l = (ItemLexicon) heldItem.getItem();
						l.unlockKnowledge(heldItem, ExtraBotanyAPI.dreamKnowledge);
						return true;
					}
					if(player.inventory.addItemStackToInventory(((TilePedestal)tile).getItem())){
						te.setStrikes(0);
						te.markForUpdate();
						te.setItem(ItemStack.EMPTY);
						world.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.5F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1, false);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		return handleBlockActivation(world, pos, player, player.getHeldItem(hand));
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player){
		return new ItemStack(Item.getItemFromBlock(this));
	}

	@SideOnly(Side.CLIENT)
	@Nonnull
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Nonnull
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
		return AABB;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state){
		return false;
	}
	
	@Nonnull
	@Override
	public TileEntity createTileEntity(@Nonnull World world, @Nonnull IBlockState state) {
		return new TilePedestal();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() {
		ModelHandler.registerBlockToState(this, PedestalVariant.values().length - 1);;
	}

}