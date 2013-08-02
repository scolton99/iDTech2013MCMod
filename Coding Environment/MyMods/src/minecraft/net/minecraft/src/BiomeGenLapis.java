package net.minecraft.src;

import java.util.Random;

public class BiomeGenLapis extends BiomeGenBase {
	public BiomeGenLapis(int par1){
		super(par1);
		
		this.theBiomeDecorator.treesPerChunk = 1;
		this.theBiomeDecorator.grassPerChunk = 2;
		this.theBiomeDecorator.flowersPerChunk = 0;
		
		this.biomeName="lapisBiome";
		
		this.fillerBlock=(byte)Block.oreLapis.blockID;
		this.topBlock=(byte)Block.blockLapis.blockID;
		
		this.spawnableCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityEnderpig.class, 5, 3, 7));
	}

    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return this.worldGeneratorTreesLapis;
    }
    
    public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
    {
        return new WorldGenTallGrass(mod_LapisTools.tallGrassLapis.blockID, 1);
    }
}
