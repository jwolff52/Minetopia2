package io.github.jwolff52.minetopia2.tileentity;

import io.github.jwolff52.minetopia2.init.ModBlocks;
import io.github.jwolff52.minetopia2.inventory.ContainerAlchemicalChest;
import io.github.jwolff52.minetopia2.ref.N;
import io.github.jwolff52.minetopia2.ref.Sounds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityAlchemyChest extends TileEntityM2 implements IInventory {

    public float lidAngle;
    public float prevLidAngle;
    public int numUsingPlayers;

    private int ticksSinceSync;
	private ItemStack[] inventory;
	
	public TileEntityAlchemyChest(int metaData){
        super();
        this.state = (byte) metaData;

        if (metaData == 0)
        {
            inventory = new ItemStack[ContainerAlchemicalChest.SMALL_INVENTORY_SIZE];
        }
        else if (metaData == 1)
        {
            inventory = new ItemStack[ContainerAlchemicalChest.MEDIUM_INVENTORY_SIZE];
        }
        else if (metaData == 2)
        {
            inventory = new ItemStack[ContainerAlchemicalChest.LARGE_INVENTORY_SIZE];
        }
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slotIndex) {
		return inventory[slotIndex];
	}

	@Override
	public ItemStack decrStackSize(int slotIndex, int decrementAmmount) {
		ItemStack stack=getStackInSlot(slotIndex);
		if(stack!=null){
			if(stack.stackSize<=decrementAmmount){
				setInventorySlotContents(slotIndex, null);
			}else{
				stack=stack.splitStack(decrementAmmount);
				if(stack.stackSize==0){
					setInventorySlotContents(slotIndex, null);
				}
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex) {
		if(inventory[slotIndex] != null){
			ItemStack stack = inventory[slotIndex];
            setInventorySlotContents(slotIndex, null);
            return stack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack itemStack) {
		inventory[slotIndex]=itemStack;

		if(itemStack != null && itemStack.stackSize > getInventoryStackLimit()){
			itemStack.stackSize = getInventoryStackLimit();
		}

        this.markDirty();
	}

    @Override
    public String getInventoryName() {
        return this.hasCustomName() ? this.getCustomName() : N.Containers.ALCHEMY_CHEST;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return this.hasCustomName();
    }

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(xCoord,  yCoord,  zCoord) == this && player.getDistanceSq((double)xCoord+0.5D, (double)yCoord+0.5D, (double)zCoord+0.5D)<64D;
	}

    @Override
    public void openInventory() {
        ++numUsingPlayers;
        worldObj.addBlockEvent(xCoord, yCoord, zCoord, ModBlocks.alchemyChest, 1, numUsingPlayers);
    }

    @Override
    public void closeInventory() {
        --numUsingPlayers;
        worldObj.addBlockEvent(xCoord, yCoord, zCoord, ModBlocks.alchemyChest, 1, numUsingPlayers);
    }

    @Override
    public boolean isItemValidForSlot(int slotIndex, ItemStack itemStack) {
        return true;
    }

	@Override
    public void updateEntity() {
        super.updateEntity();

        if(++ticksSinceSync % 20 * 4 == 0) {
            worldObj.addBlockEvent(xCoord, yCoord, zCoord, ModBlocks.alchemyChest, 1, numUsingPlayers);
        }

        prevLidAngle = lidAngle;
        float angleIncrement = 0.1f;
        double adjustedXCoord, adjustedZCoord;

        if(numUsingPlayers > 0 && lidAngle == 0.0f) {
            adjustedXCoord = xCoord + 0.5D;
            adjustedZCoord = zCoord + 0.5D;
            worldObj.playSoundEffect(adjustedXCoord, yCoord + 0.5D, adjustedZCoord, Sounds.CHEST_OPEN, 0.5f, worldObj.rand.nextFloat() * 0.1f + 0.9f);
        }

        if(numUsingPlayers == 0 && lidAngle > 0.0f || numUsingPlayers > 0 && lidAngle < 1.0f) {
            float i = lidAngle;

            if(numUsingPlayers > 0) {
                lidAngle += angleIncrement;
            } else {
                lidAngle -= angleIncrement;
            }

            if(lidAngle > 1.0f) {
                lidAngle = 1.0f;
            }

            if(lidAngle <0.5f && i >= 0.5f) {
                adjustedXCoord = xCoord + 0.5D;
                adjustedZCoord = zCoord + 0.5D;
                worldObj.playSoundEffect(adjustedXCoord, yCoord + 0.5D, adjustedZCoord, Sounds.CHEST_CLOSE, 0.5f, worldObj.rand.nextFloat() * 0.1f + 0.9f);
            }

            if(lidAngle < 0.0f) {
                lidAngle = 0.0f;
            }
        }
    }

    @Override
    public boolean receiveClientEvent(int eventID, int numUsingPlayers) {
        if(eventID == 1) {
            this.numUsingPlayers = numUsingPlayers;
            return true;
        }
        return super.receiveClientEvent(eventID, numUsingPlayers);
    }

	@Override
	public void readFromNBT(NBTTagCompound tagCompound){
		super.readFromNBT(tagCompound);
		
		NBTTagList tagList=tagCompound.getTagList(N.NBT.ITEMS, 10);
		for(int i=0; i<tagList.tagCount();i++){
			NBTTagCompound tag = tagList.getCompoundTagAt(i);
			byte slot=tag.getByte("Slot");
			if(slot>=0&&slot< inventory.length){
				inventory[slot]=ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound){
		super.writeToNBT(tagCompound);
		
		NBTTagList itemList = new NBTTagList();
		for(int i = 0; i< inventory.length; i++){
			ItemStack stack= inventory[i];
			if(stack!=null){
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", itemList);
	}
}