package com.github.revival.server.entity.mob.test;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class DinoAIFindAirTarget extends EntityAIBase
{
	private EntityFlyingPrehistoric mob;
	private double shelterX;
	private double shelterY;
	private double shelterZ;
	private World theWorld;

	public DinoAIFindAirTarget(EntityFlyingPrehistoric mob){
		this.mob = mob;
		this.theWorld = mob.worldObj;
		this.setMutexBits(1);
	}

	public boolean shouldExecute(){
		if(!mob.isDirectPathBetweenPoints(new ChunkCoordinates(MathHelper.floor_double(mob.posX), MathHelper.floor_double(mob.posY), MathHelper.floor_double(mob.posZ)), new ChunkCoordinates(MathHelper.floor_double(shelterX), MathHelper.floor_double(shelterY), MathHelper.floor_double(shelterZ)))){
			mob.currentTarget = null;
		}

		if(mob.currentTarget != null && mob.getDistance(mob.currentTarget.posX, mob.currentTarget.posY, mob.currentTarget.posZ) < 10F){
			return false;
		}
		else
		{
			ChunkCoordinates vec3 = this.findWaterTarget();

			if (vec3 == null)
			{
				return false;
			}
			else
			{
				this.shelterX = vec3.posX;
				this.shelterY = vec3.posY;
				this.shelterZ = vec3.posZ;
				return true;
			}
		}
	}

	public boolean continueExecuting(){
		return mob.currentTarget != null;
	}

	public void startExecuting(){
		this.mob.currentTarget = new ChunkCoordinates((int)shelterX, (int)shelterY, (int)shelterZ);
	}

	public ChunkCoordinates findWaterTarget(){
		if(mob.getAttackTarget() == null || mob.ridingEntity != null && mob.getAttackTarget() != null){
			Random random = this.mob.getRNG();
			mob.setAttackTarget(null);
			ChunkCoordinates chunkCoordinates = getCoords();
			for (int i = 0; i < 10; ++i)
			{
				ChunkCoordinates chunkCoordinates1 = new ChunkCoordinates(chunkCoordinates.posX + random.nextInt(60) - 30, chunkCoordinates.posY + random.nextInt(32) - 16, chunkCoordinates.posZ + random.nextInt(60) - 30);
				if (mob.worldObj.getBlock(chunkCoordinates1.posX, chunkCoordinates1.posY, chunkCoordinates1.posZ).getMaterial() == Material.air)
				{
					return chunkCoordinates1;
				}
			}
		}else{
			Random random = this.mob.getRNG();
			ChunkCoordinates coords = getTargetCoords();
			if (mob.worldObj.getBlock(coords.posX, coords.posY, coords.posZ).getMaterial() == Material.air)
			{
				return coords;
			}
		}

		return null;
	}
	
	public ChunkCoordinates getCoords(){
		int i = MathHelper.floor_double(mob.posX);
		int j = MathHelper.floor_double(mob.posY);
		int k = MathHelper.floor_double(mob.posZ);
		return new ChunkCoordinates((int)this.mob.posX, (int)this.mob.posY, (int)this.mob.posZ);
	}

	public ChunkCoordinates getTargetCoords(){
		int i = MathHelper.floor_double(mob.posX);
		int j = MathHelper.floor_double(mob.posY);
		int k = MathHelper.floor_double(mob.posZ);
		return new ChunkCoordinates((int)this.mob.getAttackTarget().posX, (int)this.mob.getAttackTarget().posY, (int)this.mob.getAttackTarget().posZ);
	}


}